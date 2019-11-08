package com.asignatura.solemne02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Cmr_act extends AppCompatActivity {

    private EditText etRut;
    private TextView punto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmr_act);
        etRut=findViewById(R.id.etRut);
        etRut.setText(getIntent().getStringExtra("rut"));
        punto=findViewById(R.id.idPunt);
    }

    public void calcular(View view)
    {
        if (etRut.getText().toString().equals("183593897"))
        {
            punto.setText("Tiene: 12000 puntos\n puede reclamar su Tablet");
        }
        if (etRut.getText().toString().equals("114418455"))
        {
            punto.setText("Tiene: 16000 puntos\n puede reclamar su Refrigerador");
        }

    }
}
