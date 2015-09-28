# Effective Java

`Java`

## 使用静态工厂方法代替构造器
- 有名称，易于理解和阅读
- 不必再每次调用的时候都创建一个新对象
- 可以返回原返回类型的任何值类型对象
- 创建参数化类型示例的对象的时候，它们使代码更加简单



## 遇到多个构造器参数时要考虑使用构造器
可用于参数过多的时候（四个或者更多）
使用`Builder`模式

```java
public class Product{
	private final int a;
	// 以下为可选
	private final int b;
	private final int c;
	private final int d;
	
	public static class Builder{
		private int a = 0;
		
		private int b = 0;
		private int c = 0;
		private int d = 0;
		
		public Builder(int a){
			this.a = a;
		}
		
		public Builder setB(int b){
			this.b = b;
			return this;
		}
		
		public Builder setC(int c){
			this.c = c;
			return this;
		}
		
		public Builder setD(int d){
			this.d = d;
			return this;
		}
		
		public Product build(){
			return new Product(this);
		}
		
		private Product(Builder builder){
			a = builder.a;
			.....
		}
		
	}
}

```

## 通过私有构造器强化不可实例化的能力
例如，有些工具类是不希望实例化的

```java
public final class AppUtils{
	private AppUtils(){
		throw new AssertionError();
	}
	
	public static getVersionCode(Context context){
		...
	}
}
```

## 避免创建不必要的对象
- 不要使用下列语句：`String s = new String("hello world");`，该语句执行的时候都会创建一个新的String实例
- 要优先使用基本类型而不是装箱基本类型
- 可复用的对象尽量复用

## 消除过期的对象引用
- 警惕内存泄露
- 内存泄露的另一个来源是缓存
- 第三个来源是监听器和其他回调

##  覆盖`equals`请遵守通用约定
- 自反性
- 对称性
- 传递性
- 一致性

高质量euals方法的诀窍
1. 使用==操作符检查**参数是否为这个对象的引用**
2. 使用instanceof检查参数是否为正确的类型，否则返回false
3. 对于类中的每个关键域，检查参数中的域是否与该对象中对应的相等

## 覆盖equals时总要覆盖hasCode

## 始终要覆盖toString

## 使类和成员的可访问性最小化
- 尽可能的使每个类或者成员不被外界访问

## 在公有类中使用访问方法
- 但是可以在包级私有或者私有的嵌套类中直接暴露它的数据域
- 类的内部避免使用getter和setter

## 使类可变性最小化的方法
- 不提供任何会修改对象状态的方法
- 保证类不会被拓展（final）
- 使所有的域是final的
- 使所有的域都成为私有的
- 如果类具有指向可变对象的域，则必须确保该类的客户端无法获得指向这些对象的引用

## 复合优于继承
在包的内部使用继承是安全的，因为属于同一个程序员控制
考虑使用装饰模式
继承打破了封装性，要么为继承而设计，并提供文档说明，要么就禁止继承

## 接口优于抽象类
- 现有的类可以很容易的更新，以实现新的接口
- 接口是定义混合类型的理想选择（混合类型： 类除了实现它的基本自身行为之外，还可以实现某些可供选择的类型，如`Comparable`）
- 实现多继承
- 定义骨架

##　接口只用于定义类型
接口应该只用来定义类型，不应该被用来导出常量
常量接口模式是对接口的**不良使用**

```java
	public interface PhysicalConstant {
		
		static final double MAX_VALUE = 100;
		
		static final double ELECTRON_MASS = 0.124;
	}
```
如果要导出常量：
- 枚举类型
- 不可实例化的工具类

工具类通常要求客户端使用类名来描述常量名，如
`Constant.MAX_EAT_COUNT`
如果大量使用工具类导出的常量，可以通过利用`静态导入机制`避免用类名来修饰常量名（JAVA1.5及以上）

```java
import static com.effectivejava.Constant.*;

public class Test {
	void getMaxCount(){
		return MAX_EAT_COUNT;
	}
}
```

## 类层次优于标签类

##　用函数对象表示策略

##　优先考虑使用静态成员类
非静态成员类的每个实例都会隐含着与外围类的一个外围实例相关联，会有引起内存泄露的风险
如果声明成员类不要求访问外围实例，就要始终使用static

## 不要在新代码中使用原生态类型
如果使用像`List`这样的原生态类型，就会丢掉类型安全性
但是如果使用`List<Object>`这样的参数化类型就不会

## 消除非受检警告
指的是unchecked cast warnings以及unchecked conversion warnings
尽可能消除所有警告
若无法消除，但是可以证实是安全的，可以使用`@suppressWarnings("unchecked")`注解来禁止这条警告

## 优先考虑泛型方法
如工具类












