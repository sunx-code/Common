package com.sunx.common.json.serializer;

public interface NameFilter extends SerializeFilter {
    String process(Object source, String name, Object value);
}
