package org.nounsys.nounservice.bussiness;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author:gaoxu
 * @create:2020-03-26 11:05
 **/
@Service
public class UserPayServiceStrategyFactory {

    private static Map<String, UserPayService> services = new ConcurrentHashMap<String, UserPayService>();

    public static UserPayService getByUserType(String type) {
        return services.get(type);
    }

    public static void register(String userType, UserPayService userPayService) {
        Assert.notNull(userType, "userType can't be null");
        services.put(userType, userPayService);
    }
}
