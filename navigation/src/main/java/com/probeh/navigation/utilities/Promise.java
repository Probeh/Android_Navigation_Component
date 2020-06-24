package com.probeh.navigation.utilities;
/*
    Created by Yonathan Probeh
    On Wednesday, Jun 24, 2020
*/
import java.util.ArrayList;
import java.util.List;

public class Promise<T> implements Disposable {
    
    private static final String TAG = "* Promise";
    private List<Object> callbackChain = new ArrayList<>();
    private List<Object> errorHandlers = new ArrayList<>();
    private T value;
    public Promise() {
    }
    public Awaiter<T> await(long timeout) {
        return new Awaiter<T>(this, timeout);
    }
    public Promise<T> then(Task<T> callback) {
        this.callbackChain.add(callback);
        return this;
    }
    public Promise<T> then(Runnable callback) {
        this.callbackChain.add(callback);
        return this;
    }
    public Promise<T> then(Awaiter<T> awaiter) {
        this.callbackChain.add(awaiter);
        return this;
    }
    public Promise<T> error(Task<Exception> handler) {
        this.errorHandlers.add(handler);
        return this;
    }
    public Promise<T> error(Runnable handler) {
        this.errorHandlers.add(handler);
        return this;
    }
    public void complete() {
        this.onComplete(this.value);
    }
    public void onComplete(T value) {
        new Thread(() -> {
            this.callbackChain.forEach(callback -> this.start(callback, value));
        }).start();
    }
    private void start(Object callback, T value) {
        try {
            if (callback instanceof Task) ((Task<T>)callback).run(value);
            if (callback instanceof Runnable) ((Runnable)callback).run();
            if (callback instanceof Awaiter) {
                Thread.sleep(((Awaiter<T>)callback).getTimeout());
                ((Awaiter<T>)callback).getAwaiter(value);
            }
        }
        catch (Exception ex) {
            this.errorHandlers.forEach(handler -> {
                if (handler instanceof Task) ((Task<Exception>)handler).run(ex);
                if (handler instanceof Runnable) ((Runnable)handler).run();
            });
        }
    }
    @Override
    public void onDispose() {
        this.callbackChain.clear();
        this.errorHandlers.clear();
    }
    
}
