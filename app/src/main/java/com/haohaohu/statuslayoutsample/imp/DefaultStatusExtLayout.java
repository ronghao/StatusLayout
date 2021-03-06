package com.haohaohu.statuslayoutsample.imp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.haohaohu.statuslayout.interfaces.IStatusChangeListener;
import com.haohaohu.statuslayout.base.BaseStatusExtLayout;
import com.haohaohu.statuslayoutsample.R;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

/**
 * 自定义状态效果
 *
 * @author haohao on 2017/6/19 15:28
 * @version v1.0
 */
public class DefaultStatusExtLayout extends BaseStatusExtLayout {
    private RelativeLayout mLayout;
    private TextView mLoadingText;
    private TextView mErrorText;

    private IStatusChangeListener mListener;

    DefaultStatusExtLayout(Context context) {
        mLayout = (RelativeLayout) LayoutInflater.from(context).
                inflate(R.layout.layout_extstatus_default, null);

        mLoadingText = (TextView) mLayout.findViewById(R.id.status_ext_loading_default);
        mErrorText = (TextView) mLayout.findViewById(R.id.status_ext_error_default);
        mErrorText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
