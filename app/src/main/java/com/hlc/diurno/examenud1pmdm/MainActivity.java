package com.hlc.diurno.examenud1pmdm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Clase principal de la aplicación
 * @Author Sergio Sánchez Polaino
 */
public class MainActivity extends AppCompatActivity {

    private EditText numero;
    private Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Cargo los recursos que corresponden a esta activity
        this.numero = (EditText) findViewById(R.id.numero_factorial);
        this.boton = (Button) findViewById(R.id.calcular);

        //Al botón le asigno una escucha para que haga una tarea al ser pulsado
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Cuando se pulsa al botón vamos a pasar los datos a otra activity para que muestre el resultado
                Intent resultado = new Intent(view.getContext(), Resultado.class);
                try {
                    //Calculamos el factorial del número indicado
                    int factorial = factorial(Integer.parseInt(numero.getText().toString()));
                    //Le pasamos los datos del número y del resultado de su factorial
                    resultado.putExtra("NUMERO", numero.getText().toString());
                    resultado.putExtra("FACTORIAL", factorial);
                    //Iiniciamos la activity
                    startActivity(resultado);
                }catch (NumberFormatException e){
                    //Podemos encontrarnos esta excepción cuando convertimos el string a un entero
                }
            }
        });
    }

    /**
     * Método que calcular el factorial de un número natural. Devuelve -1 si el número pasado es negativo ya que no existen
     * los factoriales de los números negativos
     * @param n Factorial del número a calcular
     * @return El factorial de n
     */
    public int factorial(int n){
        int resultado = 1;

        //Si el número es natural se calcula el factorial, si no devuelve -1
        if(n >= 0) {
            for (int i = 1; i <= n; i++) {
                resultado *= i;
            }
        }else{
            return -1;
        }

        return resultado;
    }

}


