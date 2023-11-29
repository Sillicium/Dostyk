package com.example.myapplication.network.sessionManager.auth

import androidx.datastore.core.DataStore
import com.example.myapplication.network.repo.data_store.BaseDataStoreRepo
import com.google.gson.Gson
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.myapplication.data.SessionData
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject

class SessionDataStoreRepoImpl @Inject constructor(
    private val userDataStorePreferences: DataStore<Preferences>
) : BaseDataStoreRepo {

    private val gson = Gson()

    override suspend fun getAccessToken(): String {
        val json = getStringValue(SESSION_DATA_JSON_KEY)

        if (json.isEmpty()) {
            return ""
        }

        return gson.fromJson(json, SessionData::class.java).accessToken

    }

    private suspend fun getStringValue(key: Preferences.Key<String>): String {
        val flow = userDataStorePreferences.data
            .catch { exception ->
                /*
                 * dataStore.data throws an IOException when an error
                 * is encountered when reading data
                 */
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                // Get our name value, defaulting to "" if not set
                preferences[key]
            }
        return flow.firstOrNull() ?: ""
    }

    private companion object {
        //        Always add "mercahnt_" for clarity
        private val SESSION_DATA_JSON_KEY = stringPreferencesKey("data")
    }
}