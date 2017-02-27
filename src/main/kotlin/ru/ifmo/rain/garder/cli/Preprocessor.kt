package ru.ifmo.rain.garder.cli

/**
 * Contains methods that preprocess script
 */
class Preprocessor {
    companion object {
        private val VAR_SYMBOL = '$'

        /**
         * replaces enrironment variables with its' values
         */
        fun preprocess(env: Environment, script: String): String {
            val builder = StringBuilder()
            var i = 0
            var skipVars = false
            while (i < script.length) {
                val c = script[i]
                if (skipVars || c != VAR_SYMBOL) {
                    builder.append(c)
                    if (c == '\'') {
                        skipVars = !skipVars
                    }
                    i++
                    continue
                }
                var j = i + 1
                while (j < script.length && !script[j].isWhitespace() && script[j] != '"' && script[j] != '\'') {
                    j++
                }
                builder.append(env.getValue(script.substring(i + 1, j)))
                i = j
            }
            return builder.toString()
        }
    }
}