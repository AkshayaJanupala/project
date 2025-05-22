/*package com.project.users.controller;

 




import jakarta.validation.Valid;

import jakarta.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.project.users.dto.LoginRequest;
import com.project.users.dto.UserDto;
import com.project.users.exception.UserNotFoundException;
import com.project.users.service.UserService;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/api/users")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<UserDto> addUser(@Valid @RequestBody UserDto userDto) {
        UserDto createdUser = userService.addUser(userDto);
        return ResponseEntity.ok(createdUser);
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginRequest loginRequest) {
        String token = userService.login(loginRequest);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }


    @PostMapping("/validate")
    public ResponseEntity<UserDto> validateUser(@Valid @RequestBody UserDto userDto) throws UserNotFoundException {
        UserDto validatedUser = userService.validateUser(userDto);
        return ResponseEntity.ok(validatedUser);
    }

    @PutMapping("/update")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto) throws UserNotFoundException {
        UserDto updatedUser = userService.updateUser(userDto);
        return ResponseEntity.ok(updatedUser);
    }
    
    @PutMapping("/password/{userId}")
    public ResponseEntity<UserDto> updateUserPassword(@PathVariable Long userId, @RequestParam String newPassword) throws UserNotFoundException {
        UserDto updatedUser = userService.updateUserPassword(userId, newPassword);
        return ResponseEntity.ok(updatedUser);
    }


    @GetMapping("/view/{id}")
    public ResponseEntity<UserDto> viewUser(@PathVariable @Min(value = 1, message = "UserId should be positive") Long id) 
            throws UserNotFoundException {
        UserDto userDto = userService.viewUser(id);
        return ResponseEntity.ok(userDto);
        }
    
   
    @GetMapping("/view")
    public ResponseEntity<List<UserDto>> viewUser() {
        List<UserDto> users = userService.viewUser();
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) throws UserNotFoundException {
        userService.deleteUser(id);
        return ResponseEntity.ok("User Deleted Successfully with ID: "+id);
    }
    

  
    
    @GetMapping("/authentication")
    public String welcome() {
        return " Authentication Successful";
    }
}*/
package com.project.users.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.project.users.dto.LoginRequest;
import com.project.users.dto.UserDto;
import com.project.users.exception.UserNotFoundException;
import com.project.users.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Validated
public class UserController {

    // Logger for the controller
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<UserDto> addUser(@Valid @RequestBody UserDto userDto) {
        logger.info("Request received to add a new user with username: {}", userDto.getUsername());

        UserDto createdUser = userService.addUser(userDto);

        logger.info("User created successfully with ID: {}", createdUser.getUserId());
        return ResponseEntity.ok(createdUser);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginRequest loginRequest) {
        logger.info("Login attempt for username: {}", loginRequest.username());

        String token = userService.login(loginRequest);

        logger.info("Login successful for username: {}", loginRequest.username());
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

  /*  @PostMapping("/validate")
    public ResponseEntity<UserDto> validateUser(@Valid @RequestBody UserDto userDto) throws UserNotFoundException {
        logger.info("Validating user with ID: {}", userDto.getUserId());

        UserDto validatedUser = userService.validateUser(userDto);

        logger.info("User validated successfully with ID: {}", userDto.getUserId());
        return ResponseEntity.ok(validatedUser);
    }*/

    @PutMapping("/update")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto) throws UserNotFoundException {
        logger.info("Updating user with ID: {}", userDto.getUserId());

        UserDto updatedUser = userService.updateUser(userDto);

        logger.info("User updated successfully with ID: {}", updatedUser.getUserId());
        return ResponseEntity.ok(updatedUser);
    }

    @PutMapping("/password/{userId}")
    public ResponseEntity<UserDto> updateUserPassword(@PathVariable Long userId, @RequestParam String newPassword) throws UserNotFoundException {
        logger.info("Request to update password for user with ID: {}", userId);

        UserDto updatedUser = userService.updateUserPassword(userId, newPassword);

        logger.info("Password updated successfully for user with ID: {}", userId);
        return ResponseEntity.ok(updatedUser);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<UserDto> viewUser(@PathVariable @Min(value = 1, message = "UserId should be positive") Long id) throws UserNotFoundException {
        logger.info("Fetching user details for ID: {}", id);

        UserDto userDto = userService.viewUser(id);

        logger.info("User details fetched successfully for ID: {}", id);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/view")
    public ResponseEntity<List<UserDto>> viewUser() {
        logger.info("Fetching all users");

        List<UserDto> users = userService.viewUser();

        logger.info("Fetched {} users", users.size());
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) throws UserNotFoundException {
        logger.info("Request received to delete user with ID: {}", id);

        userService.deleteUser(id);

        logger.info("User deleted successfully with ID: {}", id);
        return ResponseEntity.ok("User Deleted Successfully with ID: " + id);
    }

    @GetMapping("/authentication")
    public String welcome() {
        logger.info("Authentication check successful");

        return "Authentication Successful";
    }
}


