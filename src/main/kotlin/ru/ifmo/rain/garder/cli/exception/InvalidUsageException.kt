package ru.ifmo.rain.garder.cli.exception

import ru.ifmo.rain.garder.cli.command.Command
import ru.ifmo.rain.garder.cli.command.CustomCommand

/**
 * Exception when command was used wrong
 */
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