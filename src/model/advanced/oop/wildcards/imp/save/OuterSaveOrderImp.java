package model.advanced.oop.wildcards.imp.save;


import model.advanced.oop.wildcards.imp.model.bo.OuterSavedInfo;
import model.advanced.oop.wildcards.interfac.SaveT;

/**
 * 外部渠道下单信息落表
 *
 * @author: east
 * @date: 2023/11/25
 */

public class OuterSaveOrderImp implements SaveT<OuterSavedInfo> {
    /**
     * 保存下单数据
     *
     * @param savedInfo 相关信息:账单表，统计表
     */
    @Override
    public void save(OuterSavedInfo savedInfo) {
        // 落表
        System.out.println("开始落表");
        System.out.println(savedInfo.toString());
    }
}
