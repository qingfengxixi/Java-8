package programming_language.interface_enhance;
/*
 *在实现类中，我们只需要实现接口中抽象方法，可以直接继承默认方法
 */
public class Class_01 implements Interface_01,Interface_02 {
	@Override
	public void method_01() {
		System.out.println("Class_01 method_01 from Interface_01...");
	}

	@Override
	public void method_02() {
		System.out.println("Class_01 method_02 from Interface_02...");
	}
	//因为 Interface_01 和 Interface_02 中同时存在 defaultMethod 方法
	@Override
	public void defaultMethod() {
		//调用 Interface_01 接口的默认方法
		Interface_01.super.defaultMethod();
		//自己实现
		System.out.println("Class_01 defaultMethod...");
	}
}
