package com.example.snapchat.database;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.telephony.SmsManager;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;

public class Message {

    private SmsManager sms;
    public static final int SEND_SMS_PERMISSION_REQUEST_CODE = 1;


    public boolean sendMessage(Context context, String phoneNumber,String msg)
    {

        if(checkPermission(context, Manifest.permission.SEND_SMS))
        {
            sms = SmsManager.getDefault();
            sms.sendTextMessage(phoneNumber, null, msg, null, null);
            return true;
        }
        else{
            return false;
        }
    }


    public boolean checkPermission(Context context, String permission)
    {
        int check = ContextCompat.checkSelfPermission(context, permission);
        check = PackageManager.PERMISSION_GRANTED;
        if(check == 0)
            return true;
        else
            return false;

    }
}

