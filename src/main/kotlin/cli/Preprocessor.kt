package cli

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
            while (i < script.length) {
                val c = script[i]
                if (c != VAR_SYMBOL) {
                    builder.append(c)
                    i++
                    continue
                }
                var j = i + 1
                while (j < script.length && !script[j].isWhitespace()) {
                    j++
                }
                builder.append(env.getValue(script.substring(i + 1, j)))
                i = j
            }
            return builder.toString()
        }
    }
}