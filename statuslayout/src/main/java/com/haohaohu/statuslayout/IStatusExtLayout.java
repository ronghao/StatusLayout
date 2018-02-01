package com.haohaohu.statuslayout;

import android.view.View;

/**
 * 自定义StatusExtLayout需实现该接口
 *
 * @author haohao on 2017/6/19 15:05
 * @version v1.0
 */
public interface IStatusExtLayout {

    /**
     * 获取StatusExtLayout根布局
     *
     * @return StatusExtLayout根布局
     */
    View getView();

    /**
     * 错误，ui变化监听，对于StatusExtLayout根布局
     */
    void onError();

    /**
     * 成功，ui变化监听，对于StatusExtLayout根布局
     */
    void onSuccess();

    /**
     * 加载，ui变化监听，对于StatusExtLayout根布局
     */
    void onLoading();

    /**
     * 回调，执行重试
     *
     * @param listener 回调事件监听
     */
    void setStatusChangeListener(IStatusChangeListener listener);

    /**
     * 销毁
     */
    void destroy();
}
