# 面向对象

### 1.ArrayList 集合的长度是可变的

> 看包，java.utl.ArrayList看new，看方法
>
> 背景：数组的长度不可以发生改变，但是ArrayList的长度是可以随意变化的

* API文档中，ArrayList类名后面有个 `<E>`  ,他代表泛型，也就是说装在集合中的所有元素，全部是统一的类型
* **泛型只能是引用类型，不能是基本类型**
* 注意：
  * ArrayList 集合 直接打印是展示元素，不是地址值
  * 如果是空，打印空列表

1. **语法**

   ```java
   ArrayList<String> list = new ArrayList<>();
   ArrayList<String> list = new ArrayList<String>(); // JDK1.7+ 后面String可以不写，但是<> 不能省略
   // 创建一个ArrayList集合，里面装的是String类型数据
   ```

2. **常用方法**

   ```java
   ArrayList<String> list = new ArrayList<>();
   /*
   public boolean add(E e) 添加元素，参数类型和泛型一致，返回布尔类型数值
   备注：对于ArrayList集合来说，add动作一定是成功的，但是其它的集合不一定了
   public E get(int index) 从集合中获取元素，参数是索引，返回元素
   public E remove(int index) 从集合中删除元素，参数是索引编号，返回被删除元素
   public int size() 获取集合长度，返回值是及很重包含的元素个数
   */
   ```

3. **在集合 ArrayList当中存储基础类型数据，必须使用基本类型对应的包装类**

   ```java
   /*
   基本类型		包装类（引用类型，包装类都位于java.lang包下）
   byte			Byte
   short			Short
   int				Integer  [特殊]
   long			Long
   float			Float
   double			Double
   char			Character	[特殊]
   boolean			Boolean
   */
   ArrayList<Integer> intList = new ArrayList<>();
   intList.add(10) // 自动装箱， 基本类型 --> 包装类型
   intList.add(20) // 自动装箱， 基本类型 --> 包装类型
   int num = intList.get(0)  // 自动拆箱, 包装类型 --> 基本类型
   ```

### 2.String类

#### 1.定义：

* java.lang.String 类代表字符串
* Java程序中的所有字符串字面值（“abc”）都作为此类的实现实例。
* 程序当中所有的双引号字符串，都是String类的对象

#### 2.字符串的特点：

* **字符串的内容永不可变**。【重点】
* 正是因为字符串不可变，所以**字符串是可以共享使用的**。
* 字符串效果上相当于是char[]字符数组，**但是底层原理是bytes[] 字节数组**

#### 3.构造方法

```java
public String(); // 创建一个空白字符串，不含有任何内容
public String(char[] array); // 根据字符数组的内容，来创建对应的字符串
public String(byte[] array); // 根据字节数组的内容，来创建对应的字符串。
String str = "Hello"; // 直接创建
```

```java
package com.Api.Demo;

public class StringDemo {
    public static void main(String[] args) {
        // 创建空的字符串
        String str1 = new String();
        System.out.println(str1);
        
        // 通过字符数组创建字符串
        char[] charArray = new char[]{'A', 'B', 67, 97};
        String str2 = new String(charArray);
        System.out.println(str2);
        
        // 通过字节数组创建字符串
        byte[] byteArray = {65, 97};
        String str3 = new String(byteArray);
        System.out.println(str3);
        
        // 直接创建
        String str4 = "hello world";
        System.out.println(str4);
    }
}

```

* 数组创建方法(小插曲)

  ```java
  数据类型[] 数组名 = new 数据类型[长度];
  数据类型[] 数组名 = new 数据类型{元素1， 元素2， 元素3...};
  数据类型[] 数组名 = {元素1， 元素2， 元素3...}；
  ```

#### 4.**字符串常量池**

* 字符串常量池：程序当中直接写上的双引号字符串，就在字符串常量池中

* `==`比较

  * 对于基本类型，== 是进行数值的比较
  * 对于引用类型，== 是进行【地址值】的比较

