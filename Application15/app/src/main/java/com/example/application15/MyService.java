package com.example.application15;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Binder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MyService extends Service {

    private final IBinder steviesBinder = new MyLocalBinder();

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return steviesBinder;
    }

    public String getCurrentTime(){
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        return (df.format(new Date()));
    }

    public class MyLocalBinder extends Binder {
        MyService getService(){
            return MyService.this;
        }
    }
}
