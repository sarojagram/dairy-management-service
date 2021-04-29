package com.agraminfotech.dairymanagement.security.user;

import com.agraminfotech.dairymanagement.security.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    private UserService (UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null) throw new UsernameNotFoundException("User 404");

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),true,true,true,true,
                getAuthorities(user));
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(User user) {
        String[] userRoles = user.getRoles().stream().map(Role::getName).toArray(String[]::new);
        return AuthorityUtils.createAuthorityList(userRoles);
    }

    public User saveOrUpdate(User user){
        return  userRepository.save( user);
    }

    public User findById(Long id){
        return userRepository.findById(id).get();
    }

    public User findByUsername(String username){return  userRepository.findByUsername(username);}

    public boolean existsByUsername(String username){
        return  userRepository.existsByUsername(username);
    }

    public boolean existsByEmail(String email){
        return  userRepository.existsByEmail(email);
    }

}
