package nashorn;

import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.junit.Test;

public class TestClass {
	/*
	 * 测试：限制类调用(延后)
	 */
	@Test
	public void test_07() throws Exception{
		
	}
	
	
	/*
	 * 测试：调用父类方法
	 */
	@Test
	public void test_06() throws Exception{
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		engine.eval(new FileReader("src/main/java/jdk_01/nashorn/test_04.js"));
		Invocable invocable = (Invocable)engine;
		invocable.invokeFunction("fun2");
	}
	
	/*
	 * 测试：继承具体类
	 */
	@Test
	public void test_05() throws Exception{
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		engine.eval(new FileReader("src/main/java/jdk_01/nashorn/test_04.js"));
		Invocable invocable = (Invocable)engine;
		invocable.invokeFunction("fun1");
	}
	
	/*
	 * 测试：继承抽象类
	 */
	@Test
	public void test_04() throws Exception{
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		engine.eval(new FileReader("src/main/java/jdk_01/nashorn/test_03.js"));
		Invocable invocable = (Invocable)engine;
		invocable.invokeFunction("fun1");
	}
	
	/*
	 * 测试：实现接口
	 */
	@Test
	public void test_03() throws Exception{
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		engine.eval(new FileReader("src/main/java/jdk_01/nashorn/test_02.js"));
		Invocable invocable = (Invocable)engine;
		invocable.invokeFunction("fun1");
	}
	
	/*
	 * 测试：Js 调用自定义 Java 类
	 */
	@Test
	public void test_02() throws Exception{
		//通过脚本引擎工厂创建脚本引擎对象
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		//将 js 文件加载到引擎中
		engine.eval(new FileReader("src/main/java/jdk_01/nashorn/test_01.js"));
		//将引擎对象转为 Invocable 对象
		Invocable invocable = (Invocable)engine;
		//通过 Invocable 的 invokeFunction 来调用 js 中的方法
		invocable.invokeFunction("fun1");
//输出结果：
//		this is test_01.js hello Peter
//		hello Bob
	}
	/*
	 * 测试：Java 调用 Js 方法
	 * 为了调用函数，首先需要将脚本引擎转换为 Invocable。Invocable 
	 * 接口由 NashornScriptEngine 实现，并定义了 invokeFunction 
	 * 方法来调用指定名称的 JavaScript 函数。
	 * 问题：javax.script 类库介绍
	 */
	@Test
	public void test_01() throws Exception{
		//通过脚本引擎工厂创建脚本引擎对象
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		//将 js 文件加载到引擎中
		engine.eval(new FileReader("src/main/java/jdk_01/nashorn/test.js"));
		//将引擎对象转为 Invocable 对象
		Invocable invocable = (Invocable)engine;
		//通过 Invocable 的 invokeFunction 来调用 js 中的方法
		Object result = invocable.invokeFunction("fun1", "Peter");
		System.out.println(result);
		System.out.println(result.getClass());

//输出结果：
//		hello Peter
//		greeting from js
//		class java.lang.String
	}
}
