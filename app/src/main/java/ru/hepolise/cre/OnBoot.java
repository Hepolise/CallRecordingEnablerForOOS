package ru.hepolise.cre;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class OnBoot extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        CallReceiver.enableCallRecording(context);
    }
}

