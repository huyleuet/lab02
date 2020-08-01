package com.example.lab2;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

public class CustomFontTextView extends AppCompatTextView {
    public CustomFontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        int typefaceType;
        TypedArray array = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.CustomFontTextView,
                0, 0);
        try {
            typefaceType = array.getInteger(R.styleable.CustomFontTextView_font_name,0);
        }finally {
            array.recycle();
        }
        if (!isInEditMode()) {
            int font = Utils.getFont(typefaceType);
            applyCustomFont(context,font);
        }
    }

    private void applyCustomFont(Context context, int font) {
        Typeface tf = FontCache.get(font,context);
        setTypeface(tf);
    }
}
