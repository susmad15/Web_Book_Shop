package data;

import data.Book;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-22T19:46:19")
@StaticMetamodel(Author.class)
public class Author_ { 

    public static volatile ListAttribute<Author, Book> booklist;
    public static volatile SingularAttribute<Author, String> firstname;
    public static volatile SingularAttribute<Author, Integer> authorId;
    public static volatile SingularAttribute<Author, String> url;
    public static volatile SingularAttribute<Author, String> lastname;

}