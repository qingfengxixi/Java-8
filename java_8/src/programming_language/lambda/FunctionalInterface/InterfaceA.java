package programming_language.lambda.FunctionalInterface;

/*
 * 用 @FuctionalInterface 注解显示声明接口为函数式接口
 * 如果接口定义不符合函数式接口规范，就会报错
 */
@FunctionalInterface
public interface InterfaceA {
	//不接收参数，不返回值，且是接口 InterfaceA 的唯一一个抽象方法
	public void noParamsAndReturns();
}
