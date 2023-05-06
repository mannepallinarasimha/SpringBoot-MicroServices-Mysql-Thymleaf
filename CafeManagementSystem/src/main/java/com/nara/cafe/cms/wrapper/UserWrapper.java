package com.nara.cafe.cms.wrapper;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserWrapper {
    private Integer id;
    private String name;
    private String email;
    private String status;
    private String contactNumber;

    public UserWrapper(Integer id, String name, String email, String status, String contactNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.status = status;
        this.contactNumber = contactNumber;
    }
}
