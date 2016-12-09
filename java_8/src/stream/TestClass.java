package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import stream.classes.Developer;
import stream.classes.EntityA;

public class TestClass {
	/*
	 * min 和 max:在 Stream 中 min/max 函数接收 Comparactor 比较器参数
	 * 求出流中最小值/最大值，但是如果我们直接调用 Math::min 或 Integer::min
	 * 就会出现问题，具体原因文章中已经做了相关介绍，请查看
	 */
	@Test
	public void test_10(){
		Optional min1 = Arrays.asList(12,2,5,33).stream().min(Math::min);
		Optional min2= Arrays.asList(12,2,5,33).stream().min((m,n)->m>n?1:-1);
		System.out.println("min1 :" + min1.get());
		System.out.println("min2 :" + min2.get());
	}
	
	@Test
	public void test_09(){
		//字符串拼接 : AbCz
		String concat = Stream.of("A","b","C","z").reduce("", String::concat);
		//过滤，拼接 : AC
		String filterConcat = Stream.of("A","b","C","z")
				.filter(n -> n.compareTo("Z") < 0)
				.reduce("", String::concat);
		//求取最小值 : -2
		int min = Stream.of(1,2,5,10,-2)
				.reduce(Integer.MAX_VALUE, Integer::min);
		//求取最大值 : 10
		int max = Stream.of(1,2,5,10,-2)
				.reduce(Integer.MIN_VALUE, Integer::max);
		//求和 : 16
		int sum = Stream.of(1,2,5,10,-2)
				.reduce(0, (n,m) -> n+m);
		int sum1 = Stream.of(1,2,5,10,-2)
				.reduce(0, Integer::sum);
		System.out.println("concat :" + concat);
		System.out.println("filterConcat :" + filterConcat);
		System.out.println("min :" + min);
		System.out.println("max :" + max);
		System.out.println("sum :" + sum);
		System.out.println("sum1 :" + sum1);
	}
	
	@Test
	public void test_08(){
		Object[] str = Stream.of("abfgfsdg","acgfg","aderewr","betyjyj")
		.map(String::toUpperCase)
		.unordered()
		//为什么不写 collect 方法，就无法打印
		.toArray();
		
		Arrays.stream(str).forEach(n -> System.out.println(n));
		
	}
	
	@Test
	public void test_07(){
		List<Integer> str = Arrays.asList(1,8,3,4,6);
		str.stream()
		/*
		 * 按照自定自定义规则排序
		 */
		.sorted((p1,p2) -> Integer.compare((p1>3?p1-2:p1*p1), (p2>3?p2-2:p2*p2)))
		.forEach(m -> System.out.println(m));
	}
	
	@Test
	public void test_06(){
		List<String> str = Arrays.asList("java","javascript","c++","c++");
		str.stream()
		/*
		 * 过滤出元素中包含字母 c 的元素
		 */
		.filter(n -> n.contains("c"))
		.distinct()
		.forEach(m -> System.out.println(m));
	}
	
	@Test
	public void test_05(){
		List<String> str = Arrays.asList("java","javascript","c++");
		str.stream()//获取 Stream 对象
		.map(String::toUpperCase)//将字母转为大写
		.forEach(n -> System.out.println(n));//遍历打印输出
	}
	
	@Test
	public void test_04(){
		/*
		 * 开发团队：程序员 = 1：n
		 * 程序员：开发语言 = 1：n
		 */
		List<Developer> team = new ArrayList<Developer>();
		Developer developer = new Developer();
		developer.setName("Bob");
		developer.setLanguages(Arrays.asList("java","javascript","pytho"));
		Developer developer1 = new Developer();
		developer1.setName("Tom");
		developer1.setLanguages(Arrays.asList("matlab","Chinese"));
		team.add(developer);
		team.add(developer1);
		
		List<String> teamLanguages = team.stream()//List.stream()获取流对象
				.map(d -> d.getLanguages())//获取开发人员的开发语言，开发语言是 List 对象
				/*
				 * flatMap是将多个输入流中的内容按照一定的规则匹配到一个输入流中
				 * l 代表程序要对象中的开发语言List集合，这里有两个List作为输入流
				 * flatMap是将两个List(language)中的内容放到一个 Stream 中返回
				 * 
				 * 这里的规则时：字符串的长度要大于5
				 */
				.flatMap(l -> l.stream().filter(s -> s.length() > 5))
				.collect(Collectors.toList());//可以通过 collect() 方法获取 List Map Set
		teamLanguages.forEach(n -> System.out.println(n));
	}
	
	
	
	//通过集合
	public void test_03(){
		List<String> list = new ArrayList<String>();
		Stream stream = list.stream();
		//Map 没有 stream() 方法
		Map<String,String> map = new HashMap<String,String>();
	}
	
	//通过数组
	public void test_02(){
		String[] strArray = new String[]{"a","b","v","b"};
		Stream stream = Arrays.stream(strArray);
		//1 代表元素的开始位置，2 代表元素的结束位置：既 strArray[1] - strArray[2]
		Stream stream2 = Arrays.stream(strArray,1,2);
	}
	
	/*
	 * 通过
	 * ① Stream.of(T... arg0)
	 * ② Stream.of(T arg0)
	 * 方法创建 Stream对象
	 */
	@Test
	public void test_01(){
		//直接向方法中传入多个参数：String int...
		Stream streamByStr = Stream.of("a","b","C");
		Stream streamByInt = Stream.of(1,6,3);
		//自定义类对象
		EntityA a = new EntityA();
		a.setName("Bob");
		Stream streamByObj = Stream.of(a);
		//数组对象 Array
		String[] strArrays = new String[] {"adf","b","F"};
		Stream streamByArr = Stream.of(strArrays);
		//集合 Collection
		List<String> list = new ArrayList<String>();
		Stream streamByList = Stream.of(list);
		Map<String,String> map = new HashMap<String,String>();
		Stream streamByMap = Stream.of(map);
	}

}
