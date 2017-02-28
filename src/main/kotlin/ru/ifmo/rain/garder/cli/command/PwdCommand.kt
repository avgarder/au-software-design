package ru.ifmo.rain.garder.cli.command

import ru.ifmo.rain.garder.cli.Environment
import java.io.InputStream
import java.nio.file.Paths

/**
 * Implementation of pwd command
 */
class PwdCommand(args: List<String>) : Command(args) {
    override fun run(env: Environment, input: InputStream?): InputStream? {
        return Paths.get("").toAbsolutePath().toString().byteInputStream()
    }
}