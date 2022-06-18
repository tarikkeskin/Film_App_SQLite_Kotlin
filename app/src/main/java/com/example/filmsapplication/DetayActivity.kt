package com.example.filmsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.filmsapplication.entity.Filmler
import kotlinx.android.synthetic.main.activity_detay.*
import kotlinx.android.synthetic.main.film_card_tasarim.*

class DetayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)

        val film = intent.getSerializableExtra("filmNesne") as Filmler

        textViewDetayFilmAd.text = film.film_ad
        textViewFilmYil.text = film.film_yil.toString()
        textViewYonetmen.text = film.yonetmen.yonetmen_ad

        imageViewDetayResim.setImageResource(this.resources.getIdentifier(film.film_resim,
            "drawable",this.packageName))
    }
}