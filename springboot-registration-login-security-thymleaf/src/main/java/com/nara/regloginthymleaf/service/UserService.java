package com.nara.regloginthymleaf.service;

import com.nara.regloginthymleaf.model.User;
import com.nara.regloginthymleaf.web.dto.UserRegistrationDto;

public interface UserService {
    User save(UserRegistrationDto userRegistrationDto);

}
