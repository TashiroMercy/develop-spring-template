package jp.template.service;


import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import jp.template.domain.User;
import jp.template.mapper.UserMapper;
import jp.template.security.LoginUser;



/**
 * UserDetailsService�̎����N���X
 * Spring Security�ł̃��[�U�[�F�؂Ɏg�p����
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserMapper userMapper; 
    
    @Override
    public UserDetails loadUserByUsername(String login_id)
            throws UsernameNotFoundException {

        // �F�؂��s�����[�U�[�����i�[����
        User user = null;
        try {
            // ���͂������[�U�[ID����F�؂��s�����[�U�[�����擾����
        	user = userMapper.select(login_id);
			if (Objects.isNull(user)) {
				 throw new UsernameNotFoundException("User not found for login id: " + login_id);
			}

	        // ���[�U�[��񂪎擾�ł�����Spring Security�ŔF�؂ł���`�Ŗ߂�
	        return new LoginUser(user);
        } catch (Exception e) {
            // �擾����Exception�����������ꍇ
            throw new UsernameNotFoundException("It can not be acquired User");
        }

    }

}