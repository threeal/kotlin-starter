package io.github.leonardo.bonacci

import kotlin.test.Test
import kotlin.test.assertEquals

class FibonacciTest {
    @Test
    fun `generates a Fibonacci sequence`() {
        assertEquals(listOf(), fibonacciSequence(0))
        assertEquals(listOf(1), fibonacciSequence(1))
        assertEquals(listOf(1, 1), fibonacciSequence(2))
        assertEquals(listOf(1, 1, 2, 3, 5), fibonacciSequence(5))
    }
}
