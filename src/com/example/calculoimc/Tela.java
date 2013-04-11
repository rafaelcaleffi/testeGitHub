package com.example.calculoimc;


import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Tela extends Activity {

	Button btCalcular;
	EditText etAltura, etPeso;
	CheckBox cbMasculino, cbFeminino;
	
	double altura, peso, resultado;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculoimc);
        
        btCalcular = (Button) findViewById(R.id.btCalcular);
        etAltura = (EditText) findViewById(R.id.etAltura);
        etPeso = (EditText) findViewById(R.id.etPeso);
        cbMasculino = (CheckBox) findViewById(R.id.cbMasculino);
        cbFeminino = (CheckBox) findViewById(R.id.cbFeminino);
        
       
        cbFeminino.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				cbMasculino.setChecked(false);
				
			}
		});
		cbMasculino.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				cbFeminino.setChecked(false);
				
			}
		});
		
        
        btCalcular.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				int i=0;
				
				String vazio ="";
				if(etAltura.getText().toString().equals(""))
				{
					vazio = "Campo altura não pode ser vazio.\n";
				}
				if(etPeso.getText().toString().equals(""))
				{
					vazio+= "Campo peso não pode ser vazio.";
				}
				
				if(etAltura.getText().toString().equals("") || etPeso.getText().toString().equals(""))
				{
					mensagemExibir("ERRO", "" + vazio);
					etAltura.requestFocus();
					return;
				}
					
				
				altura = Double.parseDouble(etAltura.getText().toString());						
				peso = Double.parseDouble(etPeso.getText().toString());
				
				
				
				altura= Math.pow(altura, 2);
				resultado = peso/altura;
				
			    String re= String.valueOf(resultado);
			    re = re.substring(0,5);
			    resultado = Double.parseDouble(re);
				
				if(cbMasculino.isChecked()){
					i=1;					
				}
				else if(cbFeminino.isChecked()){
					i=2;					
				}
				else{
					mensagemExibir("Erro", "Selecionar sexo");
					return;
				}
				
				if((i==1) && (resultado <20.7))
				{
					mensagemExibir("IMC", "Seu IMC é: "+resultado+". \nVocê está abaixo do Peso.");
				}
				else if((i==1) && (resultado <26.4))
				{
					mensagemExibir("IMC", "Seu IMC é: "+resultado+". \nVocê está no peso normal.");
				}
				
				else if((i==1) && (resultado <27.8))
				{
					mensagemExibir("IMC", "Seu IMC é: "+resultado+". \nVocê está marginalmente acima do peso.");
				}
				
				else if((i==1) && (resultado <31.1))
				{
					mensagemExibir("IMC", "Seu IMC é: "+resultado+". \nVocê está acima do peso ideal.");
				}
				
				else if (i==1)
				{
					mensagemExibir("IMC", "Seu IMC é: "+resultado+". \nVocê está obeso.");
				}
				
				else if((i==2) && (resultado <19.1))
				{
					mensagemExibir("IMC", "Seu IMC é: "+resultado+". \nVocê está abaixo do peso.");
				}
				
				else if((i==2) && (resultado <25.8))
				{
					mensagemExibir("IMC", "Seu IMC é: "+resultado+". \nVocê está no peso normal.");
				}
				
				else if((i==2) && (resultado <27.3))
				{
					mensagemExibir("IMC", "Seu IMC é: "+resultado+". \nVocê está marginalmente acima do peso.");
				}
				
				else if((i==2) && (resultado <32.3))
				{
					mensagemExibir("IMC", "Seu IMC é: "+resultado+". \nVocê está acima do peso ideal.");
				}
				else					
				{
					mensagemExibir("IMC", "Seu IMC é: "+resultado+". \nVocê está obesa.");
				}
			}
		});
        
        
    }
    
    public void mensagemExibir(String titulo, String texto)
	{
		AlertDialog.Builder mensagem = new AlertDialog.Builder(Tela.this);
		mensagem.setTitle(titulo);
		mensagem.setMessage(texto);
		mensagem.setNeutralButton("OK", new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int which) {
				//System.exit(0);
				
			}
		});
		mensagem.show();
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.calculoimc, menu);
        return true;
    }
}
