package com.orogersilva.scaffoldandroid.testing.files

object FileSystemSupport {

    fun loadFile(path: String): String =
        javaClass
            .classLoader!!
            .getResourceAsStream(path)
            .bufferedReader()
            .use { it.readText() }
}
