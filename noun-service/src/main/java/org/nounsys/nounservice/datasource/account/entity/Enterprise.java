package org.nounsys.nounservice.datasource.account.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Enterprise {
    private Long id;

    private String fullName;

    private String licenceCode;

    private String businessLicenceAttachmentId;

    private String corpName;

    private String corpMobile;

    private String corpLicenceType;

    private String corpLicenceCode;

    private String corpLicenceFrontAttachmentId;

    private String corpLicenceBackAttachmentId;

    private String warrantAttachmentId;

    private String bankAccountCode;

    private String bankAcronym;

    private String bankProvince;

    private String bankCity;

    private String bankBranchName;

    private String status;

    private Date createdAt;

    private Date updatedAt;

    private String type;
}