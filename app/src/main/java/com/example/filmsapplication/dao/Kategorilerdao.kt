package com.example.filmsapplication.dao

import android.annotation.SuppressLint
import com.example.filmsapplication.VeritabaniYardimcisi
import com.example.filmsapplication.entity.Kategoriler

class Kategorilerdao {

    @SuppressLint("Range")
    fun tumKategoryler(vt:VeritabaniYardimcisi):ArrayList<Kategoriler>{
        val db = vt.writableDatabase

        val kategorilerListe = ArrayList<Kategoriler>()

        val c = db.rawQuery("select * from kategoriler",null)

        while (c.moveToNext()){
            val kategori = Kategoriler(c.getInt(c.getColumnIndex("kategori_id")),
                c.getString(c.getColumnIndex("kategori_ad")))
            kategorilerListe.add(kategori)
        }

        return kategorilerListe
    }

}
