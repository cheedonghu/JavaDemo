package usage.advanced.oop.wildcards.imp;

import usage.advanced.oop.wildcards.imp.model.bo.OuterSavedInfo;
import usage.advanced.oop.wildcards.imp.model.req.OuterOrderRequest;
import usage.advanced.oop.wildcards.imp.save.OuterSaveOrderImp;
import usage.advanced.oop.wildcards.interfac.AbstractOrderTR;

import java.math.BigDecimal;

/**
 * 内部下单实现类
 *
 * @author: east
 * @date: 2023/11/24
 */
public class OuterOrderTR extends AbstractOrderTR<OuterOrderRequest, OuterSavedInfo> {

    public OuterOrderTR(OuterSaveOrderImp save) {
        super(save);
    }

    @Override
    public void order(OuterOrderRequest outerOrderRequest) {
        try {

            // 校验等逻辑....

            // 落表
            // note 这里通过模板类全量指定
            save.save(new OuterSavedInfo(outerOrderRequest.generateOrderInfo()));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        OuterSaveOrderImp saveOrderAction = new OuterSaveOrderImp();
        OuterOrderTR orderAction = new OuterOrderTR(saveOrderAction);
        orderAction.order(new OuterOrderRequest(BigDecimal.ONE, "outSerialTR", "rcvNo"));
    }

}

