package org.restjson.json.deserialize;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtils {

    private static ObjectMapper mapper = new ObjectMapper();

    static <T> T deserializeString(String json, T t) throws IOException {
        if (!validateJSON(json)) {
            throw new IllegalArgumentException("Unparseable Input String");
        }
        return constructObject(json, t);
    }

    private static <T> T constructObject(String json, T t) throws IOException {
        return (T) mapper.readValue(json, t.getClass());
    }

    static <T> List<T> deserializeArray(String json, T t) throws IOException {
        if (!checkIsValidJSONArray(json)) {
            throw new IllegalArgumentException("Unparseable Input String");
        }
        return constructListOfObjects(json, t);
    }

    private static <T> List<T> constructListOfObjects(String json, T t) throws IOException {
        JavaType listType = mapper.getTypeFactory().constructCollectionType(List.class, t.getClass());
        return mapper.readValue(json, listType);
    }

    public static boolean validateJSON(String input) {
        try {
            new JSONObject(input);
        } catch (JSONException ex) {
            return false;
        }
        return true;
    }

    public static boolean checkIsValidJSONArray(String input) {
        try {
            new JSONArray(input);
        } catch (JSONException ex1) {
            return false;
        }
        return true;
    }
}