package za.ac.cput.factory;

import za.ac.cput.entity.UserRole;
import za.ac.cput.util.GenericHelper;

/*  UserRoleFactory.java
    Factory for the UserRole entity
    Author: Adriaan Burger(219014868)
    Date: 10 June 2021
 */
public class UserRoleFactory {
    private static String userID, roleID;
    public static UserRole createUserRole(String userID,String roleID){
        // 25-07 | Assignment feedback : "No getters in entities. userId, roleId should NOT be generated in UserRoleFactory."
       // String userID = GenericHelper.generateId();
       // String roleID = GenericHelper.generateId();
      //  userID = user.getUserID();
    //    roleID = role.getRoleID();

//        UserRole userRole = new UserRole.Builder()
//                .setRoleID(userID)
//                .setRoleID(roleID)
//                .build();
//        return userRole;

        // August update:
        if(GenericHelper.isNullorEmpty(userID) || GenericHelper.isNullorEmpty(roleID))
           return new UserRole.Builder().build();
        return new UserRole.Builder().setUserID(userID).setRoleID(roleID).build();
    }
}