package com.drimax.brightnesscontrolapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class StartingPoint extends Activity {

	Thread timeSpan;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_point);
        
        
        timeSpan=new Thread(){

			@Override
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				finally{
					Intent CameraInt=new Intent("com.drimax.brightnesscontrol.BRIGHTCONTROL");
					startActivity(CameraInt);
				}
			}
        	
        };
        timeSpan.start();
        
        
        
    }
	@Override
	protected void onPause() {
		super.onPause();
		finish();
	}



    
}
