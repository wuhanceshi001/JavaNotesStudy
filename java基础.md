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

### 6.继承

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

      * 构造方法的访问特点

        * 子类构造方法当中，有一个默认隐含的super()调用，所以一定是先调用的父类构造，后执行的子类构造
        * 子类构造可以通过super关键字来调用父类重载构造
        * super的父类构造调用，必须是子类构造方法的第一句。不能一个子类构造调用多次super构造。
        * 小结
          * 子类必须调用父类构造方法，不写默认调用super(),写了则调用指定的父类构造方法，super只能有一个

8. super的三种使用场景

   1. 在子类的成员方法中，访问父类的成员变量
   2. 在子类的成员方法中，访问父类的成员方法
   3. 在子类的构造方法中，访问父类的构造方法

9. this的三种使用场景

   1. 在本类的成员方法中，访问本类的成员变量
   2. 在本类的成员方法中，访问本类的另一个成员方法
   3. 在本类的构造方法中，访问本类的另一个构造方法

10. super和this的内存图

    ![04-super与this的内存图](.\images\04-super与this的内存图.png)

12. Java语言继承的特点
    1. Java语言是单继承
    2. Java语言可以多继承
    3. 一个子类的直接父类是唯一的，但是一个父类可以拥有很多个子类

### 7.抽象类

1. 抽象类
   * 抽象方法所在的类，必须是抽象类。在class 前写abstract即可。
2. 抽象方法
   * 方法的修饰符换成`abstract` 关键字，然后去掉大括号，直接分号结束。

3. 抽象类的使用
   * 不能直接创建new一个抽象对象
   * 必须用一个子类来继承抽象父类
   * 子类必须覆盖重写父类中所有的抽象方法
     * 子类去掉抽象方法的abstract关键字，然后不上方法体大括号
   * 创建子类对象进行使用
4. 抽象类的使用注意事项
   * 抽象类不能创建对象
   * 抽象类中可以有构造方法，是供子类创建对象时，初始化父类成员的。
   * 抽象类不一定包含抽象方法，但是又抽象方法的必定是抽象类
   * 抽象类的子类，必须重写父类中所有的抽象方法，否则编译无法通过。除非该子类也是抽象类。
   * 没有抽象方法的抽象类，有特殊用途，适配器？

### 8.接口

1. 接口是一种**公共的规范标准**

2. 接口的定义

   ```java
   public interface 接口名称{
       // 接口内容
   }
   // 换成关键字interface后，编译生成的字节码文件仍然是java --> .class
   ```

   * 接口内容
     * Java 7
       * 常量
       * 抽象方法
     * Java 8
       * 默认方法
       * 静态方法
     * Java 9
       * 私有方法

3. 定义一个接口

   1. 在任何版本的Java中，接口都能定义抽象方法

      * 格式：public abstract 返回值类型 方法名称(参数列表)

   2. 注意事项

      * 接口中的抽象方法，修饰符必须是两个固定的关键字：public  abstract

      * 这两个关键字修饰符，可以选择性地省略。

      * 方法三要素，可以随意定义

        ```java
        public interface MyInterfaceAbs{
            // 这是一个抽象方法
            public abstract void methodAbs1();
            
            // 这是一个抽象方法
            abstract void methodAbs1();
            
            // 这是一个抽象方法
            public void methodAbs1();
            
            // 这是一个抽象方法
            void methodAbs1();
        }
        ```

4. 接口的使用步骤

   1. 接口不能直接使用，必须有一个“实现类”来实现“该接口”

      格式：

      ​	public class 实现类名称 implements 接口名称{

      ​		// 

      ​	}

   2. 接口的实现类必须覆盖重写接口中所有的抽象方法。

      * 去掉abstract关键字，加上方法体大括号

   3. 创建实现类对象，进行使用。

   4. 注意事项

      * 如果实现类并没有覆盖重写接口中所有的抽象方法，那么这个实现类自己必须是抽象类

5. Java 8 接口中可以定义默认方法

   1. 格式

      ```java
      public default 返回值类型 方法名称(参数列表){
          // 方法体...
      }
      ```

   2. 使用场景

      * 接口当中的默认方法，可以解决接口升级的问题

   3. 如何使用

      * 通过接口实现类来使用
        * 接口的默认方法，可以通过接口实现类的对象直接调用
        * 接口的默认方法，可以被接口实现类进行覆盖重写

