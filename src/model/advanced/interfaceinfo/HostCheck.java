package model.advanced.interfaceinfo;

/**
 * 流水对账
 *
 * @author: east
 * @date: 2023/10/23
 */

public class HostCheck implements CheckBillInterface {
    @Override
    public void preCheck() {
        System.out.println("I will do host check pre check");
    }

    @Override
    public void doCheck() {
        System.out.println("I will do host check");
    }

    @Override
    public void doNotify() {
        System.out.println("I will notify other system after check");
    }

    @Override
    public void cancelCheck() {
        System.out.println("I will cancel this check");
    }

}
