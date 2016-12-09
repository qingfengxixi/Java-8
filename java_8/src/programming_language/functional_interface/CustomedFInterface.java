package programming_language.functional_interface;

//自定义函数式接口
@FunctionalInterface
public interface CustomedFInterface {
	//接口中只定义了一个抽象方法
	public abstract void helloWorld();
	//接口中可以有默认方法和静态方法
	public default void defaultMethod(){
		System.out.println("this is default method...");
	}
}
