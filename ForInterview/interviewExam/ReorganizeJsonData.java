package interviewExam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import org.json.JSONArray;
import org.json.JSONObject;

public class ReorganizeJsonData {

    public String reorganizeJson(String cardA, String cardB, String cardC) {
        // 替換誇號並轉 JSONArray
        cardA.replace("[", "{").replace("]", "}");
        cardB.replace("[", "{").replace("]", "}");
        cardC.replace("[", "{").replace("]", "}");

        JSONArray arrayDataA = new JSONArray(cardA);
        JSONArray arrayDataB = new JSONArray(cardB);
        JSONArray arrayDataC = new JSONArray(cardC);

        // 创建整理后的对象
        JSONObject reorganizedData = new JSONObject();

        // 整理 cardA
       reorganizeCard(arrayDataA, reorganizedData);

        // 整理 cardB
       reorganizeCard(arrayDataB, reorganizedData);

        // 整理 cardC
        reorganizeCard(arrayDataC, reorganizedData);

        //System.out.println(reorganizedData.toString(2));

        // 将整理后的 JSON 转为字符串返回（您可能还想返回其他信息）
        return reorganizedData.toString(2);
    }

    private void reorganizeCard(JSONArray arrayData, JSONObject reorganizedData) {
        for (int i = 0; i < arrayData.length(); i++) {
            JSONObject allData = arrayData.getJSONObject(i);
            String cardNoValue = allData.getString("cardNo");
            String billYYYYValue = allData.getString("billYYYY");
            String billMMValue = allData.getString("billMM");
            String ym = billYYYYValue + "_" + billMMValue;
            
            // 檢查key（ym）是否已經存在於 reorganizedData 中
            if (!reorganizedData.has(ym)) {
                // 如果不存在，創建一個新的 JSONArray 並添加到 reorganizedData 中
                JSONArray cardArray = new JSONArray();
                reorganizedData.put(ym, cardArray);
            }

            JSONObject cardNoObject = new JSONObject();
            cardNoObject.put("cardNo", cardNoValue);
            cardNoObject.put("billYYYY", billYYYYValue);
            cardNoObject.put("billMM", billMMValue);
            
         // 加入cardData至對應的ym key的 JSONArray
            JSONArray cardArray = reorganizedData.getJSONArray(ym);
            cardArray.put(cardNoObject);
        }
    }
}