package programming_language.interface_enhance;

public interface Interface_01 {
	//抽象方法
	public void method_01();
	//通过 default 关键字声明定义默认方法，然后实现
	public default void defaultMethod(){
		System.out.println("Interface_01 defaultMethod...");
	}
	//通过 static 关键字声明定义静态方法，然后实现
	public static void staticMethod(){
		System.out.println("Interface_01 staticMethod...");
	}
}
