package com.iss.statuslayoutsample.imp;

import android.content.Context;
import android.util.AttributeSet;

import com.iss.statuslayout.BaseStatusLayout;
import com.iss.statuslayout.IStatusExtLayout;

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
    public IStatusExtLayout getStatusExtLayout() {
        return new DefaultStatusExtLayout(getContext());
    }
}
