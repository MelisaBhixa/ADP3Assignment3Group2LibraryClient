package za.ac.cput.factory;

import za.ac.cput.entity.Role;
import za.ac.cput.util.GenericHelper;
/*  RoleFactory.java
    Factory for the Role entity
    Author: Adriaan Burger(219014868)
    Date: 10 June 2021
 */

public class RoleFactory {
    // private String roleID, name, description;
    public static Role createRole(String name, String description){
      //check if name is empty
      if(name.isEmpty()){
          return null;//we can't create a new Role without the name
      }
      String roleID = GenericHelper.generateId();
      //check if non-required input is null and change that rather to empty string
      description = description == null ? "" : description;

      //create new role:
        Role role = new Role.Builder()
                .setRoleID(roleID)
                .setName(name)
                .setDescription(description)
                .build();
        return role;
    }
}
