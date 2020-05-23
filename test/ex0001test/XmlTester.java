package ex0001test;


import data.BookShop;
import java.io.File;
import javax.xml.bind.JAXB;
import static junit.framework.TestCase.assertEquals;
import org.junit.Test;
import server.XML_Access;

public class XmlTester
{
  
  public XmlTester()
  {
  }

  @Test
  public void load1()
  {
    
    BookShop bs = 
      JAXB.unmarshal(
        new File("RP_SF_bookshop.xml"), BookShop.class);
    
    System.out.println("size = "+bs.getPublisherlist().size());
    assertEquals(18,bs.getPublisherlist().size());
  }
  
  @Test
  public void load2()
  {
    BookShop bs;
    //bs = XML_Access.getInstance().loadBookShop("/resources/RP_SF_bookshop.xml");
    //assertEquals(18,bs.getPublisherlist().size());    
  }
  
}
