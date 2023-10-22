package base;

import model.DemoClassA;

/**
 * @description: java基本内容测试
 * @author: east
 * @date: 2023/10/22
 */

public class BaseTest {

    /**
     * 自动装箱和拆箱
     */
    public void testIntegerAndInt() {
        // 如果整型字面量的值在-128 到 127 之间，那么不会 new 新的 Integer对象，而是直接引用常量池中的 Integer 对象
        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
        System.out.println(f1 == f2);
        System.out.println(f3 == f4);
    }

    /**
     * 字符常量
     */
    public void testStringIntern() {
        String s1 = new StringBuilder("go")
                .append("od").toString();
        System.out.println(s1.intern() == s1);
        String s2 = new StringBuilder("ja")
                .append("va").toString();
        System.out.println(s2.intern() == s2);
    }

    /**
     * 位移运算
     */
    public void testWeiYiYunSuan() {
        // 左移n位等于乘以2的n次方
        System.out.println(5 * 8 == 5 << 3);
        // 右移n位等于除以2的n次方
        System.out.println(24 / 8 == 24 >> 3);
    }

    /**
     * 数组length属性
     */
    public void testArrayLength() {
        int[] array = new int[3];
        // 数组没有length()方法：数组类型在Java中是特殊的数据结构，其长度是作为公共属性存在的。
        System.out.println(array.length);

        // 数组类型在Java中是特殊的数据结构，其长度是作为公共属性存在的。
        String[] stringArray = new String[3];
        System.out.println(stringArray.length);
    }

    /**
     * equals与hashCode
     */
    public void testEquals() {
        String s = "123";
        String s2 = "123";
    }

    /**
     * 参数传递形式
     * 当你传递一个对象作为参数时，实际上是传递了该对象的引用的值。这个引用指向内存中的对象。所以，虽然传递的是引用的值，你仍然操作的是原始对象。
     * 但需要注意，如果在方法内部将参数引用指向新的对象，那么这将不会影响原始对象，因为在方法内部你只是改变了引用的值，而不是原始对象的值。
     * demoClassA是值；@2133c8f8是引用
     */
    public void testPassParam1() {
        DemoClassA demoClassA = new DemoClassA("str1");

        testPassParam2(demoClassA);

        System.out.println(demoClassA.getString());
    }

    public void testPassParam2(DemoClassA demoClassA) {
        System.out.println(demoClassA);

        demoClassA = new DemoClassA("str2");

        System.out.println(demoClassA);

        demoClassA.setString("str3");
    }


    /**
     * 字符串特性
     */
    public void testString() {
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s2));
        System.out.println(System.identityHashCode(s3));
        System.out.println(System.identityHashCode(s4));
        System.out.println(System.identityHashCode(s5));
        System.out.println(System.identityHashCode(s6));
        System.out.println(System.identityHashCode(s2.intern()));
        System.out.println(System.identityHashCode(s6.intern()));

        System.out.println(s1 == s2);
        System.out.println();
        System.out.println(s1 == s5);
        System.out.println(s1 == s6);
        System.out.println(s1 == s6.intern());
        System.out.println(s2 == s2.intern());
    }


    /**
     * test
     */
    public void test() {
        String s = "123";
        String s2 = "123";
    }

    public static void main(String[] args) {
        BaseTest baseTest = new BaseTest();
        baseTest.testString();
    }

}
