package com.januscole.kotlinscratchpad.util

import com.januscole.kotlinscratchpad.data.source.searches.model.BoundedQueue
import org.junit.Test

import org.junit.Assert.*

class BoundedQueueTest {

    @Test
    fun addOneString() {
        val boundedQueue = BoundedQueue<String>(5)
        boundedQueue.add("Test String 1")
        assertEquals("Test String 1", boundedQueue.poll())
    }

    @Test
    fun addSixStrings() {
        val boundedQueue = BoundedQueue<String>(5)
        boundedQueue.add("Test String 1")
        boundedQueue.add("Test String 2")
        boundedQueue.add("Test String 3")
        boundedQueue.add("Test String 4")
        boundedQueue.add("Test String 5")
        boundedQueue.add("Test String 6")
        assertEquals("Test String 2", boundedQueue.poll())
    }

    @Test
    fun addDuplicateStrings() {
        val boundedQueue = BoundedQueue<String>(5)
        boundedQueue.add("Test String 1")
        boundedQueue.add("Test String 2")
        boundedQueue.add("Test String 1")
        assertEquals(2, boundedQueue.size)
    }
}