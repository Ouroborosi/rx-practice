package com.rx.practice.basic.pattern.observe.subject

import com.rx.practice.basic.pattern.observe.contract.Observer
import com.rx.practice.basic.pattern.observe.contract.Subject
import java.util.*


class ConcreteSubject: Subject {

    private val observerList = ArrayList<Observer>()

    override fun addObserver(vararg observer: Observer) {
        for (singleObserver in observer) {
            if (observerList.contains(singleObserver)) throw RuntimeException("Current Observer has already contained in Subject.")
            observerList.add(singleObserver)
        }
    }

    override fun removeObserver(vararg observer: Observer) {
        for (singleObserver in observer) {
            if (!observerList.contains(singleObserver)) throw RuntimeException("Subject doesn't contain current Observer")
            observerList.remove(singleObserver)
        }
    }

    override fun removeAll() {
        observerList.clear()
    }

    override fun notifyAll(data: Any) {
        for (observer: Observer in observerList) {
            observer.update(data)
        }
    }

    override fun notify(observer: Observer, data: Any) {
        observer.update(data)
    }

}