package com.buchwald.kotlincoroutines.chapters

enum class SequenceExampleType {
    INITIAL,
    WITH_PRINTS
}

fun <T> runSequenceExample(
    triple: Triple<T, T, T>,
    type: SequenceExampleType
) {
    println("Starting")
    when (type) {
        SequenceExampleType.INITIAL -> initialSequenceExample(triple)
        SequenceExampleType.WITH_PRINTS -> sequenceExampleWithPrints(triple)
    }
    println("Finished")
}

private fun <T> initialSequenceExample(triple: Triple<T, T, T>) {
    val (x, y, z) = triple
    val seq = sequence {
        yield(x)
        yield(y)
        yield(z)
    }
    seq.forEach(::println)
}

private fun <T> sequenceExampleWithPrints(triple: Triple<T, T, T>) {
    val seq = sequence {
        val (x, y, z) = triple
        println("Generating first")
        yield(x)
        println("Generating second")
        yield(y)
        println("Generating third")
        yield(z)
        println("Done")
    }
    seq.forEach(::println)
}