* 代码

  ```java
  package com.Api.Demo;
  
  public class StringDemo1 {
      public static void main(String[] args) {
          String str1 = "abc";
          String str2 = "abc";
  
          char[] charArray = {'a', 'b', 'c'};
          String str3 = new String(charArray);
          System.out.println(str1);
          System.out.println(str2);
          System.out.println(str3);
          System.out.println(str1 == str2); // true
          System.out.println(str2 == str3); // False
          System.out.println(str2 == str3); // False
      }
  }
  
  ```

  **常量池内存图**

  ![01-字符串的常量池](.\images\01-字符串的常量池.png)

#### 5.**字符串的方法**

1. 比较方法：

> **public boolean equals(Object obj)**
>
> **public boolean equalsIgnoreCase(String str)**
>
> 当比较引用类型时，== 是比较的地址值，如果希望比较内容，则使用equal等方法

```java
/*
public boolean equals(Object obj) 参数可以是任何一个对象，只有参数是一个字符串并且内容相同的才会给true，否则返回false
注意事项：
1. 任何对象都能用Object接收
2. equals 方法具有对称性，也就是说 a.equals(b) 和 b.equals(a)效果是一样的
3. 如果比较双方一个常量一个变量，推荐把常量字符串写在前面
推荐："abc".equals(str) 
不推荐：str.equals("abc") --可能会产生空指针异常
*/

/*
public boolean equalsIgnoreCase(String str) 忽略大小写，进行内容比较。
*/
```

2. **获取相关方法**

   ```java
   /*
   String 常用的获取方法
   public int length() 获取字符串当中含有的字符个数，拿到字符串长度
   public String concat(String str) 将当前字符串和参数字符串拼接成返回值新的字符串
   public char charAt(int index) 获取指定索引位置的单个字符。索引从0开始
   public int indexof(String str) 查找参数字符串在本字符串中首次出现的索引位置，如果找不到返回 -1
   */
   ```

3. 字符串的截取方法

   ```java
   /*
   public String substring(int index) 截取从参数位置一直到字符串末位，返回新的字符串
   public String substring(int begin, int end) 截取从begin开始，一直到end结束，中间的字符串。备注：包含左边不包含右边。
   */
   ```

4. 字符串的转换方法

   ```java
   /*
   public char[] toCharArray() 将当前字符串拆分成为字符数组作为返回值
   public byte[] getBytes() 获取当前字符串底层的字节数组
   public String replace(CharSequence oldString, CharSequence newString)
   字符产的替换，将当前字符串中的oldString 替换成 newString
   */
   ```

5. 切割字符串

   ```java
   /*
   public String[] split(String regex) 按照参照的规则，将字符串切分为若干部分
   注意事项：
   split方法的额参数其实是一个正则表达式
   用 . 切割  写作 \\.
   */
   ```

### 3.static关键字

1. 背景

   * 对象有一些公有的属性

   * 一旦使用了static关键字，name这样的内容就不在属于自己，而是属于类，所以凡是本类的对象，都共享同一份。

     概述内存

     ![02-静态static关键字概述](.\images\02-静态static关键字概述.png)

2. 静态修饰成员方法和成员变量
   1. 一旦使用了`static`修饰成员方法，那么这就成为了静态方法。静态方法属于类，不属于对象。
      1. 如果没有stattic关键字，那么必须首先创建对象，然后通过对象才能使用它。
      2. 如果有了static关键字，那么不需要创建对象，直接就能通过类名成来使用它
   2. 无论是成员变量还是成员方法，如果有了static，都推荐使用类名称进行调用。
      1. 静态变量：类名称.静态变量
      2. 静态方法：类名称.静态方法()
   3. 注意事项：
      1. 静态不能直接访问非静态
         * 原因：因为在内存当中是先有静态内容，后有非静态内容
      2. 静态方法当中不能使用this关键字
         * this代表当前对象，通过谁调用的方法，谁就是当前对象。

3. 静态内存图

   ![03-静态的内存图](.\images\03-静态的内存图.png)

