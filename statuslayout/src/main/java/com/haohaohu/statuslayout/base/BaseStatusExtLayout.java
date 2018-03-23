package com.haohaohu.statuslayout.base;

import android.view.View;

import com.haohaohu.statuslayout.interfaces.IStatusChangeListener;

/**
 * 自定义StatusExtLayout
 * 需实现该接口
 *
 * @author haohao on 2017/6/19 15:05
 * @version v1.0
 */
public abstract class BaseStatusExtLayout {

    /**
     * 获取StatusExtLayout根布局
     *
     * @return StatusExtLayout根布局
     */
    public abstract View getView();

    /**
     * 错误，ui变化监听，对于StatusExtLayout根布局
     */
    public abstract void onError();

    /**
     * 成功，ui变化监听，对于StatusExtLayout根布局
     */
    public abstract void onSuccess();

    /**
     * 加载，ui变化监听，对于StatusExtLayout根布局
     */
    public abstract void onLoading();

    /**
     * 回调，执行重试
     *
     * @param listener 回调事件监听
     */
    public abstract void setStatusChangeListener(IStatusChangeListener listener);

    /**
     * 销毁
     */
    public abstract void destroy();
}
