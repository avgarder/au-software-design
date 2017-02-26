package cli.command

import cli.Environment
import cli.exception.InvalidUsageException
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class WcCommand(args: List<String>) : Command(args) {
    override fun run(env: Environment, input: InputStream?): InputStream? {
        if (args.size > 1) {
            throw InvalidUsageException(this)
        }
        val input = getInput(if (args.isEmpty()) null else args[0], input)

        val reader = BufferedReader(InputStreamReader(input))
        var linesNumber = 1
        var wordsNumber = 1
        var bytesNumber = 0
        var wordNow = false
        while (true) {
            val byte = reader.read()
            if (byte == -1) {
                break
            }
            bytesNumber++
            if (byte == '\n'.toInt() || byte == '\r'.toInt()) {
                linesNumber++
            }

            if (byte.toChar().isWhitespace()) {
                if (wordNow) {
                    wordsNumber++
                }
                wordNow = false
            } else {
                wordNow = true
            }
        }

        return "$linesNumber $wordsNumber $bytesNumber".byteInputStream()
    }

    override fun getUsage(): String {
        return "wc [FILE]"
    }
}