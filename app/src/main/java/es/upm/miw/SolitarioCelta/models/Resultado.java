package es.upm.miw.SolitarioCelta.models;

/**
 * Created by ai0395 on 28/10/2016.
 */

public class Resultado {
    private int _id;
    private String _nombreJugador;
    private int _puntuacion;
    private String _tablero; //Tablero serializado
    private  long _tiempo ;

    public Resultado(int _id, String _nombreJugador, int _puntuacion, String _tablero, long _tiempo) {
        this._id = _id;
        this._nombreJugador = _nombreJugador;
        this._puntuacion = _puntuacion;
        this._tablero = _tablero;
        this._tiempo = _tiempo;
    }

    public Resultado(){

    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_nombreJugador() {
        return _nombreJugador;
    }

    public void set_nombreJugador(String _nombreJugador) {
        this._nombreJugador = _nombreJugador;
    }

    public int get_puntuacion() {
        return _puntuacion;
    }

    public void set_puntuacion(int _puntuacion) {
        this._puntuacion = _puntuacion;
    }

    public String get_tablero() {
        return _tablero;
    }

    public void set_tablero(String _tablero) {
        this._tablero = _tablero;
    }

    public long get_tiempo() {
        return _tiempo;
    }

    public void set_tiempo(long _tiempo) {
        this._tiempo = _tiempo;
    }
}
