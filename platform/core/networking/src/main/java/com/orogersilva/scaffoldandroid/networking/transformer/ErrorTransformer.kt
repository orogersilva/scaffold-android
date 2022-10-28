package com.orogersilva.scaffoldandroid.networking.transformer

interface ErrorTransformer {

    suspend fun transform(incoming: Throwable): Throwable
}
