package data;

import data.Book;
import data.BookShop;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-22T19:46:19")
@StaticMetamodel(Publisher.class)
public class Publisher_ { 

    public static volatile ListAttribute<Publisher, Book> booklist;
    public static volatile SingularAttribute<Publisher, Integer> publisherId;
    public static volatile SingularAttribute<Publisher, BookShop> shop;
    public static volatile SingularAttribute<Publisher, String> name;
    public static volatile SingularAttribute<Publisher, String> url;

}