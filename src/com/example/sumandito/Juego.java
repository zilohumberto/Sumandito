package com.example.sumandito;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import android.*;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Juego extends Activity {
	
	int[] nivel= {5,10,20,30,40,50,60,70,80,90,100};
	int p=4;
	ProgressBar bar;
	private TextView tvniveles,tvdigito_01,tvdigito_02,tverror,tvsegundos;
	private Button btop_01,btop_02,btop_03,btop_04;
	private int nivel_id=0,suma_ok=0, digito1, digito2;
	int cantidad_intentos_malos,seg,count;
	
	Handler h = new Handler(){
		@Override
		public void handleMessage(Message msg){
			tvsegundos.setText(seg+"");
		}
	};
	boolean isR = false;
	public void onStart(){
		super.onStart();
		Thread background = new Thread(new Runnable(){
			public void run(){
				try{
					while(true){
						seg++;
						Thread.sleep(1000);
						h.sendMessage(h.obtainMessage());
					}
				}catch(Throwable t){
					
				}
			}
		});
		isR = true;
		background.start();
	}
	public void stop(){
		super.onStop();
		isR = false;
	}
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		seg=00;
		
		bar = (ProgressBar)findViewById(R.id.pb1);
		bar.incrementProgressBy(10);
		final MediaPlayer mp = new MediaPlayer();
		
		Context mc;
		mc = this;
		final Vibrator vibrator=(Vibrator)mc.getSystemService(VIBRATOR_SERVICE);
		
		
		tvniveles = (TextView)findViewById(R.id.nivel);
		tverror= (TextView)findViewById(R.id.Error);
		tvdigito_01 = (TextView)findViewById(R.id.numero1);
		tvdigito_02 = (TextView)findViewById(R.id.numero2);
		
		tvsegundos = (TextView)findViewById(R.id.segundos);
		tvsegundos.setText(seg+"");
		
		btop_01 = (Button)findViewById(R.id.op01);
		btop_01.setOnClickListener(new OnClickListener(){
		
		@SuppressLint("NewApi")
		@Override
		public void onClick(View arg0) {
			int aux = Integer.parseInt(btop_01.getText().toString());
			//evaluamos si el valor de ese boton es el correcto!	
			if(aux==suma_ok){
				//mensaje de suma correcta!
				btop_01.setTextColor(Color.GREEN);
				tvsegundos.setBackgroundColor(Color.GREEN);
				comenzarUnNuevoNivel(true,false);
				sonidito(mp);
				//Play();
			}else{
				if(mp.isPlaying()){  
		            mp.stop();
		            mp.reset();
		        } 
				vibrator.vibrate(70);
				btop_01.setTextColor(Color.WHITE);
				tvsegundos.setBackgroundColor(Color.RED);
				//btop_01.set(false);
				btop_01.setClickable(false);
				btop_01.setBackgroundResource(R.drawable.btn_disabled);
				cantidad_intentos_malos++;
	        	tverror.setText("Errores \n"+cantidad_intentos_malos);
	        	//comenzarUnNuevoNivel(false,false); 
				//llevar al activity de que te equivocastes
				//fin del juego!
			}	
		}
	    });
	    
		btop_02 = (Button)findViewById(R.id.op02);
		btop_02.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				int aux = Integer.parseInt(btop_02.getText().toString());
				//evaluamos si el valor de ese boton es el correcto!
				
				if(aux==suma_ok){
					//mensaje de suma correcta!
					btop_02.setTextColor(Color.GREEN);
					tvsegundos.setBackgroundColor(Color.GREEN);
					comenzarUnNuevoNivel(true,false);
					sonidito(mp);
					//Play();
				}else{
					if(mp.isPlaying()){  
			            mp.stop();
			            mp.reset();
			        } 
					vibrator.vibrate(70); 
					btop_02.setTextColor(Color.WHITE);
					tvsegundos.setBackgroundColor(Color.RED);
					btop_02.setBackgroundResource(R.drawable.btn_disabled);
					btop_02.setClickable(false);
					cantidad_intentos_malos++;
		        	tverror.setText("Errores \n"+cantidad_intentos_malos);
				}	
			}
	    });
		
		btop_03 = (Button)findViewById(R.id.op03);
		btop_03.setOnClickListener(new OnClickListener(){
		@Override
		public void onClick(View arg0) {
			int aux = Integer.parseInt(btop_03.getText().toString());
			//evaluamos si el valor de ese boton es el correcto!
			
			if(aux==suma_ok){
				//mensaje de suma correcta!
				btop_03.setTextColor(Color.GREEN);
				tvsegundos.setBackgroundColor(Color.GREEN);
				comenzarUnNuevoNivel(true,false);
				sonidito(mp);
				//Play();
			}else{
				if(mp.isPlaying()){  
		            mp.stop();
		            mp.reset();
		        } 
				vibrator.vibrate(70); 
				btop_03.setTextColor(Color.WHITE);
				tvsegundos.setBackgroundColor(Color.RED);
				btop_03.setClickable(false);
				btop_03.setBackgroundResource(R.drawable.btn_disabled);				
				cantidad_intentos_malos++;
	        	tverror.setText("Errores \n"+cantidad_intentos_malos);
	        	
			}	
		}
	    
	    });
		
		btop_04 = (Button)findViewById(R.id.op04);
		btop_04.setOnClickListener(new OnClickListener(){
		@Override
		public void onClick(View arg0) {
			int aux = Integer.parseInt(btop_04.getText().toString());
			//evaluamos si el valor de ese boton es el correcto!
			
			if(aux==suma_ok){
				//mensaje de suma correcta!
				btop_04.setTextColor(Color.GREEN);
				tvsegundos.setBackgroundColor(Color.GREEN);
				comenzarUnNuevoNivel(true,false);
				sonidito(mp);
				//Play();
			}else{
				if(mp.isPlaying()){  
		            mp.stop();
		            mp.reset();
		        } 
				vibrator.vibrate(70);
				btop_04.setTextColor(Color.WHITE);
				btop_04.setBackgroundResource(R.drawable.btn_disabled);
				tvsegundos.setBackgroundColor(Color.RED);
				btop_04.setClickable(false);
				btop_04.setClickable(false);				
	        	cantidad_intentos_malos++;
	        	tverror.setText("Errores \n"+cantidad_intentos_malos);
			}	
		}
	    
	    });
		
	    if(nivel_id==0){
	    	comenzarUnNuevoNivel(true, true);
	    }
	}
	
	private void sonidito(MediaPlayer mp){
		if(mp.isPlaying()){  
            mp.stop();
            mp.reset();
        } 
        try{

            AssetFileDescriptor afd;
            afd = getAssets().openFd("Coin.mp3");
            mp.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
            mp.prepare();
            mp.start();
        } catch (IllegalStateException e) {
            
        } catch (IOException e) {
           
        }
	}
	
	private void comenzarUnNuevoNivel(boolean color, boolean first){
		if(nivel_id>8){
			Intent sc=new Intent(Juego.this,Estadistica.class);
			sc.putExtra("tiempo",Long.toString(seg));
			sc.putExtra("errores",Integer.toString(cantidad_intentos_malos));
			startActivity(sc);
			//mensajito de 'you win de game, sabes sumar'
		}else{
			
			digito1 = this.generarOP(this.nivel_id);
			digito2 = this.generarOP(this.nivel_id);
			suma_ok = digito1 + digito2;
			tvniveles.setText("Nivel \n"+(nivel_id+1));
			tverror.setText("Errores \n"+this.cantidad_intentos_malos);
			tvdigito_01.setText(digito1+"");
			tvdigito_02.setText(digito2+"");
			bar.incrementProgressBy(10);
			//asignale valores a los botones!
			//int[] aux = {generarNumero(nivel[nivel_id]),generarNumero(nivel[nivel_id]),generarNumero(nivel[nivel_id]),generarNumero(nivel[nivel_id])};
			
			
			
			int[] aux = fornumAle(nivel_id);
			int s=generarNumero(4);
			aux[s] = suma_ok;
			
			btop_01.setClickable(true);
			btop_02.setClickable(true);
			btop_03.setClickable(true);
			btop_04.setClickable(true);
			btop_01.setBackgroundResource(R.drawable.btn_default);
			btop_02.setBackgroundResource(R.drawable.btn_default);
			btop_03.setBackgroundResource(R.drawable.btn_default);
			btop_04.setBackgroundResource(R.drawable.btn_default);
			
			btop_01.setText(aux[0]+"");
			//btop_01.setClickable(true);
			btop_01.setTextColor(Color.YELLOW);
			btop_02.setText(aux[1]+"");
			//btop_02.setClickable(true);
			btop_02.setTextColor(Color.YELLOW);
			btop_03.setText(aux[2]+"");
			//btop_03.setClickable(true);
			btop_03.setTextColor(Color.YELLOW);
			btop_04.setText(aux[3]+"");
			//btop_04.setClickable(true);
			btop_04.setTextColor(Color.YELLOW);
			
			nivel_id++;
			
		}
	}
	
	int[] fornumAle(int max){
		int aux[] = new int[p];
		int cond;
		for(int i=0;i<p;i++){
			cond = generarNumero(nivel[max])+generarNumero(nivel[max]);
			for(int j=0;j<i;j++){
				while(cond==aux[j]){
					cond = generarNumero(nivel[max])+generarNumero(nivel[max]);
					j=0;
				}
			}
			while(suma_ok==cond){
				cond = generarNumero(nivel[max])+generarNumero(nivel[max]);
				i=0;
			}
			aux[i] = cond;
		}
		return aux;
	}
	int generarOP(int a){
		int min=0;
		if(a==0){
			min=0;
		}else{
			min = nivel[a-1];
		}
		int i=-1;
		while(true){
			i = (int) (Math.random()*nivel[a]);
			if(i>min){
				break;
			}
		}
		return i;
	}
	
	int generarNumero(int a){
		return (int) (Math.random()*a);
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@SuppressLint("NewApi")
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}
}	