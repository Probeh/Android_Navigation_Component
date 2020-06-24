package com.probeh.navigation.utilities;
/*
    Created by Yonathan Probeh
    On Friday, Jun 12, 2020
*/
import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

public class Dictionary<TKey, TValue> extends HashMap<TKey, TValue> {
    
    public Dictionary() {}
    
    public Dictionary(@NonNull Map<? extends TKey, ? extends TValue> m) {
        super(m);
    }
    
    public Dictionary<TKey, TValue> append(TKey key, TValue value) {
        super.put(key, value);
        return this;
    }
    
    public void removeAt(TKey key) {
        super.remove(key);
    }
}
