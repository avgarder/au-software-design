package ru.ifmo.rain.garder.cli.command

import ru.ifmo.rain.garder.cli.Environment
import ru.ifmo.rain.garder.cli.exception.InvalidUsageException
import ru.ifmo.rain.garder.cli.exception.RunException
import java.io.File
import java.io.FileNotFoundException
import java.io.InputStream
import java.nio.file.Paths

/**
 * Implementation of ls command
 */

class LsCommand(args: List<String>) : Command(args) {

    override fun run(env: Environment, input: InputStream?): InputStream? {
        if (args.size > 1) {
            throw InvalidUsageException(this)
        }
        val path = if (args.isEmpty()) "." else args[0]
        try {
            val curDir = File("").absolutePath
            val dest = Paths.get(curDir, path).toAbsolutePath().toFile()

            if (!dest.isDirectory) {
                throw RunException("$path is not directory")
            }

            return dest.walkTopDown().maxDepth(1).drop(1).map { it.name }.joinToString(" ").byteInputStream()
        } catch (e: FileNotFoundException) {
            throw RunException("file not found: $path")
        }
    }

    override fun getUsage(): String {
        return "ls [DIRECTORY]"
    }
}