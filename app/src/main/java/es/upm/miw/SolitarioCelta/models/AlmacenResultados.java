package es.upm.miw.SolitarioCelta.models;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by ai0395 on 28/10/2016.
 */

public class AlmacenResultados extends SQLiteOpenHelper {
    public static final String DATABASE_FILE = ResultadoContract.tablaResultado.TABLE_NAME + ".db";
    public static final int NUM_VERSION = 1;

    public AlmacenResultados(Context context) {
        super(context, DATABASE_FILE, null, NUM_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlQuery = "CREATE TABLE " + ResultadoContract.tablaResultado.TABLE_NAME + " (" +
                ResultadoContract.tablaResultado.COL_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ResultadoContract.tablaResultado.COL_NAME_NOMBRE + " TEXT, " +
                ResultadoContract.tablaResultado.COL_NAME_PUNTUACION + " INTEGER, " +
                ResultadoContract.tablaResultado.COL_NAME_TABLERO + " TEXT, " +
                ResultadoContract.tablaResultado.COL_NAME_TIEMPO + " INTEGER)";
        Log.i("MIW16", sqlQuery);
        sqLiteDatabase.execSQL(sqlQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.i("MIW16", "onUpgrade AlmacenResultados.java");
    }

    /*
        Devuelve numero de filas
         */
    public Long count() {
        SQLiteDatabase db = getReadableDatabase();
        return (DatabaseUtils.queryNumEntries(db, ResultadoContract.tablaResultado.TABLE_NAME));
    }

    public ArrayList<Resultado> getall() {
//        String consultaSQL="SELECT * FROM " + ResultadoContract.tablaResultado.TABLE_NAME;
        ArrayList<Resultado> resultados = new ArrayList<Resultado>();
        SQLiteDatabase db = getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * from " + ResultadoContract.tablaResultado.TABLE_NAME, null);
        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    Resultado result = new Resultado();
                    result.set_id(c.getInt(c.getColumnIndex(ResultadoContract.tablaResultado.COL_NAME_ID)));
                    result.set_nombreJugador(c.getString(c.getColumnIndex(ResultadoContract.tablaResultado.COL_NAME_NOMBRE)));
                    result.set_puntuacion(c.getInt(c.getColumnIndex(ResultadoContract.tablaResultado.COL_NAME_PUNTUACION)));
                    result.set_tablero(c.getString(c.getColumnIndex(ResultadoContract.tablaResultado.COL_NAME_TABLERO)));
                    result.set_tiempo(c.getInt(c.getColumnIndex(ResultadoContract.tablaResultado.COL_NAME_TIEMPO)));
                    resultados.add(result);
                } while (c.moveToNext());
            }
        }
        return resultados;
    }


    public void insert(int id, String nombre, int puntuacion, String tablero, int tiempo) {
        String sqlQuery = "INSERT INTO " + ResultadoContract.tablaResultado.TABLE_NAME + " VALUES (" +
                Integer.toString(id) + ",'" +
                nombre + "'," +
                Integer.toString(puntuacion) + ",'" +
                tablero + "'," +
                Integer.toString(tiempo) + ")";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sqlQuery);
    }

    public void delete(int id) {
        String sqlQuery = "DELETE FROM " + ResultadoContract.tablaResultado.TABLE_NAME + " WHERE " +
                ResultadoContract.tablaResultado.COL_NAME_ID +
                "=" + Integer.toString(id);
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sqlQuery);
    }

    public void  deleteAll() {
        String sqlQuery = "DELETE FROM " + ResultadoContract.tablaResultado.TABLE_NAME;
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sqlQuery);
    }

    public Resultado getResultadoById(int id) {
        Resultado result = null;
        SQLiteDatabase db = getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * from " + ResultadoContract.tablaResultado.TABLE_NAME, null);
        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    if (c.getInt(c.getColumnIndex(ResultadoContract.tablaResultado._ID))==id)
                    {
                        result = new Resultado();
                        result.set_id(c.getInt(c.getColumnIndex(ResultadoContract.tablaResultado.COL_NAME_ID)));
                        result.set_nombreJugador(c.getString(c.getColumnIndex(ResultadoContract.tablaResultado.COL_NAME_NOMBRE)));
                        result.set_puntuacion(c.getInt(c.getColumnIndex(ResultadoContract.tablaResultado.COL_NAME_PUNTUACION)));
                        result.set_tablero(c.getString(c.getColumnIndex(ResultadoContract.tablaResultado.COL_NAME_TABLERO)));
                        result.set_tiempo(c.getInt(c.getColumnIndex(ResultadoContract.tablaResultado.COL_NAME_TIEMPO)));
                    }
                } while (result==null);
            }
        }
        return result;
    }
}

