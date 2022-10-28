package com.orogersilva.scaffoldandroid.networking.transformer

import com.orogersilva.scaffoldandroid.networking.error.RemoteServiceIntegrationError
import kotlinx.serialization.SerializationException

object SerializationErrorTransformer : ErrorTransformer {

    override suspend fun transform(incoming: Throwable): Throwable =
        when (incoming) {
            is SerializationException -> RemoteServiceIntegrationError.UnexpectedResponse
            else -> incoming
        }
}
