package com.buchwald.kotlincoroutines

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.buchwald.kotlincoroutines.chapters.SequenceExampleType
import com.buchwald.kotlincoroutines.chapters.createFibonacciSequence
import com.buchwald.kotlincoroutines.chapters.createRandomNumbers
import com.buchwald.kotlincoroutines.chapters.createRandomStrings
import com.buchwald.kotlincoroutines.chapters.runSequenceExample

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Sequence Builder Use Cases
        // createFibonacciSequence(10)
        // createRandomNumbers(10)
        createRandomStrings(10, 15)

        // Sequence Builder
        /*runSequenceExample(Triple("first", "second", "third"), SequenceExampleType.INITIAL)
        runSequenceExample(Triple(1, 2, 3), SequenceExampleType.WITH_PRINTS)
        runSequenceExample(Triple(1, 2, 3), SequenceExampleType.MANUEL_VALUE_GETTERS)*/

        setContent {}
    }
}