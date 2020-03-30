package org.nounsys.nounservice.bussiness;

import java.math.BigDecimal;

/**
 * @author:gaoxu
 * @create:2020-03-26 11:00
 **/
public interface UserPayService {
    /**
     * 计算应付价格
     */
    public BigDecimal quote(BigDecimal orderPrice);
}
