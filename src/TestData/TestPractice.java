package TestData;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import utility.ExcelUtils;
public class TestPractice {
	 static int  a=10;
	 protected static String sheetName= "TestLoginPage";
	@Rule
	public ErrorCollector errcollector=new ErrorCollector();	 
	 @Test
	
	public void test() throws Exception {
		
		try{
		assertEquals("12",a);
		
		
		}
		catch(Throwable e){
			errcollector.addError(e);

		}
		
				
	
	System.out.println("Data is " +a);}
	}
	
	



