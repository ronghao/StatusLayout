package com.haohaohu.statuslayoutsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.haohaohu.statuslayout.IStatusChangeListener;
import com.haohaohu.statuslayout.StatusLayout;

public class MainActivity extends AppCompatActivity {

    private StatusLayout mStatusLayout;
    private TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mStatusLayout = (StatusLayout) findViewById(R.id.status_layout);
        mText = (TextView) findViewById(R.id.text);

        mStatusLayout.setStatusListener(new IStatusChangeListener() {
            @Override
            public void onSuccess() {
                mText.setText("加载成功");
                mText.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mStatusLayout.showError();
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
    }
}
