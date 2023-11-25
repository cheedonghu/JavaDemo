package usage.advanced.oop.wildcards.imp.save;


import usage.advanced.oop.wildcards.interfac.Save;
import usage.advanced.oop.wildcards.interfac.model.bo.SavedInfo;

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
//        InnerSavedInfo innerSavedInfo=(InnerSavedInfo) savedInfo;
        // 落表
        System.out.println("内部渠道下单信息开始落表");
//        System.out.println("内部渠道特有数据获取: "+innerSavedInfo.getSpecialMsg());
        // todo 这里有个很大的问题就是如果不通过强制类型转换无法拿到特定种类的数据
        System.out.println(savedInfo.toString());
    }
}
