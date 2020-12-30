package RestAssuredTraining.RestAssuredTraining;

import org.testng.annotations.DataProvider;

public class dataForTest {


		@DataProvider(name = "DataForPost")
		public Object[][] dataForPost() {
//			Object[][] data = new Object[2][2];
//			
//			data[0][0]="Deepak";
//			data[0][1]="IT";
//			
//			data[1][0]="Trupti";
//			data[1][1]="IT";
//			return data;
//			
			return new Object[][] {
				{"Peter","Teacher"},
				{"Mayer","Coach"}
			};
		}
		}
	

