package ru.ifmo.rain.garder.cli.command

import ru.ifmo.rain.garder.cli.Environment
import ru.ifmo.rain.garder.cli.exception.InvalidUsageException
import ru.ifmo.rain.garder.cli.exception.RunException
import java.io.File
import java.io.FileNotFoundException
import java.io.InputStream
import java.nio.file.Paths

/**
 * Implementation of cd command
 */
class CdCommand(args: List<String>) : Command(args) {

    override fun run(env: Environment, input: InputStream?): InputStream? {
        if (args.size > 1) {
            throw InvalidUsageException(this)
        }
        if (args.isEmpty()) {
            return "".byteInputStream()
        }
        val path = args[0]
        val curDir = File("").absolutePath
        val dest = Paths.get(curDir, path).toAbsolutePath().toFile()

        if (!dest.isDirectory) {
            throw RunException("$path is not directory")
        }

        System.setProperty("user.dir", dest.canonicalPath)

        return "".byteInputStream()
    }

    override fun getUsage(): String {
        return "cd [DIRECTORY]"
    }
}