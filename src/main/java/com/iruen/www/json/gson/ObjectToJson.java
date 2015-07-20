package com.iruen.www.json.gson;

import java.util.Iterator;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

public class ObjectToJson {
    public static void main(String[] argv) {
        String companyJson= "{\"name\":\"1004lucifer\\u0027s Company\",\"employees\":[{\"name\":\"1004lucifer\",\"age\":\"30\",\"sex\":\"M\"},{\"name\":\"vvoei\",\"age\":\"29\",\"sex\":\"M\"},{\"name\":\"John\",\"sex\":\"M\"},{\"name\":\"Jane\",\"age\":\"20\"},{}]}";
 
        JsonObject object = new JsonParser().parse(companyJson).getAsJsonObject();
 
        System.out.println("========== Encrypt Value =========");
        companyJson = cipherValue(object, true);
        System.out.println(companyJson);
 
        System.out.println("========== Decrypt Value =========");
        companyJson = cipherValue(object, false);
        System.out.println(companyJson);
 
    }
 
    /**
     * Encrypt OR Decript Method   ---   ?????Έν?? λͺ¨λ?? ??₯ν?? ??????.
     * @param jsonObject
     * @param isEncrypt     true: encrypt   false: decrypt
     * @return
     */
    private static String cipherValue(JsonObject jsonObject, boolean isEncrypt) {
        Iterator<Map.Entry<String, JsonElement>> iterator = jsonObject.entrySet().iterator();
        Map.Entry<String, JsonElement> entry;
        while (iterator.hasNext()) {
            entry = iterator.next();
            JsonElement value = entry.getValue();
            if (value.isJsonPrimitive()) {
                try {
                    if (isEncrypt) {
                        entry.setValue(new JsonPrimitive(entry.getValue().getAsString()));
                    } else {
                        entry.setValue(new JsonPrimitive(entry.getValue().getAsString()));
                    }
                } catch (Exception e) {}
 
            } else if (value.isJsonObject()) {
                cipherValue(value.getAsJsonObject(), isEncrypt);
 
            } else if (value.isJsonArray()) {
                JsonArray jsonArray = value.getAsJsonArray();
                JsonElement jsonElement;
                for (int i = 0; i < jsonArray.size(); i++) {
                    jsonElement = jsonArray.get(i);
                    cipherValue(jsonElement.getAsJsonObject(), isEncrypt);
                }
            }
        }
        return jsonObject.toString();
    }
}
