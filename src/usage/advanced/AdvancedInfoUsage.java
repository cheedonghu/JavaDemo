package usage.advanced;

import model.advanced.abstractinfo.SystemAHttpUtil;
import model.advanced.abstractinfo.SystemBHttpUtil;
import model.advanced.concurrent.async.ClassExtendThread;
import model.advanced.concurrent.async.ClassImpCallable;
import model.advanced.concurrent.async.ClassImpRunnable;
import model.advanced.concurrent.sync.ClassWithSynchronized;
import model.advanced.innerclass.ClassA;
import model.advanced.innerclass.ClassB;
import model.advanced.innerclass.Poke;
import model.advanced.interfaceinfo.CheckBillInterface;
import model.advanced.interfaceinfo.HostCheck;
import model.advanced.interfaceinfo.WalletCheck;
import model.base.CommonClassA;

import java.util.concurrent.CompletableFuture;

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
     * synchronized相关使用特性，可直接在方法前修饰，也可以在代码块内声明对象
     * note: 实际拿的对象锁！
     */
    public void testSynchronizedFun() {
        ClassWithSynchronized classWithSynchronized = new ClassWithSynchronized();
        Thread threadA = new Thread(classWithSynchronized::funcA);
        Thread threadB = new Thread(classWithSynchronized::funcB);
        threadB.start();
        threadA.start();

//        ClassWithSynchronized classWithSynchronized2 = new ClassWithSynchronized();
//        ClassWithSynchronized classWithSynchronized3 = new ClassWithSynchronized();
//        Thread threadC = new Thread(classWithSynchronized3::funcA);
//        Thread threadD = new Thread(classWithSynchronized2::funcB);
//        threadC.start();
//        threadD.start();

    }


    /**
     * 多线程的几种实现方式
     * 1. extend thread
     * 2. implement callable
     * 3. implement runnable
     * 4. CompletableFuture
     * <p>
     * 目的: 抢占更多cpu时间片, 重复逻辑并行处理减小 io密集型的不必要开销
     */
    public void testAsnyc() {
        ClassExtendThread classExtendThread = new ClassExtendThread();
        ClassImpCallable classImpCallable = new ClassImpCallable();
        ClassImpRunnable classImpRunnable = new ClassImpRunnable();
        CompletableFuture<CommonClassA> demoClassACompletableFuture = new CompletableFuture<>();

        // 1.继承thread方式开启另一个线程 主线程和子线程顺序未知
//        classExtendThread.start();

        // 2.实现runnable方式开启另一个线程 主线程和子线程顺序未知
//        Thread thread = new Thread(classImpRunnable);
//        thread.start();

        // 3. 实现callable方式开启另一线程 . 主子线程顺序未知
//        FutureTask<Object> futureTask = new FutureTask<>(classImpCallable);
//        Thread thread = new Thread(futureTask);
////        Thread thread = new Thread(classImpRunnable);  //此方法跑一半主函数可能会退出
//        thread.start();

        // 4. 通过completableFuture.runAsync开启新线程.  不加join()函数则顺序未知,加入后等待新线程全部执行
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            // set MDC Info 这里还可以设置日志打印信息防止新线程日志杂乱
            CommonClassA.commonFun();
        });
        // 等所有future执行完毕
//        CompletableFuture.allOf(voidCompletableFuture).join();

        for (int i = 0; i < 10; i++) {
//            System.out.println("Main thread "+i);
            System.out.println("Main Thread Id : " + Thread.currentThread().getId() + " times : " + i);
        }
    }

    /**
     * test
     */
    public void test() {
        String s = "123";
    }

    public static void main(String[] args) {
        AdvancedInfoUsage advancedInfoUsage = new AdvancedInfoUsage();
        advancedInfoUsage.testAsnyc();
    }
}
