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

### 11.权限修饰符

1. Java中有四种权限修饰符

   * public
   * protected
   * (default)
     * (default)并不是关键字“default”，而是根本不写。
   * private

2. 权限关系

   ```java
   /*
   Java中有四种权限修饰符：
                       public  >   protected   >   (default)   >   private
   同一个类(我自己)       YES         YES             YES             YES
   同一个包(我邻居)       YES         YES             YES             NO
   不同包子类(我儿子)     YES         YES             NO              NO
   不同包非子类(陌生人)    YES         NO              NO              NO
   */
   ```

### 12.内部类

1. 概念
   * 一个事物包含另一个事物，那么就是一个内部类包含另一个内部类
   * 例如身体和心脏，汽车和发动机的关系
2. 分类
   * 成员内部类
   * 局部内部类（包含匿名内部类）

3. 成员内部类的定义

   ```java
   public class Body { // 外部类
   
       public class Heart { // 成员内部类
   
           // 内部类的方法
           public void beat() {
               System.out.println("心脏跳动：蹦蹦蹦！");
               System.out.println("我叫：" + name); // 正确写法！
           }
   
       }
   
       // 外部类的成员变量
       private String name;
   
       // 外部类的方法
       public void methodBody() {
           System.out.println("外部类的方法");
           new Heart().beat();
       }
   
       public String getName() {
           return name;
       }
   
       public void setName(String name) {
           this.name = name;
       }
   }
   ```

4. 成员内部类的使用

   ```java
   /*
   如果一个事物的内部包含另一个事物，那么这就是一个类内部包含另一个类。
   例如：身体和心脏的关系。又如：汽车和发动机的关系。
   
   分类：
   1. 成员内部类
   2. 局部内部类（包含匿名内部类）
   
   成员内部类的定义格式：
   修饰符 class 外部类名称 {
       修饰符 class 内部类名称 {
           // ...
       }
       // ...
   }
   
   注意：内用外，随意访问；外用内，需要内部类对象。
   
   ==========================
   如何使用成员内部类？有两种方式：
   1. 间接方式：在外部类的方法当中，使用内部类；然后main只是调用外部类的方法。
   2. 直接方式，公式：
   类名称 对象名 = new 类名称();
   【外部类名称.内部类名称 对象名 = new 外部类名称().new 内部类名称();】
    */
   public class Demo01InnerClass {
   
       public static void main(String[] args) {
           Body body = new Body(); // 外部类的对象
           // 通过外部类的对象，调用外部类的方法，里面间接在使用内部类Heart
           body.methodBody();
           System.out.println("=====================");
   
           // 按照公式写：
           Body.Heart heart = new Body().new Heart();
           heart.beat();
       }
   
   }
   ```

5. 如何访问外部类的成员变量

   * 访问方式
     * 外部类名称.this.外部类成员变量名

   ```java
   // 如果出现了重名现象，那么格式是：外部类名称.this.外部类成员变量名
   public class Outer {
   
       int num = 10; // 外部类的成员变量
   
       public class Inner /*extends Object*/ {
   
           int num = 20; // 内部类的成员变量
   
           public void methodInner() {
               int num = 30; // 内部类方法的局部变量
               System.out.println(num); // 局部变量，就近原则
               System.out.println(this.num); // 内部类的成员变量
               System.out.println(Outer.this.num); // 外部类的成员变量
           }
   
       }
   
   }
   ```

6. 局部内部类和权限修饰符（外部类、成员内部类，局部内部类）

   ```java
   /*
   如果一个类是定义在一个方法内部的，那么这就是一个局部内部类。
   “局部”：只有当前所属的方法才能使用它，出了这个方法外面就不能用了。
   
   定义格式：
   修饰符 class 外部类名称 {
       修饰符 返回值类型 外部类方法名称(参数列表) {
           class 局部内部类名称 {
               // ...
           }
       }
   }
   
   小节一下类的权限修饰符：
   public > protected > (default) > private
   定义一个类的时候，权限修饰符规则：
   1. 外部类：public / (default)
   2. 成员内部类：public / protected / (default) / private
   3. 局部内部类：什么都不能写
    */
   class Outer {
   
       public void methodOuter() {
           class Inner { // 局部内部类
               int num = 10;
               public void methodInner() {
                   System.out.println(num); // 10
               }
           }
   
           Inner inner = new Inner();
           inner.methodInner();
       }
   
   }
   ```

7. 局部内部类访问局部变量，需要保证局部变量有效final的（Java1.8+）

   ```java
   /*
   局部内部类，如果希望访问所在方法的局部变量，那么这个局部变量必须是【有效final的】。
   
   备注：从Java 8+开始，只要局部变量事实不变，那么final关键字可以省略。
   
   原因：
   1. new出来的对象在堆内存当中。
   2. 局部变量是跟着方法走的，在栈内存当中。
   3. 方法运行结束之后，立刻出栈，局部变量就会立刻消失。
   4. 但是new出来的对象会在堆当中持续存在，直到垃圾回收消失。
    */
   public class MyOuter {
   
       public void methodOuter() {
           int num = 10; // 所在方法的局部变量
   
           class MyInner {
               public void methodInner() {
                   System.out.println(num);
               }
           }
       }
   
   }
   ```

8. 匿名内部类-匿名对象

   ```java
   /*
   如果接口的实现类（或者是父类的子类）只需要使用唯一的一次，
   那么这种情况下就可以省略掉该类的定义，而改为使用【匿名内部类】。
   
   匿名内部类的定义格式：
   接口名称 对象名 = new 接口名称() {
       // 覆盖重写所有抽象方法
   };
   
   对格式“new 接口名称() {...}”进行解析：
   1. new代表创建对象的动作
   2. 接口名称就是匿名内部类需要实现哪个接口
   3. {...}这才是匿名内部类的内容
   
   另外还要注意几点问题：
   1. 匿名内部类，在【创建对象】的时候，只能使用唯一一次。
   如果希望多次创建对象，而且类的内容一样的话，那么就需要使用单独定义的实现类了。
   2. 匿名对象，在【调用方法】的时候，只能调用唯一一次。
   如果希望同一个对象，调用多次方法，那么必须给对象起个名字。
   3. 匿名内部类是省略了【实现类/子类名称】，但是匿名对象是省略了【对象名称】
   强调：匿名内部类和匿名对象不是一回事！！！
    */
   public class DemoMain {
   
       public static void main(String[] args) {
   //        MyInterface obj = new MyInterfaceImpl();
   //        obj.method();
   
   //        MyInterface some = new MyInterface(); // 错误写法！
   
           // 使用匿名内部类，但不是匿名对象，对象名称就叫objA
           MyInterface objA = new MyInterface() {
               @Override
               public void method1() {
                   System.out.println("匿名内部类实现了方法！111-A");
               }
   
               @Override
               public void method2() {
                   System.out.println("匿名内部类实现了方法！222-A");
               }
           };
           objA.method1();
           objA.method2();
           System.out.println("=================");
   
           // 使用了匿名内部类，而且省略了对象名称，也是匿名对象
           new MyInterface() {
               @Override
               public void method1() {
                   System.out.println("匿名内部类实现了方法！111-B");
               }
   
               @Override
               public void method2() {
                   System.out.println("匿名内部类实现了方法！222-B");
               }
           }.method1();
           // 因为匿名对象无法调用第二次方法，所以需要再创建一个匿名内部类的匿名对象
           new MyInterface() {
               @Override
               public void method1() {
                   System.out.println("匿名内部类实现了方法！111-B");
               }
   
               @Override
               public void method2() {
                   System.out.println("匿名内部类实现了方法！222-B");
               }
           }.method2();
       }
   
   }
   ```