6. Java 8 接口中可以定义静态方法

   1. 格式

      ```java
      public static 返回值类型 方法名称(参数列表){
          // 方法体...
      }
      ```

   2. 使用场景

      * 只是和类相关，和对象无关

   3. 如何使用

      * **不能通过接口实现类来调用接口当中的静态方法**
      * 正确方法
        * 接口名称.静态方法名(参数);

7. Java 9 接口中允许定义私有方法

   1. 格式

      ```java
      private 返回值类型 方法名称(参数列表){
          // 方法体...
      }
      
      private static 返回值类型 方法名称(参数列表){
          // 方法体...
      }
      ```

   2. 场景

      * 解决接口中，默认方法重复代码的问题

   3. 使用

      * 直接定义私有，就可以直接调用

8. 接口当中可以定义"成员变量"-**常量**，但是必须使用`public static final` 三个关键字进行修饰。从效果上看就是接口的常量。

   * 格式

     > public static final 数据类型 常量名称 = 数据值;

   * 注意事项

     * 接口中的常量，可以省略public static final 。
     * 接口中的常量，必须进行赋值，不能不赋值。
     * 接口中的常量名称，使用完全大写的字母，用下划线进行分隔。

9. **接口小结**

   ```java
   /*
   在Java 9+版本中，接口的内容可以有：
   
   1. 成员变量其实是常量，格式：
   [public] [static] [final] 数据类型 常量名称 = 数据值;
   注意：
   	常量必须进行赋值，而且一旦赋值不能改变。
   	常量名称完全大写，用下划线进行分隔。
   
   2. 接口中最重要的就是抽象方法，格式：
   [public] [abstract] 返回值类型 方法名称(参数列表);
   注意：实现类必须覆盖重写接口所有的抽象方法，除非实现类是抽象类。
   
   3. 从Java 8开始，接口里允许定义默认方法，格式：
   [public] default 返回值类型 方法名称(参数列表) { 方法体 }
   注意：默认方法也可以被覆盖重写
   
   4. 从Java 8开始，接口里允许定义静态方法，格式：
   [public] static 返回值类型 方法名称(参数列表) { 方法体 }
   注意：应该通过接口名称进行调用，不能通过实现类对象调用接口静态方法
   
   5. 从Java 9开始，接口里允许定义私有很乏，格式：
   普通私有方法：private 返回值类型 方法名称(参数列表) { 方法体 }
   静态私有方法：private static 返回值类型 方法名称(参数列表) { 方法体 }
   注意：private的方法只有接口自己才能调用，不能被实现类或别人使用。
   */
   ```

10. **接口使用注意事项**

    ```java
    /*
    使用接口的时候，需要注意：
    
    1. 接口是没有静态代码块或者构造方法的。
    2. 一个类的直接父类是唯一的，但是一个类可以同时实现多个接口。
    格式：
    public class MyInterfaceImpl implements MyInterfaceA, MyInterfaceB {
        // 覆盖重写所有抽象方法
    }
    3. 如果实现类所实现的多个接口当中，存在重复的抽象方法，那么只需要覆盖重写一次即可。
    4. 如果实现类没有覆盖重写所有接口当中的所有抽象方法，那么实现类就必须是一个抽象类。
    5. 如果实现类所实现的多个接口当中，存在重复的默认方法，那么实现类一定要对冲突的默认方法进行覆盖重写。
    6. 一个类如果直接父类当中的方法，和接口当中的默认方法产生了冲突，优先用父类当中的方法。
     */
    ```

11. **类和接口的继承关系**

    ```java
    /*
    1. 类与类之间是单继承的。直接父类只有一个。
    2. 类与接口之间是多实现的。一个类可以实现多个接口。
    3. 接口与接口之间是多继承的。
    
    注意事项：
    1. 多个父接口当中的抽象方法如果重复，没关系。
    2. 多个父接口当中的默认方法如果重复，那么子接口必须进行默认方法的覆盖重写，【而且带着default关键字】。
     */
    ```

### 9.多态

1. 概念

   * 多态的前提-继承或者实现

     > extends 继承或者 implements 实现， 是多态的前提。
     >
     > 类与类之间的继承
     >
     > 类与接口之间的实现
     >
     > 接口与接口之间的实现

2. 多态的使用

   * 父类引用指向子类对象

   ```java
   /*
   代码当中体现多态性，其实就是一句话：父类引用指向子类对象。
   
   格式：
   父类名称 对象名 = new 子类名称();
   或者：
   接口名称 对象名 = new 实现类名称();
    */
   ```

