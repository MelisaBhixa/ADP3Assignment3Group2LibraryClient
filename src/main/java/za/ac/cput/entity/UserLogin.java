package za.ac.cput.entity;

/*  UserLogin.java
    User Login entity
    Author: Taahir Boltman(218022972)
    Date: 10 June 2021
 */

public class UserLogin {
    private String userId, userName, password;


    private UserLogin(Builder builder) {
        this.userId = builder.userId;
        this.userName = builder.userName;
        this.password = builder.password;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static class Builder{
        private String userId, userName, password;

        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UserLogin build(){
            return new UserLogin(this);
        }

        public Builder copy(UserLogin user){
            this.userId = user.userId;
            this.userName = user.userName;
            this.password = user.password;
            return this;
        }
    }




}

