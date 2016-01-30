package org.nishkarma.erp.order.repository;

import org.nishkarma.erp.order.model.TbTmpErpOrders;

public interface TbTmpErpOrdersMapper {
    int insert(TbTmpErpOrders record);
    int selectErpOrderID(int frontOrderId);
}