package com.xinlei.entity;

import lombok.Data;

@Data
public class User {
    private int id;
    private String groupNo;
    private Integer branchCode;
    private String approvalDate;
    private Integer approvalStatus;
    private String approver;
    private String groupNumber;
    private String groupNoDesc;
}
