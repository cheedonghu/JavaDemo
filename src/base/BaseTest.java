package base;

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

    public static void main(String[] args) {
        BaseTest baseTest = new BaseTest();
        baseTest.testIntegerAndInt();
    }

}
