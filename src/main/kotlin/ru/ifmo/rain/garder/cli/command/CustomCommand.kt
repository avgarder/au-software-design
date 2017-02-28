package ru.ifmo.rain.garder.cli.command

import ru.ifmo.rain.garder.cli.Environment
import ru.ifmo.rain.garder.cli.exception.RunException
import java.io.IOException
import java.io.InputStream

/**
 * Implementation of custom command
 */
class CustomCommand(args: List<String>) : Command(args) {

    override fun run(env: Environment, input: InputStream?): InputStream? {
        try {
            return Runtime.getRuntime().exec(args.toTypedArray()).inputStream
        } catch (e: IOException) {
            throw RunException("Cannon run custom command: " + args.joinToString(separator = " "))
        }
    }
}