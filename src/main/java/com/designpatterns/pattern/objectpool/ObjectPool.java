package com.designpatterns.pattern.objectpool;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ObjectPool<T extends Poolable> {

    private BlockingDeque<T> availablepool;

    public ObjectPool(Supplier<T> creator, int count){
        availablepool= new LinkedBlockingDeque<>();
        IntStream.range(0, count).forEach(
                i -> availablepool.offer(creator.get())
        );
    }

    public T get() {
        try {
            return availablepool.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void release(T obj) {
        obj.reset();
        try {
            availablepool.put(obj);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
