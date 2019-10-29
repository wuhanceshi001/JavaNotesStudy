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

   