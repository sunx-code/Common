package com.sunx.common.json.parser.deserializer;

import java.lang.reflect.Type;

import com.sunx.common.json.parser.JSONToken;
import com.sunx.common.json.JSONArray;
import com.sunx.common.json.parser.DefaultJSONParser;

public class JSONArrayDeserializer implements ObjectDeserializer {
    public final static JSONArrayDeserializer instance = new JSONArrayDeserializer();

    @SuppressWarnings("unchecked")
    public <T> T deserialze(DefaultJSONParser parser, Type clazz, Object fieldName) {
        JSONArray array = new JSONArray();
        parser.parseArray(array);
        return (T) array;
    }

    public int getFastMatchToken() {
        return JSONToken.LBRACKET;
    }
}
