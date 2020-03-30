package org.nounsys.nounservice.bussiness.impl;

import org.nounsys.nounservice.base.constant.UserPayServiceEnum;
import org.nounsys.nounservice.bussiness.UserPayService;
import org.nounsys.nounservice.bussiness.UserPayServiceStrategyFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author:gaoxu
 * @create:2020-03-26 11:02
 **/

@Service
public class VipPayService implements UserPayService, InitializingBean {
    @Override
    public BigDecimal quote(BigDecimal orderPrice) {
        if (orderPrice.compareTo(new BigDecimal("100")) > 1) {
            return new BigDecimal("8");
        }
        return new BigDecimal("9");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        UserPayServiceStrategyFactory.register(UserPayServiceEnum.VIP.getValue(), this);
    }
}