# 常用的API

### 1.日期Date类

1. 毫秒值
   * 时间原点
     * 1970年1月1日00:00:00（英国格林威治）
     * 毫秒值和日期之间的转换
   * 中国是东8区，要加8个小时的毫秒值（代码自动给加）
2. 构造方法
   1. Data()
      * 获取当前时间对象
   2. Date(long date)
      * 传递毫秒值，把毫秒值转换为Date日期
3. 成员方法
   1. getTime()
      * 获取当前**时间对象**的毫秒值
      * 和System.currentTimeMillis()方法是获取当前时间的毫秒值

### 2.DateFormat类和SimpleDateFormat

1. 功能介绍

   ```java
   /*
   java.text.DateFormat:是日期/时间格式化子类的抽象类
       作用:
           格式化（也就是日期 -> 文本）、解析（文本-> 日期）
       成员方法:
           String format(Date date)  按照指定的模式,把Date日期,格式化为符合模式的字符串
           Date parse(String source)  把符合模式的字符串,解析为Date日期
       DateFormat类是一个抽象类,无法直接创建对象使用,可以使用DateFormat类的子类
   
       java.text.SimpleDateFormat extends DateFormat
   
       构造方法:
           SimpleDateFormat(String pattern)
             用给定的模式和默认语言环境的日期格式符号构造 SimpleDateFormat。
           参数:
                String pattern:传递指定的模式
           模式:区分大小写的
               y   年
               M   月
               d   日
               H   时
               m   分
               s   秒
           写对应的模式,会把模式替换为对应的日期和时间
               "yyyy-MM-dd HH:mm:ss"
           注意:
               模式中的字母不能更改,连接模式的符号可以改变
                "yyyy年MM月dd日 HH时mm分ss秒"
   */
   ```

2. 功能使用

   ```java
   public class Demo01DateFormat {
       public static void main(String[] args) throws ParseException {
           demo02();
       }
   
       /*
            使用DateFormat类中的方法parse,把文本解析为日期
            使用步骤:
               1.创建SimpleDateFormat对象,构造方法中传递指定的模式
               2.调用SimpleDateFormat对象中的方法parse,把符合构造方法中模式的字符串,解析为Date日期
               注意:
                   public Date parse(String source) throws ParseException
                   parse方法声明了一个异常叫ParseException
                   如果字符串和构造方法的模式不一样,那么程序就会抛出此异常
                   调用一个抛出了异常的方法,就必须的处理这个异常,要么throws继续抛出这个异常,要么try catch自己处理
        */
       private static void demo02() throws ParseException {
           //1.创建SimpleDateFormat对象,构造方法中传递指定的模式
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
           //2.调用SimpleDateFormat对象中的方法parse,把符合构造方法中模式的字符串,解析为Date日期
           //Date parse(String source)  把符合模式的字符串,解析为Date日期
           Date date = sdf.parse("2088年08月08日 15时51分54秒");
           System.out.println(date);
       }
   
       /*
           使用DateFormat类中的方法format,把日期格式化为文本
           使用步骤:
               1.创建SimpleDateFormat对象,构造方法中传递指定的模式
               2.调用SimpleDateFormat对象中的方法format,按照构造方法中指定的模式,把Date日期格式化为符合模式的字符串(文本)
        */
       private static void demo01() {
           //1.创建SimpleDateFormat对象,构造方法中传递指定的模式
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
           //2.调用SimpleDateFormat对象中的方法format,按照构造方法中指定的模式,把Date日期格式化为符合模式的字符串(文本)
           //String format(Date date)  按照指定的模式,把Date日期,格式化为符合模式的字符串
           Date date = new Date();
           String d = sdf.format(date);
           System.out.println(date);//Sun Aug 08 15:51:54 CST 2088
           System.out.println(d);//2088年08月08日 15时51分54秒
       }
   }
   ```

### 3.Calendar类

* 使用

  ```java
  package com.itheima.demo04.Calendar;
  
  import java.util.Calendar;
  import java.util.Date;
  
  /*
      Calendar类的常用成员方法:
          public int get(int field)：返回给定日历字段的值。
          public void set(int field, int value)：将给定的日历字段设置为给定值。
          public abstract void add(int field, int amount)：根据日历的规则，为给定的日历字段添加或减去指定的时间量。
          public Date getTime()：返回一个表示此Calendar时间值（从历元到现在的毫秒偏移量）的Date对象。
      成员方法的参数:
          int field:日历类的字段,可以使用Calendar类的静态成员变量获取
              public static final int YEAR = 1;	年
              public static final int MONTH = 2;	月
              public static final int DATE = 5;	月中的某一天
              public static final int DAY_OF_MONTH = 5;月中的某一天
              public static final int HOUR = 10; 		时
              public static final int MINUTE = 12; 	分
              public static final int SECOND = 13;	秒
   */
  public class Demo02Calendar {
      public static void main(String[] args) {
          demo04();
      }
  
      /*
          public Date getTime()：返回一个表示此Calendar时间值（从历元到现在的毫秒偏移量）的Date对象。
          把日历对象,转换为日期对象
       */
      private static void demo04() {
          //使用getInstance方法获取Calendar对象
          Calendar c = Calendar.getInstance();
  
          Date date = c.getTime();
          System.out.println(date);
      }
  
      /*
          public abstract void add(int field, int amount)：根据日历的规则，为给定的日历字段添加或减去指定的时间量。
          把指定的字段增加/减少指定的值
          参数:
              int field:传递指定的日历字段(YEAR,MONTH...)
              int amount:增加/减少指定的值
                  正数:增加
                  负数:减少
       */
      private static void demo03() {
          //使用getInstance方法获取Calendar对象
          Calendar c = Calendar.getInstance();
  
          //把年增加2年
          c.add(Calendar.YEAR,2);
          //把月份减少3个月
          c.add(Calendar.MONTH,-3);
  
  
          int year = c.get(Calendar.YEAR);
          System.out.println(year);
  
          int month = c.get(Calendar.MONTH);
          System.out.println(month);//西方的月份0-11 东方:1-12
  
          //int date = c.get(Calendar.DAY_OF_MONTH);
          int date = c.get(Calendar.DATE);
          System.out.println(date);
      }
  
      /*
          public void set(int field, int value)：将给定的日历字段设置为给定值。
          参数:
              int field:传递指定的日历字段(YEAR,MONTH...)
              int value:给指定字段设置的值
       */
      private static void demo02() {
          //使用getInstance方法获取Calendar对象
          Calendar c = Calendar.getInstance();
  
          //设置年为9999
          c.set(Calendar.YEAR,9999);
          //设置月为9月
          c.set(Calendar.MONTH,9);
          //设置日9日
          c.set(Calendar.DATE,9);
  
          //同时设置年月日,可以使用set的重载方法
          c.set(8888,8,8);
  
          int year = c.get(Calendar.YEAR);
          System.out.println(year);
  
          int month = c.get(Calendar.MONTH);
          System.out.println(month);//西方的月份0-11 东方:1-12
  
          int date = c.get(Calendar.DATE);
          System.out.println(date);
      }
  
      /*
          public int get(int field)：返回给定日历字段的值。
          参数:传递指定的日历字段(YEAR,MONTH...)
          返回值:日历字段代表的具体的值
       */
      private static void demo01() {
          //使用getInstance方法获取Calendar对象
          Calendar c = Calendar.getInstance();
          int year = c.get(Calendar.YEAR);
          System.out.println(year);
  
          int month = c.get(Calendar.MONTH);
          System.out.println(month);//西方的月份0-11 东方:1-12
  
          //int date = c.get(Calendar.DAY_OF_MONTH);
          int date = c.get(Calendar.DATE);
          System.out.println(date);
      }
  }
  
  ```

