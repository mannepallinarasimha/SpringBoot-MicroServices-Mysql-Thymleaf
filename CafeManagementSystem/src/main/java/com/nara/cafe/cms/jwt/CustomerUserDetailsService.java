package com.nara.cafe.cms.jwt;

import com.nara.cafe.cms.dao.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
@Slf4j
public class CustomerUserDetailsService implements UserDetailsService {

    @Autowired
    UserDao userDao;

    private com.nara.cafe.cms.model.User userDetails; //because User model is already available in Security Config Class
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("inside loadUserByUsername {}", username);
       userDetails = userDao.findByEmailId(username); //actually we are using email as username
       if(!Objects.isNull(userDetails)){
           return new User(userDetails.getEmail(), userDetails.getPassword(), new ArrayList<>());
       }else{
           throw new UsernameNotFoundException("User NOT found");
       }
    }

    public com.nara.cafe.cms.model.User getUserDetails(){

        //we do not need to expose password we can do below two lines or we can leave as it is. As of now i am leaving as it is
//        com.nara.cafe.cms.model.User user = userDetails;
//        user.setPassword(null);
        return userDetails;
    }
}
