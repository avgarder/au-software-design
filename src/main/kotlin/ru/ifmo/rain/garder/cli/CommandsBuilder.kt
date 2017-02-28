package ru.ifmo.rain.garder.cli

import ru.ifmo.rain.garder.cli.command.Command
import ru.ifmo.rain.garder.cli.command.CommandFactory

/**
 * Container for methods that creates command classes
 */
class CommandsBuilder {
    companion object {
        /**
         * builds commands from script text
         */
        fun buildCommands(env: Environment, script: String): List<Command> {
            val processed = Preprocessor.preprocess(env, script)
            val tokens = Tokenizer.tokenize(processed)
            val splitted = PipeSplitter.splitPipes(tokens)
            val commands = splitted.map { CommandFactory.getCommand(it) }
            return commands
        }
    }
}