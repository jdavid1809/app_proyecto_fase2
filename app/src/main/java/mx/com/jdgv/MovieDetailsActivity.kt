package mx.com.jdgv

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import com.squareup.picasso.Picasso
import mx.com.jdgv.databinding.ActivityHomeBinding
import mx.com.jdgv.databinding.ActivityMovieDetailsBinding

class MovieDetailsActivity : AppCompatActivity() {
    //lateinit var link:String
    private lateinit var goToMovie: Button
    private lateinit var binding: ActivityMovieDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        goToMovie = findViewById(R.id.goMovie)

        val title = intent.getStringExtra("TITLE")
        val year = intent.getStringExtra("YEAR")
        val rating = intent.getStringExtra("RATING")
        val director = intent.getStringExtra("DIRECTOR")
        val duration = intent.getStringExtra("DURATION")
        val imageUrl = intent.getStringExtra("IMAGE")
        val link = intent.getStringExtra("LINK").toString()
        val description = intent.getStringExtra("DESCRIPTION")

        binding.movieTitle.text = title
        binding.movieDescription.text = description
        binding.movieDirector.text = director
        binding.movieYear.text = year
        binding.movieRating.text = "Calificacion: ${rating}/10"
        binding.movieDuration.text = "Duracion: ${duration}"
        Picasso.get().load(imageUrl).into(binding.movieImage)

        goToMovie.setOnClickListener{
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse(link)

            startActivity(openURL)
        }
    }

    fun closeDialog(view: View){
        finish()
    }
}