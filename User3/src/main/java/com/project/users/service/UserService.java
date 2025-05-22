/*package com.project.users.service;



import java.util.List;


import com.project.users.dto.LoginRequest;
import com.project.users.dto.UserDto;
import com.project.users.exception.UserNotFoundException;








public interface UserService {
	UserDto addUser(UserDto userDto);
    UserDto validateUser(UserDto userDto) throws UserNotFoundException;
    UserDto updateUser(UserDto userDto) throws UserNotFoundException;
    UserDto updateUserPassword(Long userId, String newPassword) throws UserNotFoundException;
    UserDto removeUser(Long userId) throws UserNotFoundException;
	String deleteUser(Long userId) throws UserNotFoundException;
	List<UserDto> viewUser();
	UserDto viewUser(Long userId) throws UserNotFoundException;
	String login(LoginRequest loginRequest);
	
	
	
	
//	List<UserDto> getUsersByRole(String roles);
}*/
package com.project.users.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import com.project.users.dto.LoginRequest;
import com.project.users.dto.UserDto;
import com.project.users.exception.UserNotFoundException;

public interface UserService {
    
    Logger logger = LoggerFactory.getLogger(UserService.class);

    default UserDto addUser(UserDto userDto) {
        logger.info("Adding user: {}", userDto); // Log user addition
        return null;
    }

  /*  default UserDto validateUser(UserDto userDto) throws UserNotFoundException {
        logger.info("Validating user: {}", userDto.getUsername()); // Log user validation
        return null;
    }*/

    default UserDto updateUser(UserDto userDto) throws UserNotFoundException {
        logger.info("Updating user: {}", userDto.getUsername()); // Log user update
        return null;
    }

    default UserDto updateUserPassword(Long userId, String newPassword) throws UserNotFoundException {
        logger.info("Updating password for userId: {}", userId); // Log password update
        return null;
    }

    default UserDto removeUser(Long userId) throws UserNotFoundException {
        logger.info("Removing user with ID: {}", userId); // Log user removal
        return null;
    }

    default String deleteUser(Long userId) throws UserNotFoundException {
        logger.info("Deleting user with ID: {}", userId); // Log user deletion
        return null;
    }

    default List<UserDto> viewUser() {
        logger.info("Fetching all users."); // Log view all users request
        return null;
    }

    default UserDto viewUser(Long userId) throws UserNotFoundException {
        logger.info("Fetching user with ID: {}", userId); // Log view user by ID
        return null;
    }

    default String login(LoginRequest loginRequest) {
        logger.info("Attempting login for username: {}", loginRequest.username()); // Log login attempt
        return null;
    }

    // Optional: If needed, you can also uncomment this method and log based on user role
    // default List<UserDto> getUsersByRole(String roles) {
    //     logger.info("Fetching users with role: {}", roles); // Log role-based user fetching
    //     return null;
    // }
}
