package cli.command

import cli.Environment
import java.io.InputStream

/**
 * Auxiliary command for setting value to environment
 */
class SetVariableCommand(args: List<String>) : Command(args) {
    override fun run(env: Environment, input: InputStream?): InputStream? {
        env.setValue(args[0], args[1])
        return input
    }
}