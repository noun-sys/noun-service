package org.nounsys.nounservice.datasource.contract.entity;

import java.util.Date;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }

    public String getLicenceCode() {
        return licenceCode;
    }

    public void setLicenceCode(String licenceCode) {
        this.licenceCode = licenceCode == null ? null : licenceCode.trim();
    }

    public String getBusinessLicenceAttachmentId() {
        return businessLicenceAttachmentId;
    }

    public void setBusinessLicenceAttachmentId(String businessLicenceAttachmentId) {
        this.businessLicenceAttachmentId = businessLicenceAttachmentId == null ? null : businessLicenceAttachmentId.trim();
    }

    public String getCorpName() {
        return corpName;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName == null ? null : corpName.trim();
    }

    public String getCorpMobile() {
        return corpMobile;
    }

    public void setCorpMobile(String corpMobile) {
        this.corpMobile = corpMobile == null ? null : corpMobile.trim();
    }

    public String getCorpLicenceType() {
        return corpLicenceType;
    }

    public void setCorpLicenceType(String corpLicenceType) {
        this.corpLicenceType = corpLicenceType == null ? null : corpLicenceType.trim();
    }

    public String getCorpLicenceCode() {
        return corpLicenceCode;
    }

    public void setCorpLicenceCode(String corpLicenceCode) {
        this.corpLicenceCode = corpLicenceCode == null ? null : corpLicenceCode.trim();
    }

    public String getCorpLicenceFrontAttachmentId() {
        return corpLicenceFrontAttachmentId;
    }

    public void setCorpLicenceFrontAttachmentId(String corpLicenceFrontAttachmentId) {
        this.corpLicenceFrontAttachmentId = corpLicenceFrontAttachmentId == null ? null : corpLicenceFrontAttachmentId.trim();
    }

    public String getCorpLicenceBackAttachmentId() {
        return corpLicenceBackAttachmentId;
    }

    public void setCorpLicenceBackAttachmentId(String corpLicenceBackAttachmentId) {
        this.corpLicenceBackAttachmentId = corpLicenceBackAttachmentId == null ? null : corpLicenceBackAttachmentId.trim();
    }

    public String getWarrantAttachmentId() {
        return warrantAttachmentId;
    }

    public void setWarrantAttachmentId(String warrantAttachmentId) {
        this.warrantAttachmentId = warrantAttachmentId == null ? null : warrantAttachmentId.trim();
    }

    public String getBankAccountCode() {
        return bankAccountCode;
    }

    public void setBankAccountCode(String bankAccountCode) {
        this.bankAccountCode = bankAccountCode == null ? null : bankAccountCode.trim();
    }

    public String getBankAcronym() {
        return bankAcronym;
    }

    public void setBankAcronym(String bankAcronym) {
        this.bankAcronym = bankAcronym == null ? null : bankAcronym.trim();
    }

    public String getBankProvince() {
        return bankProvince;
    }

    public void setBankProvince(String bankProvince) {
        this.bankProvince = bankProvince == null ? null : bankProvince.trim();
    }

    public String getBankCity() {
        return bankCity;
    }

    public void setBankCity(String bankCity) {
        this.bankCity = bankCity == null ? null : bankCity.trim();
    }

    public String getBankBranchName() {
        return bankBranchName;
    }

    public void setBankBranchName(String bankBranchName) {
        this.bankBranchName = bankBranchName == null ? null : bankBranchName.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}