### 4.System类

* 基本方法

  ```java
  /*
      java.lang.System类中提供了大量的静态方法，可以获取与系统相关的信息或系统级操作，在System类的API文档中，常用的方法有：
          public static long currentTimeMillis()：返回以毫秒为单位的当前时间。
          public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)：将数组中指定的数据拷贝到另一个数组中。
   */
  ```

* 案例

  ```java
  
  public class Demo01System {
      public static void main(String[] args) {
          demo02();
          StringBuilder sb = new StringBuilder();
      }
  
      /*
          public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)：将数组中指定的数据拷贝到另一个数组中。
          参数:
              src - 源数组。
              srcPos - 源数组中的起始位置(起始索引)。
              dest - 目标数组。
              destPos - 目标数据中的起始位置。
              length - 要复制的数组元素的数量。
          练习:
              将src数组中前3个元素，复制到dest数组的前3个位置上
                  复制元素前：
                  src数组元素[1,2,3,4,5]，dest数组元素[6,7,8,9,10]
                  复制元素后：
                  src数组元素[1,2,3,4,5]，dest数组元素[1,2,3,9,10]
       */
      private static void demo02() {
          //定义源数组
          int[] src = {1,2,3,4,5};
          //定义目标数组
          int[] dest = {6,7,8,9,10};
          System.out.println("复制前:"+ Arrays.toString(dest));
          //使用System类中的arraycopy把源数组的前3个元素复制到目标数组的前3个位置上
          System.arraycopy(src,0,dest,0,3);
          System.out.println("复制后:"+ Arrays.toString(dest));
      }
  
      /*
          public static long currentTimeMillis()：返回以毫秒为单位的当前时间。
          用来程序的效率
          验证for循环打印数字1-9999所需要使用的时间（毫秒）
       */
      private static void demo01() {
          //程序执行前,获取一次毫秒值
          long s = System.currentTimeMillis();
          //执行for循环
          for (int i = 1; i <=9999 ; i++) {
              System.out.println(i);
          }
          //程序执行后,获取一次毫秒值
          long e = System.currentTimeMillis();
          System.out.println("程序共耗时:"+(e-s)+"毫秒");//程序共耗时:106毫秒
      }
  }
  
  ```

### 5.StringBuilder类

1. 构造方法

   * StringBuilder()
   * StringBuilder(str)

2. 成员方法

   * StringBuilder的常用方法:

     > public StringBuilder append(...)：添加任意类型数据的字符串形式，并返回当前对象自身。
     >
     > public String toString()：将当前StringBuilder对象转换为String对象。

# 集合Collection

### 1.Collection

1. collection是一个抽象类，是List和Set的父类

2. Collection中公有的方法

   ```java
   /*
   java.util.Collection接口
           所有单列集合的最顶层的接口,里边定义了所有单列集合共性的方法
           任意的单列集合都可以使用Collection接口中的方法
   
   
       共性的方法:
         public boolean add(E e)：  把给定的对象添加到当前集合中 。
         public void clear() :清空集合中所有的元素。
         public boolean remove(E e): 把给定的对象在当前集合中删除。
         public boolean contains(E e): 判断当前集合中是否包含给定的对象。
         public boolean isEmpty(): 判断当前集合是否为空。
         public int size(): 返回集合中元素的个数。
         public Object[] toArray(): 把集合中的元素，存储到数组中。
   */
   ```

3. 迭代器的简单介绍

   ```java
   /*
   java.util.Iterator接口:迭代器(对集合进行遍历)
       有两个常用的方法
           boolean hasNext() 如果仍有元素可以迭代，则返回 true。
               判断集合中还有没有下一个元素,有就返回true,没有就返回false
           E next() 返回迭代的下一个元素。
               取出集合中的下一个元素
       Iterator迭代器,是一个接口,我们无法直接使用,需要使用Iterator接口的实现类对象,获取实现类的方式比较特殊
       Collection接口中有一个方法,叫iterator(),这个方法返回的就是迭代器的实现类对象
           Iterator<E> iterator() 返回在此 collection 的元素上进行迭代的迭代器。
   
       迭代器的使用步骤(重点):
           1.使用集合中的方法iterator()获取迭代器的实现类对象,使用Iterator接口接收(多态)
           2.使用Iterator接口中的方法hasNext判断还有没有下一个元素
           3.使用Iterator接口中的方法next取出集合中的下一个元素
   */
   ```

4. 增强for循环

   ```java
   /*
   增强for循环:底层使用的也是迭代器,使用for循环的格式,简化了迭代器的书写
       是JDK1.5之后出现的新特性
       Collection<E>extends Iterable<E>:所有的单列集合都可以使用增强for
       public interface Iterable<T>实现这个接口允许对象成为 "foreach" 语句的目标。
   
       增强for循环:用来遍历集合和数组
   
       格式:
           for(集合/数组的数据类型 变量名: 集合名/数组名){
               sout(变量名);
           }
   */
   ```

### 2.泛型

1. 泛型是指的未知类型，泛型是没有继承概念的

2. 使用泛型的好处

   ```java
   /*
   创建集合对象,使用泛型
           好处:
               1.避免了类型转换的麻烦,存储的是什么类型,取出的就是什么类型
               2.把运行期异常(代码运行之后会抛出的异常),提升到了编译期(写代码的时候会报错)
            弊端:
               泛型是什么类型,只能存储什么类型的数据
   */
   
   /*
   创建集合对象,不使用泛型
           好处:
               集合不使用泛型,默认的类型就是Object类型,可以存储任意类型的数据
           弊端:
               不安全,会引发异常
           多态不能访问子类特有的方法，需要强制转换，会发生异常
           编译看左边，使用子类特有的方法，编译都过不去
   */
   ```

2. 使用泛型-创建一个含有泛型的类

   ```java
   /*
       定义一个含有泛型的类,模拟ArrayList集合
       泛型是一个未知的数据类型,当我们不确定什么什么数据类型的时候,可以使用泛型
       泛型可以接收任意的数据类型,可以使用Integer,String,Student...
       创建对象的时候确定泛型的数据类型
    */
   public class GenericClass<E> {
       private E name;
   
       public E getName() {
           return name;
       }
   
       public void setName(E name) {
           this.name = name;
       }
   }
   
   // =================================================================
   
   public class Demo02GenericClass {
       public static void main(String[] args) {
           //不写泛型默认为Object类型
           GenericClass gc = new GenericClass();
           gc.setName("只能是字符串");
           Object obj = gc.getName();
   
           //创建GenericClass对象,泛型使用Integer类型
           GenericClass<Integer> gc2 = new GenericClass<>();
           gc2.setName(1);
   
           Integer name = gc2.getName();
           System.out.println(name);
   
           //创建GenericClass对象,泛型使用String类型
           GenericClass<String> gc3 = new GenericClass<>();
           gc3.setName("小明");
           String name1 = gc3.getName();
           System.out.println(name1);
       }
   }
   
   ```

