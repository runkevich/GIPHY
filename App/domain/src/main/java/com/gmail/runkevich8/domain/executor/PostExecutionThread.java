package com.gmail.runkevich8.domain.executor;


import io.reactivex.Scheduler;


//этот интерфейс нужен реализовать в presentation слое
public interface PostExecutionThread {
    Scheduler getScheduler();
}
