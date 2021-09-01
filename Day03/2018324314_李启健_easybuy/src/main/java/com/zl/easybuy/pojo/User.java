package com.zl.easybuy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class User {
    private Integer id;
    private String loginName;
    private String userName;
    private String password;
    private Integer sex;
    private String identityCode;
    private String email;
    private String mobile;
    private Integer type;

}