3. 使用泛型-创建一个含有泛型的方法

   ```java
   /*
       定义含有泛型的方法:泛型定义在方法的修饰符和返回值类型之间
   
       格式:
           修饰符 <泛型> 返回值类型 方法名(参数列表(使用泛型)){
               方法体;
           }
   
       含有泛型的方法,在调用方法的时候确定泛型的数据类型
       传递什么类型的参数,泛型就是什么类型
    */
   public class GenericMethod {
       //定义一个含有泛型的方法
       public <M> void method01(M m){
           System.out.println(m);
       }
   
       //定义一个含有泛型的静态方法
       public static <S> void method02(S s){
           System.out.println(s);
       }
   }
   
   // =============================================================
   /*
       测试含有泛型的方法
    */
   public class Demo03GenericMethod {
       public static void main(String[] args) {
           //创建GenericMethod对象
           GenericMethod gm = new GenericMethod();
   
           /*
               调用含有泛型的方法method01
               传递什么类型,泛型就是什么类型
            */
           gm.method01(10);
           gm.method01("abc");
           gm.method01(8.8);
           gm.method01(true);
   
           gm.method02("静态方法,不建议创建对象使用");
   
           //静态方法,通过类名.方法名(参数)可以直接使用
           GenericMethod.method02("静态方法");
           GenericMethod.method02(1);
       }
   }
   
   
   ```

4. 使用泛型-接口

   ```java
   /*
       定义含有泛型的接口
    */
   public interface GenericInterface<I> {
       public abstract void method(I i);
   }
   
   // =========================================================
   
   /*
       含有泛型的接口,第一种使用方式:定义接口的实现类,实现接口,指定接口的泛型
       public interface Iterator<E> {
           E next();
       }
       Scanner类实现了Iterator接口,并指定接口的泛型为String,所以重写的next方法泛型默认就是String
       public final class Scanner implements Iterator<String>{
           public String next() {}
       }
    */
   public class GenericInterfaceImpl1 implements GenericInterface<String>{
       @Override
       public void method(String s) {
           System.out.println(s);
       }
   }
   
   // =========================================================
   
   /*
       含有泛型的接口第二种使用方式:接口使用什么泛型,实现类就使用什么泛型,类跟着接口走
       就相当于定义了一个含有泛型的类,创建对象的时候确定泛型的类型
       public interface List<E>{
           boolean add(E e);
           E get(int index);
       }
       public class ArrayList<E> implements List<E>{
           public boolean add(E e) {}
           public E get(int index) {}
       }
    */
   public class GenericInterfaceImpl2<I> implements GenericInterface<I> {
       @Override
       public void method(I i) {
           System.out.println(i);
       }
   }
   
   // =============================================================
   /*
       测试含有泛型的接口
    */
   public class Demo04GenericInterface {
       public static void main(String[] args) {
           //创建GenericInterfaceImpl1对象
           GenericInterfaceImpl1 gi1 = new GenericInterfaceImpl1();
           gi1.method("字符串");
   
           //创建GenericInterfaceImpl2对象
           GenericInterfaceImpl2<Integer> gi2 = new GenericInterfaceImpl2<>();
           gi2.method(10);
   
           GenericInterfaceImpl2<Double> gi3 = new GenericInterfaceImpl2<>();
           gi3.method(8.8);
       }
   }
   
   ```

5. 使用泛型-泛型通配符

   ```java
   import java.util.ArrayList;
   import java.util.Collection;
   
   /*
       泛型的上限限定: ? extends E  代表使用的泛型只能是E类型的子类/本身
       泛型的下限限定: ? super E    代表使用的泛型只能是E类型的父类/本身
    */
   public class Demo06Generic {
       public static void main(String[] args) {
           Collection<Integer> list1 = new ArrayList<Integer>();
           Collection<String> list2 = new ArrayList<String>();
           Collection<Number> list3 = new ArrayList<Number>();
           Collection<Object> list4 = new ArrayList<Object>();
   
           getElement1(list1);
           //getElement1(list2);//报错
           getElement1(list3);
           //getElement1(list4);//报错
   
           //getElement2(list1);//报错
           //getElement2(list2);//报错
           getElement2(list3);
           getElement2(list4);
   
           /*
               类与类之间的继承关系
               Integer extends Number extends Object
               String extends Object
            */
   
       }
       // 泛型的上限：此时的泛型?，必须是Number类型或者Number类型的子类
       public static void getElement1(Collection<? extends Number> coll){}
       // 泛型的下限：此时的泛型?，必须是Number类型或者Number类型的父类
       public static void getElement2(Collection<? super Number> coll){}
   }
   ```

### 3.数据结构

1. 栈
   * 先进后出
2. 队列
   * 先进先出
   * 查询比修改快
3. 链表
   * 单向链表和双向链表
   * 修改速度快
   * 查询速度慢
4. 二叉树
   * 查询速度超快

### 3 常见的数据结构

数据存储的常用结构有：栈、队列、数组、链表和红黑树。我们分别来了解一下：

#### 栈

- **栈**：**stack**,又称堆栈，它是运算受限的线性表，其限制是仅允许在标的一端进行插入和删除操作，不允许在其他任何位置进行添加、查找、删除等操作。

简单的说：采用该结构的集合，对元素的存取有如下的特点

- 先进后出（即，存进去的元素，要在后它后面的元素依次取出后，才能取出该元素）。例如，子弹压进弹夹，先压进去的子弹在下面，后压进去的子弹在上面，当开枪时，先弹出上面的子弹，然后才能弹出下面的子弹。

- 栈的入口、出口的都是栈的顶端位置。

  ![](F:/java%E4%B8%8B%E8%BD%BD/00.%E8%AE%B2%E4%B9%89+%E7%AC%94%E8%AE%B0+%E8%B5%84%E6%96%99/Java%E5%9F%BA%E7%A1%80/06.%E4%BC%9A%E5%91%98%E7%89%88(2.0)-%E5%B0%B1%E4%B8%9A%E8%AF%BE(2.0)-%E9%9B%86%E5%90%88/14.%E3%80%90List%E3%80%81Set%E3%80%91/14.%E3%80%90List%E3%80%81Set%E3%80%91-%E7%AC%94%E8%AE%B0/%E5%B0%B1%E4%B8%9A%E7%8F%AD-day03-List%E3%80%81Set%E3%80%81%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E3%80%81Collections/img/%E5%A0%86%E6%A0%88.png)

这里两个名词需要注意：

- **压栈**：就是存元素。即，把元素存储到栈的顶端位置，栈中已有元素依次向栈底方向移动一个位置。
- **弹栈**：就是取元素。即，把栈的顶端位置元素取出，栈中已有元素依次向栈顶方向移动一个位置。

#### 队列

- **队列**：**queue**,简称队，它同堆栈一样，也是一种运算受限的线性表，其限制是仅允许在表的一端进行插入，而在表的另一端进行删除。

简单的说，采用该结构的集合，对元素的存取有如下的特点：

- 先进先出（即，存进去的元素，要在后它前面的元素依次取出后，才能取出该元素）。例如，小火车过山洞，车头先进去，车尾后进去；车头先出来，车尾后出来。
- 队列的入口、出口各占一侧。例如，下图中的左侧为入口，右侧为出口。

![](F:/java%E4%B8%8B%E8%BD%BD/00.%E8%AE%B2%E4%B9%89+%E7%AC%94%E8%AE%B0+%E8%B5%84%E6%96%99/Java%E5%9F%BA%E7%A1%80/06.%E4%BC%9A%E5%91%98%E7%89%88(2.0)-%E5%B0%B1%E4%B8%9A%E8%AF%BE(2.0)-%E9%9B%86%E5%90%88/14.%E3%80%90List%E3%80%81Set%E3%80%91/14.%E3%80%90List%E3%80%81Set%E3%80%91-%E7%AC%94%E8%AE%B0/%E5%B0%B1%E4%B8%9A%E7%8F%AD-day03-List%E3%80%81Set%E3%80%81%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E3%80%81Collections/img/%E9%98%9F%E5%88%97%E5%9B%BE.bmp)

