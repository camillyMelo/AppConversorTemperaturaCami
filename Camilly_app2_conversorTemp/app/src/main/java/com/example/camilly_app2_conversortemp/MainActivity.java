package com.example.camilly_app2_conversortemp;

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

    private EditText tempEditText;
    private Button converterCelsiusButton;
    private TextView saidaValueTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tempEditText = findViewById(R.id.edittext_value);
        saidaValueTextView = findViewById(R.id.textview_value_converted);

        converterCelsiusButton = findViewById(R.id.button_celsius);
        converterCelsiusButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == converterCelsiusButton){
            double tempF;
            try{
                tempF = Double.valueOf(tempEditText.getText().toString());
            }catch (NumberFormatException nfe){
                tempF = 0;
                mensagem("Temperatura de entrada inválida!");
            }catch (Exception e){
                tempF = 0;
                mensagem("Erro na entrada de dados!");
            }
            saidaValueTextView.setText(String.format("%.2f°F = %.2f°C",tempF, getCelsiusConvertion(tempF)));
        }
    }

    private void mensagem(String m){
        Toast.makeText(this, m, Toast.LENGTH_SHORT).show();
    }

    private double getCelsiusConvertion(double F){

        double C = (F - TRINTA_DOIS) /  UM_PONTO_OITO;

        return C;
    }
}