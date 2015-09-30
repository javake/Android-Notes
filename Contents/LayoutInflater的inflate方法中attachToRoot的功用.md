[Layout Inflation as intented](https://possiblemobile.com/2013/05/layout-inflation-as-intended/)

我们在ListView的Adapter的`getView()`方法里面经常会调用两个参数的inflate方法，
```java
mInflater.inflate(R.layout.adv_viewpager, null)
```

我们可能会发现item layout外层的layout_width  layout_height属性都没起作用，全都变成wrap_content的值了。 

这个问题就是因为我们使用了错误的参数照成的，系统在inflate layout的时候 如果传入的root为空的话 就会忽略LayoutParams.

```java
/**
     * Inflate a new view hierarchy from the specified xml resource. Throws
     * {@link InflateException} if there is an error.
     * 
     * @param resource ID for an XML layout resource to load (e.g.,
     *        <code>R.layout.main_page</code>)
     * @param root Optional view to be the parent of the generated hierarchy (if
     *        <em>attachToRoot</em> is true), or else simply an object that
     *        provides a set of LayoutParams values for root of the returned
     *        hierarchy (if <em>attachToRoot</em> is false.)
     * @param attachToRoot Whether the inflated hierarchy should be attached to
     *        the root parameter? If false, root is only used to create the
     *        correct subclass of LayoutParams for the root view in the XML.
     * @return The root View of the inflated hierarchy. If root was supplied and
     *         attachToRoot is true, this is root; otherwise it is the root of
     *         the inflated XML file.
     */
    public View inflate(int resource, ViewGroup root, boolean attachToRoot) {
        if (DEBUG) System.out.println("INFLATING from resource: " + resource);
        XmlResourceParser parser = getContext().getResources().getLayout(resource);
        try {
            return inflate(parser, root, attachToRoot);
        } finally {
            parser.close();
        }
    }
```



所以在getView里面应该调用
mInflater.inflate(R.layout.adv_viewpager, root, false)


这样在R.layout.adv_viewpager layout xml文件里面所有关于Layout的属性就都能生效。

那么attachToRoot是什么作用呢？ 他会自动把layout加到View hierarchy中， 
不需要手动调用root.addView，当然在Adapter.getView里面不用手动调用root.addView是因为Adapter已经帮我们做了， 
所以如果我们在Adapter.getView里面传入attachToRoot为true的话，就会报错， 因为一个view不能attach两次。
