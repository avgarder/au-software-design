package ru.ifmo.rain.garder.cli.command

import ru.ifmo.rain.garder.cli.Environment
import java.io.InputStream

/**
 * Implementation of echo command
 */
class EchoCommand(args: List<String>) : Command(args) {
    override fun run(env: Environment, input: InputStream?): InputStream? {
        return args.joinToString(separator = " ").byteInputStream()
    }
}