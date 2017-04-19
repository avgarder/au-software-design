package ru.ifmo.rain.garder.cli.command

/**
 * Creates command class by list of tokens
 */
class CommandFactory {
    companion object {
        private val CAT_COMMAND = "cat"
        private val EXIT_COMMAND = "exit"
        private val ECHO_COMMAND = "echo"
        private val PWD_COMMAND = "pwd"
        private val WC_COMMAND = "wc"
        private val LS_COMMAND = "ls"
        private val CD_COMMAND = "cd"

        /**
         * creates command by tokens
         */
        fun getCommand(tokens: List<String>): Command {
            val cmd = tryCreateSetVariableCommand(tokens)
            if (cmd != null) {
                return cmd
            }
            when (tokens[0]) {
                CAT_COMMAND -> return CatCommand(tokens.subList(1, tokens.size))
                EXIT_COMMAND -> return ExitCommand(tokens.subList(1, tokens.size))
                ECHO_COMMAND -> return EchoCommand(tokens.subList(1, tokens.size))
                PWD_COMMAND -> return PwdCommand(tokens.subList(1, tokens.size))
                WC_COMMAND -> return WcCommand(tokens.subList(1, tokens.size))
                LS_COMMAND -> return LsCommand(tokens.subList(1, tokens.size))
                CD_COMMAND -> return CdCommand(tokens.subList(1, tokens.size))
                else -> return CustomCommand(tokens)
            }
        }

        private fun tryCreateSetVariableCommand(tokens: List<String>): Command? {
            if (tokens.size != 1) {
                return null
            }

            var delimeterPos = -1
            for (i in 0..tokens[0].length - 1) {
                if (tokens[0][i] == '=') {
                    delimeterPos = i
                    break
                }
                if (!tokens[0][i].isLetter()) {
                    return null
                }
            }
            if (delimeterPos == -1) {
                return null
            }
            return SetVariableCommand(listOf(tokens[0].substring(0, delimeterPos), tokens[0].substring(delimeterPos + 1)))
        }
    }
}