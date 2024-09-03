package Test_Case_File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Page_Object_File.Login_class;
import Utilities_File.Data_Driven_Class;

public class TestCase extends BaseClass
{

	@Test(dataProvider="datapro1")
	void logiCase(String user,String pass)
	{ 
		driver.get(url);
		Login_class lc=new Login_class(driver);
		lc.username(user);
		lc.password(pass);
		lc.submit();	
	}
	
	
@DataProvider(name="datapro1")
	public String[][] getData() throws Exception
				{
					String file_name="C:\\Users\\RINKI\\Desktop\\TestData.xlsx";
					int Rows=Data_Driven_Class.getRowCount(file_name, "Sheet1");
					int cols =Data_Driven_Class.getColCunt(file_name, "Sheet1");
					String s1[][] = new String[Rows-1][cols];
					for(int i=1;i<Rows;i++)
					{
						for(int j=0;j<cols;j++)
						{
							s1[i-1][j]=Data_Driven_Class.getCellvalue(file_name, "Sheet1", i, j);
						}
					}
					return s1;
				}
}
