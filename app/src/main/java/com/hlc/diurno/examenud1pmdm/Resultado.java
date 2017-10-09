package com.hlc.diurno.examenud1pmdm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Clase que muestra el resultado del factorial de n
 * @Author Sergio Sánchez Polaino
 */
public class Resultado extends AppCompatActivity {

    private TextView resultado;

    private int numero, factorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        //Cargamos el recurso que nos motrará los resultados
        this.resultado = (TextView) findViewById(R.id.resultado_factorial);

        //Comprueba que la actividad acterior haya mandado un Intent con los contenidos de clave-valor FACTORIAL y NUMERO
        if(getIntent().hasExtra("FACTORIAL") && getIntent().hasExtra("NUMERO")){
            //Guardo el número en una variable y compruebo que sea natural
            this.numero = Integer.parseInt(getIntent().getStringExtra("NUMERO"));
            if(this.numero >= 0) {
                //En caso de ser natural se mostrará el mensaje con el numero y su factorial
                this.factorial = getIntent().getIntExtra("FACTORIAL", 0);
                this.resultado.setText("El factorial de " + this.numero + " es " + this.factorial);
            }else{
                //En caso de ser negativo se mostrará este mensaje
                this.resultado.setText("No existe el factorial un número negativo");
            }
        }
    }
}
