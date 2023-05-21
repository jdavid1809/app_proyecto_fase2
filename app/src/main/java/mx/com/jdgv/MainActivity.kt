package mx.com.jdgv

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.TextView
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var homeTitle: TextView
    private lateinit var usuario:EditText
    private lateinit var password:EditText
    private lateinit var inicioButton: Button

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Ruta de los resources
        homeTitle = findViewById(R.id.titleHome)
        usuario = findViewById(R.id.user)
        password = findViewById(R.id.password)
        inicioButton = findViewById(R.id.botonIngresar)

        inicioButton.setOnClickListener(){
            Toast.makeText(getApplicationContext(), "Funcionamiento Correcto", Toast.LENGTH_SHORT).show();
        }
/*
        usuario.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s:Editable){}
            override fun beforeTextChanged(
                s:CharSequence,star:Int,
                count:Int, after:Int
            ){
            }
            override fun onTextChanged(
                s:CharSequence,star:Int,
                count:Int, after:Int
            ){
                usuario.text = usuario.text
            }
        })

        password.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s:Editable){}
            override fun beforeTextChanged(s:CharSequence, star:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, star:Int, count:Int, after:Int){
                password.text = password.text
            }
        })
 */
    }
}