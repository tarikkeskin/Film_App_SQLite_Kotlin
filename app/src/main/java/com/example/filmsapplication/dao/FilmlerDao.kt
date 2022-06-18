package com.example.filmsapplication.dao

import android.annotation.SuppressLint
import com.example.filmsapplication.VeritabaniYardimcisi
import com.example.filmsapplication.entity.Filmler
import com.example.filmsapplication.entity.Kategoriler
import com.example.filmsapplication.entity.Yonetmenler

class FilmlerDao() {

    @SuppressLint("Range")
    fun tumFilmlerByKategoriId(vt: VeritabaniYardimcisi,kategori_id:Int):ArrayList<Filmler>{
        val db = vt.writableDatabase

        val filmlerListesi = ArrayList<Filmler>()

        val c = db.rawQuery("select * " +
                                 " from kategoriler,yonetmenler,filmler" +
                                " where filmler.kategori_id = kategoriler.kategori_id " +
                                    "and filmler.yonetmen_id = yonetmenler.yonetmen_id " +
                                     "and filmler.kategori_id = $kategori_id"
                                    ,  null)

        while (c.moveToNext()){
            val kategori = Kategoriler(c.getInt(c.getColumnIndex("kategori_id")),
                c.getString(c.getColumnIndex("kategori_ad")))

            val yonetmen = Yonetmenler(c.getInt(c.getColumnIndex("yonetmen_id")),
                c.getString(c.getColumnIndex("yonetmen_ad")))

            val film = Filmler(c.getInt(c.getColumnIndex("film_id"))
                ,c.getString(c.getColumnIndex("film_ad"))
                , c.getInt(c.getColumnIndex("film_yil"))
                ,c.getString(c.getColumnIndex("film_resim")),kategori,yonetmen)

            filmlerListesi.add(film)
        }

        return filmlerListesi
    }
}
