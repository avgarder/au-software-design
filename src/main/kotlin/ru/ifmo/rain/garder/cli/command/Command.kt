package ru.ifmo.rain.garder.cli.command

import ru.ifmo.rain.garder.cli.Environment
import ru.ifmo.rain.garder.cli.exception.InvalidUsageException
import ru.ifmo.rain.garder.cli.exception.RunException
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.InputStream

/**
 * Abstract command.
 * @constructor takes arguments of the command
 * @see Command.run for running the command.
 */
abstract class Command(protected val args: List<String>) {

    /**
     * runs command
     * @return output of the command
     */
    abstract fun run(env: Environment, input: InputStream?): InputStream?

    /**
     * @return usage of the command if overrided
     */
    open fun getUsage(): String {
        throw UnsupportedOperationException()
    }

    open protected fun getInput(file: String?, input: InputStream?): InputStream? {
        if (file == null && input == null) {
            throw InvalidUsageException(this)
        }
        if (file != null) {
            try {
                return FileInputStream(file)
            } catch (e: FileNotFoundException) {
                throw RunException("file not found: $file")
            }
        }
        return input
    }
}