package za.ac.cput.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/*  User.java
    Entity for the User
    Author: Adriaan Burger(219014868)
    Date: 10 June 2021
 */
@Entity
public class User {
    @Id
    private String userID;
    private String name, surname, cellphone, email, address;
    public User(){}
    // 25-07 | Assignment feedback : "No getters in entities. userId, roleId should NOT be generated in UserRoleFactory."
    private User(Builder builder){
        this.userID = builder.userID;
        this.name = builder.name;
        this.surname = builder.surname;
        this.cellphone = builder.cellphone;
        this.email = builder.email;
        this.address = builder.address;

    }

    public String getUserID() { return userID;   }

    public String getName() {   return name;   }

    public String getSurname() {  return surname;  }

    public String getCellphone() {   return cellphone;   }

    public String getEmail() {   return email;   }

    public String getAddress() {    return address;   }

    public static class Builder{
        private String userID, name, surname, cellphone, email, address;
        public Builder setUserID(String userID){
            this.userID = userID;
            return this;
        }

        public Builder setName(String name){
            this.name = name;
            return this;
        }

        public Builder setSurname(String surname){
            this.surname = surname;
            return this;
        }

        public Builder setCellphone(String cellphone){
            this.cellphone = cellphone;
            return this;
        }
        public Builder setEmail(String email){
            this.email = email;
            return this;
        }
        public Builder setAddress(String address){
            this.address = address;
            return this;
        }

        public User build(){
            return new User(this);
        }

        public Builder copy(User user){
            this.userID = user.userID;
            this.name = user.name;
            this.surname = user.surname;
            this.cellphone = user.cellphone;
            this.email = user.email;
            this.address = user.address;
            return this;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}
