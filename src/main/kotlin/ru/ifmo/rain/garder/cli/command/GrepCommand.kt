package ru.ifmo.rain.garder.cli.command

import joptsimple.OptionException
import joptsimple.OptionParser
import joptsimple.OptionSet
import ru.ifmo.rain.garder.cli.Environment
import ru.ifmo.rain.garder.cli.exception.InvalidUsageException
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*
import java.util.regex.Pattern

/**
 * Implementation of grep command
 */
class GrepCommand(args: List<String>) : Command(args) {
    override fun run(env: Environment, input: InputStream?): InputStream? {
        val options: OptionSet
        try {
            options = parseOptions()
        } catch (e: OptionException) {
            throw InvalidUsageException(this)
        }
        if (options.nonOptionArguments().isEmpty() || options.nonOptionArguments().size > 2) {
            throw InvalidUsageException(this)
        }
        val pattern = buildPattern(options)
        var input = getInput(
                if (options.nonOptionArguments().size < 2) null else options.nonOptionArguments()[1].toString(),
                input)

        val reader = BufferedReader(InputStreamReader(input))
        var next = 0
        val result = ArrayList<String>()
        while (true) {
            val s = reader.readLine() ?: break
            if (pattern.matcher(s).matches()) {
                result.add(s)
                if (options.has("A")) {
                    next = options.valueOf("A").toString().toInt()
                }
            } else if (next > 0) {
                result.add(s)
                next--
            }
        }
        return result.joinToString("\n").byteInputStream()
    }

    private fun parseOptions() : OptionSet {
        val parser = OptionParser("iwA:")
        val options = parser.parse(*args.toTypedArray())
        return options
    }

    private fun buildPattern(options: OptionSet) : Pattern {
        var regex = options.nonOptionArguments()[0].toString()
        if (options.has("w")) {
            regex = "\\b$regex\\b"
        }
        regex = ".*?$regex.*?"
        var flags = 0
        if (options.has("i")) {
            flags = Pattern.CASE_INSENSITIVE
        }
        return Pattern.compile(regex, flags)
    }

    override fun getUsage(): String {
        return "grep [-i] [-w] [-A n] pattern [file]"
    }
}