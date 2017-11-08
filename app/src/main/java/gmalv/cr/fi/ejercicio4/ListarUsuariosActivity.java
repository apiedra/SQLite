package gmalv.cr.fi.ejercicio4;

import android.app.ExpandableListActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import gmalv.cr.fi.ejercicio4.Database.DatabaseManager;

public class ListarUsuariosActivity extends ExpandableListActivity implements
        ExpandableListView.OnChildClickListener {
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    ArrayList<String> groupItem = new ArrayList<String>();
    ArrayList<Object> childItem = new ArrayList<Object>();
    List<PersonaModel> listaPersona;
    Persona persona;
    ArrayList<Persona> adapterList = new ArrayList<Persona>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_listar_usuarios);
        sharedPref = getSharedPreferences(
                getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        editor = sharedPref.edit();
        leer();

        ExpandableListView expandbleLis = getExpandableListView();
        expandbleLis.setDividerHeight(2);
        expandbleLis.setGroupIndicator(null);
        expandbleLis.setClickable(true);
        PersonaAdapter mPersonaAdapter = new PersonaAdapter(groupItem, childItem);
        mPersonaAdapter
                .setInflater(
                        (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE),
                        this);
        getExpandableListView().setAdapter(mPersonaAdapter);
        expandbleLis.setOnChildClickListener(this);
        setGroupData();
        setChildGroupData();
    }


    private void leer() {
        if(listaPersona!=null)
            listaPersona.clear();
        listaPersona = DatabaseManager.getInstance().getAllPersonaModels();

        if (listaPersona != null) {
            for (PersonaModel item : listaPersona) {
                persona = new Persona();
                persona.setNombre(item.nombre);
                persona.setUsuario(item.usuario);
                persona.setCorreo(item.correo);
                persona.setContraseña(item.contraseña);
                persona.setTelefono(item.telefono);
                adapterList.add(persona);
            }
        }
    }

    public void setGroupData() {

        if (listaPersona != null) {
            for (Persona per : adapterList) {
                persona = new Persona();
                groupItem.add(per.getUsuario());
            }
        }
    }

    public void setChildGroupData() {
        for (Persona per : adapterList) {
            ArrayList<String> child = new ArrayList<String>();
            child.add(per.getNombre());
            child.add(per.getCorreo());
            child.add(per.getEdad());
            child.add(per.getTelefono());
            childItem.add(child);
        }

    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v,
                                int groupPosition, int childPosition, long id) {
        Toast.makeText(ListarUsuariosActivity.this, "Clicked On Child",
                Toast.LENGTH_SHORT).show();
        return true;
    }
}
