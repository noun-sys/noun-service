package org.nounsys.nounservice.datasource.account.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfo {
    private Long id;

    private Long userId;

    private String realName;

    private String idCard;

    private String bankCard;

    private String reservedMobile;

    private String idCardFrontAttachmentId;

    private String idCardBackAttachmentId;

    private Long enterpriseId;

    private Integer faceVerifyScore;

    private String status;

    private String identityInfoStatus;

    private String threeFactorVerifyStatus;

    private String fourFactorVerifyStatus;

    private String livingVerifyStatus;

    private Date createdAt;

    private Date updatedAt;
}