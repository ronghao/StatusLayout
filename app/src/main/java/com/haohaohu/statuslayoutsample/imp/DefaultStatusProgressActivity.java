package com.haohaohu.statuslayoutsample.imp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.haohaohu.statuslayout.interfaces.IStatusChangeListener;
import com.haohaohu.statuslayoutsample.R;

public class DefaultStatusProgressActivity extends AppCompatActivity {

    private DefaultStatusProgressLayout mStatusLayout;
    private TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default_progress_status);
        init();
    }

    private void init() {
        mStatusLayout = (DefaultStatusProgressLayout) findViewById(R.id.default_status_layout);
        mText = (TextView) findViewById(R.id.text);

        mStatusLayout.setStatusListener(new IStatusChangeListener() {
            @Override
            public void onSuccess() {
                mText.setText("加载成功");
                mText.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mStatusLayout.showProgress();
                    }
                });
            }

            @Override
            public void onLoading() {

            }

            @Override
            public void onError() {

            }

            @Override
            public void retry() {
                mStatusLayout.showLoading();
                mStatusLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mStatusLayout.showSuccess();
                    }
                }, 3000);
            }
        });

        mStatusLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                mStatusLayout.showError();
            }
        }, 3000);

        mStatusLayout.showLoading();
    }
}
