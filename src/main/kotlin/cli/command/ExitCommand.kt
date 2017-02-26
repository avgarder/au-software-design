package cli.command

import cli.Environment
import java.io.InputStream

class ExitCommand(args: List<String>) : Command(args) {
    override fun run(env: Environment, input: InputStream?): InputStream? {
        throw UnsupportedOperationException("Exit command can't run")
    }
}