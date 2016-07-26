package com.example.keleger.nightswatch;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class PermissionManageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission_manage);

        CheckBox locationCheckBox = (CheckBox) findViewById(R.id.locationCheckBox);
        CheckBox contactsCheckBox = (CheckBox) findViewById(R.id.contactscheckBox);

        SharedPreferences pre = getSharedPreferences("permissions", Activity.MODE_WORLD_READABLE);
        Boolean contactChecked = pre.getBoolean("contact", false);
        Boolean locationChecked = pre.getBoolean("location", false);

        locationCheckBox.setChecked(locationChecked);
        contactsCheckBox.setChecked(contactChecked);
    }

    private void contactChecked(){
        CheckBox contactsCheckBox = (CheckBox) findViewById(R.id.contactscheckBox);
    }
    public void onChecked(View v) {
        SharedPreferences contactShare = getSharedPreferences("permissions", Activity.MODE_WORLD_READABLE);
        SharedPreferences.Editor permissionEditor = contactShare.edit();
        if (v.getId() == R.id.contactscheckBox){
            CheckBox contactsCheckBox = (CheckBox) findViewById(R.id.contactscheckBox);
            if (contactsCheckBox.isChecked()) {
                permissionEditor.putBoolean("contact", true);
            } else {
                permissionEditor.putBoolean("contact", false);
            }
        }
        if (v.getId() == R.id.locationCheckBox){
            CheckBox locationCheckBox = (CheckBox) findViewById(R.id.locationCheckBox);
            if (locationCheckBox.isChecked()) {
                permissionEditor.putBoolean("location", true);
            } else {
                permissionEditor.putBoolean("location", false);
            }
        }
        permissionEditor.commit();
    }
}
