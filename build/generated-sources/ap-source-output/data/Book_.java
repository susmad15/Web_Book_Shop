package data;

import data.Author;
import data.Publisher;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-22T19:46:19")
@StaticMetamodel(Book.class)
public class Book_ { 

    public static volatile SingularAttribute<Book, Double> price;
    public static volatile SingularAttribute<Book, String> isbn;
    public static volatile ListAttribute<Book, Author> authorlist;
    public static volatile SingularAttribute<Book, Publisher> publisher;
    public static volatile SingularAttribute<Book, String> title;
    public static volatile SingularAttribute<Book, String> url;
    public static volatile SingularAttribute<Book, Integer> bookId;

}