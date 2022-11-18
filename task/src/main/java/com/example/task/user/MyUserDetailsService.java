package com.example.task.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override   //userdetailsの取得
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(
                        user -> new MyUserDetails(
                                user.getUsername(),
                                user.getPassword(),
                                Collections.emptyList()
                        )
                )
                .orElseThrow(//DB内にuserがいなかった場合の例外
                        () -> new UsernameNotFoundException(username + "が見つかりませんでした。")
                );
    }
}
