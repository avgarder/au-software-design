package cli

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
         * @return entered string or null if finished
         */
        fun readString(): String? {
            return reader.readLine()
        }

        /**
         * @return current environment
         */
        fun getEnvironment(): Environment {
            return env
        }

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
