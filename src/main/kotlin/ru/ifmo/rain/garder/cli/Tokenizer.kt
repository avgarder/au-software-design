package ru.ifmo.rain.garder.cli

import java.util.*

/**
 * Contains methods that tokenizes script
 */
class Tokenizer {
    companion object {
        /**
         * splits string to tokens
         */
        fun tokenize(s: String): List<String> {
            val tokens = ArrayList<String>()
            var i = 0
            while (i < s.length) {
                val builder = StringBuilder()
                var quotesCode = -1
                while (i < s.length) {
                    val c = s[i]
                    if (c.isWhitespace()) {
                        if (quotesCode == -1) {
                            i++
                            break
                        }
                    }
                    if (c.toInt() == quotesCode) {
                        i++
                        break
                    }
                    if (c == '\'' && quotesCode == -1) {
                        quotesCode = c.toInt()
                        i++
                        continue
                    }
                    if (c == '"' && quotesCode == -1) {
                        quotesCode = c.toInt()
                        i++
                        continue
                    }
                    builder.append(c)
                    i++
                }
                if (!builder.isEmpty()) {
                    tokens.add(builder.toString())
                }
            }
            return tokens
        }
    }
}