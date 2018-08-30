package com.cqf.fenglib.base;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cqf.fenglib.R;


/**
 * Created by wpc on 2017/11/29 0029.
 * 布局中include R.layout.fragment_toolbar
 * settitle  setlefticon enableback
 */

public abstract class BaseToolbarActivity extends BaseActivity {
    protected RelativeLayout rlBaseTile;
    protected TextView tvTitle, tvRight;
    protected ImageView ivBack;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        rlBaseTile=findViewById(R.id.rlBaseTile);
        tvTitle=findViewById(R.id.tvTitle);
        tvRight=findViewById(R.id.tvRight);
        ivBack=findViewById(R.id.ivBack);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        super.onCreate(savedInstanceState);
    }
    public void setTitle(String title) {
        tvTitle.setText(title);
    }

}
