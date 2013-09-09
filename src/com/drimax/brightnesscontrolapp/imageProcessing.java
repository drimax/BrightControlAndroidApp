package com.drimax.brightnesscontrolapp;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.provider.MediaStore.Images;

public class imageProcessing {
	
	Bitmap bmp;
	
	
	private void setImage(Bitmap bmp)
	{
		this.bmp=bmp;
	}

	private Bitmap toGrayScale(Bitmap bm){
		
		int width,height;
		height=bm.getHeight();
		width=bm.getWidth();
		
		Bitmap bmGrayScale=Bitmap.createBitmap(width,height,Bitmap.Config.RGB_565);
		Canvas c=new Canvas(bmGrayScale);
		Paint paint=new Paint();
		ColorMatrix colorM=new ColorMatrix();
		colorM.setSaturation(0);
		ColorMatrixColorFilter filter=new ColorMatrixColorFilter(colorM);
		paint.setColorFilter(filter);
		c.drawBitmap(bm, 0,0, paint);
		return bmGrayScale;
		
	}
	
	
}
