package com.rx.practice.basic.pattern.observe

import com.rx.practice.basic.pattern.observe.observer.ObserverOne
import com.rx.practice.basic.pattern.observe.observer.ObserverThree
import com.rx.practice.basic.pattern.observe.observer.ObserverTwo
import com.rx.practice.basic.pattern.observe.subject.ConcreteSubject

fun main(args: Array<String>) {
    val concreteSubject = ConcreteSubject()
    val observer1 = ObserverOne()
    val observer2 = ObserverTwo()
    val observer3 = ObserverThree()
    concreteSubject.addObserver(observer1, observer2, observer3)

    println("#1. Notify to all subscribe Observer")
    concreteSubject.notifyAll("Notify to all Observers")

    println("#2. Notify ObserverTwo only")
    concreteSubject.notify(observer2, "Notify to ObserverTwo only")

    println("#3. Unsubscribe ObserverThree and notify all Observers again")
    concreteSubject.removeObserver(observer3)
    concreteSubject.notifyAll("Notify to all user Second time")
}
