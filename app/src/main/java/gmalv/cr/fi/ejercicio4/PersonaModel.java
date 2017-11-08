package gmalv.cr.fi.ejercicio4;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by APiedra on 08/11/2017.
 */

public class PersonaModel {

    @DatabaseField
    public String nombre;
    @DatabaseField
    public String telefono;
    @DatabaseField
    public String correo;
    @DatabaseField
    public String edad;
    @DatabaseField
    public String usuario;
    @DatabaseField
    public String contraseña;

    //public int edad;
}

