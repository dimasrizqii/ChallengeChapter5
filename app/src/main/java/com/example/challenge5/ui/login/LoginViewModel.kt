package com.example.challenge5.ui.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.challenge5.data.dao.AccountDao
import com.example.challenge5.data.entity.AccountEntity
import kotlinx.coroutines.launch

class LoginViewModel (
    val database : AccountDao, application: Application) : AndroidViewModel(application) {
    fun readAccountById(email: String) : LiveData<AccountEntity> {
        val dummy = MutableLiveData <AccountEntity>()
        viewModelScope.launch {
            dummy.value = getDataFromDatabase(email)
        }
        return dummy
    }

    private suspend fun getDataFromDatabase(email: String) : AccountEntity? {
        return database.readAccountByEmail(email)
    }
}