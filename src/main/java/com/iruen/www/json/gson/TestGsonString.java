package com.iruen.www.json.gson;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

/**
 * Created by 1004lucifer on 2015-04-08.
 */
public class TestGsonString {
    public static void main(String[] argv) {
        String companyJson= "{\"a\": \"aa\", \"b\": \"123\", \"c\": \"12.3\", \"d\": {}, \"e\": [{\"bb\": \"55555\"}]}";
 
        JsonObject jsonObject = new JsonParser().parse(companyJson).getAsJsonObject();
        JsonArray jsonArray = jsonObject.getAsJsonArray("e");
        JsonObject jsonObject1 = jsonArray.get(0).getAsJsonObject();
        JsonPrimitive jsonPrimitive = jsonObject1.getAsJsonPrimitive("bb");
        int value = jsonPrimitive.getAsInt();
        System.out.println("value == 55555 is : " + (value == 55555));
    }
}
