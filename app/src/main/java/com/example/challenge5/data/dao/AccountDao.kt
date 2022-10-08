package com.example.challenge5.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.challenge5.data.entity.AccountEntity

@Dao
interface AccountDao {
    @Query("SELECT * FROM ACCOUNT_DATABASE WHERE EMAIL == :email")
    suspend fun readAccountByEmail(email: String): AccountEntity?

    @Insert
    suspend fun insertAccount(account: AccountEntity)
}