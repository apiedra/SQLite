package gmalv.cr.fi.ejercicio4.Database;

import android.content.Context;

import java.sql.SQLException;
import java.util.List;

import gmalv.cr.fi.ejercicio4.PersonaModel;


public class DatabaseManager {

    private static DatabaseManager instance;
    private DatabaseHelper helper;

    public static void init(Context context) {
        if (instance == null) {
            instance = new DatabaseManager(context);
        }
    }

    public static DatabaseManager getInstance() {
        return instance;
    }

    private DatabaseManager(Context context) {
        helper = new DatabaseHelper(context);
    }

    private DatabaseHelper getHelper() {
        return helper;
    }

    public List<PersonaModel> getAllPersonaModels() {
        List<PersonaModel> PersonaModelList = null;
        try {
            PersonaModelList = getHelper().getPersonaModelListDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return PersonaModelList;
    }

    public void addPersonaModel(PersonaModel PersonaModel) {
        try {
            getHelper().getPersonaModelListDao().create(PersonaModel);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateWeather(PersonaModel PersonaModel) {
        try {
            getHelper().getPersonaModelListDao().update(PersonaModel);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