#### 数组

- **数组**:**Array**,是有序的元素序列，数组是在内存中开辟一段连续的空间，并在此空间存放元素。就像是一排出租屋，有100个房间，从001到100每个房间都有固定编号，通过编号就可以快速找到租房子的人。

简单的说,采用该结构的集合，对元素的存取有如下的特点：

- 查找元素快：通过索引，可以快速访问指定位置的元素

  ![](F:/java%E4%B8%8B%E8%BD%BD/00.%E8%AE%B2%E4%B9%89+%E7%AC%94%E8%AE%B0+%E8%B5%84%E6%96%99/Java%E5%9F%BA%E7%A1%80/06.%E4%BC%9A%E5%91%98%E7%89%88(2.0)-%E5%B0%B1%E4%B8%9A%E8%AF%BE(2.0)-%E9%9B%86%E5%90%88/14.%E3%80%90List%E3%80%81Set%E3%80%91/14.%E3%80%90List%E3%80%81Set%E3%80%91-%E7%AC%94%E8%AE%B0/%E5%B0%B1%E4%B8%9A%E7%8F%AD-day03-List%E3%80%81Set%E3%80%81%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E3%80%81Collections/img/%E6%95%B0%E7%BB%84%E6%9F%A5%E8%AF%A2%E5%BF%AB.png)

- 增删元素慢

  - **指定索引位置增加元素**：需要创建一个新数组，将指定新元素存储在指定索引位置，再把原数组元素根据索引，复制到新数组对应索引的位置。如下图![](F:/java%E4%B8%8B%E8%BD%BD/00.%E8%AE%B2%E4%B9%89+%E7%AC%94%E8%AE%B0+%E8%B5%84%E6%96%99/Java%E5%9F%BA%E7%A1%80/06.%E4%BC%9A%E5%91%98%E7%89%88(2.0)-%E5%B0%B1%E4%B8%9A%E8%AF%BE(2.0)-%E9%9B%86%E5%90%88/14.%E3%80%90List%E3%80%81Set%E3%80%91/14.%E3%80%90List%E3%80%81Set%E3%80%91-%E7%AC%94%E8%AE%B0/%E5%B0%B1%E4%B8%9A%E7%8F%AD-day03-List%E3%80%81Set%E3%80%81%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E3%80%81Collections/img/%E6%95%B0%E7%BB%84%E6%B7%BB%E5%8A%A0.png)
  - **指定索引位置删除元素：**需要创建一个新数组，把原数组元素根据索引，复制到新数组对应索引的位置，原数组中指定索引位置元素不复制到新数组中。如下图![](F:/java%E4%B8%8B%E8%BD%BD/00.%E8%AE%B2%E4%B9%89+%E7%AC%94%E8%AE%B0+%E8%B5%84%E6%96%99/Java%E5%9F%BA%E7%A1%80/06.%E4%BC%9A%E5%91%98%E7%89%88(2.0)-%E5%B0%B1%E4%B8%9A%E8%AF%BE(2.0)-%E9%9B%86%E5%90%88/14.%E3%80%90List%E3%80%81Set%E3%80%91/14.%E3%80%90List%E3%80%81Set%E3%80%91-%E7%AC%94%E8%AE%B0/%E5%B0%B1%E4%B8%9A%E7%8F%AD-day03-List%E3%80%81Set%E3%80%81%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E3%80%81Collections/img/%E6%95%B0%E7%BB%84%E5%88%A0%E9%99%A4.png)



#### 链表

- **链表**:**linked list**,由一系列结点node（链表中每一个元素称为结点）组成，结点可以在运行时i动态生成。每个结点包括两个部分：一个是存储数据元素的数据域，另一个是存储下一个结点地址的指针域。我们常说的链表结构有单向链表与双向链表，那么这里给大家介绍的是**单向链表**。

  ![](F:/java%E4%B8%8B%E8%BD%BD/00.%E8%AE%B2%E4%B9%89+%E7%AC%94%E8%AE%B0+%E8%B5%84%E6%96%99/Java%E5%9F%BA%E7%A1%80/06.%E4%BC%9A%E5%91%98%E7%89%88(2.0)-%E5%B0%B1%E4%B8%9A%E8%AF%BE(2.0)-%E9%9B%86%E5%90%88/14.%E3%80%90List%E3%80%81Set%E3%80%91/14.%E3%80%90List%E3%80%81Set%E3%80%91-%E7%AC%94%E8%AE%B0/%E5%B0%B1%E4%B8%9A%E7%8F%AD-day03-List%E3%80%81Set%E3%80%81%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E3%80%81Collections/img/%E5%8D%95%E9%93%BE%E8%A1%A8%E7%BB%93%E6%9E%84%E7%89%B9%E7%82%B9.png)

简单的说，采用该结构的集合，对元素的存取有如下的特点：

- 多个结点之间，通过地址进行连接。例如，多个人手拉手，每个人使用自己的右手拉住下个人的左手，依次类推，这样多个人就连在一起了。

  ![](F:/java%E4%B8%8B%E8%BD%BD/00.%E8%AE%B2%E4%B9%89+%E7%AC%94%E8%AE%B0+%E8%B5%84%E6%96%99/Java%E5%9F%BA%E7%A1%80/06.%E4%BC%9A%E5%91%98%E7%89%88(2.0)-%E5%B0%B1%E4%B8%9A%E8%AF%BE(2.0)-%E9%9B%86%E5%90%88/14.%E3%80%90List%E3%80%81Set%E3%80%91/14.%E3%80%90List%E3%80%81Set%E3%80%91-%E7%AC%94%E8%AE%B0/%E5%B0%B1%E4%B8%9A%E7%8F%AD-day03-List%E3%80%81Set%E3%80%81%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E3%80%81Collections/img/%E5%8D%95%E9%93%BE%E8%A1%A8%E7%BB%93%E6%9E%84.png)

- 查找元素慢：想查找某个元素，需要通过连接的节点，依次向后查找指定元素

- 增删元素快：

  - 增加元素：只需要修改连接下个元素的地址即可。

    ![](F:/java%E4%B8%8B%E8%BD%BD/00.%E8%AE%B2%E4%B9%89+%E7%AC%94%E8%AE%B0+%E8%B5%84%E6%96%99/Java%E5%9F%BA%E7%A1%80/06.%E4%BC%9A%E5%91%98%E7%89%88(2.0)-%E5%B0%B1%E4%B8%9A%E8%AF%BE(2.0)-%E9%9B%86%E5%90%88/14.%E3%80%90List%E3%80%81Set%E3%80%91/14.%E3%80%90List%E3%80%81Set%E3%80%91-%E7%AC%94%E8%AE%B0/%E5%B0%B1%E4%B8%9A%E7%8F%AD-day03-List%E3%80%81Set%E3%80%81%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E3%80%81Collections/img/%E5%A2%9E%E5%8A%A0%E7%BB%93%E7%82%B9.png)

  - 删除元素：只需要修改连接下个元素的地址即可。

    ![](F:/java%E4%B8%8B%E8%BD%BD/00.%E8%AE%B2%E4%B9%89+%E7%AC%94%E8%AE%B0+%E8%B5%84%E6%96%99/Java%E5%9F%BA%E7%A1%80/06.%E4%BC%9A%E5%91%98%E7%89%88(2.0)-%E5%B0%B1%E4%B8%9A%E8%AF%BE(2.0)-%E9%9B%86%E5%90%88/14.%E3%80%90List%E3%80%81Set%E3%80%91/14.%E3%80%90List%E3%80%81Set%E3%80%91-%E7%AC%94%E8%AE%B0/%E5%B0%B1%E4%B8%9A%E7%8F%AD-day03-List%E3%80%81Set%E3%80%81%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E3%80%81Collections/img/%E5%88%A0%E9%99%A4%E7%BB%93%E7%82%B9.bmp)

