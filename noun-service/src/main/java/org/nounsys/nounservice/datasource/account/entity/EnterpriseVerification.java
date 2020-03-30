package org.nounsys.nounservice.datasource.account.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class EnterpriseVerification {
    private Long id;

    private Long enterpriseId;

    private String verifyProcess;

    private String enterpriseInfoVerifyStatus;

    private String bankAccountVerifyStatus;

    private Long transactionRecordId;

    private String transactionRecordHistoryIds;

    private BigDecimal receivedAmount;

    private Integer failedTimes;

    private Integer payTimes;

    private Date createdAt;

    private Date updatedAt;

    private Date submittedAt;

    private Date reviewedAt;

    private String reviewedOperator;
}