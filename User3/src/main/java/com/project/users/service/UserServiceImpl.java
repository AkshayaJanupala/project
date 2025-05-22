/*package com.project.users.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.users.dto.LoginRequest;
import com.project.users.dto.UserDto;
import com.project.users.entity.User;
import com.project.users.exception.UserNotFoundException;
import com.project.users.jwt.JwtUtil;
import com.project.users.repository.IUserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private IUserRepository userRepository;
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private JwtUtil jwtUtil;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto addUser(UserDto userDto) {
        User user = mapToEntity(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User newUser = userRepository.save(user);
        return mapToDto(newUser);
    }

    @Override
    public UserDto validateUser(UserDto userDto) throws UserNotFoundException {
        Optional<User> foundUser = userRepository.findById(userDto.getUserId());
        if (foundUser.isPresent() && 
            passwordEncoder.matches(userDto.getPassword(), foundUser.get().getPassword())) {
            return mapToDto(foundUser.get());
        }
        throw new UserNotFoundException("Invalid user credentials");
    }

    @Override
    public UserDto updateUser(UserDto userDto) throws UserNotFoundException {
        User existingUser = userRepository.findById(userDto.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

  
        if (userDto.getUsername() != null) existingUser.setUsername(userDto.getUsername());
        if (userDto.getPassword() != null) existingUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
        if (userDto.getUserPhone() != null) existingUser.setUserPhone(userDto.getUserPhone());
        if (userDto.getEmail() != null) existingUser.setEmail(userDto.getEmail());
        if (userDto.getRoles() != null) existingUser.setRoles(userDto.getRoles());

        return mapToDto(userRepository.save(existingUser));
    }
    
    @Override
    public UserDto updateUserPassword(Long userId, String newPassword) throws UserNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        user.setPassword(passwordEncoder.encode(newPassword));
        return mapToDto(userRepository.save(user));
    }

    @Override
    public UserDto viewUser(Long userId) throws UserNotFoundException {
        return userRepository.findById(userId)
                .map(this::mapToDto)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }
    
 
    
//    
//    
//    @Override
//    public List<UserDto> getUsersByRole(String roles) {
//        return userRepository.findByRole(roles.toUpperCase())
//                .stream()
//                .map(this::mapToDto)
//                .collect(Collectors.toList());
//    }


    @Override
    public List<UserDto> viewUser() {
        return userRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public String deleteUser(Long userId) throws UserNotFoundException {
        if (!userRepository.existsById(userId)) {
            throw new UserNotFoundException("User not found");
        }
        userRepository.deleteById(userId);
        return "User deleted successfully";
    }

    @Override
    public UserDto removeUser(Long userId) throws UserNotFoundException {
        UserDto userDto = viewUser(userId);
        userRepository.deleteById(userId);
        return userDto;
    }

    @Override
    public String login(LoginRequest loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.username(), loginRequest.password()));
        return jwtUtil.generateToken(loginRequest.username());
    }

    private UserDto mapToDto(User user) {
        return new UserDto(user.getUserId(), user.getUsername(),
                user.getPassword(), user.getUserPhone(), user.getEmail(), user.getRoles());
    }

    private User mapToEntity(UserDto userDto) {
        return new User(userDto.getUserId(), userDto.getUsername(),
                userDto.getPassword(), userDto.getUserPhone(), userDto.getEmail(), userDto.getRoles());
    }

	

	
	
    
    
    
}*/

