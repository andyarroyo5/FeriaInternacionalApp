package edu.udem.feriainternacional;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class InicioSesionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);
    }

    public void inicioSesionGoogle(View view)
    {

        Toast.makeText(this, "Inicio Sesión", Toast.LENGTH_SHORT).show();
    }



}
