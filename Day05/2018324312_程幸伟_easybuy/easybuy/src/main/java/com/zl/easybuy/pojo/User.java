package com.zl.easybuy.pojo;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String loginName;
    private String password;
    private Integer sex;
    private String userName;
    private String identityCode;
    private String email;
    private String mobile;
    private Integer type;
}