#### 红黑树

- **二叉树**：**binary tree** ,是每个结点不超过2的有序**树（tree）** 。

简单的理解，就是一种类似于我们生活中树的结构，只不过每个结点上都最多只能有两个子结点。

二叉树是每个节点最多有两个子树的树结构。顶上的叫根结点，两边被称作“左子树”和“右子树”。

如图：

![](F:/java%E4%B8%8B%E8%BD%BD/00.%E8%AE%B2%E4%B9%89+%E7%AC%94%E8%AE%B0+%E8%B5%84%E6%96%99/Java%E5%9F%BA%E7%A1%80/06.%E4%BC%9A%E5%91%98%E7%89%88(2.0)-%E5%B0%B1%E4%B8%9A%E8%AF%BE(2.0)-%E9%9B%86%E5%90%88/14.%E3%80%90List%E3%80%81Set%E3%80%91/14.%E3%80%90List%E3%80%81Set%E3%80%91-%E7%AC%94%E8%AE%B0/%E5%B0%B1%E4%B8%9A%E7%8F%AD-day03-List%E3%80%81Set%E3%80%81%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E3%80%81Collections/img/%E4%BA%8C%E5%8F%89%E6%A0%91.bmp)

我们要说的是二叉树的一种比较有意思的叫做**红黑树**，红黑树本身就是一颗二叉查找树，将节点插入后，该树仍然是一颗二叉查找树。也就意味着，树的键值仍然是有序的。

红黑树的约束:

1. 节点可以是红色的或者黑色的

2. 根节点是黑色的

3. 叶子节点(特指空节点)是黑色的
4. 每个红色节点的子节点都是黑色的
5. 任何一个节点到其每一个叶子节点的所有路径上黑色节点数相同

红黑树的特点:

​	速度特别快,趋近平衡树,查找叶子元素最少和最多次数不多于二倍

# List

### 1.ArrayList

* 底层是一个数组结构，查询快，增删慢

* java.util.List接口 extends Collection接口

*  List接口的特点:

  * 有序的集合,存储元素和取出元素的顺序是一致的(存储123 取出123)
  * 有索引,包含了一些带索引的方法
  * 允许存储重复的元素

      List接口中带索引的方法(特有)
          - public void add(int index, E element): 将指定的元素，添加到该集合中的指定位置上。
          - public E get(int index):返回集合中指定位置的元素。
          - public E remove(int index): 移除列表中指定位置的元素, 返回的是被移除的元素。
          - public E set(int index, E element):用指定元素替换集合中指定位置的元素,返回值的更新前的元素。
      注意:
          操作索引的时候,一定要防止索引越界异常
          IndexOutOfBoundsException:索引越界异常,集合会报
          ArrayIndexOutOfBoundsException:数组索引越界异常
          StringIndexOutOfBoundsException:字符串索引越界异常

```java

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
    java.util.List接口 extends Collection接口
    List接口的特点:
        1.有序的集合,存储元素和取出元素的顺序是一致的(存储123 取出123)
        2.有索引,包含了一些带索引的方法
        3.允许存储重复的元素

    List接口中带索引的方法(特有)
        - public void add(int index, E element): 将指定的元素，添加到该集合中的指定位置上。
        - public E get(int index):返回集合中指定位置的元素。
        - public E remove(int index): 移除列表中指定位置的元素, 返回的是被移除的元素。
        - public E set(int index, E element):用指定元素替换集合中指定位置的元素,返回值的更新前的元素。
    注意:
        操作索引的时候,一定要防止索引越界异常
        IndexOutOfBoundsException:索引越界异常,集合会报
        ArrayIndexOutOfBoundsException:数组索引越界异常
        StringIndexOutOfBoundsException:字符串索引越界异常
 */
public class Demo01List {
    public static void main(String[] args) {
        //创建一个List集合对象,多态
        List<String> list = new ArrayList<>();
        //使用add方法往集合中添加元素
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("a");
        //打印集合
        System.out.println(list);//[a, b, c, d, a]  不是地址重写了toString

        //public void add(int index, E element): 将指定的元素，添加到该集合中的指定位置上。
        //在c和d之间添加一个itheima
        list.add(3,"itheima");//[a, b, c, itheima, d, a]
        System.out.println(list);

        //public E remove(int index): 移除列表中指定位置的元素, 返回的是被移除的元素。
        //移除元素
        String removeE = list.remove(2);
        System.out.println("被移除的元素:"+removeE);//被移除的元素:c
        System.out.println(list);//[a, b, itheima, d, a]

        //public E set(int index, E element):用指定元素替换集合中指定位置的元素,返回值的更新前的元素。
        //把最后一个a,替换为A
        String setE = list.set(4, "A");
        System.out.println("被替换的元素:"+setE);//被替换的元素:a
        System.out.println(list);//[a, b, itheima, d, A]

        //List集合遍历有3种方式
        //使用普通的for循环
        for(int i=0; i<list.size(); i++){
            //public E get(int index):返回集合中指定位置的元素。
            String s = list.get(i);
            System.out.println(s);
        }
        System.out.println("-----------------");
        //使用迭代器
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String s = it.next();
            System.out.println(s);
        }
        System.out.println("-----------------");
        //使用增强for
        for (String s : list) {
            System.out.println(s);
        }

        String r = list.get(5);//IndexOutOfBoundsException: Index 5 out-of-bounds for length 5
        System.out.println(r);

    }
}
```

### 2.LinkedList

* java.util.LinkedList集合 implements List接口
* LinkedList集合的特点:
  * 底层是一个链表结构:查询慢,增删快
  * 里边包含了大量操作首尾元素的方法
  * 注意:使用LinkedList集合特有的方法,不能使用多态

