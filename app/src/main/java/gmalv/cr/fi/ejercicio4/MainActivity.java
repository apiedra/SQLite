package gmalv.cr.fi.ejercicio4;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import gmalv.cr.fi.ejercicio4.Database.DatabaseManager;

public class MainActivity extends AppCompatActivity {
    EditText user;
    EditText password;
    Intent intent;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseManager.init(this);
    }

    public void Registrar(View view) {
        switch (view.getId()) {
            case R.id.enterButton:
                break;
            case R.id.registerButton:

                intent = new Intent(this, RegistrarUsuarioActivity.class);
                startActivity(intent);

                break;
            case R.id.buttonListar:
                intent = new Intent(this, ListarUsuariosActivity.class);
                startActivity(intent);
                break;
        }


    }

}
