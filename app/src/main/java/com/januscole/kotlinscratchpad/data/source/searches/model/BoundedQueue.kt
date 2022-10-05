package com.januscole.kotlinscratchpad.data.source.searches.model

import java.util.*

class BoundedQueue<T>(private val sizeLimit: Int): LinkedList<T>() {
    override fun add(element: T): Boolean {
        if (contains(element)) return false
        if (size == sizeLimit) {
            this.poll()
        }
        return super.add(element)
    }
}