```
    - public void addFirst(E e):将指定元素插入此列表的开头。
    - public void addLast(E e):将指定元素添加到此列表的结尾。
    - public void push(E e):将元素推入此列表所表示的堆栈。

    - public E getFirst():返回此列表的第一个元素。
    - public E getLast():返回此列表的最后一个元素。

    - public E removeFirst():移除并返回此列表的第一个元素。
    - public E removeLast():移除并返回此列表的最后一个元素。
    - public E pop():从此列表所表示的堆栈处弹出一个元素。

    - public boolean isEmpty()：如果列表不包含元素，则返回true。
```
```java
import java.util.LinkedList;

/*
    java.util.LinkedList集合 implements List接口
    LinkedList集合的特点:
        1.底层是一个链表结构:查询慢,增删快
        2.里边包含了大量操作首尾元素的方法
        注意:使用LinkedList集合特有的方法,不能使用多态

        - public void addFirst(E e):将指定元素插入此列表的开头。
        - public void addLast(E e):将指定元素添加到此列表的结尾。
        - public void push(E e):将元素推入此列表所表示的堆栈。

        - public E getFirst():返回此列表的第一个元素。
        - public E getLast():返回此列表的最后一个元素。

        - public E removeFirst():移除并返回此列表的第一个元素。
        - public E removeLast():移除并返回此列表的最后一个元素。
        - public E pop():从此列表所表示的堆栈处弹出一个元素。

        - public boolean isEmpty()：如果列表不包含元素，则返回true。

 */
public class Demo02LinkedList {
    public static void main(String[] args) {
        show03();
    }

    /*
        - public E removeFirst():移除并返回此列表的第一个元素。
        - public E removeLast():移除并返回此列表的最后一个元素。
        - public E pop():从此列表所表示的堆栈处弹出一个元素。此方法相当于 removeFirst
     */
    private static void show03() {
        //创建LinkedList集合对象
        LinkedList<String> linked = new LinkedList<>();
        //使用add方法往集合中添加元素
        linked.add("a");
        linked.add("b");
        linked.add("c");
        System.out.println(linked);//[a, b, c]

        //String first = linked.removeFirst();
        String first = linked.pop();
        System.out.println("被移除的第一个元素:"+first);
        String last = linked.removeLast();
        System.out.println("被移除的最后一个元素:"+last);
        System.out.println(linked);//[b]
    }

    /*
        - public E getFirst():返回此列表的第一个元素。
        - public E getLast():返回此列表的最后一个元素。
     */
    private static void show02() {
        //创建LinkedList集合对象
        LinkedList<String> linked = new LinkedList<>();
        //使用add方法往集合中添加元素
        linked.add("a");
        linked.add("b");
        linked.add("c");

        //linked.clear();//清空集合中的元素 在获取集合中的元素会抛出NoSuchElementException

        //public boolean isEmpty()：如果列表不包含元素，则返回true。
        if(!linked.isEmpty()){
            String first = linked.getFirst();
            System.out.println(first);//a
            String last = linked.getLast();
            System.out.println(last);//c
        }
    }

    /*
        - public void addFirst(E e):将指定元素插入此列表的开头。
        - public void addLast(E e):将指定元素添加到此列表的结尾。
        - public void push(E e):将元素推入此列表所表示的堆栈。此方法等效于 addFirst(E)。
     */
    private static void show01() {
        //创建LinkedList集合对象
        LinkedList<String> linked = new LinkedList<>();
        //使用add方法往集合中添加元素
        linked.add("a");
        linked.add("b");
        linked.add("c");
        System.out.println(linked);//[a, b, c]

        //public void addFirst(E e):将指定元素插入此列表的开头。
        //linked.addFirst("www");
        linked.push("www");
        System.out.println(linked);//[www, a, b, c]

        //public void addLast(E e):将指定元素添加到此列表的结尾。此方法等效于 add()
        linked.addLast("com");
        System.out.println(linked);//[www, a, b, c, com]
    }
}
```

# Set

1. java.util.Set接口 extends Collection接口
2.  Set接口的特点:
   - 不允许存储重复的元素
   - 没有索引,没有带索引的方法,也不能使用普通的for循环遍历

### 1.HashSet

