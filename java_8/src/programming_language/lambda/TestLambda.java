package programming_language.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/*
 * 该类主要是为了演示 Lambda 表达式“传递行为而不是传递值”的特性
 */
public class TestLambda {
	
	/**
	 * 求符合条件的所有元素加和
	 * @param numbers
	 * @param p
	 * @return
	 */
	public static int sum(List<Integer> numbers,Predicate<Integer> p){
		int total = 0;
		for(int number : numbers){
			//p.test() 方法根据指定的规则，验证number是否有效
			if(p.test(number)){
				total += number;
			}
		}
		return total;
	}
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
		/*
		 * 1:向 sum 方法传入两个参数一个是 List 另一个是 Lambda 表达式
		 * 2：n -> true 是告诉 Java 底层（※底层是什么※）传入一个参数 n 返回结果为 true
		 * 3：当底层调用 Predicate 的 test 方法时，接收参数 n 返回结果 true
		 */
		int sumAll = sum(numbers,n -> true);
		/*
		 * 1:向 sum 方法传入两个参数一个是 List 另一个是 Lambda 表达式
		 * 2：n -> true 是告诉 Java 底层传入一个参数 n 返回结果根据  n%2 == 0 来判断
		 * 3：当底层调用 Predicate 的 test 方法时，接收参数 n 返回结果 true或者false
		 */
		int sumEven = sum(numbers,n -> n % 2 == 0);
		/*
		 * 1:向 sum 方法传入两个参数一个是 List 另一个是 Lambda 表达式
		 * 2：n -> true 是告诉 Java 底层传入一个参数 n 返回结果根据  n > 3 来判断
		 * 3：当底层调用 Predicate 的 test 方法时，接收参数 n 返回结果 true或者false
		 */
		int sumGreaterThree = sum(numbers,n -> n > 3);
		System.out.println(sumAll + ":" + sumEven + ":" + sumGreaterThree);
	}
}
