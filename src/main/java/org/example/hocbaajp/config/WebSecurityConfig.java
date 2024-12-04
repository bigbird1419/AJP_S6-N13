package org.example.hocbaajp.config;

import org.example.hocbaajp.dao.UserDao;
import org.example.hocbaajp.object.UserObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

    private final UserDao userDao;
    public WebSecurityConfig(UserDao userDao) {
        this.userDao = userDao;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private static class CustomUserDetailsService implements UserDetailsService {

        private final UserDao userDao;

        public CustomUserDetailsService(UserDao userDao) {
            this.userDao = userDao;
        }

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            UserObject userObject = userDao.getUserByTendangnhap(username);

            if (userObject == null) {
                throw new UsernameNotFoundException("User not found with username: " + username);
            }
            else {
                return User.withUsername(userObject.getTendangnhap())
                        .password(userObject.getPassword())
                        .authorities(userObject.getLoaitk())
                        .build();
            }
        }
    }
}
