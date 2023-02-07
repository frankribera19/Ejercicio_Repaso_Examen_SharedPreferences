package com.example.ejerciciorepasoexamensharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtEmail, txtPassword;
    private Button btnLogin;

    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializar();

        if (sharedPreferences.contains(Constantes.EMAIL) && sharedPreferences.contains(Constantes.PASSWORD)){
            Toast.makeText(this, "Logeado con SharedPreferences", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, HomeActivity.class));
            finish();
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!txtEmail.getText().toString().isEmpty() && !txtPassword.getText().toString().isEmpty()){
                    //Para escrivir en las sharedPreferences se necesita un editor Editor de SharedPreferences
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(Constantes.EMAIL, txtEmail.getText().toString());
                    editor.putString(Constantes.PASSWORD, txtPassword.getText().toString());
                    editor.apply();
                    startActivity(new Intent(MainActivity.this, HomeActivity.class));
                    finish();
                }
            }
        });
    }

    private void inicializar() {
        txtEmail = findViewById(R.id.txtEmailMain);
        txtPassword = findViewById(R.id.txtPasswordMain);
        btnLogin = findViewById(R.id.btnLoginMain);

        //Asocio a la variable el fichero xml (usuario.xml)
        sharedPreferences = getSharedPreferences(Constantes.USER, MODE_PRIVATE);
    }
}