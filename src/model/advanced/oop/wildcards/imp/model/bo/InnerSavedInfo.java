package model.advanced.oop.wildcards.imp.model.bo;


import model.advanced.oop.wildcards.interfac.model.bo.OrderInfo;
import model.advanced.oop.wildcards.interfac.model.bo.SavedInfo;

/**
 * 下单落表信息
 * 账单信息
 * 其他信息自行继承本类实现
 *
 * @author: east
 * @date: 2023/11/25
 */

public class InnerSavedInfo extends SavedInfo {


    public InnerSavedInfo(OrderInfo orderInfo) {
        super(orderInfo);
    }

    @Override
    public String toString() {
        return "InnerSavedInfo{" +
                "orderInfo=" + orderInfo +
                '}';
    }
}
