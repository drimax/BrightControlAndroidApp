package com.drimax.brightnesscontrolapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class BrightControl extends Activity {

	

			float BackliteValue= 0.5f;

			@Override
			protected void onCreate(Bundle savedInstanceState) {
				// TODO Auto-generated method stub
				super.onCreate(savedInstanceState);
				setContentView(R.layout.bright_control);
				
				SeekBar backlightControl=(SeekBar)findViewById(R.id.BrightnessSeekBar);
				TextView BacklightText=(TextView)findViewById(R.id.BackLightValue);
				Button UpdateSystem=(Button)findViewById(R.id.BrightnessSettingButton);
				
				
				UpdateSystem.setOnClickListener(new OnClickListener()
				{
					public void onClick(View arg0)
					{
						int sysBacklightValue=(int)(BackliteValue*255);
						android.provider.Settings.System.putInt(getContentResolver(),android.provider.Settings.System.SCREEN_BRIGHTNESS, sysBacklightValue);
					}
				});
				
				backlightControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
					
					public void onStopTrackingTouch(SeekBar seekBar) {
						// TODO Auto-generated method stub
						
					}
					
					public void onStartTrackingTouch(SeekBar seekBar) {
						// TODO Auto-generated method stub
						
					}
					
					public void onProgressChanged(SeekBar arg0, int arg1,
							boolean arg2) {
						// TODO Auto-generated method stub
						BackliteValue=(float)arg1/100;
						WindowManager.LayoutParams BrightLayout=getWindow().getAttributes();
						BrightLayout.screenBrightness=BackliteValue;
						getWindow().setAttributes(BrightLayout);
						
					}
					
				});
				
			}
			
			


	}