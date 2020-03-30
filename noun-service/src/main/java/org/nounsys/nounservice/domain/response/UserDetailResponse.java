package org.nounsys.nounservice.domain.response;

/**
 * @author:gaoxu
 * @create:2020-03-20 16:59
 **/
public class UserDetailResponse {
    private String userName;
    private String passWord;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public UserDetailResponse(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public UserDetailResponse() {
    }
}
