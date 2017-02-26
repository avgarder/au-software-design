package cli.command

import cli.Environment
import java.io.InputStream

class EchoCommand(args: List<String>) : Command(args) {
    override fun run(env: Environment, input: InputStream?): InputStream? {
        return args.joinToString(separator = " ").byteInputStream()
    }
}