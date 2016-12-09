package programming_language.functional_interface;

import org.junit.Test;

public class TestClasses {
	/*
	 * 该内部类是为了方便测试自定义接口而创建的
	 */
	public class MyClass{
		private CustomedFInterface in;
		private FunctionalInterface_01 in2;
		
		public MyClass(){}
		/*
		 * 服务目标：test_03
		 * 内容：接收 FunctionalInterface_01 类型的参数
		 */
		public void setFunctionalInterface_01(FunctionalInterface_01 arg0){
			this.in2 = arg0;
		}
		/*
		 * 服务目标：test_03
		 * 内容：调用 FunctionalInterface_01 的抽象方法
		 */
		public void for_Test03(String name){
			String result = in2.abstractMehtod(name);
			System.out.println("for_Test03:" + result);
		}
		/*
		 * 服务目标：test_02
		 * 内容：接收 CustomedFInterface 类型的参数
		 */
		public MyClass(CustomedFInterface arg0){
			this.in = arg0;
		}
		/*
		 * 服务目标：test_02
		 * 内容：调用 CustomedFInterface 的抽象方法
		 */
		public void for_Test02(){
			in.helloWorld();
			System.out.println("for_Test02...");
		}
		
	}
	//测试：参数，多语句，返回值
	@Test
	public void test_03(){
		MyClass my = new MyClass();
		my.setFunctionalInterface_01((name)->{
			System.out.println("hello world");
			return "I'm " + name + "...";
		});
		my.for_Test03("Lisa");
	}
	//测试：使用自定义接口
	@Test
	public void test_02(){
		//Lambda 表达式
		MyClass my1 = new MyClass(()->System.out.println("Lambda CustomedFInterface helloWorld..."));
		my1.for_Test02();
		//传统方式	
		MyClass my2 = new MyClass(new CustomedFInterface(){
			@Override
			public void helloWorld() {
				System.out.println("traditional CustomedFInterface helloWorld...");
			}
		});
		my2.for_Test02();
	}
	//测试：函数式接口使用的传统方式
	@Test
	public void test_01(){
		Thread t = new Thread(new Runnable(){
			@Override
			public void run() {
				System.out.println("the traditional way to use functional interface...");
			}
		});
		t.start();
	}

}
