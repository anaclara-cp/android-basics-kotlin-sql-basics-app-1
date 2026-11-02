
package com.example.sqlbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.launch
import androidx.lifecycle.lifecycleScope
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Instancia o banco passando o lifecycleScope da Activity
        val db = AppDatabase.getDatabase(this, lifecycleScope)
        // Força o Room a abrir o arquivo SQLite físico e rodar os callbacks imediatamente
        db.openHelper.writableDatabase

        val clienteDao = db.clienteDao()


    }
}

