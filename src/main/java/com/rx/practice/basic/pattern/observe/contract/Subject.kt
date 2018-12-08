package com.rx.practice.basic.pattern.observe.contract

interface Subject {

    fun addObserver(vararg observer: Observer)

    fun removeObserver(vararg observer: Observer)

    fun removeAll()

    fun notifyAll(data: Any)

    fun notify(observer: Observer, data: Any)

}