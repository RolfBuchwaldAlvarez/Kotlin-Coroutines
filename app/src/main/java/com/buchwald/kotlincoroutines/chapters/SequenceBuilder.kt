package com.buchwald.kotlincoroutines.chapters

enum class SequenceExampleType {
    INITIAL,
    WITH_PRINTS,
    MANUEL_VALUE_GETTERS,
}

fun <T> runSequenceExample(
    triple: Triple<T, T, T>,
    type: SequenceExampleType,
) {
    println("Initialising")
    when (type) {
        SequenceExampleType.INITIAL -> initialSequenceExample(triple)
        SequenceExampleType.WITH_PRINTS -> sequenceExampleWithPrints(triple)
        SequenceExampleType.MANUEL_VALUE_GETTERS -> sequenceExampleWithManualValueGetters(triple)
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

/**
 * Within the sequence, each Triple item is generated on demand, not in advance.
 * Output:
 * Starting
 * Generating first
 * The next value is 1
 * Generating second
 * The next value is 2
 * Generating third
 * The next value is 3
 * Done
 * Finished
 *
 * So, after generating each number, we jump into the loop, printing "The next value is ...". After
 * that, the code jumps back to where it was inside the sequence builder. You can compare it to a
 * video game, where you can save your progress and come back later to go on from where you stopped.
 * This is called "resuming" the game. With sequences, this would be impossible without a suspension
 * mechanism, as it wouldn't be possible to stop a function in the middle of execution and resume it
 * from the exact same point in the future. But this can be done here thanks to suspension.
 */
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
    seq.forEach {
        println("The next value is $it")
    }
}

/**
 * Here, an iterator is used to get the next value from the sequence. At any point, we can call it
 * again to jump back into the middle of the sequence builder function and generate the next value.
 */
private fun <T> sequenceExampleWithManualValueGetters(triple: Triple<T, T, T>) {
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
    val iterator = seq.iterator()
    println("Starting")
    val first = iterator.next()
    println("The first value is $first")
    val second = iterator.next()
    println("The second value is $second")
    val third = iterator.next()
    println("The third value is $third")
    println("And they lived happily ever after")
    // ...
}