package gmalv.cr.fi.ejercicio4;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import gmalv.cr.fi.ejercicio4.Database.DatabaseManager;

public class RegistrarUsuarioActivity extends AppCompatActivity {
    Context context = this;
    EditText nombreEditText;
    EditText edadEditText;
    EditText correoEditText;
    EditText usuarioEditText;
    EditText passEditText;
    PersonaModel persona;

    ArrayList<PersonaModel> listaPersona = new ArrayList<PersonaModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);
        initComponents();


    }

    public void Onclick(View view) {
        listaPersona.add(persona);
        guardar();
    }

    private void guardar() {

        setPersona();
        DatabaseManager.getInstance().addPersonaModel(persona);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    public void initComponents() {

        nombreEditText = (EditText) findViewById(R.id.nombreEditText);
        edadEditText = (EditText) findViewById(R.id.edadEditText);
        correoEditText = (EditText) findViewById(R.id.correoEditText);
        usuarioEditText = (EditText) findViewById(R.id.usuarioEditText);
        passEditText = (EditText) findViewById(R.id.passEditText);

    }


    public void setPersona() {
        persona = new PersonaModel();
        persona.nombre = nombreEditText.getText().toString();
        persona.contraseña = passEditText.getText().toString();
        persona.edad = edadEditText.getText().toString();
        persona.correo = correoEditText.getText().toString();
        persona.usuario = usuarioEditText.getText().toString();

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
