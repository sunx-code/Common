package com.sunx.common.json.parser.deserializer;

import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;

import com.sunx.common.json.parser.JSONToken;
import com.sunx.common.json.JSONException;
import com.sunx.common.json.parser.DefaultJSONParser;

public class URLDeserializer implements ObjectDeserializer {
    public final static URLDeserializer instance = new URLDeserializer();

    @SuppressWarnings("unchecked")
    public <T> T deserialze(DefaultJSONParser parser, Type clazz, Object fieldName) {
        
        String url = (String) parser.parse();
        
        if (url == null) {
            return null;
        }
        
        try {
            return (T) new URL(url);
        } catch (MalformedURLException e) {
            throw new JSONException("create url error", e);
        }
    }

    public int getFastMatchToken() {
        return JSONToken.LITERAL_STRING;
    }
}
