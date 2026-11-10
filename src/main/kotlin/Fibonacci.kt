package io.github.leonardo.bonacci

/**
 * Generates a Fibonacci sequence up to the given number of terms.
 *
 * The sequence starts from `1, 1`, and exactly [n] terms are returned, so an [n] of 0 yields an
 * empty sequence.
 */
fun fibonacciSequence(n: Int): List<Int> {
    val sequence = MutableList(n) { 1 }
    for (i in 2 until n) {
        sequence[i] = sequence[i - 2] + sequence[i - 1]
    }
    return sequence
}
