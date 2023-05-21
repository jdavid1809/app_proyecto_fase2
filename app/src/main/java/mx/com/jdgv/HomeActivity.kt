package mx.com.jdgv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import mx.com.jdgv.variables.USERS

class HomeActivity : AppCompatActivity() {
    private lateinit var username: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val bundle=intent.extras
        val count = bundle?.getInt("count")
        //val name = bundle?.getString("usuario")
        username= findViewById(R.id.userWelcome)
        username.text = "Bienvenido ${USERS[count!!].getNombre()}"

    }
}