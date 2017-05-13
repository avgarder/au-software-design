package ru.ifmo.rain.garder.cli

import ru.ifmo.rain.garder.cli.command.ExitCommand
import ru.ifmo.rain.garder.cli.exception.InvalidUsageException
import ru.ifmo.rain.garder.cli.exception.RunException
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

/**
 * Main application loop
 */
fun main(args: Array<String>) {
    mainLoop@ while (true) {
        print("> ")
        System.out.flush()
        val s = Shell.readString() ?: break
        val commands = CommandsBuilder.buildCommands(Shell.getEnvironment(), s)
        var lastStream: InputStream? = System.`in`
        for (command in commands) {
            if (command is ExitCommand) {
                return
            }
            try {
                lastStream = command.run(Shell.getEnvironment(), lastStream)
            } catch (e: InvalidUsageException) {
                println(e.message)
                continue@mainLoop
            } catch (e: RunException) {
                println(e.message)
                continue@mainLoop
            }
        }
        Shell.writeLines(lastStream)
    }
}