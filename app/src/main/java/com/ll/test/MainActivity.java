package com.ll.test;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private ServiceConnection mServiceConnection1;
    private ServiceConnection mServiceConnection2;
    private MyService mService1;
    private MyService mService2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(getApplicationContext(), MyService.class));
            }
        });
        findViewById(R.id.bt_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mServiceConnection1 = new ServiceConnection() {
                    @Override
                    public void onServiceConnected(ComponentName name, IBinder binder) {
                        Log.e(TAG, "onServiceConnected");
                        mService1 = ((MyService.MyBinder) binder).getService();
                        mService1.print();
                    }

                    @Override
                    public void onServiceDisconnected(ComponentName name) {
                        Log.e(TAG, "onServiceDisconnected");
                        mService1 = null;
                    }
                };
                Intent intent = new Intent(getApplicationContext(), MyService.class);
                getApplicationContext().bindService(intent, mServiceConnection1, Context.BIND_AUTO_CREATE);
            }
        });
        findViewById(R.id.bt_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getApplicationContext().unbindService(mServiceConnection1);
//                mServiceConnection2 = new ServiceConnection() {
//                    @Override
//                    public void onServiceConnected(ComponentName name, IBinder binder) {
//                        Log.e(TAG, "onServiceConnected");
//                        mService2 = ((MyService.MyBinder) binder).getService();
//                        mService2.print();
//                    }
//
//                    @Override
//                    public void onServiceDisconnected(ComponentName name) {
//                        Log.e(TAG, "onServiceDisconnected");
//                        mService2 = null;
//                    }
//                };
                Intent intent = new Intent(getApplicationContext(), MyService.class);
                getApplicationContext().bindService(intent, mServiceConnection1, Context.BIND_AUTO_CREATE);
            }
        });
        findViewById(R.id.bt_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getApplicationContext().unbindService(mServiceConnection1);
            }
        });
        findViewById(R.id.bt_5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getApplicationContext().unbindService(mServiceConnection2);
            }
        });
    }
}
