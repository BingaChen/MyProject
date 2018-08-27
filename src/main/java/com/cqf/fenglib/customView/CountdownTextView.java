package com.cqf.fenglib.customView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.widget.TextView;

import com.cqf.fenglib.custom.MyThread;

import java.text.SimpleDateFormat;

/**
 * Created by Binga on 8/24/2018.
 */

@SuppressLint("AppCompatCustomView")
public class CountdownTextView extends TextView {
    MyThread t;
    public SimpleDateFormat format;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    if (format!=null){
                        setText(format.format(msg.arg1*1000)+"");
                    }else {
                        setText(msg.arg1+"");
                    }
                    break;
            }
        }
    };
    public CountdownTextView(Context context) {
        super(context);
    }
    public void countDown(final int countdownNum){
        t=new MyThread(new Runnable() {
            @Override
            public void run() {
                for (int i = countdownNum; i >=0 ; i--) {
                    if (t.runTag){
                        Message message=Message.obtain();
                        message.what=1;
                        message.arg1=i;
                        handler.sendMessage(message);
                        SystemClock.sleep(1000);
                    }
                }
            }
        });
        t.start();
    }
}
