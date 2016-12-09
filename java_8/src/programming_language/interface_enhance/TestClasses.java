package programming_language.interface_enhance;

import org.junit.Test;

public class TestClasses {
	//测试：调用接口静态方法
	@Test
	public void test_03(){
		Interface_01.staticMethod();
	}
	//测试：同名默认方法
	@Test
	public void test_02(){
		Class_01 c = new Class_01();
		c.defaultMethod();
	}
	//测试：实现类继承接口中默认方法
	@Test
	public void test_01(){
		Class_01 c = new Class_01();
		//调用接口中的默认方法
		c.defaultMethod();
	}
}
