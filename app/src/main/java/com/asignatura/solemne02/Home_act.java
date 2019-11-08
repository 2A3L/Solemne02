package com.asignatura.solemne02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Home_act extends AppCompatActivity {

    private TextView txtRut;
    private Spinner sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_act);
        txtRut=findViewById(R.id.txtRut);
        sp=findViewById(R.id.spOpciones);

        txtRut.setText(getIntent().getStringExtra("rut"));
        ArrayAdapter a = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                getIntent().getStringArrayExtra("bundle"));
        sp.setAdapter(a);
    }

    public void Url(View view)
    {
        Uri uri = Uri.parse("https://www.falabella.com/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void llamar(View view)
    {
        Intent i = new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel:6803906000"));
        startActivity(i);
    }

    public void Accion(View view)
    {
        if (sp.getSelectedItem().equals("CMR puntos"))
        {
            Intent i = new Intent(getBaseContext(), Cmr_act.class);
            i.putExtra("rut", getIntent().getStringExtra("rut"));
            startActivity(i);
        }
        if (sp.getSelectedItem().equals("Deudas Pendiente"))
        {
            Intent i = new Intent(getBaseContext(), Deudas_act.class);
            String[] cuota={"1", "2"};
            i.putExtra("cuota", cuota);
            String[] tipo={"Pago en cuotas", "Pagar todo"};
            i.putExtra("tipo", tipo);
            startActivity(i);
        }
    }

}

