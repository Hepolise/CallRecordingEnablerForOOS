package ru.hepolise.cre;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {
    CheckBox checkBox;
    public static String prefName = "toast_enabled";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBox = findViewById(R.id.show_toast);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        checkBox.setChecked(sharedPreferences.getBoolean(prefName, true));
        permissions();
    }
    private void permissions() {
        int REQUEST_CODE_ASK_PERMISSIONS = 123;
        String[] request = new String[]{Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.PROCESS_OUTGOING_CALLS};

        if ((checkSelfPermission(Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED)
                || (checkSelfPermission(Manifest.permission.PROCESS_OUTGOING_CALLS) != PackageManager.PERMISSION_GRANTED)) {
            requestPermissions(request,
                    REQUEST_CODE_ASK_PERMISSIONS);
        }
    }
    public void enableCallRecording(View view) {
        CallReceiver.enableCallRecording(getApplicationContext(), true);
    }
    public void onCheckBoxClicked(View view) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        sharedPreferences.edit().putBoolean(prefName, checkBox.isChecked()).apply();
    }
}
