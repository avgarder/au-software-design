package ru.ifmo.rain.garder.cli

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.InputStream

/**
 * Contains current environment and methods for interactions with user
 */
class Shell {
    companion object {
        private val reader = BufferedReader(InputStreamReader(System.`in`))
        private val env = Environment()

        /**
         * returns entered string or null if finished
         */
        fun readString(): String? {
            return reader.readLine()
        }

        /**
         * returns current environment
         */
        fun getEnvironment(): Environment {
            return env
        }

        /**
         * writes lines from stream to System.out if it's not the System.in stream
         */
        fun writeLines(stream: InputStream?) {
            if (stream == null || stream == System.`in`) {
                return
            }
            val reader = BufferedReader(InputStreamReader(stream))
            while (true) {
                val line = reader.readLine() ?: break
                println(line)
            }
        }
    }
}
