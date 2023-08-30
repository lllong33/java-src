package org.example;

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * Hello world!
 *
 */
public class ReferenceTest
{
    public static void main( String[] args )
    {
        Object obj = new Object();
        // 弱引用
        WeakReference<Object> weakReference = new WeakReference<>(obj);
        System.out.println(obj);
        System.out.println(weakReference.get());
        obj = null;
        System.gc();
        System.out.println(obj);
        System.out.println(weakReference.get());
        // 软引用例子
        SoftReference<byte[]> softReference = new SoftReference<>(new byte[1024 * 1024 * 10]);
        System.out.println(softReference.get());
        System.gc();
        System.out.println(softReference.get()); // 直接内存不足时才会优先释放
        // 幻象引用
        PhantomReference<Object> phantomReference = new PhantomReference<>(new Object(), null);
        System.out.println(phantomReference.get());
    }
}
