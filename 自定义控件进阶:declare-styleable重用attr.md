如下：
当两个重复的`declare-styleable`存在重复的属性声明时，以下写法可进一步优化
```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>

    <declare-styleable name="ExTextView">
       <attr name="enableOnPad" format="boolean" />
     <attr name="supportDeviceType" format="reference"/>
    </declare-styleable>

    <declare-styleable name="ExEditText">
       <attr name="enableOnPad" format="boolean" />
     <attr name="supportDeviceType" format="reference"/>  
    </declare-styleable>
</resources>
```

优化为：(即已声明过的`attr`直接调用即可)
```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
  <attr name="enableOnPad" format="boolean" />
  <attr name="supportDeviceType" format="reference"/>

    <declare-styleable name="ExTextView">
        <attr name="enableOnPad"/>
        <attr name="supportDeviceType"/>
    </declare-styleable>

    <declare-styleable name="ExEditText">
        <attr name="enableOnPad"/>
      <attr name="supportDeviceType"/>
    </declare-styleable>
</resources>
```
