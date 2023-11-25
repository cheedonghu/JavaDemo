package usage.advanced.oop.wildcards.imp;


import usage.advanced.oop.wildcards.imp.model.bo.InnerSavedInfo;
import usage.advanced.oop.wildcards.imp.model.req.InnerOrderRequest;
import usage.advanced.oop.wildcards.imp.save.InnerSaveOrder;
import usage.advanced.oop.wildcards.interfac.AbstractOrder;

import java.math.BigDecimal;

/**
 * 内部下单实现类
 *
 * @author: east
 * @date: 2023/11/24
 */
public class InnerOrder extends AbstractOrder<InnerOrderRequest> {

    public InnerOrder(InnerSaveOrder save) {
        super(save);
    }

    @Override
    public void order(InnerOrderRequest innerOrderRequest) {
        try {

            // 校验等逻辑....

            // 落表  这里save为模板方法
            save.save(new InnerSavedInfo(innerOrderRequest.generateOrderInfo(), "this is inner special message"));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        InnerSaveOrder innerSaveOrder = new InnerSaveOrder();
        InnerOrder innerOrder = new InnerOrder(innerSaveOrder);
        innerOrder.order(new InnerOrderRequest(BigDecimal.ONE, "innerSerial", "rcvNo"));
    }

}

