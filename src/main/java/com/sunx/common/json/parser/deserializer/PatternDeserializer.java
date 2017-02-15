package com.sunx.common.json.parser.deserializer;

import java.lang.reflect.Type;
import java.util.regex.Pattern;

import com.sunx.common.json.parser.JSONToken;
import com.sunx.common.json.parser.DefaultJSONParser;

public class PatternDeserializer implements ObjectDeserializer {
    public final static PatternDeserializer instance = new PatternDeserializer();

    @SuppressWarnings("unchecked")
    public <T> T deserialze(DefaultJSONParser parser, Type clazz, Object fieldName) {
        Object value = parser.parse();

        if (value == null) {
            return null;
        }
        
        String pattern = (String) value;
        
        return (T) Pattern.compile(pattern);
    }

    public int getFastMatchToken() {
        return JSONToken.LITERAL_STRING;
    }
}
