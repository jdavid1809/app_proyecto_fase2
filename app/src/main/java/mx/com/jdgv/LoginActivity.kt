package mx.com.jdgv

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.EditText
import android.widget.Toast
import mx.com.jdgv.variables.USERS

class LoginActivity : AppCompatActivity() {

    private lateinit var homeTitle: TextView
    private lateinit var usuario:EditText
    private lateinit var password:EditText
    private lateinit var inicioButton: Button
    private lateinit var registroButton: Button

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Ruta de los resources
        homeTitle = findViewById(R.id.titleHome)
        usuario = findViewById(R.id.user)
        password = findViewById(R.id.password)
        inicioButton = findViewById(R.id.botonIngresar)
        registroButton = findViewById(R.id.botonRegister)

        inicioButton.setOnClickListener(){
            var count = 0
            for (i in USERS){
                if (i.getNoCliente().toString() == usuario.text.toString()){
                    if(i.getContraseña() == password.text.toString()){
                        println(count)
                        val bundle = Bundle()
                        bundle.putInt("count",count)

                        val intent = Intent(this,HomeActivity::class.java).apply {
                            putExtras(bundle)
                        }
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Contraseña incorrecta", Toast.LENGTH_SHORT).show();
                    }
                }
                count++
            }
        }

        registroButton.setOnClickListener(){
            val intent = Intent(this,RegisterActivity::class.java).apply {}
            startActivity(intent)
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
 */
    }
}