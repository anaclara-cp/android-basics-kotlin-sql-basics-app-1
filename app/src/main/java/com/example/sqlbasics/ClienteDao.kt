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

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.sqlbasics.Cliente

@Dao
interface ClienteDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun inserir(cliente: Cliente): Long

    @Update
    suspend fun atualizar(cliente: Cliente)

    @Delete
    suspend fun deletar(cliente: Cliente)

    @Query("SELECT * FROM clientes ORDER BY nome_completo ASC")
    suspend fun listarTodos(): List<Cliente>

    @Query("SELECT * FROM clientes WHERE id = :id LIMIT 1")
    suspend fun buscarPorId(id: Long): Cliente?

    @Query("SELECT * FROM clientes WHERE email = :email LIMIT 1")
    suspend fun buscarPorEmail(email: String): Cliente?

    // Exemplo didático de consulta para simulação de validação de acesso / login
    @Query("SELECT * FROM clientes WHERE email = :email AND senha_hash = :senha LIMIT 1")
    suspend fun autenticar(email: String, senha: String): Cliente?
}