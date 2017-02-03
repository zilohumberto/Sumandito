package com.example.sumandito;

import android.app.Activity;
import android.app.TabActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.content.Intent;
import android.content.res.Resources;


public class MenuPrincipal extends Activity {
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menuprincipal);
	}
	
	public void Play(View x){
		Intent jugar=new Intent(MenuPrincipal.this,Juego.class);
		startActivity(jugar);
	}
}