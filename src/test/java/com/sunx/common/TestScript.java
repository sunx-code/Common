package com.sunx.common;

import com.sunx.common.js.ScriptEnginePool;
import org.junit.Before;
import org.junit.Test;

import javax.script.ScriptEngine;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sunxing on 2017/1/17.
 */
public class TestScript {
    private ScriptEnginePool pool = null;
    private String script = "function test(){out.println(str);}";

    @Before
    public void init(){
        pool = new ScriptEnginePool();
    }

    @Test
    public void test() throws Exception{
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("out", System.out);
        param.put("str","123");

        ScriptEngine engine = pool.get();
        pool.runExtractor(engine,script,"test",param);
    }
}
