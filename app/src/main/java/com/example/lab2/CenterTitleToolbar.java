package com.example.lab2;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;

public class CenterTitleToolbar extends Toolbar {
    private AppCompatTextView titleTextView;

    public CenterTitleToolbar(Context context) {
        super(context);
    }

    public CenterTitleToolbar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CenterTitleToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setTitle(CharSequence title) {
        if (!TextUtils.isEmpty(title)) {
            if (titleTextView == null) {
                final Context context = getContext();
                titleTextView = new AppCompatTextView(context);
                titleTextView.setSingleLine();
                titleTextView.setEllipsize(TextUtils.TruncateAt.END);
                titleTextView.setTextAppearance(context, R.style.TextAppearance_MaterialComponents_Headline6);
                final LayoutParams lp = generateDefaultLayoutParams();
                lp.gravity = Gravity.CENTER;
                titleTextView.setLayoutParams(lp);
            }
            if (titleTextView.getParent() != this) {
                addSystemView(titleTextView);
            }
        } else if (titleTextView != null && titleTextView.getParent() == this) {
            removeView(titleTextView);
        }
        if (titleTextView != null) {
            titleTextView.setText(title);
        }
    }


    private void addSystemView(View v) {
        final ViewGroup.LayoutParams vlp = v.getLayoutParams();
        final LayoutParams lp;
        if (vlp == null) {
            lp = generateDefaultLayoutParams();
        } else if (!checkLayoutParams(vlp)) {
            lp = generateLayoutParams(vlp);
        } else {
            lp = (LayoutParams) vlp;
        }
        addView(v, lp);
    }
}
