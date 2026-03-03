package com.seuapp.performance.root

import java.io.DataOutputStream

object RootExecutor {

    fun execute(command: String): String {
        return try {
            val process = Runtime.getRuntime().exec("su")
            val outputStream = DataOutputStream(process.outputStream)

            outputStream.writeBytes("$command\n")
            outputStream.writeBytes("exit\n")
            outputStream.flush()

            process.waitFor()

            "Sucesso"
        } catch (e: Exception) {
            "Erro: ${e.message}"
        }
    }
}