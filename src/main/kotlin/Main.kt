/*
 * A command-line interface for generating a Fibonacci sequence.
 *
 * This is the placeholder CLI of a project template; remove it along with the
 * `application` plugin, its coverage exclusion, and the Clikt dependency if
 * your project doesn't need one.
 */

package io.github.leonardo.bonacci

import com.github.ajalt.clikt.core.Context
import com.github.ajalt.clikt.core.CoreCliktCommand
import com.github.ajalt.clikt.core.context
import com.github.ajalt.clikt.core.main
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.options.versionOption
import com.github.ajalt.clikt.parameters.types.int

private class Bonacci : CoreCliktCommand(name = "bonacci") {
    private val n by argument(help = "The number of terms").int()

    init {
        versionOption("0.1.0")
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

fun main(args: Array<String>) = Bonacci().main(args)
