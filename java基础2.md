# java基础2

# 线程

### 1.并发和并行

* 并发
  * 指两个或多个事件在同一个时间段内发生
* 并行
  * 指两个或多个事件在同一时刻发生(同时发生)

### 2.进程和线程

* 进程概念
  * 进程是指内存中运行的应用程序，每个进程都有一个独立的内存空间，一个应用程序可以同时运行多个进程；
  * 进程也是程序的一次执行过程，是系统运行程序的基本单位
  * 系统运行一个程序即是一个进程从创建、运行到消亡的过程

* 线程概念
  * 线程是进程中的一个执行单元，负责当前进程中程序的执行，一个进程中至少有一个线程。
  * 一个进程中可以有多个线程，这个应用程序也称为多线程程序

### 3.线程调度

* 分时调度
  * 所有线程轮流使用CPU的使用权，平均分配每个线程占用CPU的时间
* 抢占式调度
  * 优先让优先级高的线程使用CPU，如果线程的优先级相同，那么会随机选择一个（线程随机性）,Java使用的方式就是抢占式调度

### 4.主线程

* 主线程：执行主方法（main）的线程

* 单线程程序，java程序只有一个线程，执行从main方法开始，从上到下依次执行

### 5.创建子线程

* **第一种方式**
  * java.lang.Thread类：是描述线程的类，我们想要实现多线程程序，就必须继承Thread类
  * 创建Thread的子类，重写run方法，通过start方法开启run方法
* 注意事项
  * java程序是抢占式调度，哪个优先级高，哪个线程优先执行，同一个优先级，随机选择一个执行

### 6.线程的方法、

1. 获取线程的名字
   * String  getName() 返回该线程的名称
2. 获取当前线程的方法
   * static  Thread  currentThread()  返回对当前正在执行的线程对象的引用
3. 线程的名字
   * 主线程： main
   * 新线程：Thread-0，Thread-1,Thread-2
4. 设置线程的两种方式
   * 使用Thread类中的方法setName(名字)
     * void setName(String name) 改变线程名称
   * 创建一个带有参数的构造方法，参数传递线程的名字，调用父类的带参构造方法，把线程名传递给父类，让父类（Thread）给子线程起一个名字
5. 使当前正在执行的线程以指定的毫秒数暂停
   * public static void sleep(long millis)
   * 使当前正在执行的线程以指定的毫秒数暂停（暂时停止运行）。毫秒数结束之后，线程继续执行
   * 此方法需要处理异常

### 7.创建子线程的第二种方式

1. 定义Runnerable接口实现类，并且重写该接口的run()方法
2. 创建Thread对象，实例化过程传入Runnerable对象
3. 通过start()启动线程

### 8.继承Thread类和实现Runnerable接口对比

* 实现Runnerable接口的好处：
  * 避免了单继承的局限性
    * 一个类只能继承一个类，类继承Thread就不能再继承其他类
    * 实现Runnerable接口，还可以继承其它的类，实现其它的接口
  * 增强了程序的扩展性，降低了耦合性
    * 传递不同的实现类，设置不同的任务

### 9.线程安全问题

* 如果有多个线程在同时运行，而这些线程可能会同时运行这段代码。程序每次运行结果和单线程运行的结果是一样的，而且其他的变量的值也和预期的是一样的，就是线程安全的。 
* 当我们使用多个线程访问同一资源的时候，且多个线程中对资源有写的操作，就容易出现线程安全问题。

### 10.解决线程安全问题

* **同步代码块**： synchronized 关键字可以用于方法中的某个区块中，表示只对这个区块的资源实行互斥访问。 

  ```java
  synchronized(同步锁){ 
      需要同步操作的代码 
  }
  /*
  对象的同步锁只是一个概念,可以想象为在对象上标记了一个锁.
  1. 锁对象 可以是任意类型。 
  2. 多个线程对象 要使用同一把锁。
  在任何时候,最多允许一个线程拥有同步锁,谁拿到锁就进入代码块,其他的线程只能在外等着 (BLOCKED)。
  */
  ```

* **同步方法**:使用synchronized修饰的方法,就叫做同步方法,保证A线程执行该方法的时候,其他线程只能在方法外 等着。 

  ```java
  public synchronized void method(){ 
      可能会产生线程安全问题的代码 
  }
  /*
  同步锁是谁? 对于非static方法,同步锁就是this。 对于static方法,我们使用当前方法所在类的字节码对象(类名.class)。
  */
  ```

* `java.util.concurrent.locks.Lock` 机制提供了比**synchronized**代码块和**synchronized**方法更广泛的锁定操作, 同步代码块/同步方法具有的功能Lock都有,除此之外更强大,更体现面向对象。 

  ```java
  /*
  Lock锁也称同步锁，加锁与释放锁方法化了，
  如下： 
  public void lock() :加同步锁。 
  public void unlock() :释放同步锁。
  */
  
  public class Ticket implements Runnable{ 
      private int ticket = 100;
      Lock lock = new ReentrantLock();
      /** 执行卖票操作 */ 
      @Override 
      public void run() { 
          //每个窗口卖票的操作 
          //窗口 永远开启 
          while(true){ 
              lock.lock(); 
              if(ticket>0){
                  //有票 可以卖 
                  //出票操作 
                  //使用sleep模拟一下出票时间 
                  try {
                      Thread.sleep(50); 
                  } catch (InterruptedException e) { 
                      // TODO Auto‐generated catch block 
                      e.printStackTrace(); 
                  }//获取当前线程对象的名字 
                  String name = Thread.currentThread().getName(); 
                  System.out.println(name+"正在卖:"+ticket‐‐); 
              }
              lock.unlock();
          } 
      } 
  }
  ```

### 11.线程的状态

* 在API中 java.lang.Thread.State 这个枚举中给出了六种线程状态：

  * NEW(新建) 
    * 线程刚被创建，但是并未启动。还没调用start方法。
  * Runnable(可运行) 
    * 线程可以在java虚拟机中运行的状态，可能正在运行自己代码，也可能没有，这取决于操作系统处理器。 
  * Blocked(锁阻塞) 
    * 当一个线程试图获取一个对象锁，而该对象锁被其他的线程持有，则该线程进入Blocked状态；当该线程持有锁时，该线程将变成Runnable状态。 
  * Waiting(无限等待)
    * 一个线程在等待另一个线程执行一个（唤醒）动作时，该线程进入Waiting状态。进入这个状态后是不能自动唤醒的，必须等待另一个线程调用notify或者notifyAll方法才能够唤醒。 
  * Timed Waiting(计时等待)  
    * 同waiting状态，有几个方法有超时参数，调用他们将进入Timed Waiting状态。这一状态将一直保持到超时期满或者接收到唤醒通知。带有超时参数的常用方法有Thread.sleep 、Object.wait。 
  * Teminated(被终止) 
    * 因为run方法正常退出而死亡，或者因为没有捕获的异常终止了run方法而死亡。 

  

