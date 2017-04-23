package com.example.tetiana.randomversion2;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ListView;

public class FullyVisibleListView extends ListView {

    private int previousCount = 0;

    public FullyVisibleListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if(previousCount != getCount()) {
            int height = getChildAt(0).getHeight() * getCount();
            setHeight(height);
            previousCount = getCount();
        }

        super.onDraw(canvas);
    }

    private void setHeight(int height) {
        android.view.ViewGroup.LayoutParams params = getLayoutParams();
        params.height = height;
        setLayoutParams(params);
    }
}
