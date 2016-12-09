function fun1(){
	//通过 Java.type 方法获取类，并创建类类型
	var TestClass = Java.type("jdk_01.nashorn.TestClass_01");
	//调用类的静态方法
	var result = TestClass.fun1("Peter");
	print("this is test_01.js " + result);
	
	var test = new TestClass();
	//通过创建对象调用非静态方法
	var result1 = test.sayHi("Bob");
	print(result1);
}
