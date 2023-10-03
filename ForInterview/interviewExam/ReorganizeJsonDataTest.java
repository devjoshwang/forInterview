package interviewExam;

import javax.naming.spi.DirStateFactory.Result;

public class ReorganizeJsonDataTest {

	public static void main(String[] args) {

		ReorganizeJsonData go = new ReorganizeJsonData();

		String cardA = "[\n" +
                "   {\n" +
                "       \"cardNo\": \"1111\",\n" +
                "       \"billYYYY\": \"2023\",\n" +
                "       \"billMM\": \"08\"\n" +
                "   },\n" +
                "   {\n" +
                "       \"cardNo\": \"1111\",\n" +
                "       \"billYYYY\": \"2023\",\n" +
                "       \"billMM\": \"07\"\n" +
                "   },\n" +
                "   {\n" +
                "       \"cardNo\": \"1111\",\n" +
                "       \"billYYYY\": \"2023\",\n" +
                "       \"billMM\": \"06\"\n" +
                "   },\n" +
                "   {\n" +
                "       \"cardNo\": \"1111\",\n" +
                "       \"billYYYY\": \"2023\",\n" +
                "       \"billMM\": \"05\"\n" +
                "   },\n" +
                "   {\n" +
                "       \"cardNo\": \"1111\",\n" +
                "       \"billYYYY\": \"2023\",\n" +
                "       \"billMM\": \"04\"\n" +
                "   }\n" +
                "]";

        String cardB = "[\n" +
                "   {\n" +
                "       \"cardNo\": \"2222\",\n" +
                "       \"billYYYY\": \"2023\",\n" +
                "       \"billMM\": \"08\"\n" +
                "   },\n" +
                "   {\n" +
                "       \"cardNo\": \"2222\",\n" +
                "       \"billYYYY\": \"2023\",\n" +
                "       \"billMM\": \"07\"\n" +
                "   },\n" +
                "   {\n" +
                "       \"cardNo\": \"2222\",\n" +
                "       \"billYYYY\": \"2023\",\n" +
                "       \"billMM\": \"06\"\n" +
                "   },\n" +
                "   {\n" +
                "       \"cardNo\": \"2222\",\n" +
                "       \"billYYYY\": \"2023\",\n" +
                "       \"billMM\": \"05\"\n" +
                "   },\n" +
                "   {\n" +
                "       \"cardNo\": \"2222\",\n" +
                "       \"billYYYY\": \"2023\",\n" +
                "       \"billMM\": \"04\"\n" +
                "   }\n" +
                "]";

        String cardC = "[\n" +
                "   {\n" +
                "       \"cardNo\": \"3333\",\n" +
                "       \"billYYYY\": \"2023\",\n" +
                "       \"billMM\": \"08\"\n" +
                "   },\n" +
                "   {\n" +
                "       \"cardNo\": \"3333\",\n" +
                "       \"billYYYY\": \"2023\",\n" +
                "       \"billMM\": \"07\"\n" +
                "   },\n" +
                "   {\n" +
                "       \"cardNo\": \"3333\",\n" +
                "       \"billYYYY\": \"2023\",\n" +
                "       \"billMM\": \"06\"\n" +
                "   },\n" +
                "   {\n" +
                "       \"cardNo\": \"3333\",\n" +
                "       \"billYYYY\": \"2023\",\n" +
                "       \"billMM\": \"05\"\n" +
                "   },\n" +
                "   {\n" +
                "       \"cardNo\": \"3333\",\n" +
                "       \"billYYYY\": \"2023\",\n" +
                "       \"billMM\": \"04\"\n" +
                "   }\n" +
                "]";
        
        
       String result = go.reorganizeJson(cardA,cardB,cardC);
       
       System.out.println(result);
	}
}
