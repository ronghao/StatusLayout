package com.haohaohu.statuslayoutsample.imp;

import android.content.Context;
import android.util.AttributeSet;

import com.haohaohu.statuslayout.base.BaseStatusLayout;
import com.haohaohu.statuslayout.base.BaseStatusExtLayout;

/**
 * @author haohao on 2017/6/19 15:27
 * @version v1.0
 */
public class DefaultStatusLayout extends BaseStatusLayout {
    public DefaultStatusLayout(Context context) {
        super(context);
    }

    public DefaultStatusLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DefaultStatusLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public BaseStatusExtLayout getStatusExtLayout() {
        return new DefaultStatusExtLayout(getContext());
    }
}
