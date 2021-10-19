package za.ac.cput.entity;
/*  Role.java
    Entity for the Role
    Author: Adriaan Burger(219014868)
    Date: 10 June 2021
 */
public class Role {

    private String roleID, name, description;
    private Role(){}
    private Role(Builder builder) {
        this.roleID = builder.roleID;
        this.name = builder.name;
        this.description = builder.description;

    }

    public String getRoleID() {  return roleID;   }

    public String getName() {   return name;   }

    public String getDescription() {  return description;  }

    public static class Builder {
        private String roleID, name, description;

        public Builder setRoleID(String roleID) {
            this.roleID = roleID;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Role build() {
            return new Role(this);
        }

        public Builder copy(Role role) {
            this.roleID = role.roleID;
            this.name = role.name;
            this.description = role.description;

            return this;
        }
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleID='" + roleID + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}