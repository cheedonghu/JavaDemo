package model.advanced.oop.wildcards.interfac;


import model.advanced.oop.wildcards.interfac.model.bo.SavedInfo;

/**
 * 保存下单相关信息, 模板类
 *
 * @author: east
 * @date: 2023/11/23
 */
public interface SaveT<T extends SavedInfo> {
    /**
     * 保存下单数据
     *
     * @param savedInfo 相关信息:账单表，统计表
     */
    public void save(T savedInfo);
}
