package io.github.leonardo.bonacci.cli

import com.github.ajalt.clikt.core.Context
import com.github.ajalt.clikt.core.CoreCliktCommand
import com.github.ajalt.clikt.core.context
import com.github.ajalt.clikt.core.main
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.options.versionOption
import com.github.ajalt.clikt.parameters.types.int
import io.github.leonardo.bonacci.fibonacciSequence

private class Bonacci : CoreCliktCommand(name = "bonacci") {
    private val n by argument(help = "The number of terms").int()

    init {
        versionOption(BuildConfig.VERSION)
        context {
            exitProcess = System::exit
            echoMessage = { _, message, trailingNewline, err ->
                val stream = if (err) System.err else System.out
                if (trailingNewline) stream.println(message) else stream.print(message)
            }
        }
    }

    override fun help(context: Context) =
        "Generate a Fibonacci sequence up to the given number of terms"

    override fun run() {
        echo(fibonacciSequence(n).joinToString(" "))
    }
}

/** A command-line interface for generating a Fibonacci sequence. */
fun main(args: Array<String>) = Bonacci().main(args)
