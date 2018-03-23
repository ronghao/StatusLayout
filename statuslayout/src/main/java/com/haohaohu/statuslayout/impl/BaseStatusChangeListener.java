package com.haohaohu.statuslayout.impl;

import com.haohaohu.statuslayout.interfaces.IStatusChangeListener;

/**
 * 实现部分方法的状态变化回调接口
 *
 * @author haohao(ronghao3508@gmail.com) on 2018/3/23 22:36
 * @version v1.0
 */
public abstract class BaseStatusChangeListener implements IStatusChangeListener {
    public BaseStatusChangeListener() {
    }

    @Override
    public void onSuccess() {
    }

    @Override
    public void onLoading() {
    }

    @Override
    public void onError() {
    }
}
