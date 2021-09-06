package com.zl.easybuy.pojo;
//实体类的数据类型必须使用包装类

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class User {
    private  Integer id;
    private  String  loginName;
    private String password;
    private Integer sex;
    private String userName;
    private String identityCode;
    private String email;
    private String mobile;
    private Integer type;

    //alt+insert

}
