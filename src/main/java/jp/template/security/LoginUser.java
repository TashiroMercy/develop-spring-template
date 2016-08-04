package jp.template.security;

import org.springframework.security.core.authority.AuthorityUtils;

import jp.template.domain.User;

public class LoginUser extends org.springframework.security.core.userdetails.User {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 5995980685832853146L;
	/**
     * ���O�C�����[�U�[
     */
    private final User user;


    /**
     * �R���X�g���N�^
     * @param user
     */
    public LoginUser(User user) {
        // �X�[�p�[�N���X�̃��[�U�[ID�A�p�X���[�h�ɒl���Z�b�g����
        // ���ۂ̔F�؂̓X�[�p�[�N���X�̃��[�U�[ID�A�p�X���[�h�ōs����
        super(user.getLoginUserId(), user.getPassword(),
                AuthorityUtils.createAuthorityList("ROLE_USER"));
        this.user = user;
    }

    /**
     *
     * @return
     */
    public User getUser() {
        return user;
    }

}
