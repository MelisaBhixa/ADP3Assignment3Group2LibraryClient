package za.ac.cput.entity;

/**
 * author.java
 * This code represents an entity using the builder pattern
 * @author: Melven Johannes Booysen (219201277)
 * Date: 10 June 2021
 */

//This package "entity/domain - is the blueprint part of things (skeleton)
public class Author
{
    private String authorId, name, surname, bio;

    private Author(Builder builder)
    {
        this.authorId = builder.authorId;
        this.name = builder.name;
        this.surname = builder.surname;
        this.bio = builder.bio;
    }

    @Override
    public String toString()
    {
        return "Author{" +
                "authorId='" + authorId + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }

    //Getters
    public String getAuthorId()
    {
        return authorId;
    }

    public String getName()
    {
        return name;
    }

    public String getSurname()
    {
        return surname;
    }

    public String getBio()
    {
        return bio;
    }//End of getters

    public static class Builder
    {
        private String  authorId, name, surname, bio;

        //Setters
        public Builder setAuthorId(String authorId)
        {
            this.authorId = authorId;
            return this;
        }

        public Builder setName(String name)
        {
            this.name = name;
            return this;
        }

        public Builder setSurname(String surname)
        {
            this.surname = surname;
            return this;
        }

        public Builder setBio(String bio)
        {
            this.bio = bio;
            return this;
        }//End of setters

        public Author build()
        {
            return new Author(this);
        }

        public Builder copy(Author author)
        {
            this.authorId = author.authorId;
            this.name = author.name;
            this.surname = author.surname;
            this.bio = author.bio;

            return this;
        }
    }//*** End of inner class ***

}//*** End of outer class ***
