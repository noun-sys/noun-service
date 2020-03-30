package org.nounsys.nounservice.base.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.nounsys.nounservice.base.exception.BusinessException;
import org.nounsys.nounservice.base.exception.ErrorCodeEnum;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author:gaoxu
 * @create:2020-03-17 15:21
 **/
@Component
public class JwtUtils {

    /** 过期时间，缺省15分钟 */
    private long EXPIRE_TIME = 15 * 60 * 1000;

    /** token 私钥，缺省 galaxy-all */
    private String TOKEN_SECRET = "Galaxy-All";

    /** header */
    private Map<String, Object> header = new HashMap<>();

    /** 签名算法实例 */
    private Algorithm algorithm;

    /** token 认证器 */
    private JWTVerifier verifier;

    public JwtUtils() {
        JwtInit();
    }

    public JwtUtils(long expireTime, String tokenSecret) {
        this.EXPIRE_TIME = expireTime;
        this.TOKEN_SECRET = tokenSecret;
        JwtInit();
    }

    // 签名算法和认证器初始化
    private void JwtInit() {
        this.algorithm = Algorithm.HMAC256(this.TOKEN_SECRET);
        this.verifier = JWT.require(this.algorithm).build();
        this.header.put("typ", "JWT");
        this.header.put("alg", "HS256");
    }

    /**
     * 签名方法：采用 HMAC256算法，附带 claims 信息生成签名
     *
     * @param claims
     * @return
     */
    public String sign(Map<String, String> claims){
        // 计算 token 过期时间
        Date date = new Date(System.currentTimeMillis() + this.EXPIRE_TIME);

        try {
            JWTCreator.Builder jwt = JWT.create().withHeader(this.header).withExpiresAt(date);
            for (Map.Entry<String, String> entry : claims.entrySet()) {
                jwt.withClaim(entry.getKey(), entry.getValue());
            }

            return jwt.sign(this.algorithm);
        } catch (JWTCreationException exception) {
            exception.printStackTrace();
            throw new BusinessException(ErrorCodeEnum.SERVER_COMMON_ERROR);
        }
    }

    /**
     * 认证方法类
     * @param token
     * @return
     */
    public boolean verify(String token) {
        try {
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (JWTVerificationException exception) {
            return false;
        }
    }
}
