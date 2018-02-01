package com.iss.statuslayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

/**
 * 实例StatusExtLayout
 * 包括加载中状态的ui和加载失败的ui
 *
 * @author haohao on 2017/6/19 14:12
 * @version v1.0
 */
class StatusExtLayout implements IStatusExtLayout {
    private RelativeLayout mLayout;
    private TextView mLoadingText;
    private TextView mErrorText;

    private IStatusChangeListener mListener;

    @SuppressLint("InflateParams")
    StatusExtLayout(Context context) {
        mLayout = (RelativeLayout) LayoutInflater.from(context).
                inflate(R.layout.layout_extstatus, null);

        mLoadingText = (TextView) mLayout.findViewById(R.id.status_ext_loading);
        mErrorText = (TextView) mLayout.findViewById(R.id.status_ext_error);

        mErrorText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLoading();
                if (mListener != null) {
                    mListener.retry();
                }
            }
        });
    }

    @Override
    public View getView() {
        return mLayout;
    }

    @Override
    public void onError() {
        mLayout.setVisibility(VISIBLE);
        mErrorText.setVisibility(VISIBLE);
        mLoadingText.setVisibility(INVISIBLE);
    }

    @Override
    public void onSuccess() {
        mLayout.setVisibility(INVISIBLE);
        mErrorText.setVisibility(INVISIBLE);
        mLoadingText.setVisibility(INVISIBLE);
    }

    @Override
    public void onLoading() {
        mLayout.setVisibility(VISIBLE);
        mErrorText.setVisibility(INVISIBLE);
        mLoadingText.setVisibility(VISIBLE);
    }

    @Override
    public void setStatusChangeListener(IStatusChangeListener listener) {
        mListener = listener;
    }

    @Override
    public void destroy() {

    }
}