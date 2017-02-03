package com.example.sumandito;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Niveles extends Activity {
	private Button uno;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.niveles);
		uno = (Button)findViewById(R.id.n1);
	}
	public void nivel_uno(View v){
		Intent MP=new Intent(Niveles.this,Juego.class);
		startActivity(MP);	
	}
	
}