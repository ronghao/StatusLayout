package com.haohaohu.statuslayoutsample.imp;

import android.content.Context;
import android.util.AttributeSet;

import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.haohaohu.statuslayout.base.BaseStatusLayout;
import com.haohaohu.statuslayout.base.BaseStatusExtLayout;
import com.haohaohu.statuslayoutsample.R;

/**
 * 自定义状态布局
 *
 * @author haohao on 2017/6/19 15:27
 * @version v1.0
 */
public class DefaultStatusProgressLayout extends BaseStatusLayout {
    private RelativeLayout mProgress;

    public DefaultStatusProgressLayout(Context context) {
        super(context);
    }

    public DefaultStatusProgressLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DefaultStatusProgressLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public BaseStatusExtLayout getStatusExtLayout() {
        return new DefaultStatusExtLayout(getContext());
    }

    @Override
    public void initStatus() {
        mProgress = (RelativeLayout) LayoutInflater.from(getContext())
                .inflate(R.layout.layout_extstatus_progress, null);
        LayoutParams params =
                new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        addView(mProgress, params);
        super.initStatus();
    }

    @Override
    public void showError() {
        super.showError();
        mProgress.setVisibility(GONE);
    }

    @Override
    public void showLoading() {
        super.showLoading();
        mProgress.setVisibility(GONE);
    }

    @Override
    public void showSuccess() {
        super.showSuccess();
        mProgress.setVisibility(GONE);
    }

    public void showProgress() {
        mProgress.setVisibility(VISIBLE);
    }
}
