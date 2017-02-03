package com.example.sumandito;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Estadistica extends Activity {
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.estadisticas);
		Bundle extras=getIntent().getExtras();
		TextView tvtiempo,tverrores;
		if (extras!=null){
			tvtiempo=(TextView)findViewById(R.id.tiempo);
			tverrores=(TextView)findViewById(R.id.errores);
			tvtiempo.setText(String.format("%s tiempo", extras.getString("tiempo")));
			tverrores.setText(String.format("%s errores",extras.getString("errores")));
		}
	}
	public void volver(View v){
		Intent MP=new Intent(Estadistica.this,Inicio.class);
		startActivity(MP);		
	}
	public void newgame(View v){
		Intent N_Juego=new Intent(Estadistica.this,Juego.class);
		startActivity(N_Juego);	
	}
}