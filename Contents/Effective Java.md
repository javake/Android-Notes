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
继承打破了封装性






