package com.haohaohu.statuslayout;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import com.haohaohu.statuslayout.impl.SimpleStatusChangeListener;

/**
 * 状态布局
 * 加载中、加载成功、加载失败
 *
 * @author haohao on 2017/6/19 13:46
 * @version v1.0
 */
public abstract class BaseStatusLayout extends RelativeLayout {

    //被包含子控件
    protected View mChildView;

    private IStatusExtLayout mStatusExtLayout;

    private IStatusChangeListener mListener;

    public BaseStatusLayout(Context context) {
        super(context);
        initView();
    }

    public BaseStatusLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public BaseStatusLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        mStatusExtLayout = getStatusExtLayout();
        if (mStatusExtLayout == null) return;
        LayoutParams params =
                new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        addView(mStatusExtLayout.getView(), params);
        mListener = new SimpleStatusChangeListener();
        mStatusExtLayout.setStatusChangeListener(mListener);
    }

    public abstract IStatusExtLayout getStatusExtLayout();

    public void setStatusListener(IStatusChangeListener mListener) {
        this.mListener = mListener;
        if (mStatusExtLayout != null) mStatusExtLayout.setStatusChangeListener(mListener);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        //onAttachedToWindow方法中mChildView始终是第0个child，把content放到构造函数中，mChildView最后被inflate
        mChildView = getChildAt(1);
        init();
    }

    public void showError() {
        if (mStatusExtLayout != null) mStatusExtLayout.onError();
        if (mChildView != null) {
            mChildView.setVisibility(INVISIBLE);
        } else {
            Log.e("警告", "子布局未定义");
        }
        if (mListener != null) mListener.onError();
    }

    public void showLoading() {
        if (mStatusExtLayout != null) mStatusExtLayout.onLoading();
        if (mChildView != null) {
            mChildView.setVisibility(INVISIBLE);
        } else {
            Log.e("警告", "子布局未定义");
        }
        if (mListener != null) mListener.onLoading();
    }

    public void showSuccess() {
        if (mStatusExtLayout != null) mStatusExtLayout.onSuccess();
        if (mChildView != null) {
            mChildView.setVisibility(VISIBLE);
        } else {
            Log.e("警告", "子布局未定义");
        }
        if (mListener != null) mListener.onSuccess();
    }

    /**
     * 自定义初始化,可重写
     */
    public void init() {
        showLoading();
    }

    /**
     * 销毁view,可重写
     * 界面退出时候调用
     */
    public void destroy() {
        if (mStatusExtLayout != null) mStatusExtLayout.destroy();
    }
}
