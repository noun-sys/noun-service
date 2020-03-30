package org.nounsys.nounservice.base.exception;

import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 *
 * @author gaoxu
 * @date 2019/07/04 18:54
 */
public enum ErrorCodeEnum {
    Exception("未知异常", -1),
    None("默认", 0),
    INVALID_PARAM("无效的参数", 100),
    PARAM_NULL_ERROR("参数为空", 101),
    BAD_REQUEST("输入参数错误", 400),
    UNAUTHORIZED_ERROR("用户未登录授权", 401),
    SERVER_COMMON_ERROR("服务器错误", 500),

    INVALID_GEETEST("无极验或极验失败", 10000),
    INVALID_MOBILE("无效的手机号", 10001),
    INVALID_EMAIL("无效的邮箱", 10002),
    INVALID_PASSWORD("无效的密码", 10003),
    INVALID_USERNAME_OR_PASSWORD("无效的用户名", 10004),
    INVALID_MOBILE_OR_EMAIL("无效的手机号或邮箱", 10004),

    INCORRECT_USERNAME("不正确的登录账号", 10010),
    INCORRECT_PASSWORD("不正确的登录密码", 10011),
    INCORRECT_USERNAME_OR_PASSWORD("不正确的登录账号或密码", 10012),
    SAME_PASSWORD_AND_RESET_PASSWORD("重置密码与原密码相同", 10013),
    LOGIN_FAIL_TIMES_BEYOND_LIMIT("登录失败次数过多，请稍后尝试", 10018),

    ACCOUNT_HAS_BEEN_DISABLED("该账号已被企业管理员禁用！", 10021),
    ACCOUNT_NOT_EXIST("账户不存在", 10023),
    ACCOUNT_TYPE_ERROR("账户类型错误", 10024),
    MASTER_ACCOUNT_NOT_EXIST("主账户不存在", 10025),
    SUB_ACCOUNT_IS_EXIST("子账户用户名不能重复", 10026),
    MASTER_AND_SUB_ACCOUNT_EMAIL_EXIST("企业账户及子账户邮箱不能重复", 10027),
    SUB_ACCOUNT_NOT_EXIST("子账户不存在", 10028),

    MOBILE_UNREGISTERED("该手机号未注册", 10030),
    EMAIL_UNREGISTERED("该邮箱未注册", 10031),
    SUB_ACCOUNT_IS_DELETE("账户已删除，不能更新状态", 10035),

    MOBILE_ALREADY_REGISTERED("该手机号已被注册", 10050),
    EMAIL_ALREADY_REGISTERED("该邮箱已被注册", 10051),
    ENTERPRISE_ALREADY_REGISTERED("该企业名称已被注册", 10052),
    USERNAME_ALREADY_REGISTERED("该用户名已被注册", 10053),
    USER_REGISTER_BUSY("当前用户注册忙,稍后再试", 10054),
    ENTERPRISE_INFO_CAN_NOT_NULL("静默注册当前企业用户企业信息不能为空", 10055),
    TENANT_CODE_INVALID("该租户编码无效", 10056),

    MOBILE_ALREADY_EXIST("该手机号已存在", 10060),
    EMAIL_ALREADY_EXIST("该邮箱已存在", 10061),
    ENTERPRISE_ALREADY_EXIST("该企业已存在", 10062),
    USERNAME_ALREADY_EXIST("该用户名已存在", 10063),
    ENTERPRISE_NOT_EXIST("该企业不存在", 10064),

    SESSION_EXPIRED("Session过期", 10071),
    INVALID_SESSION("Session无效", 10072),

    INVALID_EMAIL_ACTIVATION("无效的邮箱激活码", 10080),
    EMAIL_ALREADY_ACTIVATED("邮箱已激活", 10081),
    EMAIL_ACTIVATION_EXPIRED("邮箱激活码已失效", 10082),
    EMAIL_ACTIVATION_NOT_MATCH("待激活邮箱与激活链接邮箱不一致", 10083),
    RETRY_TIMES_OVER_LIMIT("激活邮箱重试次数超过限定值", 10084),

    EMAIL_EXISTING("邮件已存在", 10100),
    EMAIL_TEMPLATE_NOT_EXIST("邮件模板不存在", 10101),
    EMAIL_TEMPLATE_READ_EXCEPTION("邮件模板内容读取异常", 10102),
    EMAIL_TEMPLATE_BLANK("邮件模板内容为空", 10103),

    MOBILE_VERIFICATION_CODE_INTERVAL_ERROR("手机验证码发送间隔少于60秒", 10121),
    MOBILE_VERIFICATION_CODE_EXPIRED("手机验证码已过期", 10122),
    MOBILE_VERIFICATION_CODE_NOT_MATCH("手机验证码不匹配", 10123),
    MOBILE_VERIFICATION_DEST_NOT_MATCH("手机号不匹配", 10124),
    MOBILE_VERIFICATION_CODE_EXCEED_LIMIT("手机验证码操作太频繁", 10125),

