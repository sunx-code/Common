package com.sunx.common.json.parser.deserializer;

import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;

import com.sunx.common.json.parser.DefaultJSONParser;
import com.sunx.common.json.parser.JSONLexer;
import com.sunx.common.json.parser.JSONToken;
import com.sunx.common.json.util.TypeUtils;

public class BooleanDeserializer implements ObjectDeserializer {

    public final static BooleanDeserializer instance = new BooleanDeserializer();

    @SuppressWarnings("unchecked")
    public <T> T deserialze(DefaultJSONParser parser, Type clazz, Object fieldName) {
        final JSONLexer lexer = parser.getLexer();

        Boolean boolObj;
        if (lexer.token() == JSONToken.TRUE) {
            lexer.nextToken(JSONToken.COMMA);
            boolObj = Boolean.TRUE;
        } else if (lexer.token() == JSONToken.FALSE) {
            lexer.nextToken(JSONToken.COMMA);
            boolObj = Boolean.FALSE;
        } else if (lexer.token() == JSONToken.LITERAL_INT) {
            int intValue = lexer.intValue();
            lexer.nextToken(JSONToken.COMMA);

            if (intValue == 1) {
                boolObj = Boolean.TRUE;
            } else {
                boolObj = Boolean.FALSE;
            }
        } else {
            Object value = parser.parse();

            if (value == null) {
                return null;
            }

            boolObj = TypeUtils.castToBoolean(value);
        }

        if (clazz == AtomicBoolean.class) {
            return (T) new AtomicBoolean(boolObj.booleanValue());
        }

        return (T) boolObj;
    }

    public int getFastMatchToken() {
        return JSONToken.TRUE;
    }
}
