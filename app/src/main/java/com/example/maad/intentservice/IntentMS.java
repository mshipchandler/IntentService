package com.example.maad.intentservice;


import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

public class IntentMS extends IntentService
{
    // The super ctor takes a string argument as described here -> https://groups.google.com/forum/#!topic/android-developers/HVBnJ15amVc
    public IntentMS()
    {
        // Since there is no default ctor available in IntentService
        super("IntentMS");
    }

    // Only 1 method to implement from IntentService
    @Override
    protected void onHandleIntent(Intent intent)
    {
        System.out.println("onHandleIntent() in IntentMS starting...");
        // Doing some work (portrayed by putting the Thread to sleep)
        for(int i = 0; i < 5; i++)
        {
            System.out.println("Putting Thread to sleep...");
            try
            { Thread.sleep(1000); }
            catch (Exception e) { System.out.println("Exception caught in onHandleIntent(): " + e); }
        }

        Intent broadcast = new Intent("com.example.maad.IntentMS.done");
        LocalBroadcastManager.getInstance(this).sendBroadcast(broadcast);
    }

}
