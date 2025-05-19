package com.ptit.ttcs.bookstore.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final StaffService staffService;

    public CustomUserDetailsService(StaffService staffService) {
        this.staffService = staffService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.ptit.ttcs.bookstore.domain.Staff staff = this.staffService.findByUsername(username);
        if (staff == null) {
            throw new UsernameNotFoundException("user not found");
        }

        return new User(
                staff.getEmail(),
                staff.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(staff.getRole().toString())));
    }
}
