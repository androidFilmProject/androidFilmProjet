package com.gmail.eamosse.idbdata.utils

import androidx.lifecycle.MutableLiveData
import com.gmail.eamosse.idbdata.data.Category
import org.chromium.net.NetworkException
import retrofit2.Response
import java.io.IOException
import java.util.List


internal fun <T : Any> Response<T>.parse(): Result<T> {
        return if (isSuccessful) {
            body()?.let {
                Result.Succes(it)
            } ?: run {
                Result.Error(
                    exception = NoDataException(),
                    message = "Aucune donnée",
                    code = 404
                )
            }
        } else {
            Result.Error(
                exception = Exception(),
                message = message(),
                code = code()
            )
        }
    }

internal suspend fun <T : Any> safeCall(execute: suspend () -> Result<T>): Result<T> {
        return try {
            execute()
        } catch (e: Exception) {
            if (e is IOException) {
                Result.Error(
                    exception = NetworkException(),
                    message = "Problème d'accès au réseau",
                    code = -1
                )
            } else {
                Result.Error(
                    exception = e,
                    message = e.message ?: "No message",
                    code = -1
                )
            }
        }
    }




class NoDataException: Exception()
    class NetworkException: Exception()
