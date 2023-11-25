package usage.advanced.oop.wildcards.interfac;


import usage.advanced.oop.wildcards.interfac.model.bo.SavedInfo;
import usage.advanced.oop.wildcards.interfac.model.req.OrderRequest;

/**
 * 模板类接口作为成员变量，未通过模板指定接口类型
 *
 * @author: east
 * @date: 2023/11/24
 */
public abstract class AbstractOrderT<T extends OrderRequest<?>> {

    // 不通过模板指定，仅用通配符参数限定，
    protected SaveT<? extends SavedInfo> save; // note 如果实现类中不指定SaveT的类型，则save接口无法使用

    public AbstractOrderT(SaveT<? extends SavedInfo> save) {
        this.save = save;
    }


    /**
     * 下单
     */
    public abstract void order(T orderRequest);
}