    EMAIL_VERIFICATION_CODE_INTERVAL_ERROR("邮箱验证码发送间隔少于60秒", 10131),
    EMAIL_VERIFICATION_CODE_EXPIRED("邮箱验证码已过期", 10132),
    EMAIL_VERIFICATION_CODE_NOT_MATCH("邮箱验证码不匹配", 10133),
    EMAIL_VERIFICATION_DEST_NOT_MATCH("验证邮箱不匹配", 10134),
    EMAIL_VERIFICATION_CODE_EXCEED_LIMIT("邮箱验证码操作太频繁", 10135),

    CAN_NOT_MORE_THAN_TWO_ACCESS_KEY("已经存在两个有效的AccessKey,无法新建", 10200),

    ILLEGAL_TOKEN_CHARACTER("Token字符串不符合规则", 10300),
    TOKEN_HAS_EXPIRED("Token已过期", 10301),
    TOKEN_SIGNATURE_CHECK_ERROR("Token验证失败", 10302),

    //企业和个人认证相关

    VERIFICATION_NOT_VERIFIED("当前用户未授权认证", 20001),

    USER_VERIFICATION_NOT_USER("当前用户不是个人用户", 20101),
    USER_VERIFICATION_CANNOT_REPEAT_VERIFY("不能重复验证个人信息", 20102),
    USER_VERIFICATION_ID_CARD_EXISTED("该身份证信息已存在", 20103),
    USER_VERIFICATION_BANK_CARD_EXISTED("该银行卡信息已存在", 20104),
    USER_VERIFICATION_RESERVED_MOBILE_EXISTED("该预留手机号信息已存在", 20105),
    USER_VERIFICATION_CANNOT_UPDATE_ID_CARD_OCR_ON_CURRENT_STATUS("当前状态不能重新提交ocr", 20106),
    USER_VERIFICATION_ID_CARD_INFO_NOT_SET("当前用户未设置身份证信息", 20107),
    THREE_FACTOR_VALIDATION_FAIL("三要素验证失败", 20108),

    ENTERPRISE_VERIFICATION_NOT_ENTERPRISE("当前用户不是企业用户", 20201),
    ENTERPRISE_VERIFICATION_NOT_START_VERIFY("企业未开始认证", 20202),
    ENTERPRISE_VERIFICATION_CANNOT_VERIFY_ON_CURRENT_STATUS("当前状态不能认证企业信息", 20203),
    ENTERPRISE_VERIFICATION_CANNOT_MODIFY_ON_CURRENT_STATUS("当前状态下不能修改企业认证信息", 20204),
    ENTERPRISE_VERIFICATION_NEED_PROVIDE_LICENSE_OR_CORP_INFO("请补齐企业营业执照和法人信息后再提交认证", 20205),
    ENTERPRISE_VERIFICATION_MISS_CORP_LICENSE_BACK_ATTACHMENT("法人证件照片背面id不能为空", 20206),
    ENTERPRISE_VERIFICATION_CANNOT_PAY_VERIFY_ON_CURRENT_STATUS("当前状态不能进行打款金额认证", 20207),
    ENTERPRISE_VERIFICATION_CANNOT_REPAY_FOR_VERIFY_FAILED("认证已失败不能重新进行打款金额认证", 20208),
    ENTERPRISE_VERIFICATION_CANNOT_REPAY_FOR_VERIFY_SUCCESS("认证已成功不能重新进行打款金额认证", 20209),
    ENTERPRISE_VERIFICATION_CANNOT_REPAY_FOR_MAX_PAY_LIMIT("超出最多3次打款限制，账户已被锁定", 20210),
    ENTERPRISE_VERIFICATION_AMOUNT_FORMAT_INVALID("输入金额格式不正确", 20211),
    ENTERPRISE_VERIFICATION_LICENCE_CODE_EXISTED("社会信用代码号已存在", 20212),
    ENTERPRISE_VERIFICATION_BANK_ACCOUNT_CODE_EXISTED("企业银行账户号已存在", 20213),
    ENTERPRISE_VERIFICATION_BANK_ACCOUNT_STATUS_CANNOT_MODIFY_ON_CURRENT_STATUS("企业银行账状态在当前状态下不能修改", 20214),
    ENTERPRISE_VERIFICATION_TRUSTEE_IDENTITY_NOT_MATCH("受托人身份证信息不匹配", 20215),
    ENTERPRISE_VERIFICATION_LEGAL_IDENTITY_NOT_MATCH("法人身份证信息不匹配", 20216),
    ENTERPRISE_VERIFICATION_TWO_FACTOR_IDENTITY_EXCEED_LIMIT("提交信息次数过于频繁，系统已限制您再次提交信息，请在24小时后重新尝试。", 20217),
    ENTERPRISE_VERIFICATION_WARRANT_MISSING("请上传受托书", 20218),
    ENTERPRISE_VERIFICATION_ENTERPRISE_NOT_EXIST("企业账户不存在", 20219),

    VERIFICATION_CANNOT_DO_VIDEO_VERIFY_ON_CURRENT_STATUS("当前状态不能进行人脸识别检测", 20301),

