# Android 性能优化总结

## 代码层面

> 通常来说，高效的代码需要满足下面两个规则：
> 1. 不要做冗余的动作
> 2. 如果能避免，尽量不要分配内存
  

+ 避免创建不必要的对象，避免在循环中创建对象避免创建不必要的对象
+ 慎用异常
+ 常量声明为`static final`
+ 避免内部的Getters/Setters
+ 使用优化过的数据结构,如`SparseArray`等
6. 代码重构
7. 算法优化
8. 静态优于抽象
9. 使用增强型for循环语法
10. 多使用系统封装好的API：如使用System.arraycopy()等一些封装好的库函数，它的效率是手动编写copy实现的9倍多
11. 复杂算法尽量使用C完成
12. 了解java四种引用方式
13. 使用`StringBuilder`拼接字符串
14. 如果你不需要访问一个对象的值域,请保证这个方法是static类型的,这样方法调用将快15%-20%

**tips:**代码的微优化有很多很多东西可以讲，小到一个变量的声明，大到一段算法。尤其在代码Review的过程中，可能会反复审查代码是否可以优化。不过我认为，代码的微优化是非常耗费时间的，**没有必要从头到尾将所有代码都优化一遍**。开发者应该根据具体的业务逻辑去专门针对某部分代码做优化。比如应用中可能有一些方法会被反复调用，那么这部分代码就值得**专门做优化**。其它的代码，需要开发者在写代码过程中去注意。

## UI层面
### ListView优化
1. 复用view
2. 使用`ViewHolder`模式,且最好是静态内部类（可参考[Android-Common-Adapter](https://github.com/fengjundev/Android-Common-Adapter):一个基于ViewHolder模式的封装库）
3. listview高度设置为`match_parent`
4. 涉及图片等加载的时候使用异步加载
5. 异步加载的时候引入线程池和线程队列
6. 分页加载
7. 图片进行缩放处理
8. 图片加载时引入三级缓存
9. 滑动不加载图片
**tips:**listview优化主要是把`getView`的耗时操作提取出来,进行提前加载或者异步加载

### 布局优化
1. 使用`include`复用布局
2. 使用`merge`优化布局层次
3. 设计时尽量减少布局层次
4. 使用`ViewStub`
5. 首次不需要可设为`gone`
6. 减少不必要的`inflate`
7. 尽量采用`RelativeLayout`
8. 多用`wrap_content``match_parent`
9. 使用9patch
10. 尽量为所有分辨率创建资源
 
### 其他
1. 使用[Compound Drawables](https://sriramramani.wordpress.com/2013/01/15/compound-drawables/)  
2. [TextView渲染性能的提升](http://www.open-open.com/lib/view/open1429845433994.html)  

## 内存优化
1. 图片内存优化
2. 不要过多依赖GC,多手动回收对象
3. 关闭资源对象

## 性能调优/内存优化
1. 同步改异步
2. 少用`Service`,尽量采用`IntentService`
3. 界面不可见时释放内存
4. `Bitmap`优化 
5. 单例模式
6. 缓存
	- 图片缓存
	- 线程池
	- View缓存
	- IO缓存
	- 消息缓存
	- Notification缓存

