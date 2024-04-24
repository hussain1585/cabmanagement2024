package com.expatrio.cabmanagement.dto.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDTO {

    private String name;
    private String password;
    private String role;

    private AddressDTO address;
    private ContactDTO contact;
}
