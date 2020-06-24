package com.probeh.navigation.utilities;
/*
    Created by Yonathan Probeh
    On Wednesday, Jun 24, 2020
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Subscription<T> implements Disposable {
    
    private static final String TAG = "* Subscription";
    private HashMap<Disposable, Object[]> listeners = new HashMap<>();
    private List<Promise<T>> promises = new ArrayList<>();
    public Subscription<T> subscribe(Disposable instance, Task<T>... callbacks) {
        this.listeners.put(instance, callbacks);
        return this;
    }
    public Subscription<T> subscribe(Disposable instance, Runnable... callbacks) {
        this.listeners.put(instance, callbacks);
        return this;
    }
    public Promise<T> toPromise() {
        this.promises.add(new Promise<>());
        return this.promises.get(this.promises.size() - 1);
    }
    public void unsubscribe(Disposable instance) {
        this.listeners.remove(instance);
    }
    public void emit(T value) {
        if (this.listeners != null && !this.listeners.isEmpty()) {
            this.listeners.values().forEach(handlers -> {
                Arrays.stream(handlers).forEach(callback -> {
                    if (callback instanceof Task) ((Task<T>)callback).run(value);
                    if (callback instanceof Runnable) ((Runnable)callback).run();
                });
            });
        }
        if (this.promises != null && !this.promises.isEmpty()) {
            this.promises.forEach(promise -> promise.onComplete(value));
            this.promises.clear();
        }
    }
    @Override
    public void onDispose() {
        this.listeners.clear();
        this.promises.clear();
    }
}
