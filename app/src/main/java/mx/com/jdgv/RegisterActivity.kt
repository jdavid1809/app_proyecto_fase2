package mx.com.jdgv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import mx.com.jdgv.models.User
import mx.com.jdgv.variables.NoUser
import mx.com.jdgv.variables.USERS

class RegisterActivity : AppCompatActivity() {

    private lateinit var usuarioRegistro: EditText
    private lateinit var passwordRegistro: EditText
    private lateinit var passwordRegistroConfirmacion: EditText
    private lateinit var inicioButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        usuarioRegistro = findViewById(R.id.userRegister)
        passwordRegistro = findViewById(R.id.passwordRegister)
        passwordRegistroConfirmacion = findViewById(R.id.passwordRegisterConfirmation)
        inicioButton = findViewById(R.id.botonRegistrar)

        inicioButton.setOnClickListener(){
            if (!usuarioRegistro.text.toString().isEmpty() && passwordRegistro.text.toString().length > 7 && passwordRegistroConfirmacion.text.toString().length > 7){
                if (passwordRegistro.text.toString().equals(passwordRegistroConfirmacion.text.toString())){
                    val user = User(NoUser++,usuarioRegistro.text.toString(),passwordRegistro.text.toString())
                    USERS.add(user)
                    Toast.makeText(getApplicationContext(), "Registro exitoso: Tu usuario es ${NoUser-1}", Toast.LENGTH_SHORT).show();
                    val intent = Intent(this,LoginActivity::class.java).apply {}
                    startActivity(intent)
                }
                else{
                    Toast.makeText(getApplicationContext(), "Las contraseñas no son iguales", Toast.LENGTH_SHORT).show();
                }
            }else{
                if(usuarioRegistro.text.toString().isEmpty())
                    Toast.makeText(getApplicationContext(), "El campo de nombre no debe ir vacio", Toast.LENGTH_SHORT).show();
                if(passwordRegistro.text.toString().length < 8)
                    Toast.makeText(getApplicationContext(), "El tamaño de la contraseña es mayor a 8", Toast.LENGTH_SHORT).show();
            }
        }



    }
}