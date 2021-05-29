# lock类

sum.misc.Lock 是一个非常笨重的锁，内部实现是一个简化版的pv操作。
``` java
     public final synchronized void lock() throws InterruptedException {
        while (this.locked) {
            this.wait();
        }
        this.locked = true;
    }
    public final synchronized void unlock() {
        this.locked = false;
        this.notifyAll();
    }

```



