package com.example.lab2;

import android.content.Context;
import android.graphics.Typeface;

import androidx.core.content.res.ResourcesCompat;

import java.util.Hashtable;

public class FontCache {

    private static final Hashtable<Integer, Typeface> fontCache = new Hashtable<Integer, Typeface>();

    public static Typeface get(int name, Context context) {
            if (!fontCache.containsKey(name)) {
                try {
                    Typeface tf = ResourcesCompat.getFont(context,name);
                    fontCache.put(name, tf);
                    return tf;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    return null;
                }
            }
            return fontCache.get(name);
    }
}