    //合同相关
    CONTRACT_UPLOAD_ERROR("创建合同失败", 30001),
    CONTRACT_SIGN_INFO_ERROR("添加签约方信息失败", 30002),
    CONTRACT_SIGN_INVITATION_ERROR("发送合同邀请失败", 30003),
    CONTRACT_SIGNED_ERROR("签约合同失败", 30004),
    CONTRACT_REJECTED_ERROR("拒绝合同失败", 30005),
    CONTRACT_CENTER_INVOKE_ERROR("调用合约中心失败", 30006),
    CONTRACT_INFO_NULL("合同信息不存在", 30007),
    CONTRACT_EXPIRED_BEFORE("合同截止日期不能小于今天", 30101),
    CONTRACT_NAME_EXCEED("合同名称不能超过20个字符", 30102),
    CONTRACT_PARTY_INFO_NULL("合同必须要有签约方信息", 30201),
    CONTRACT_PARTY_AUTHORITY("当前用户无操作权限", 30202),
    CONTRACT_PARTY_INFO_DUPLICATE("签约方信息重复", 30203),
    CONTRACT_PARTY_INFO_MAX("签约方最多5个", 30204),
    CONTRACT_INVALID_OPERATION("当前用户非法操作", 30205),
    CONTRACT_PARTY_INFO_OPERATION("操作签约方失败", 30206),
    CONTRACT_PARTY_IDENTITY_DUPLICATE("操作方身份重复", 30207),
    GUARANTOR_OPERATION_ERROR("操作担保信息出错", 30301),
    CONTRACT_TEMPLATE_PARTY_TYPE_INFO_MAX("模板合同签约人类型超过添加最大值", 30302),

    THIRD_PARTY_MINSHI_ID_CARD_OCR_FRONT_END_INVALID("身份证正面照无效", 40001),
    THIRD_PARTY_MINSHI_ID_CARD_OCR_BACK_END_INVALID("身份证背面照无效", 40002),
    THIRD_PARTY_MINSHI_FETCH_VIDEO_VERIFY_CODE_FAIL("获取视频认证随机数失败", 40003),
    THIRD_PARTY_MINSHI_UPLOAD_VIDEO_FAIL("上传视频认证文件失败", 40004),
    THIRD_PARTY_MINSHI_FETCH_VIDEO_VERIFY_RESULT_FAIL("获取视频认证结果失败", 40005),

    THIRD_PARTY_WEIXIN_FETCH_ACCESS_TOKEN_FAIL("获取微信access token失败", 40101),
    THIRD_PARTY_WEIXIN_FETCH_MINI_PROGRAM_QR_FAIL("获取微信小程序二维码失败", 40102),
    THIRD_PARTY_WEIXIN_MINI_PROGRAM_AUTH_FAIL("微信小程序调用接口认证失败", 40103),

    //仲裁相关
    ARBITRATION_CASE_NOT_FOUND("未找到仲裁案件", 50001),
    ARBITRATION_CASE_CANNOT_SUBMIT_ON_CURRENT_STATUS("当前状态不能提交仲裁", 50002),
    ARBITRATION_CASE_CANNOT_WITHDRAW_ON_CURRENT_STATUS("当前状态不能取消提交仲裁", 50003),
    ARBITRATION_CASE_CANNOT_TRANSFER_ARBITRATION_ON_CURRENT_STATUS("当前状态不能移交仲裁", 50004),
    ARBITRATION_CASE_CANNOT_REVIEW_ON_CURRENT_STATUS("当前状态不能审核仲裁", 50005),
    ARBITRATION_CASE_CANNOT_WITHDRAW_ARBITRATION_ON_CURRENT_STATUS("当前状态不能撤销仲裁申请", 50006),

    NO_PERMISSION_VIEW_POLICY("无权限查看策略信息", 60001),
    NO_PERMISSION_VIEW_GROUP_INFO("无权限查看组信息", 60002),
    USER_GROUP_CREATOR_MUST_NOT_EMPTY("创建用户组用户uid不能为空", 60003),
    PERMISSION_CODE_HAS_EXIST("当前权限Code已经存在,不可重复", 60004),

    CAN_NOT_DELETE_STRATEGY_RELATED_USER("该策略已关联用户或用户组,不能删除", 70002),
    STRATEGY_CAN_NOT_REPUBLISH("策略已经发布无法重新发布", 70003),

    //管理员操作相关异常
    ADMIN_LOGIN_FAILED("管理员登录失败", 90101);

    private String errorMessage;

    private int errorCode;

    private static final Map<Integer, ErrorCodeEnum> map = new HashMap<>();
    private static final ResourceBundleMessageSource messageSource;
    private static final String SEP = "_";

    static {
        messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("i18n/messages");
        messageSource.setDefaultEncoding("UTF-8");

        for (ErrorCodeEnum error : ErrorCodeEnum.values()) {
            map.put(error.getErrorCode(), error);
        }
    }

    ErrorCodeEnum(String errorMessage, int errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public static ErrorCodeEnum getErrorEnumByErrorCode(int errorCode) {
        if (map.containsKey(errorCode)) {
            return map.get(errorCode);
        }
        return ErrorCodeEnum.SERVER_COMMON_ERROR;
    }
}
