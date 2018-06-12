package com.atilsamancioglu.broadcastsendingdata;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendBroadcast(View view) {
        Intent intent = new Intent(this, BroadcastInner.class);
        Bundle bundle = new Bundle();
        bundle.putString("name","James");
        bundle.putInt("age",50);
        bundle.putString("instrument","Guitar");
        intent.putExtras(bundle);
        sendBroadcast(intent);
    }


    public static class BroadcastInner extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bundle = intent.getExtras();
            String name = bundle.getString("name");
            int age = bundle.getInt("age");
            String instrument = bundle.getString("instrument");

            Toast.makeText(context, "name: " + name + " age: " + age + " instrument: " + instrument, Toast.LENGTH_SHORT).show();

        }
    }
}
