package com.rx.practice.basic.rx

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable


private val mObservable: Observable<Int> = Observable.create { emitter ->
    emitter.onNext(1)
    emitter.onNext(2)
    emitter.onNext(3)
    emitter.onComplete()
}

private val mObserver = object: Observer<Int> {
    override fun onComplete() {
        println("End.")
    }

    override fun onNext(t: Int) {
        println("next: $t")
    }

    override fun onError(e: Throwable) {
        throw Exception(e)
    }

    override fun onSubscribe(d: Disposable) {
        println("New Subscription ")
    }
}

fun main(args: Array<String>) {
    println("==== pre defined observer ====")
    mObservable.subscribe(mObserver)

    println("==== subscribe in pipe ====")
    mObservable
            .map { it -> it + 1 }
            .filter{ it -> it < 3}.subscribe ({
                println(it)
            }, {
                throw Exception(it)
            }, {
                println("Completed.")
            })
}
