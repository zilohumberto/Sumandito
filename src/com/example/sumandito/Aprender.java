package com.example.sumandito;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Aprender extends Activity {
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aprende);
	}
	public void Tablas(View x){
		Intent table=new Intent(Aprender.this,Tabla.class);
		startActivity(table);
		
	}
}
