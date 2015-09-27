# 获取Message对象的优化


一般情况下，我们使用的是

```java
Message msg = new Message()
msg.what  = xxx;
msg.arg1  = xxx;
msg.arg2  = xxx;
handler.sendMessage(msg);
```


查看源码后发现,`obtainMessage()`的注释为


>Returns a new {@link android.os.Message Message} from the global message pool. More efficient than creating and allocating new instances. The retrieved message has its handler set to this instance (Message.target == this). If you don't want that facility, just call Message.obtain() instead.



> 从公共的消息池中返回一个Message对象，省去了申请内存的开销  
> 比重新创建一个新的Message对象更为高效  


  
  因此，以后开发中尽量采用
  
```java
Message msg = handler.obtainMessage();
msg.what  = xxx;
msg.arg1  = xxx;
msg.arg2  = xxx;
handler.sendMessage(msg);
```
