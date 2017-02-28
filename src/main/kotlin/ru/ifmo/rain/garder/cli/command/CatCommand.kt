package ru.ifmo.rain.garder.cli.command

import ru.ifmo.rain.garder.cli.Environment
import ru.ifmo.rain.garder.cli.exception.InvalidUsageException
import java.io.InputStream

/**
 * Implementation of cat command
 */
class CatCommand(args: List<String>) : Command(args) {

    override fun run(env: Environment, input: InputStream?): InputStream? {
        if (args.size > 1) {
            throw InvalidUsageException(this)
        }
        return getInput(if (args.isEmpty()) null else args[0], input)
    }

    override fun getUsage(): String {
        return "cat [FILE]"
    }
}