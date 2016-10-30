package es.upm.miw.SolitarioCelta.models;

import android.provider.BaseColumns;

/**
 * Created by ai0395 on 28/10/2016.
 */

public class ResultadoContract {
    public ResultadoContract() {
    }

    public static class tablaResultado implements BaseColumns {

        public final static String TABLE_NAME="resultados";

        public final static String COL_NAME_ID=_ID;
        public final static String COL_NAME_NOMBRE="NombreJugador";
        public final static String COL_NAME_PUNTUACION="puntuacion";
        public final static String COL_NAME_TABLERO="tablero";
        public final static String COL_NAME_TIEMPO="tiempo";

    }

}
