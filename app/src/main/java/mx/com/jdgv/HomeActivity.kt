package mx.com.jdgv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import mx.com.jdgv.databinding.ActivityHomeBinding
import mx.com.jdgv.variables.USERS
import mx.com.jdgv.variables.peliculas

class HomeActivity : AppCompatActivity() {
    private lateinit var username: TextView
    lateinit var arratAdapter: ArrayAdapter<*>
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

        var itemAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, peliculas)
        binding.listaPeliculas.adapter = itemAdapter


    }
}