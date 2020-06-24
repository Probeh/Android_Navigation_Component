package com.probeh.navigation.utilities;
/*
    Created by Yonathan Probeh
    On Friday, Jun 05, 2020
*/

public class Awaiter<T> {
    
    private static final String TAG = "* Awaiter";
    private long timeout;
    private Promise<T> promise;
    private Object callback;
    public Awaiter(Promise<T> promise) {
        this.promise = promise;
    }
    public Awaiter(Promise<T> promise, long timeout) {
        this(promise);
        this.timeout = timeout;
    }
    public Promise<T> then(Task<T> callback) {
        this.callback = callback;
        return this.promise.then(this);
    }
    public Promise<T> then(Runnable callback) {
        this.callback = callback;
        return this.promise.then(this);
    }
    public long getTimeout() {
        return this.timeout;
    }
    public void getAwaiter(T value) {
        if (this.callback instanceof Task) ((Task<T>)this.callback).run(value);
        if (this.callback instanceof Runnable) ((Runnable)this.callback).run();
    }
}
