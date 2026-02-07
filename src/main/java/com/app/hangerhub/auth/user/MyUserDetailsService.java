package com.app.hangerhub.auth.user;

import com.app.hangerhub.common.config.UserPrinciples;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//? UserDetailsService user to load the current user in the system
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

//    1. Declare the static final logger using SLF4J's LoggerFactory
//    private static final Logger log = LoggerFactory.getLogger(RestaurantService.class);
//    log.info("Attempting to update menu for Restaurant ID: {}", restaurantId);

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       User user = userRepository.findByEmail(email);

       if(user == null){
           System.out.println("User Not Found ");
           throw new UsernameNotFoundException("User Not Found");
       }
        return new UserPrinciples(user);
    }
}
