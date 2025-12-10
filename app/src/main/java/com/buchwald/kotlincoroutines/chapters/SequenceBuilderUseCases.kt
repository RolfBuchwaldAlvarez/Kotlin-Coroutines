package com.buchwald.kotlincoroutines.chapters

import java.math.BigInteger
import kotlin.random.Random

fun createFibonacciSequence(count: Int = 10) {
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

fun createRandomNumbers(
    repetitions: Int = 10,
    seed: Long = System.currentTimeMillis(),
) {
    val seq = sequence {
        val random = Random(seed)
        repeat(repetitions) {
            yield(random.nextInt())
        }
    }
    seq.forEach(::println)
}

fun createRandomStrings(
    repetitions: Int = 10,
    length: Int = 24,
    seed: Long = System.currentTimeMillis(),
) {
    val seq = sequence {
        val random = Random(seed)
        val charPool = ('a'..'z') + ('A'..'Z') + ('0'..'9')
        repeat(repetitions) {
            val randomString = (1..length)
                .map { i -> random.nextInt(charPool.size) }
                .map(charPool::get)
                .joinToString("")
            yield(randomString)
        }
    }
    seq.forEach(::println)
}