package ru.ifmo.rain.garder.cli

import java.util.*

/**
 * Contains set variables
 */
class Environment {
    private val data = HashMap<String, String>()

    /**
     * returns set value or key if wasn't set
     */
    fun getValue(key: String): String {
        return data[key] ?: "\$$key"
    }

    /**
     * saves value by key
     */
    fun setValue(key: String, value: String) {
        data[key] = value
    }
}