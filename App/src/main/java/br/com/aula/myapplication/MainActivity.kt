package br.com.aula.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var etUsuario: EditText
    private lateinit var etSenha: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arquivo = getSharedPreferences("login_senha", Context.MODE_PRIVATE)

        val btEntrar = findViewById<Button>(R.id.btEntrar)
        btEntrar.setOnClickListener(this)

        etUsuario = findViewById(R.id.etUsuario)
        etSenha = findViewById(R.id.etSenha)

//        etUsuario.setText(arquivo.getString("login", ""))
//        etSenha.setText(arquivo.getString("senha", ""))
    }

    override fun onClick(view: View?) {
        val arquivo = getSharedPreferences("login_senha", Context.MODE_PRIVATE)
        val usuario = arquivo.getString("login", "")
        val senha = arquivo.getString("senha", "")

        if (usuario == "" && senha == "" ) {
            val editor = arquivo.edit()
            editor.putString("login", etUsuario.text.toString())
            editor.putString("senha", etSenha.text.toString())
            editor.commit()
            Toast.makeText(
                this,
                "Bem-vindo pela primeira vez",
                Toast.LENGTH_LONG,
            ).show()

        } else if ( etUsuario.text.toString().equals(usuario) //
            and etSenha.text.toString().equals(senha) ) {

            var qtLogin = 0


            Toast.makeText(
                this,
                "Usuário: ${etUsuario.text} \t\t" + //
                        "Senha: ${etSenha.text} \n" +
                        "Qt. Login: $qtLogin",
                Toast.LENGTH_LONG
            ).show()
        } else {
            Toast.makeText(
                this,
                "Usuário e/ou senha inválidos!", //
                Toast.LENGTH_LONG
            ).show()
        }
    }

}