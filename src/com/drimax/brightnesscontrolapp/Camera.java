package com.drimax.brightnesscontrolapp;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Camera extends Activity implements View.OnClickListener {

	
	ImageButton imageB;  // this is the button that will take the image from the camera
	Button setBackGrndB; // to set the background image this button is used
	ImageView imageV;	// here we use this area to display the taken image from camera
	Intent image;		// this is for  the intent of taking the image in  manifest
	final static int cameraData=0;  // the details of the image taken are stored in this variable
	Bitmap bmp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.photo_take); // set the content as the photo_take xml file
		initializeV();
		InputStream is=getResources().openRawResource(R.drawable.ic_launcher);
		bmp=BitmapFactory.decodeStream(is);
	}
	
	private void initializeV(){
		imageB=(ImageButton)findViewById(R.id.takeImage); // initailizing according to id reference from the gen/R/id
		setBackGrndB=(Button)findViewById(R.id.setImage);  //initailizing according to id reference from the gen/R/id
		imageV=(ImageView)findViewById(R.id.showImage);    //initailizing according to id reference from the gen/R/id
		imageB.setOnClickListener(this);				   //set on click listner accroding to the implemented method
		setBackGrndB.setOnClickListener(this);
		
		
		
	}
	
	
	
	@Override
	public void onClick(View view) {
		
		switch(view.getId()) // get the action of the click with a switch case
		{
		case R.id.takeImage:
			image= new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE); // creates a intent for the manifest take image from camera
			startActivityForResult(image, cameraData);  // for the image taken activity we pass the image details to cameraData
			break;

		case R.id.setImage:
			try {
				getApplicationContext().setWallpaper(bmp);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			break;
		}
		
	}
	//@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode==RESULT_OK){
			Bundle extras=data.getExtras(); // get extra details from the image taken from the camera
			bmp=(Bitmap)extras.get("data"); // data is a key ,  put the details of the image to bitmap
			imageV.setImageBitmap(bmp);     // view the image from the bitmap details of te image in the application
		}
	}
	
	
	
	
	
	
	
	
	
}
