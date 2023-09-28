package interviewExam;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Solution {
    public String jsonValidate(String json, String format) {
    	
    	JSONObject dataJsonObject= new JSONObject(json); // data用 STRING轉 JSON
    	JSONObject formatJsonObject= new JSONObject(format); // format用 STRING轉 JSON
    	
    	//多層json物件轉單層
    	JSONObject flattenedFormat = flattenJson(formatJsonObject);
        JSONObject flattenedJson = flattenJson(dataJsonObject);
        
        // 存錯誤資訊
        List<String> lossDataErrors = new ArrayList<>();
        List<String> typeErrors = new ArrayList<>();
    	
    	//錯誤資訊轉字串
        
        validateJson3(flattenedJson,flattenedFormat, lossDataErrors, typeErrors);

        StringBuilder errorBuilder = new StringBuilder();
        
        if (!typeErrors.isEmpty()) {
            errorBuilder.append("type error: ");
            errorBuilder.append(String.join(", ", typeErrors));
            errorBuilder.append("\n");
        }

        if (!lossDataErrors.isEmpty()) {
            errorBuilder.append("loss data: ");
            errorBuilder.append(String.join(", ", lossDataErrors));
        }

        return errorBuilder.toString();
    }
    
    //試圖把多層JSON拍平成單層
    public static JSONObject flattenJson(JSONObject jsonObject) {
        JSONObject flattenedJson = new JSONObject();
        flatten("", jsonObject, flattenedJson);
        return flattenedJson;
    }

    private static void flatten(String currentKey, Object jsonValue, JSONObject flattenedJson) {
        if (jsonValue instanceof JSONObject) {
            JSONObject jsonObject = (JSONObject) jsonValue;
            for (String key : jsonObject.keySet()) {
                flatten(currentKey + key + "/", jsonObject.get(key), flattenedJson);
            }
        } else if (jsonValue instanceof JSONArray) {
            JSONArray jsonArray = (JSONArray) jsonValue;
            for (int i = 0; i < jsonArray.length(); i++) {
                flatten(currentKey + i + "/", jsonArray.get(i), flattenedJson);
            }
        } else {
            flattenedJson.put(currentKey.substring(0, currentKey.length() - 1), jsonValue);
        }
    }

    private void validateJson3(JSONObject datajsonresult, JSONObject formatresult, List<String> lossDataErrors, List<String> typeErrors) {
    	
        // 兩個集合存keyName
        Set<String> formatKeysSet = new HashSet<>();
        Set<String> jsonKeysSet = new HashSet<>();
        
        for (String key : datajsonresult.keySet()) {
            jsonKeysSet.add(key);
        }
        
        for (String key : formatresult.keySet()) {
            formatKeysSet.add(key);
        }
        
        // 找到 formatKeysSet有而 jsonKeysSet 中沒有的keyName
        Set<String> missingKeys = new HashSet<>(formatKeysSet);
        missingKeys.removeAll(jsonKeysSet);
        
        // 印出loss data
        for (String key : missingKeys) {
        	String lostData = (key).toString();
        	lossDataErrors.add(lostData);
        	//System.out.println("loss data: " + key);
        }
        
        
        // 取出formatresult中的value, 並存入formatkeys
        Iterator<String> formatkeys = formatresult.keys();
        
        //找出format 的keyName
        while (formatkeys.hasNext()) {
            String keyString = formatkeys.next();
        if (datajsonresult.has(keyString)) {
        	//取出format值內容
        	String formatValue = formatresult.getString(keyString);
        	
        	//取出jsonValueType
        	Object jsonValueType2 = datajsonresult.get(keyString).getClass().getSimpleName();
        	//對比format值內容與jsonValueType
        	if (formatValue.equals(jsonValueType2)){
        	} else {
        		String typeError = (keyString+" must be "+formatValue).toString();
        		typeErrors.add(typeError);
        		//System.out.println("type error: "+keyString+" must be "+formatValue2);
        	}
        } 
        }
     
    }
}

