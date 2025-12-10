package com.buchwald.kotlincoroutines.chapters

import java.math.BigInteger

fun createFibonacciSequence(count: Int) {
    val fibonacci = sequence {
        var first = BigInteger.ZERO
        var second = BigInteger.ONE
        while (true) {
            yield(first)
            val temp = first
            first += second
            second = temp
        }
    }
    println(fibonacci.take(count).toList())
}