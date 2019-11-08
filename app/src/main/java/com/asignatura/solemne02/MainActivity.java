package com.asignatura.solemne02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etLogin, etContra;
    private TextView recupera;
    private Button btnLogin;
    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etLogin = findViewById(R.id.etRut);
        etContra = findViewById(R.id.etContra);
        btnLogin = findViewById(R.id.btnLogin);
        pb = findViewById(R.id.progressBar);
        recupera = findViewById(R.id.txtRecupera);

        pb.setVisibility(View.INVISIBLE);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Task().execute(etLogin.getText().toString());
            }
        });
    }

    class Task extends AsyncTask<String, Void, String>
    {
        @Override
        protected void onPreExecute() {
            pb.setVisibility(View.VISIBLE);
            recupera.setText("");
            btnLogin.setEnabled(false);
        }

        @Override
        protected String doInBackground(String... strings) {
            try
            {
                for (int i = 1; i<=5; i++)
                {
                    Thread.sleep(1000);
                }
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            pb.setVisibility(View.INVISIBLE);
            btnLogin.setEnabled(true);
            if(etLogin.getText().toString().equals("114418455") & etContra.getText().toString().equals("123"))
            {
                entrar();
            }
            else
            {
                if (etLogin.getText().toString().equals("183593897") & etContra.getText().toString().equals("123"))
                {
                    entrar();
                }
                else
                {
                    recupera.setText("Recuperar Contraseña");
                }
            }
        }

        private void entrar()
        {
            Toast.makeText(getBaseContext(), "logueado correctamente", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getBaseContext(), Home_act.class);
            i.putExtra("rut", etLogin.getText().toString());
            String[] Bundle = {"CMR puntos", "Deudas Pendiente"};
            i.putExtra("bundle", Bundle);
            startActivity(i);
        }

    }


}






























/*
* package com.asignatura.actividad_22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class Login_act extends AppCompatActivity {

    private Button btn;
    private EditText et1, et2;
    private TextView tv5;
    private ProgressBar pb;
    private int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_act);
        btn = findViewById(R.id.btnEntrar);
        et1 =  findViewById(R.id.txtNombre);
        et2 = findViewById(R.id.txtContra);
        pb = findViewById(R.id.progressBar);
        tv5 = findViewById(R.id.textView5);

        pb.setVisibility(View.INVISIBLE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Task().execute(et1.getText().toString());
            }
        });
    }


    private void cargar()
    {
        i=0;
        Timer t = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                i++;
                pb.setProgress(i);
            }
        };
        t.schedule(tt, 0, 100);
    }

    class Task extends AsyncTask<String, Void, String>
    {

        @Override
        protected void onPreExecute() {
            pb.setVisibility(View.VISIBLE);
            btn.setEnabled(false);
        }

        @Override
        protected String doInBackground(String... strings) {
            try
            {
                for (int i = 1; i<=5; i++)
                {
                    Thread.sleep(1000);
                }
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            pb.setVisibility(View.INVISIBLE);
            btn.setEnabled(true);
            Toast.makeText(getBaseContext(), "logueado correctamente", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getBaseContext(), other_act.class);
            i.putExtra("user", et1.getText().toString());
            i.putExtra("contra", et2.getText().toString());
            startActivity(i);
        }

    }
}

*
*
*
*
*
*
*
*
*
*
* package com.asignatura.actividad_22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Segundo(View view)
    {
        try
        {
            for (int i = 0; i<=10; i++)
            {
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public void hilos(View view)
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try
                {
                    for (int i = 1; i<=10; i++)
                    {
                        Thread.sleep(1000);
                    }
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        Toast.makeText(getBaseContext(), "Tarea larga finalizada", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).start();
    }
    public void login(View view)
    {
        Intent i = new Intent(this, Login_act.class);
        startActivity(i);
    }
}

* */
