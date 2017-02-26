package cli.command

import cli.Environment
import cli.exception.RunException
import java.io.IOException
import java.io.InputStream

class CustomCommand(args: List<String>) : Command(args) {

    override fun run(env: Environment, input: InputStream?): InputStream? {
        try {
            return Runtime.getRuntime().exec(args.toTypedArray()).inputStream
        } catch (e: IOException) {
            throw RunException("Cannon run custom command: " + args.joinToString(separator = " "))
        }
    }
}