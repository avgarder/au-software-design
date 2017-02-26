package cli.command

import cli.Environment
import java.io.InputStream
import java.nio.file.Paths

class PwdCommand(args: List<String>) : Command(args) {
    override fun run(env: Environment, input: InputStream?): InputStream? {
        return Paths.get("").toAbsolutePath().toString().byteInputStream()
    }
}