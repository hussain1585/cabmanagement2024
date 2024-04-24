package com.expatrio.cabmanagement.usecases;

import com.expatrio.cabmanagement.dto.customer.UserInfoDTO;
import com.expatrio.cabmanagement.mappers.UserInfoDtoToEntity;
import com.expatrio.cabmanagement.ports.jpa.entity.customer.UserInfoEntity;
import com.expatrio.cabmanagement.ports.jpa.entity.customer.UserInfoDetails;
import com.expatrio.cabmanagement.ports.jpa.repository.customer.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class UserInfoService implements UserDetailsService {

    @Autowired
    private UserInfoRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserInfoDtoToEntity userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfoEntity> userDetail = userRepository.findByName(username);
        // Converting userDetail to UserDetails
        return userDetail.map(UserInfoDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
    }

    public UserInfoEntity addUser(UserInfoDTO userInfoDTO) {

        UserInfoEntity userInfoEntity = userMapper.dtoToEntity(userInfoDTO);
        userInfoEntity.setPassword(passwordEncoder.encode(userInfoEntity.getPassword()));
        return userRepository.save(userInfoEntity);
    }


}
