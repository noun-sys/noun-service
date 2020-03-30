package org.nounsys.nounservice.datasource.account.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Long id;

    private String username;

    private String displayName;

    private String mobile;

    private String email;

    private String password;

    private String type;

    private String uid;

    private String status;

    private Long masterId;

    private Boolean isApiAccess;

    private Boolean isConsoleAccess;

    private Boolean isNeedVerify;

    private String description;

    private Date createdAt;

    private Date updatedAt;
}