3. **多态访问成员变量的两种方式**

   ```java
   /*
   访问成员变量的两种方式：
   
   1. 直接通过对象名称访问成员变量：看等号左边是谁，优先用谁，没有则向上找。
   2. 间接通过成员方法访问成员变量：看该方法属于谁，优先用谁，没有则向上找。
    */
   ```

4. **多态访问成员方法的两种方法**

   ```java
   /*
   在多态的代码当中，成员方法的访问规则是：
       看new的是谁，就优先用谁，没有则向上找。
   
   口诀：编译看左边，运行看右边。
   
   对比一下：
   成员变量：编译看左边，运行还看左边。
   成员方法：编译看左边，运行看右边。
    */
   ```

5. **对象的上下转型**

   ![05-对象的上下转型](.\images\05-对象的上下转型.png)
   * **向下转型，先判断类型**

     * instanceof

       ```java
       Animal animal = new Cat();
       Cat cat = (Cat) animal;
       if (cat instanceof Cat){
           // ...
       }
       ```

### 10.final关键字

1. final关键字代表最终、不可改变的

2. 常见的四种用法

   1. 可以用来修饰一个类
   2. 可以用来修饰一个方法
   3. 还可以用来修饰一个局部变量
   4. 还可以用来修饰一个成员变量

3. 用final修饰一个类

   1. 最终类，不能被继承

   2. 格式

      ```java
      public final class 类名称 {
          
          // ...
      
      }
      ```

   3. 注意

      * 当前这个类不能有任何的子类。（太监类）
      * 一个类如果是final的，那么其中所有的成员方法都无法进行覆盖重写（因为没儿子。）

4. 使用final修饰一个方法

   1. 当final关键字用来修饰一个方法的时候，这个方法就是最终方法，也就是不能被覆盖重写。

   2. 格式

      ```java
      修饰符 final 返回值类型 方法名称(参数列表) {
          // 方法体
      }
      ```

   3. 注意事项

      * 对于类、方法来说，abstract关键字和final关键字不能同时使用，因为矛盾。

5. 使用final关键字修饰一个局部变量

   1. 一旦使用final用来修饰局部变量，那么这个变量就不能进行更改。 “一次赋值，终生不变”

   2. 写法(直接赋值或者先定义后赋值)

      ```java
      package cn.itcast.day11.demo01;
      
      public class Demo01Final {
      
          public static void main(String[] args) {
              int num1 = 10;
              System.out.println(num1); // 10
              num1 = 20;
              System.out.println(num1); // 20
      
              // 一旦使用final用来修饰局部变量，那么这个变量就不能进行更改。
              // “一次赋值，终生不变”
              final int num2 = 200;
              System.out.println(num2); // 200
      
      //        num2 = 250; // 错误写法！不能改变！
      //        num2 = 200; // 错误写法！
      
              // 正确写法！只要保证有唯一一次赋值即可
              final int num3;
              num3 = 30;
      
              // 对于基本类型来说，不可变说的是变量当中的数据不可改变
              // 对于引用类型来说，不可变说的是变量当中的地址值不可改变
              Student stu1 = new Student("赵丽颖");
              System.out.println(stu1);
              System.out.println(stu1.getName()); // 赵丽颖
              stu1 = new Student("霍建华");
              System.out.println(stu1);
              System.out.println(stu1.getName()); // 霍建华
              System.out.println("===============");
      
              final Student stu2 = new Student("高圆圆");
              // 错误写法！final的引用类型变量，其中的地址不可改变
      //        stu2 = new Student("赵又廷");
              System.out.println(stu2.getName()); // 高圆圆
              stu2.setName("高圆圆圆圆圆圆");
              System.out.println(stu2.getName()); // 高圆圆圆圆圆圆
          }
      
      }
      
      ```

6. 使用final关键字修饰成员变量
   1. 对于成员变量来说，如果使用final关键字修饰，那么这个变量也照样是不可变。

      1. 由于成员变量具有默认值，所以用了**final之后必须手动赋值**，不会再给默认值了。
      2. 对于final的成员变量，**要么使用直接赋值**，要么通过**构造方法赋值**。二者选其一。
      3. **必须保证类当中所有重载的构造方法，都最终会对final的成员变量进行赋值。**

