package org.nishkarma.mall.order.repository;

import org.nishkarma.mall.order.model.TbTmpOrder;

public interface TbTmpOrderMapper {
	 TbTmpOrder selectByPrimaryKey(Long ordId);
    int updateByPrimaryKey(TbTmpOrder record);
}