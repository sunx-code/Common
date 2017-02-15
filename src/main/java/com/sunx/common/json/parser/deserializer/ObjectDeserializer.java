package com.sunx.common.json.parser.deserializer;

import java.lang.reflect.Type;

import com.sunx.common.json.parser.DefaultJSONParser;

public interface ObjectDeserializer {
    <T> T deserialze(DefaultJSONParser parser, Type type, Object fieldName);
    
    int getFastMatchToken();
}
