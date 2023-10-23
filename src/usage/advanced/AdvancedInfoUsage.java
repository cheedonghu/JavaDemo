package usage.advanced;

import model.advanced.abstractinfo.SystemAHttpUtil;
import model.advanced.abstractinfo.SystemBHttpUtil;
import model.advanced.innerclass.ClassA;
import model.advanced.innerclass.ClassB;
import model.advanced.innerclass.Poke;
import model.advanced.interfaceinfo.CheckBillInterface;
import model.advanced.interfaceinfo.HostCheck;
import model.advanced.interfaceinfo.WalletCheck;

/**
 * 高级知识验证类
 *
 * @author: east
 * @date: 2023/10/23
 */

public class AdvancedInfoUsage {

    /**
     * 虚函数使用demo：模拟与对接系统进行Http交互时需要加签验签操作通过虚函数减少重复代码
     * <p>
     * 设计目的：减少重复代码
     */
    public void abstractDemoTest() {
        SystemAHttpUtil systemAHttpUtil = new SystemAHttpUtil();
        System.out.println(systemAHttpUtil.post("post to A"));

        SystemBHttpUtil systemBHttpUtil = new SystemBHttpUtil();
        System.out.println(systemBHttpUtil.post("post to B"));
    }

    /**
     * 测试接口使用：模拟多种核对方式情形，每种方式都需实现接口中的方法
     * <p>
     * 设计目的：简化重复代码
     */
    public void testInterfaceUsage() {
        CheckBillInterface hostCheck = new HostCheck();
        CheckBillInterface walletCheck = new WalletCheck();

        // 使用时根据核对类型获取接口
        hostCheck.preCheck();
        hostCheck.doCheck();
        hostCheck.doNotify();
        hostCheck.cancelCheck();

        walletCheck.preCheck();
        walletCheck.doCheck();
        walletCheck.doNotify();
        walletCheck.cancelCheck();
    }

    /**
     * 内部类和静态内部类
     * 一般用在POJO类中
     * 归纳某些不会复用的类。。。？ 这玩意是真抽象
     */
    public void testInnerClass() {
        Poke poke = new Poke();
//        Poke.Peach peach = new Poke.Peach().
//        Poke.Spade spade = new Poke.Spade();
    }

    /**
     * 类的加载顺序及其解释：主要涉及类的初始化
     * 1.父类的静态块。
     * 2.子类的静态块。
     * 3.父类的实例初始化块和构造方法。
     * 4.子类的实例初始化块和构造方法。
     */
    public void testLoadSequence() {
        ClassA ab = new ClassB();
        ab = new ClassB();
    }

    /**
     * test
     */
    public void test() {
        String s = "123";
    }

    public static void main(String[] args) {
        AdvancedInfoUsage advancedInfoUsage = new AdvancedInfoUsage();
        advancedInfoUsage.testLoadSequence();
    }
}
