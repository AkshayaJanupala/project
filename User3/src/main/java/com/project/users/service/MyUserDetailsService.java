/*package com.project.users.service;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.project.users.entity.User;
import com.project.users.exception.UserNotFoundException;
import com.project.users.repository.IUserRepository;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
    private  IUserRepository userPsRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UserNotFoundException {
        Optional<User> opt=userPsRepository.findByUsername(username);
        if(opt.isEmpty()){
            throw new UserNotFoundException("user not found");
        }
        User ps=opt.get();
        
        
        org.springframework.security.core.userdetails.User user=new org.springframework.security.core.userdetails.User(ps.getUsername(),
        		ps.getPassword(),
        		ps.getRoles().stream().map(role->new SimpleGrantedAuthority(role)).collect(Collectors.toList()));
        return user;
        		
        		
    }
}*/
package com.project.users.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import com.project.users.entity.User;
import com.project.users.exception.UserNotFoundException;
import com.project.users.repository.IUserRepository;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(MyUserDetailsService.class);

    @Autowired
    private IUserRepository userPsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UserNotFoundException {
        logger.info("Attempting to load user by username: {}", username); // Log the attempt to load user

        Optional<User> opt = userPsRepository.findByUsername(username);
        
        if (opt.isEmpty()) {
            logger.error("User not found: {}", username); // Log when user is not found
            throw new UserNotFoundException("User not found");
        }
        
        User ps = opt.get();
        logger.info("User found: {}", ps.getUsername()); // Log when user is found
        
        org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(
                ps.getUsername(),
                ps.getPassword(),
                ps.getRoles().stream()
                        .map(role -> new SimpleGrantedAuthority(role))
                        .collect(Collectors.toList())
        );

        logger.info("User details loaded successfully for: {}", username); // Log successful loading of user details

        return user;
    }
}
