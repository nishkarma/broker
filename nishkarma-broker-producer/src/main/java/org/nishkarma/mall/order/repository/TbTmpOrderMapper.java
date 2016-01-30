package org.nishkarma.mall.order.repository;

import org.nishkarma.mall.order.model.TbTmpOrder;

public interface TbTmpOrderMapper {

    int insert(TbTmpOrder tbTmpOrder);
    TbTmpOrder selectByPrimaryKey(Integer ordId);

}