1. java.util.HashSet集合 implements Set接口
2. **HashSet**特点:
   * 不允许存储重复的元素
   * 没有索引,没有带索引的方法,也不能使用普通的for循环遍历
   * 是一个无序的集合,存储元素和取出元素的顺序有可能不一致
   * 底层是一个哈希表结构(查询的速度非常的快

### 2.哈希值

1. 哈希值:是一个十进制的整数,由系统随机给出

   * 就是对象的地址值,是一个**逻辑地址**,是模拟出来得到地址,**不是数据实际存储的物理地址**

     ```java
     /*
     在Object类有一个方法,可以获取对象的哈希值
         int hashCode() 返回该对象的哈希码值。
         hashCode方法的源码:
             public native int hashCode();
             native:代表该方法调用的是本地操作系统的方法
     */
     ```

2. 重写Object类的hash值
3. 特殊
   * System.out.println("重地".hashCode());//1179395
   * System.out.println("通话".hashCode());//1179395

4. **自定义hashset元素类，重写hashcode和equals方法**

   ```java
   /*
   HashSet存储自定义类型元素
   
       set集合报错元素唯一:
           存储的元素(String,Integer,...Student,Person...),必须重写hashCode方法和equals方法
   
       要求:
           同名同年龄的人,视为同一个人,只能存储一次
   */
   ```

   ```java
   package com.Api.SetDemo;
   
   import java.util.Objects;
   
   public class Person {
       private String name;
       private int age;
   
       @Override
       public String toString() {
           return "Person{" +
                   "name='" + name + '\'' +
                   ", age=" + age +
                   '}';
       }
   
       public Person() {
       }
   
       public Person(String name, int age) {
           this.name = name;
           this.age = age;
       }
   
       @Override
       public boolean equals(Object o) {
           if (this == o) return true;
           if (o == null || getClass() != o.getClass()) return false;
           Person person = (Person) o;
           return age == person.age &&
                   Objects.equals(name, person.name);
       }
   
       @Override
       public int hashCode() {
   
           return Objects.hash(name, age);
       }
   }
   // ==================================================================
   
   import java.util.HashSet;
   
   public class HashDemo {
       public static void main(String[] args) {
           Person p1 = new Person("小明", 18);
           Person p2 = new Person("小明", 18);
           Person p3 = new Person("小宏", 18);
   
           HashSet<Person> peopleHashSet = new HashSet<>();
           peopleHashSet.add(p1);
           peopleHashSet.add(p2);
           peopleHashSet.add(p3);
   
           for (Person person : peopleHashSet) {
               System.out.println(person);
           }
       }
   }
   
   ```

3.**LinkedHashSet**

* 特点：
  * 底层是一个哈希表(数组+链表/红黑树)+链表:多了一条链表(记录元素的存储顺序),保证元素有序

### 3.可变参数

1. 可变参数的使用前提
   * 当方法的参数列表数据类型已经确定,但是参数的个数不确定,就可以使用可变参数.
2. 可变参数的使用
   * 修饰符 返回值类型 方法名(数据类型...变量名){}
3. 可变参数使用的原理
   1. 可变参数底层就是一个数组,根据传递参数个数不同,会创建不同长度的数组,来存储这些参数
   2. 传递的参数个数,可以是0个(不传递),1,2...多个
4. 可变参数的使用注意事项
   1. 一个方法的参数列表,只能有一个可变参数
   2. 如果方法的参数有多个,那么可变参数必须写在参数列表的末尾

```java
package com.itheima.demo04.VarArgs;
/*
    可变参数:是JDK1.5之后出现的新特性
    使用前提:
        当方法的参数列表数据类型已经确定,但是参数的个数不确定,就可以使用可变参数.
    使用格式:定义方法时使用
        修饰符 返回值类型 方法名(数据类型...变量名){}
    可变参数的原理:
        可变参数底层就是一个数组,根据传递参数个数不同,会创建不同长度的数组,来存储这些参数
        传递的参数个数,可以是0个(不传递),1,2...多个

 */
public class Demo01VarArgs {
    public static void main(String[] args) {
        //int i = add();
        //int i = add(10);
        int i = add(10,20);
        //int i = add(10,20,30,40,50,60,70,80,90,100);
        System.out.println(i);

        method("abc",5.5,10,1,2,3,4);
    }

    /*
        可变参数的注意事项
            1.一个方法的参数列表,只能有一个可变参数
            2.如果方法的参数有多个,那么可变参数必须写在参数列表的末尾
     */
    /*public static void method(int...a,String...b){

    }*/

    /*public static void method(String b,double c,int d,int...a){
    }*/

    //可变参数的特殊(终极)写法
    public static void method(Object...obj){

    }

    /*
        定义计算(0-n)整数和的方法
        已知:计算整数的和,数据类型已经确定int
        但是参数的个数不确定,不知道要计算几个整数的和,就可以使用可变参数
        add(); 就会创建一个长度为0的数组, new int[0]
        add(10); 就会创建一个长度为1的数组,存储传递来过的参数 new int[]{10};
        add(10,20); 就会创建一个长度为2的数组,存储传递来过的参数 new int[]{10,20};
        add(10,20,30,40,50,60,70,80,90,100); 就会创建一个长度为2的数组,存储传递来过的参数 new int[]{10,20,30,40,50,60,70,80,90,100};
     */
    public static int add(int...arr){
        //System.out.println(arr);//[I@2ac1fdc4 底层是一个数组
        //System.out.println(arr.length);//0,1,2,10
        //定义一个初始化的变量,记录累加求和
        int sum = 0;
        //遍历数组,获取数组中的每一个元素
        for (int i : arr) {
            //累加求和
            sum += i;
        }
        //把求和结果返回
        return sum;
    }

    //定义一个方法,计算三个int类型整数的和
    /*public static int add(int a,int b,int c){
        return a+b+c;
    }*/

    //定义一个方法,计算两个int类型整数的和
    /*public static int add(int a,int b){
        return a+b;
    }*/
}

```

### 4.Collections集合工具类

* java.utils.Collections 是集合工具类（不是Collection）

* 操作方法（静态）

  * 给集合添加一些元素

    ```java
    public static <T> boolean addAll(Collection<T> c, T...elements)
    ```

  * 打乱集合顺序

    ```java
    public static void shuffle(List<?> list)
    ```

  * 给集合中的元素排序1

    ```java
    public static <T> void sort(List<T> list)
    ```

    * 注意事项：
      * 被排序的集合里面存储的元素，必须实现Comparable，重写接口中的方法compareTo定义排序的规则
      * compareTo方法的返回值int类型，正数为大

  * 给集合中的元素排序2

    ```java
    public static <T> void sort(List<T> list, Comparator<? super T>)
    // Comparator是一个接口，可以使用匿名内部类
    /*
    Collections.sort(stuList, new Comparator<Student>() {
    		@Override
            public int compare(Student o1, Student o2) {
                int result = o1.getAge() - o2.getAge();
                if (result==0){
                   result = o1.getName().charAt(0) - o1.getName().charAt(0);
                }
                return result;
            }
        });*/
    ```

    * Comparable和Comparator的区别
      * Comparable：自己（this）和别人(参数)进行比较，自己需要实现Comparable接口，重写比较的规则comparaTo方法
      * Comparator：相当于找一个第三方的裁判，比较两个对象

# Map

### 1.Map集合

1. Map集合的特点
   1. Map集合是一个双列集合，一个元素包含两个值（一个key，一个value）
   2. Map集合中的元素，key和value的数据类型可以相同，也可以不同
   3. Map集合中的元素，key是不允许重复的，value是可以重复的
   4. Map集合中的元素，key和value是一一对应的

### 2.HashMap和LinkedHashMap集合

1. HashMap集合的特点
   1. java.util.HashMap<k, v>集合 implements Map<k, v> 接口
   2. HashMap集合底层是哈希表：查询的速度特别的快
      * JDK1.8之前：数组+单向链表
      * JDK1.8之后：数组+单向链表/红黑树（链表的长度超过8）：提高查询的速度
2. LinkedHashMap的特点
   1. java.util.LinkedHashMap<k, v> 集合 extends HashMap<k, v> 集合
   2. LinkedHashMap集合的额底层是哈希表+链表（保证迭代顺序）
   3. LinkedHashMap集合是一个有序的集合，存储元素和取出元素的顺序是一致的

### 3.Map基本方法

1.  添加/修改元素put

   ```java
   public V put(K key, V value)
   // 如果key不存在，返回null
   // 如果key存在，返回对应的value
   ```

2. 获取元素get

   ```java
   public V get(Object key)
   ```

3. 删除元素remove

   ```java
   public V remove(Object key)
   ```

4. 包含

   ```java
   boolean containsValue(Object value)
   ```

5. 获取Map的所有key

   ```java
   Set<K> keySet() // keySet方法获取Map中所有的key
   ```

   ```java
   
   
   import java.util.HashMap;
   import java.util.Set;
   
   
   public class MainDemo {
       public static void main(String[] args) {
           HashMap<String, Object> pp = new HashMap<>();
   
           pp.put("name", "小明");
           pp.put("age", 18);
           pp.put("height", 60.5);
   
           System.out.println(pp);
   
           // 遍历
           Set<String> keys = pp.keySet();
           for (String key : keys) {
               Object value = pp.get(key);
               System.out.println(value);
           }
   
   
       }
   }
   
   ```

6. 获取Map中多有的Entry对象，Entry对象封装了Map中的键值对
   1. 方法：
      *  Set<Map.Entry<K, V>>  entrySet()
   2. Entry对象提供操作键值对方法
      * K  getKey()
      * V  getValue()

7. HashMap存储自定义类型的键值
   1. HashMap存储自定义类型键值
   2. Map集合保证key是唯一的:
      * 作为key的元素,必须重写hashCode方法和equals方法,以保证key唯一
8. LinkedHashMap<K, V> extends HashMap<K, V>
   1. Map 接口的哈希表和链接表实现，具有可预知的迭代顺序
   2. 底层
      * 哈希表+链表（记录元素的顺序）

9. JDK1.9添加新特性--of方法

   * List接口,Set接口,Map接口:里边增加了一个静态的方法of,可以给集合一次性添加多个元素

   ```java
   package com.itheima.demo04.JDK9;
   
   import java.util.List;
   import java.util.Map;
   import java.util.Set;
   
   /*
       JDK9的新特性:
           List接口,Set接口,Map接口:里边增加了一个静态的方法of,可以给集合一次性添加多个元素
           static <E> List<E> of.(E... elements)
           使用前提:
               当集合中存储的元素的个数已经确定了,不在改变时使用
        注意:
           1.of方法只适用于List接口,Set接口,Map接口,不适用于接接口的实现类
           2.of方法的返回值是一个不能改变的集合,集合不能再使用add,put方法添加元素,会抛出异常
           3.Set接口和Map接口在调用of方法的时候,不能有重复的元素,否则会抛出异常
    */
   public class Demo01JDK9 {
       public static void main(String[] args) {
           List<String> list = List.of("a", "b", "a", "c", "d");
           System.out.println(list);//[a, b, a, c, d]
           //list.add("w");//UnsupportedOperationException:不支持操作异常
   
           //Set<String> set = Set.of("a", "b", "a", "c", "d");//IllegalArgumentException:非法参数异常,有重复的元素
           Set<String> set = Set.of("a", "b", "c", "d");
           System.out.println(set);
           //set.add("w");//UnsupportedOperationException:不支持操作异常
   
           //Map<String, Integer> map = Map.of("张三", 18, "李四", 19, "王五", 20,"张三",19);////IllegalArgumentException:非法参数异常,有重复的元素
           Map<String, Integer> map = Map.of("张三", 18, "李四", 19, "王五", 20);
           System.out.println(map);//{王五=20, 李四=19, 张三=18}
           //map.put("赵四",30);//UnsupportedOperationException:不支持操作异常
       }
   }
   
   ```

   