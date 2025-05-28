package com.ptit.ttcs.bookstore.security;

import com.ptit.ttcs.bookstore.domain.Staff;
import com.ptit.ttcs.bookstore.repository.StaffRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final StaffRepository staffRepository;

    public UserDetailsServiceImpl(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Staff staff = staffRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        return new User(
            staff.getUsername(),
            staff.getPassword(),
            Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + staff.getRole().name()))
        );
    }
}
