package mx.com.jdgv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import com.squareup.picasso.Picasso
import mx.com.jdgv.databinding.ActivityHomeBinding
import mx.com.jdgv.databinding.ActivityMovieDetailsBinding

class MovieDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra("TITLE")
        val year = intent.getStringExtra("YEAR")
        val rating = intent.getStringExtra("RATING")
        val director = intent.getStringExtra("DIRECTOR")
        val duration = intent.getStringExtra("DURATION")
        val imageUrl = intent.getStringExtra("IMAGE")
        val link = intent.getStringExtra("LINK")
        val description = intent.getStringExtra("DESCRIPTION")

        binding.movieTitle.text = title
        binding.movieDescription.text = description
        binding.movieDirector.text = director
        binding.movieYear.text = year
        binding.movieRating.text = "${rating}/10"
        binding.movieDuration.text = "duracion: ${duration}"
        Picasso.get().load(imageUrl).into(binding.movieImage)
    }

    fun closeDialog(view: View){
        finish()
    }
}