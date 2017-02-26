package cli

import java.io.BufferedReader
import java.io.InputStreamReader

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
    }
}
