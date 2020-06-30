package crossBrowsers;





import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testngdataprovider {

	
 
	@Test
	@Parameters("browser")
	
	
	public void verifyfileupload(String b  ) throws InterruptedException{
		  System.out.println("Browsername : "+b);
		  
	}

}
