package com.asignatura.solemne02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Deudas_act extends AppCompatActivity {

    private Spinner cuotas, tipoPago;
    private EditText deuda, saldo;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deudas_act);
        cuotas=findViewById(R.id.spCuotas);
        tipoPago=findViewById(R.id.spTipoPago);
        deuda=findViewById(R.id.etDeuda);
        saldo=findViewById(R.id.etSaldo);
        resultado = findViewById(R.id.resultado);


        ArrayAdapter cuotass = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getIntent().getStringArrayExtra("cuota"));
        ArrayAdapter pagos = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getIntent().getStringArrayExtra("tipo"));
        cuotas.setAdapter(cuotass);
        tipoPago.setAdapter(pagos);
    }

    public void Calcular(View view)
    {
        if (tipoPago.getSelectedItem().equals("Pago en cuotas"))
        {

            if (cuotas.getSelectedItem().equals("1"))
            {
                resultado.setText("Gasto: "+Integer.parseInt(deuda.getText().toString())+"\n Saldo actual: "+String.valueOf(Integer.parseInt(saldo.getText().toString())-Integer.parseInt(deuda.getText().toString()) ));
            }
            if (cuotas.getSelectedItem().equals("2"))
            {
                resultado.setText("Primera cuota a pagar: "+String.valueOf(((Integer.parseInt(deuda.getText().toString())+(Integer.parseInt(deuda.getText().toString())*0.02))/2)+"\nDeuda con interés: "+(Integer.parseInt(deuda.getText().toString())+(Integer.parseInt(deuda.getText().toString())*0.02))));//se terminaria pagando el doble segun la logica del enunciado
            }
        }
        if (tipoPago.getSelectedItem().equals("Pagar todo")) {
            if(Integer.parseInt(saldo.getText().toString())>50000)
            {
                deuda.setText("50000");
                resultado.setText("Vuelto:"+String.valueOf(Integer.parseInt(saldo.getText().toString())-50000));
            }
            else
            {
                resultado.setText("saldo insuficiente");
            }
        }


    }
}
