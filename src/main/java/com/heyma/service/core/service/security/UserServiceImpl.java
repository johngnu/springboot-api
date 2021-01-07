package com.heyma.service.core.service.security;

import com.heyma.service.core.controller.dto.UserDto;
import com.heyma.service.core.model.entity.security.Role;
import com.heyma.service.core.model.entity.security.User;
import com.heyma.service.core.model.entity.security.UserRole;
import com.heyma.service.core.model.repository.security.UserRepository;
import com.heyma.service.core.model.repository.security.UserRoleRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username.trim());
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email.trim().toLowerCase());
    }

    @Override
    public Optional<User> get(long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User persist(UserDto userDto) {
        Optional<Role> role = roleService.findByName("ROLE_ADMIN");
        if (role.isPresent()) {
            User user = new User();
            user.setUsername(userDto.getUsername());
            user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
            user.setCompleteName(userDto.getCompleteName());
            user.setEmail(userDto.getEmail().toLowerCase().trim());
            user.setBirthdate(userDto.getBirthdate());
            user.setAddress(userDto.getAddress());
            user.setEnabled(userDto.getEnabled());
            userRepository.save(user);
            UserRole userRole = new UserRole();
            userRole.setRoleId(role.get().getId());
            userRole.setUserId(user.getId());
            userRoleRepository.save(userRole);
            return user;
        }
        return null;
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }
}
