package ru.ifmo.rain.garder.cli

import java.util.*

/**
 * Contains methods that splits tokens by pipes
 */
class PipeSplitter {
    companion object {
        private val PIPE_STR = "|"
        /**
         * split tokens by pipes
         */
        fun splitPipes(tokens: List<String>): List<List<String>> {
            val splitted = ArrayList<List<String>>()
            var i = 0
            while (i < tokens.size) {
                val group = ArrayList<String>()
                while (i < tokens.size) {
                    if (tokens[i] == PIPE_STR) {
                        i++
                        break
                    }
                    group.add(tokens[i])
                    i++
                }
                splitted.add(group)
            }
            return splitted
        }
    }
}