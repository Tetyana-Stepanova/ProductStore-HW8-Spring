package com.goit.productstore.models.auth;

import com.goit.productstore.models.role.Role;
import com.goit.productstore.models.user.User;
import com.goit.productstore.models.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;


public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
 //   @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        User user = userRepository.getUserByEmail(userEmail);
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
        return new CustomUserDetails(user);

//        User user = userRepository.findByEmail(userEmail);
//        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//        for(Role role : user.getRoles()){
//            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
//        }
//        return new org.springframework.security.core.userdetails.User(user.getEmail(),
//                                                                      user.getPassword(),
//                                                                      grantedAuthorities);
    }

}
