package com.haohaohu.statuslayout;

import android.content.Context;
import android.util.AttributeSet;
import com.haohaohu.statuslayout.base.BaseStatusExtLayout;
import com.haohaohu.statuslayout.base.BaseStatusLayout;

/**
 * 示例StatusLayout，继承BaseStatusLayout
 *
 * @author haohao on 2017/6/19 13:46
 * @version v1.0
 */
public class StatusLayout extends BaseStatusLayout {

    public StatusLayout(Context context) {
        super(context);
    }

    public StatusLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public StatusLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public BaseStatusExtLayout getStatusExtLayout() {
        return new StatusExtLayout(getContext());
    }
}
