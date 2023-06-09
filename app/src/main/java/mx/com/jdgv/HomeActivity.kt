package mx.com.jdgv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import mx.com.jdgv.databinding.ActivityHomeBinding
import mx.com.jdgv.models.Movie
import mx.com.jdgv.models.MyAdapter
import mx.com.jdgv.variables.USERS
import mx.com.jdgv.variables.movie1
import mx.com.jdgv.variables.movie2
import mx.com.jdgv.variables.movie3
import mx.com.jdgv.variables.movie4
import mx.com.jdgv.variables.movie5
import mx.com.jdgv.variables.movie6

class HomeActivity : AppCompatActivity() {
    private lateinit var username: TextView
    lateinit var arrayAdapter: ArrayAdapter<*>
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle=intent.extras
        val count = bundle?.getInt("count")
        //val name = bundle?.getString("usuario")
        username= findViewById(R.id.userWelcome)
        username.text = "Bienvenido ${USERS[count!!].getNombre()}"

        var peliculas = ArrayList<Movie>()
        peliculas.add(movie1)
        peliculas.add(movie2)
        peliculas.add(movie3)
        peliculas.add(movie4)
        peliculas.add(movie5)
        peliculas.add(movie6)

        var itemAdapter = MyAdapter(this, peliculas)
        binding.listaPeliculas.adapter = itemAdapter

        binding.listaPeliculas.setOnItemClickListener { parent, view, position, id ->

            val intent = Intent(this, MovieDetailsActivity::class.java).apply {
                putExtra("TITLE", peliculas[id.toInt()].title)
                putExtra("YEAR", peliculas[id.toInt()].year)
                putExtra("RATING", peliculas[id.toInt()].rating)
                putExtra("DIRECTOR", peliculas[id.toInt()].director)
                putExtra("DURATION", peliculas[id.toInt()].duration)
                putExtra("IMAGE", peliculas[id.toInt()].imageUrl)
                putExtra("LINK", peliculas[id.toInt()].locationUrl)
                putExtra("DESCRIPTION", peliculas[id.toInt()].description)
            }
            startActivity(intent)
        }


    }
}