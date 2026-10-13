/*
 * Copyright (C) 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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


//        lifecycleScope.launch {
//            // Consulta para confirmar a inserção dos 10 registros
//            val clientes = clienteDao.listarTodos()
//
//            Log.d("BD_TESTE", "Total de clientes no banco: ${clientes.size}")
//            clientes.forEach { cliente ->
//                Log.d(
//                    "BD_TESTE",
//                    "ID: ${cliente.id} | Nome: ${cliente.nome} | Email: ${cliente.email}"
//                )
//            }
//        }
    }
}
