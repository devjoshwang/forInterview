package interviewExam;


public class SolutionTest {
    public static void main(String[] args) {
    	
    	Solution validator = new Solution();
    	
    	String format1="{\"id\":\"String\", \"name\":\"String\",\"brand\":\"String\", \"price\":\"Integer\"}";
    	String json1 = "{\"id\":\"A0001\",\"name\":\"monitor\",\"brand\":\"ViewSonic\",\"price\":5000}";
    	String wrongJson1 = "{\"id\":\"A0001\",\"name\":\"monitor\",\"memo\":\"ViewSonic V20\",\"price\":\"NT5000\"}";
    	
    	
    	String format2 = "{\"id\":\"String\",\"name\":\"String\",\"brand\":\"String\",\"price\":Integer,\"user\":{\"uid\":\"String\",\"name\":\"String\"},\"purchase\":{\"id\":\"String\",\"date\":\"Date\"}}";
    	String json2 = "{\"id\":\"A0001\",\"name\":\"monitor\",\"price\":5000,\"user\":{\"uid\":\"U0001\"},\"purchase\":{\"id\":\"P0001\",\"date\":\"20220206\"}}";
    	
    	String format3 = "{\"id\":\"String\",\"name\":\"String\",\"price\":Integer,\"user\":{\"uid\":\"String\",\"name\":{\"first_name\":\"String\",\"last_name\":\"String\"}},\"brand\":\"String\"}";
    	String json3 = "{\"id\":\"A0001\",\"name\":\"monitor\",\"price\":5000,\"user\":{\"uid\":\"U0001\",\"name\":\"Steven Rogers\",\"tel\":\"001\"}}";
    	
        String result = validator.jsonValidate(json3, format3);
        System.out.println(result);

    }
}