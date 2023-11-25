package model.advanced.oop.wildcards.imp.save;


import model.advanced.oop.wildcards.interfac.Save;
import model.advanced.oop.wildcards.interfac.model.bo.SavedInfo;

/**
 * 内部渠道保存账单
 *
 * @author: east
 * @date: 2023/11/24
 */
public class InnerSaveOrder implements Save {

    /**
     * 保存下单数据
     *
     * @param savedInfo 相关信息:账单表，统计表
     */
    @Override
    public <T extends SavedInfo> void save(T savedInfo) {
        // 落表
        System.out.println("开始落表");
        System.out.println(savedInfo.toString());
    }
}
