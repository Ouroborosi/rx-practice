package com.rx.practice.basic.pattern.observe.observer

import com.rx.practice.basic.pattern.observe.contract.Observer

class ObserverThree: Observer {

    override fun update(data: Any) {
        println("The message from subject to ${this.javaClass.kotlin.simpleName}")
        println("update data in ${this.javaClass.kotlin.simpleName}: $data")
    }

}