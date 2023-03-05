package com.example.camilly_app2_conversortemp;
package com.example.conversortempcamilly;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    private final double TRINTA_DOIS = 32;
    private final double UM_PONTO_OITO = 1.8;

    private final double DOIS_SETE_TRES = 273;

    private final double NOVE = 9;

    private EditText tempEditText;
    private Button converterCelsiusButton;

    private Button converterFahrenheitButton;

    private Button converterKelvinFahrenheitButton;

    private Button converterKelvinCelsiusButton;
    private TextView saidaValueTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tempEditText = findViewById(R.id.edittext_value);
        saidaValueTextView = findViewById(R.id.textview_value_converted);

        converterCelsiusButton = findViewById(R.id.button_celsius);
        converterCelsiusButton.setOnClickListener(this);

        converterFahrenheitButton = findViewById(R.id.button_para_fahrenheit);
        converterFahrenheitButton.setOnClickListener(this);

        converterKelvinFahrenheitButton = findViewById(R.id.button_kelvinFahrenheit);
        converterKelvinFahrenheitButton.setOnClickListener(this);

        converterKelvinCelsiusButton = findViewById(R.id.button_kelvinCelsius);
        converterKelvinCelsiusButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        double tempEntrada, tempSaida = 0;
        if(view == converterCelsiusButton){
            tempEntrada = getTemp();
            tempSaida = getCelsiusConvertion(tempEntrada);

            saidaValueTextView.setText(String.format("%.2f°F = %.2f°C",tempEntrada, getCelsiusConvertion(tempEntrada)));
        }
        if(view == converterFahrenheitButton){
            tempEntrada = getTemp();
            tempSaida = getFahreheintConvertion(tempEntrada);

            saidaValueTextView.setText(String.format("%.2f°C = %.2f°F", tempEntrada, tempSaida));
        }
        if(view == converterKelvinFahrenheitButton){
            tempEntrada = getTemp();
            tempSaida = getFahrenheitParaKelvin(tempEntrada);

            saidaValueTextView.setText(String.format("%.2f°F = %.2f°K", tempEntrada, tempSaida));
        }
        if(view == converterKelvinCelsiusButton){
            tempEntrada = getTemp();
            tempSaida = getCelsiusParaKelvin(tempEntrada);

            saidaValueTextView.setText(String.format("%.2f°C = %.2f°K", tempEntrada, tempSaida));
        }
    }

    private void mensagem(String m){
        Toast.makeText(this, m, Toast.LENGTH_SHORT).show();
    }

    private double getCelsiusConvertion(double F){

        double C = (F - TRINTA_DOIS) /  UM_PONTO_OITO;

        return C;
    }
    private double getFahreheintConvertion(double C){

        double F = (C * UM_PONTO_OITO) + TRINTA_DOIS;

        return F;
    }

    private double getFahrenheitParaKelvin(double F){

        double K = (5 *(F - TRINTA_DOIS) / NOVE)  + DOIS_SETE_TRES;

        return K;
    }

    private double getCelsiusParaKelvin(double C){

        double K = C  + DOIS_SETE_TRES;

        return K;
    }

    private double getTemp(){
        double t;
        try{
            t = Double.valueOf(tempEditText.getText().toString());
        }catch (NumberFormatException nfe){
            t = 0;
            mensagem(getString(R.string.temperatura_invalida));
        }catch (Exception e){
            t= 0;
            mensagem(getString(R.string.erro_entrada));
        }
        return t;
    }
}