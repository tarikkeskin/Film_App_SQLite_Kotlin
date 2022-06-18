package com.example.filmsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.filmsapplication.adapters.FilmlerAdapter
import com.example.filmsapplication.adapters.KategoriAdapter
import com.example.filmsapplication.dao.FilmlerDao
import com.example.filmsapplication.entity.Filmler
import com.example.filmsapplication.entity.Kategoriler
import com.example.filmsapplication.entity.Yonetmenler
import kotlinx.android.synthetic.main.activity_filmler.*

class FilmlerActivity : AppCompatActivity() {

    private lateinit var filmListe:ArrayList<Filmler>
    private lateinit var adapter: FilmlerAdapter

    private lateinit var vt : VeritabaniYardimcisi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filmler)

        val kategori = intent.getSerializableExtra("kategoriNesne") as Kategoriler

        toolbarFilmler.title = "Filmler : ${kategori.kategori_ad}"
        setSupportActionBar(toolbarFilmler)

        filmlerRv.setHasFixedSize(true)
        filmlerRv.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        vt = VeritabaniYardimcisi(this)

        filmListe = FilmlerDao().tumFilmlerByKategoriId(vt,kategori.kategori_id)

        adapter = FilmlerAdapter(this,filmListe)

        filmlerRv.adapter = adapter
    }
}