package za.ac.cput.factory;

import za.ac.cput.entity.User;
import za.ac.cput.util.GenericHelper;

/*  UserFactory.java
    Factory for the User entity
    Author: Adriaan Burger(219014868)
    Date: 10 June 2021
 */
public class UserFactory {
    //  String userID, name, surname, cellphone, email, address;
    public static User createUser(String name, String surname, String cellphone, String email, String address){
        //check if required fields(name, surname, cellphone, email) is empty
        if(name.isEmpty() || surname.isEmpty() || cellphone.isEmpty() || email.isEmpty()){
            return null; //we can't create a new User without the required fields
        }
        //generate id
        String userID = GenericHelper.generateId();
        //check if non-required input is null and change that rather to empty string
        address = address == null ? "" : address;

        //create new User
        User user = new User.Builder()
                .setUserID(userID)
                .setName(name)
                .setSurname(surname)
                .setCellphone(cellphone)
                .setEmail(email)
                .setAddress(address)
                .build();
        return user;
    }
}
