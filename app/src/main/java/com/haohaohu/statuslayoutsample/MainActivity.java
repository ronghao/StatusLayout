package com.haohaohu.statuslayoutsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.haohaohu.statuslayout.interfaces.IStatusChangeListener;
import com.haohaohu.statuslayout.StatusLayout;
import com.haohaohu.statuslayoutsample.imp.DefaultActivity;

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

    public void onDefaultClick(View view) {
        Intent intent = new Intent(MainActivity.this, DefaultActivity.class);
        startActivity(intent);
    }
}
