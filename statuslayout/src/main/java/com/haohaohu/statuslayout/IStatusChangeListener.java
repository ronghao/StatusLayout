package com.haohaohu.statuslayout;

/**
 * 状态回调接口
 *
 * @author haohao on 2017/6/19 14:36
 * @version v1.0
 */
public interface IStatusChangeListener {
    /**
     * 回调，切换到成功状态
     */
    void onSuccess();

    /**
     * 回调，切换到加载状态
     */
    void onLoading();

    /**
     * 回调，切换到错误状态
     */
    void onError();

    /**
     * 回调，执行重试
     */
    void retry();
}
