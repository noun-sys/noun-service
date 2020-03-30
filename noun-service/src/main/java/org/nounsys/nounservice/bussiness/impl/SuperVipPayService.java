package org.nounsys.nounservice.bussiness.impl;

import org.nounsys.nounservice.base.constant.UserPayServiceEnum;
import org.nounsys.nounservice.bussiness.UserPayService;
import org.nounsys.nounservice.bussiness.UserPayServiceStrategyFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author:gaoxu
 * @create:2020-03-26 11:03
 **/

@Service
public class SuperVipPayService implements UserPayService, InitializingBean {
    @Override
    public BigDecimal quote(BigDecimal orderPrice) {
        return new BigDecimal("8");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        UserPayServiceStrategyFactory.register(UserPayServiceEnum.SUPERVIP.getValue(), this);
    }
}
