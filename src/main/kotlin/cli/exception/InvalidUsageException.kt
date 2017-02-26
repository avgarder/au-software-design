package cli.exception

import cli.command.Command
import cli.command.CustomCommand

class InvalidUsageException(cmd: Command) : RuntimeException(getMessage(cmd)) {
    companion object {
        private fun getMessage(cmd: Command): String {
            when (cmd) {
                is CustomCommand -> return "Can't find binary"
                else -> return "Usage: ${cmd.getUsage()}"
            }
        }
    }
}