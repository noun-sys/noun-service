package org.nounsys.nounservice.base.constant;

/**
 * @author:gaoxu
 * @create:2020-03-26 10:59
 **/
public enum UserPayServiceEnum {
    VIP(1, "Vip"),

    SUPERVIP(2, "SuperVip"),

    PARTICULALYVIP(3, "ParticularlyVip"),

    NORMAL(4, "NormalPayService");

    /**
     * 状态值
     */
    private int code;

    /**
     * 类型描述
     */
    private String value;

    private UserPayServiceEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public static UserPayServiceEnum valueOf(int code) {
        for (UserPayServiceEnum type : UserPayServiceEnum.values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(UserPayServiceEnum.VIP.getValue());
    }
}
