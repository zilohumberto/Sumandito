package com.example.sumandito;


import android.app.Activity;
import android.app.TabActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.content.Intent;
import android.content.res.Resources;

public class Inicio extends TabActivity {
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		/*
		TabHost th = getTabHost();
		TabHost.TabSpec spec;
		Intent it;
		Resources res = getResources();
		
		
		it = new Intent().setClass(this, MenuPrincipal.class);
		
		spec = th.newTabSpec("menuprincipal").setIndicator("", res.getDrawable(R.drawable.home)).setContent(it);
		th.addTab(spec);
		
		it = new Intent().setClass(this, Tabla.class);
		spec = th.newTabSpec("aprender").setIndicator("", res.getDrawable(R.drawable.school)).setContent(it);
		th.addTab(spec);

		it = new Intent().setClass(this, Niveles.class);
		spec = th.newTabSpec("niveles").setIndicator("", res.getDrawable(R.drawable.level)).setContent(it);
		th.addTab(spec);
		
		it = new Intent().setClass(this, Avances.class);
		spec = th.newTabSpec("avances").setIndicator("", res.getDrawable(R.drawable.progress)).setContent(it);
		th.addTab(spec);
		
		
		it = new Intent().setClass(this, Opciones.class);
		spec = th.newTabSpec("opciones").setIndicator("", res.getDrawable(R.drawable.opction)).setContent(it);
		th.addTab(spec);
		
	*/
		
	}
}