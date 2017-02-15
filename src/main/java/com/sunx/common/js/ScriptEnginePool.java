package com.sunx.common.js;

import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import javax.script.*;
import java.util.Map;

/**
 * 解析器池
 */
public class ScriptEnginePool {
    //构造对象数
    private static int OBJECT_POOL_MAX_NUM = 150;
    //ScriptEngine对象池
    private GenericObjectPool<ScriptEngine> pool = null;
    //对象构建工厂
    private ScriptEngineFactory scriptEngineFactory = null;

    /**
     * 构造函数初始化对象池
     */
    public ScriptEnginePool(){
        pool = initPool();
    }

    /**
     * 构造对象池
     * @return
     */
    private GenericObjectPool<ScriptEngine> initPool(){
        scriptEngineFactory = new ScriptEngineFactory();
		//对象工厂
		GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxTotal(OBJECT_POOL_MAX_NUM); //整个池最大值
        config.setMaxWaitMillis(1000); //获取不到永远不等待
        config.setTimeBetweenEvictionRunsMillis(5 * 60 * 1000L); //-1不启动。默认1min一次
        config.setMinEvictableIdleTimeMillis(10 * 60000L); //可发呆的时间,10mins

        return new GenericObjectPool<ScriptEngine>(scriptEngineFactory,config);
	}

    /**
     * 获取数据
     * @return
     */
    public ScriptEngine get(){
        try {
            return pool.borrowObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 回收数据
     * @param engine
     */
    public void recycle(ScriptEngine engine){
        engine.getBindings(ScriptContext.ENGINE_SCOPE).clear();
        pool.returnObject(engine);
    }
    /**
     * 关闭对象池
     */
    public void close(){
        pool.close();
    }
    /**
     * 清空对象池
     */
    public void clear(){
        pool.clear();
    }

    /**
     * 根据指定的引擎和解析器
     * @param engine
     * @param script
     * @param param
     * @throws Exception
     */
    public void runExtractor(ScriptEngine engine,String script,Map<String,Object> param) throws Exception{
        CompiledScript compiled =  ((Compilable) engine).compile(script);
        SimpleBindings bindings = new SimpleBindings(param);
        compiled.eval(bindings);
    }

    /**
     *
     * @param engine
     * @param script
     * @param method
     * @param param
     * @throws Exception
     */
    public void runExtractor(ScriptEngine engine,String script,String method,Map<String,Object> param) throws Exception{
        runExtractor(engine,script,method,new SimpleBindings(param));
    }

    /**
     * 根据指定的参数来进行执行js
     * @param engine
     * @param script
     * @param method
     * @param bindings
     */
    public void runExtractor(ScriptEngine engine,String script,String method,Bindings bindings) throws  Exception{
        runExtractor(engine,((Compilable) engine).compile(script),method,bindings);
    }

    /**
     * 执行数据
     * @param engine
     * @param compiled
     * @param method
     * @param bindings
     * @throws Exception
     */
    public void runExtractor(ScriptEngine engine,CompiledScript compiled,String method,Bindings bindings) throws Exception{
        ScriptContext context = engine.getContext();
        context.setBindings(bindings,ScriptContext.ENGINE_SCOPE);
        runExtractor(engine,compiled,method,context);
    }

    /**
     *
     * @param engine
     * @param compiled
     * @param context
     */
    public void runExtractor(ScriptEngine engine,CompiledScript compiled,String method,ScriptContext context) throws Exception{
        compiled.eval(context);
        Invocable inv = (Invocable)engine;
        inv.invokeFunction(method);
    }
}
