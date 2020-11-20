package com.pokemaps.pokemap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class dUsuario {
    Context c;
    Usuario u;
    ArrayList<Usuario> lista;
    SQLiteDatabase sql;
    String bd = "BDUsuarios";
    String tabla = "create table if not exists USUARIO(ID integer primary key autoincrement,EMAIL text, PASSWORD text, NOMBRE text, APELLIDO text)";

    public dUsuario(Context c) {
        this.c = c;
        sql = c.openOrCreateDatabase(bd, c.MODE_PRIVATE, null);
        sql.execSQL(tabla);
        u=new Usuario();

    }

    public boolean insertUsuario(Usuario u) {
        if (buscar(u.getUsuario()) == 0) {
            ContentValues cv = new ContentValues();
            cv.put("EMAIL", u.getUsuario());
            cv.put("PASSWORD", u.getPassword());
            cv.put("NOMBRE", u.getNombre());
            cv.put("APELLIDO", u.getApellidos());
            return (sql.insert("USUARIO", null, cv) > 0);
        } else {
            return false;
        }
    }

    public int buscar(String u) {
        int x=0;
        lista=selectUsuarios();
        for (Usuario us:lista) {
            if (us.getUsuario().equals(u)){
                x++;
            }
        }
        return x;
    }

    public ArrayList<Usuario> selectUsuarios(){
        ArrayList<Usuario> lista=new ArrayList<Usuario>();
        Cursor cr=sql.rawQuery("select * from USUARIO", null);
        if (cr!=null&&cr.moveToFirst()){
            do {
                Usuario u=new Usuario();
                u.setId(cr.getInt(0));
                u.setUsuario(cr.getString(1));
                u.setPassword(cr.getString(2));
                u.setNombre(cr.getString(3));
                u.setApellidos(cr.getString(4));
                lista.add(u);
            }while (cr.moveToNext());
        }
        return lista;
    }

    public  int login(String u, String p ) {
        int a=0;
        Cursor cr=sql.rawQuery("select * from USUARIO", null);
        if (cr!=null&&cr.moveToFirst()){
            do {
              if(cr.getString(1).equals(u)&&cr.getString(2).equals(p)){
                  a++;
              }
            }while (cr.moveToNext());
        }
        return a;
    }
}



