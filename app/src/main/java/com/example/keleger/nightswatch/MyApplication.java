package com.example.keleger.nightswatch;

import android.app.Application;
import android.content.Context;

/**
 * Created by keleger on 16/5/18.
 */
public class MyApplication extends Application {
        private static Context context;

        @Override
        public void onCreate() {
            super.onCreate();
            context = getApplicationContext();
        }

        public static Context getContext() {
            return context;
        }
}
