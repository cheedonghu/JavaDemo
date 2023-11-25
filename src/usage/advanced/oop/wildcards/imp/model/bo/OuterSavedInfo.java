package usage.advanced.oop.wildcards.imp.model.bo;


import usage.advanced.oop.wildcards.interfac.model.bo.OrderInfo;
import usage.advanced.oop.wildcards.interfac.model.bo.SavedInfo;

/**
 * 外部下单落表类
 *
 * @author: east
 * @date: 2023/11/25
 */

public class OuterSavedInfo extends SavedInfo {
    public OuterSavedInfo(OrderInfo orderInfo) {
        super(orderInfo);
    }
    // 外部渠道额外保存的表数据
}
