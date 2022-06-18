package com.example.filmsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.filmsapplication.adapters.FilmlerAdapter
import com.example.filmsapplication.adapters.KategoriAdapter
import com.example.filmsapplication.entity.Filmler
import com.example.filmsapplication.entity.Kategoriler
import com.example.filmsapplication.entity.Yonetmenler
import kotlinx.android.synthetic.main.activity_filmler.*

class FilmlerActivity : AppCompatActivity() {

    private lateinit var filmListe:ArrayList<Filmler>
    private lateinit var adapter: FilmlerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filmler)

        val kategori = intent.getSerializableExtra("kategoriNesne") as Kategoriler

        toolbarFilmler.title = "Filmler : ${kategori.kategori_ad}"
        setSupportActionBar(toolbarFilmler)

        filmlerRv.setHasFixedSize(true)
        filmlerRv.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        filmListe = ArrayList()

        val k = Kategoriler(1,"dram")
        val y = Yonetmenler(1,"Trantino")

        val f1 = Filmler(1,"Django",2000,"django",k,y)
        val f2 = Filmler(2,"Inception",2000,"inception",k,y)
        val f3 = Filmler(3,"Pianist",2000,"thepianist",k,y)

        filmListe.add(f1)
        filmListe.add(f2)
        filmListe.add(f3)

        adapter = FilmlerAdapter(this,filmListe)

        filmlerRv.adapter = adapter
    }
}