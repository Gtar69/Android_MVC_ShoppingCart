package com.chrischang.mvc;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ThirdScreen extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.thirdscreen); 
    
		TextView showCartContent    = (TextView) findViewById(R.id.showCart);
		
		//Get Global Controller Class object (see application tag in AndroidManifest.xml)
		final Controller aController = (Controller) getApplicationContext();
        
		int cartSize = aController.getCart().getCartSize();
		
		String showString = "";
		
/******** Show Cart Products on screen - Start ********/	
		
			for(int i=0;i<cartSize;i++)
			{
				//Get product details
				String pName 	= aController.getCart().getProducts(i).getProductName();
				int pPrice   	= aController.getCart().getProducts(i).getProductPrice();
				String pDisc   	= aController.getCart().getProducts(i).getProductDesc();
				
				showString += "\n\nProduct Name : "+pName+"\n"+
	                               "Price : "+pPrice+"\n"+
	                               "Discription : "+pDisc+""+
	                               "\n -----------------------------------";
			}
		
		
		showCartContent.setText(showString);
		
/******** Show Cart Products on screen - End ********/	
		
	} 
	
}