package com.project.users.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.users.dto.LoginRequest;
import com.project.users.dto.UserDto;
import com.project.users.entity.User;
import com.project.users.exception.UserNotFoundException;
import com.project.users.jwt.JwtUtil;
import com.project.users.repository.IUserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    // Logger for the service
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private IUserRepository userRepository;
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private JwtUtil jwtUtil;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto addUser(UserDto userDto) {
        logger.info("Adding new user: {}", userDto.getUsername());

        User user = mapToEntity(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User newUser = userRepository.save(user);

        logger.info("User added successfully with ID: {}", newUser.getUserId());
        return mapToDto(newUser);
    }

   /* @Override
    public UserDto validateUser(UserDto userDto) throws UserNotFoundException {
        logger.info("Validating user with ID: {}", userDto.getUserId());

        Optional<User> foundUser = userRepository.findById(userDto.getUserId());
        if (foundUser.isPresent() && 
            passwordEncoder.matches(userDto.getPassword(), foundUser.get().getPassword())) {
            logger.info("User validated successfully with ID: {}", userDto.getUserId());
            return mapToDto(foundUser.get());
        }
        
        logger.error("Invalid user credentials for ID: {}", userDto.getUserId());
        throw new UserNotFoundException("Invalid user credentials");
    }*/

    @Override
    public UserDto updateUser(UserDto userDto) throws UserNotFoundException {
        logger.info("Updating user with ID: {}", userDto.getUserId());

        User existingUser = userRepository.findById(userDto.getUserId())
                .orElseThrow(() -> {
                    logger.error("User not found with ID: {}", userDto.getUserId());
                    return new UserNotFoundException("User not found");
                });

        if (userDto.getUsername() != null) existingUser.setUsername(userDto.getUsername());
        if (userDto.getPassword() != null) existingUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
        if (userDto.getUserPhone() != null) existingUser.setUserPhone(userDto.getUserPhone());
        if (userDto.getEmail() != null) existingUser.setEmail(userDto.getEmail());
        if (userDto.getRoles() != null) existingUser.setRoles(userDto.getRoles());

        User updatedUser = userRepository.save(existingUser);
        logger.info("User updated successfully with ID: {}", updatedUser.getUserId());
        return mapToDto(updatedUser);
    }

    @Override
    public UserDto updateUserPassword(Long userId, String newPassword) throws UserNotFoundException {
        logger.info("Updating password for user with ID: {}", userId);

        User user = userRepository.findById(userId)
                .orElseThrow(() -> {
                    logger.error("User not found with ID: {}", userId);
                    return new UserNotFoundException("User not found");
                });

        user.setPassword(passwordEncoder.encode(newPassword));
        User updatedUser = userRepository.save(user);

        logger.info("Password updated successfully for user with ID: {}", userId);
        return mapToDto(updatedUser);
    }

    @Override
    public UserDto viewUser(Long userId) throws UserNotFoundException {
        logger.info("Viewing user with ID: {}", userId);

        return userRepository.findById(userId)
                .map(this::mapToDto)
                .orElseThrow(() -> {
                    logger.error("User not found with ID: {}", userId);
                    return new UserNotFoundException("User not found");
                });
    }

    @Override
    public List<UserDto> viewUser() {
        logger.info("Fetching all users");

        return userRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public String deleteUser(Long userId) throws UserNotFoundException {
        logger.info("Deleting user with ID: {}", userId);

        if (!userRepository.existsById(userId)) {
            logger.error("User not found with ID: {}", userId);
            throw new UserNotFoundException("User not found");
        }

        userRepository.deleteById(userId);
        logger.info("User deleted successfully with ID: {}", userId);
        return "User deleted successfully";
    }

    @Override
    public UserDto removeUser(Long userId) throws UserNotFoundException {
        logger.info("Removing user with ID: {}", userId);

        UserDto userDto = viewUser(userId);
        userRepository.deleteById(userId);

        logger.info("User removed successfully with ID: {}", userId);
        return userDto;
    }

    @Override
    public String login(LoginRequest loginRequest) {
        logger.info("User attempting login with username: {}", loginRequest.username());

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.username(), loginRequest.password()));

        String token = jwtUtil.generateToken(loginRequest.username());
        logger.info("Login successful for username: {}. JWT Token generated.", loginRequest.username());

        return token;
    }

    private UserDto mapToDto(User user) {
        return new UserDto(user.getUserId(), user.getUsername(),
                user.getPassword(), user.getUserPhone(), user.getEmail(), user.getRoles());
    }

    private User mapToEntity(UserDto userDto) {
        return new User(userDto.getUserId(), userDto.getUsername(),
                userDto.getPassword(), userDto.getUserPhone(), userDto.getEmail(), userDto.getRoles());
    }
}
