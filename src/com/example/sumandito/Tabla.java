package com.example.sumandito;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;


public class Tabla extends Activity {
	int tabla=0; //Variable para controlar en que tabla voy, se inicializa en 0
	
	public void onCreate(Bundle x){
		super.onCreate(x);
		setContentView(R.layout.tablas);
		tabla++;//Aumento la tabla en la que estoy, por default 1.
		Button btn=(Button)findViewById(R.id.prev);
		btn.setVisibility(View.INVISIBLE);
	}
	
	public void next(View v){

		RelativeLayout cont=(RelativeLayout)findViewById(R.id.tabla);
		Button btn=(Button)findViewById(R.id.next);
		Button btn_2=(Button)findViewById(R.id.prev);
		tabla++;//Aumento la tabla para denotar a donde me quiero ir
		if (tabla > 1){
			btn_2.setVisibility(View.VISIBLE);
		}
		switch (tabla){
			case 2: //Tabla del 2.
				cont.setBackgroundResource(R.drawable.t_2);
			break;
			case 3:
				cont.setBackgroundResource(R.drawable.t_3);
			break;
			case 4:
				cont.setBackgroundResource(R.drawable.t_4);
			break;
			case 5:
				cont.setBackgroundResource(R.drawable.t_5);
			break;
			case 6:
				cont.setBackgroundResource(R.drawable.t_6);
			break;
			case 7:
				cont.setBackgroundResource(R.drawable.t_7);
			break;
			case 8:
				cont.setBackgroundResource(R.drawable.t_8);
			break;
			case 9:
				cont.setBackgroundResource(R.drawable.t_9);
				btn.setVisibility(View.INVISIBLE);
			break;
			
		
		}
	}

	public void prev(View v){

		RelativeLayout cont=(RelativeLayout)findViewById(R.id.tabla);
		Button btn=(Button)findViewById(R.id.next);
		Button btn_2=(Button)findViewById(R.id.prev);
		//Intent prev=new Intent(Tabla.this,Aprender.class);
		tabla--;//Decremento la tabla para denotar a donde me quiero ir
		if (tabla != 9){
			btn.setVisibility(View.VISIBLE);
		}
		switch (tabla){
			case 1:
				cont.setBackgroundResource(R.drawable.t_1);
				btn_2.setVisibility(View.INVISIBLE);
			break;
			case 2: //Tabla del 2.
				cont.setBackgroundResource(R.drawable.t_2);
			break;
			case 3:
				cont.setBackgroundResource(R.drawable.t_3);
			break;
			case 4:
				cont.setBackgroundResource(R.drawable.t_4);
			break;
			case 5:
				cont.setBackgroundResource(R.drawable.t_5);
			break;
			case 6:
				cont.setBackgroundResource(R.drawable.t_6);
			break;
			case 7:
				cont.setBackgroundResource(R.drawable.t_7);
			break;
			case 8:
				cont.setBackgroundResource(R.drawable.t_8);
			break;
			
			
		
		}
	}


}