4. 静态代码块

   ```java
   /*
   静态代码块格式：
   public class 类名称{
       static {
   		// 静态代码块的内容
       }
   }
   特点：当第一次用到本类时，静态代码块执行唯一的一次。
   静态内容总是优先于非静态，所以静态代码块比构造方法先执行。
   */
   ```

   

### 4.Arrays工具类

* java.util.Arrays 是一个与数组相关的工具类，里面提供了大量静态方法，用来实现数组常见的操作
  * public static String toString(数组) 将参数数组生成一个字符串（默认格式：[元素1, 元素2, 元素3, 元素4]）
  * public static void sort(数组) 按照默认升序（从小到大）对数组的元素进行排序。
    * 注意
      * 数组元素如果是数值，sort默认按照升序从小到大
      * 数组是字符串，sort默认是按照字母升序
      * 如果是自定义类型，要实现Comparable 或者 Comparator接口的支持

### 5.数学Math工具类

* java.util.Math 类是数学相关的工具类，里面提供了大量的静态方法，完成与数学运算相关的操作

  * 常见操作

    ```java
    public static double abs(double num) // 获取绝对值
    public static double ceil(double num) // 向上取整
    public static double floor(double num) // 向下取整
    public static double round(double num) // 四舍五入
        
    Math.PI // 圆周率
    ```

#### 6.继承

1. 继承的定义

   * 就是子类继承父类的**属性**和**行为**，使得子类对象具有与父类相同的属性、相同的行为。子类可以直接 访问父类中的**非私有**的属性和行为。 

2. 好处

   *  提高**代码的复用性**。 
   *  类与类之间产生了关系，是**多态的前提**。 

3. 定义子类的格式

   ```java
   public class 子类名称 extends 父类名称{
       // ......
   }
   ```

4. 在父子类的继承关系中，如果成员变量重名，子类对象访问的两种方式

   * 直接通过子类对象访问成员变量
     * 等号左边是谁，就先用谁的，没有则向上找

   * 间接通过成员方法访问
     * 成员变量该方法属于谁，就优先用谁，没有则向上找

5. 变量重名，如何访问

   1. 局部变量： 直接写变量名称，就近原则
   2. 本类的成员变量： this.成员变量名
   3. 父类的成员变量： super.成员变量名

6. 在继承关系中，如果成员方法重名---重写（overwrite）

   * 定义
     * 子类中出现与父类一模一样的方法时（返回值类型，方法名和参数列表都相同），会出现覆盖效果，也称为重写或者复写。**声明不变，重新实现**。 
   * 重写使用场景
     * 子类可以根据需要，定义特定于自己的行为。既沿袭了父类的功能名称，又根据子类的需要重新实现父类方法，从而进行扩展增强。
   * 重写的注意事项
     * 子类方法覆盖父类方法，必须要保证权限大于等于父类权限。
     * 子类方法覆盖父类方法，返回值类型、函数名和参数列表都要一模一样。

7. 继承后的特点

   1. 构造方法

      * 构造方法的格式

        ```java
        // 构造方法的名字是与类名一致的。所以子类是无法继承父类构造方法的。
        class Fu { 
            private int n; 
            Fu(){ System.out.println("Fu()"); 
                }
        }
        ```

      * 构造方法的作用

        * 构造方法的作用是初始化成员变量的。

        * 所以子类的初始化过程中，必须先执行父类的初始化动作。

        * 子类的构 造方法中默认有一个 super() ，表示调用父类的构造方法，父类成员变量初始化后，才可以给子类使用。

          ```java
          package com.Api.Demo;
          
          public class ExtendDemo1 {
              public static void main(String[] args) {
                  new Zi1();
              }
          }
          
          class Fu1{
              Fu1(){
                  System.out.println("Fu1初始化");
              }
          }
          
          class Zi1 extends Fu1{
              Zi1(){
                  super(); // 给父类初始化
                  System.out.println("Zi1初始化");
              }
          }
          
          ```

          