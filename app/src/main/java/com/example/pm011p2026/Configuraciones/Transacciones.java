package com.example.pm011p2026.Configuraciones;

import android.database.sqlite.SQLiteOpenHelper;

public class Transacciones {
    //DB name
    public static final String dbname = "BDM01";

    //DB tablas
    public static final String tbPersonas = "personas";

    //Tabla personas campos
    public static final String id = "id";
    public static final String nombre = "nombre";
    public static final String apellido = "apellido";
    public static final String correo = "correo";
    public static final String edad = "edad";
    public static final String foto = "foto";

    //DDL Create
    public static final String CreateTablePersonas = "CREATE TABLE " + tbPersonas + " ( " +
            id + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
            nombre + " TEXT , " +
            apellido + " TEXT , " +
            edad + " INTEGER , " +
            correo + " TEXT , " +
            foto   + " TEXT  )" ;

    //DDL Drop
    public static final String DropTablePersonas = "DROP TABLE IF Exists " + tbPersonas;

    //DML
    public static final String SelectTablePersonas = "SELECT * FROM " + tbPersonas;
}
