package programming_language.lambda;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import programming_language.lambda.FunctionalInterface.InterfaceA;
import programming_language.lambda.FunctionalInterface.InterfaceB;
import programming_language.lambda.FunctionalInterface.InterfaceC;

public class TestClasses {
	//##########################Lambda 表达式强制转换########################
	@Test
	public void test_08(){
		Object a = (InterfaceA) () -> System.out.println("this is interfaceA object");
		Object c = (InterfaceC) () -> System.out.println("this is interfaceC object");
	}
	
	public static String sayHello(InterfaceB b){
		return "hello " + b.paramAndReturn(); 
	}
	//##########################将 Lambda 表达式作为函数式接口类型参数传递给某方法#######
	//Lambda
	@Test
	public void test_07(){
		String result = sayHello(() -> "Alice");
		System.out.println(result);
	}
	//传统方式
	@Test
	public void test_06(){
		String result = sayHello(new InterfaceB(){
			@Override
			public String paramAndReturn() {
				return "Bob";
			}	
		});
		System.out.println(result);
	}
	
	
	
	@Test
	public void test_05(){
		//创建文件夹对象
		File directory = new File("F:\\zl");
		//################### 传统 #########################
		FileFilter fileFilter = new FileFilter(){
			@Override
			public boolean accept(File file) {
				if(file.getName().endsWith(".txt")){
					return true;
				}
				return false;
			}
		};
		File[] files = directory.listFiles(fileFilter);
		//################### Lambda #########################
		File[] files1 = directory.listFiles((f)->{
			if(f.getName().endsWith(".txt")){
				return true;
			}
			return false;
		});
		
		//打印
		for(File f : files){
			System.out.println(f.getName());
		}
		for(File f : files1){
			System.out.println(f.getName());
		}
	}
	
	@Test
	public void test_04(){
		List<String> names = (List) Arrays.asList("Bob","Tom","Lucy","Alice");
		//################### 传统 #########################
		Collections.sort(names,new Comparator<String>(){
			@Override
			public int compare(String str1, String str2) {
				return str1.compareTo(str2);
			}
		});
		//################### Lambda #########################
		Collections.sort(names,(m,n)->{return m.compareTo(n);});
		
		System.out.println(names.toString());
	}
	
	@Test
	public void test_03(){
		//################### 传统 #########################
		new Thread(new Runnable(){
			@Override
			public void run() {
				System.out.println("the thread has started...");
			}
			
		}).start();
		//################### Lambda #########################
		new Thread(()->System.out.println("the thread has started...")).start();
	}
	
	//传统方式
	@Test
	public void test_02(){
		InterfaceA a = new InterfaceA() {
			@Override
			public void noParamsAndReturns() {
				System.out.println("1");
				System.out.println("2");
				System.out.println("3");
				System.out.println("4");
				System.out.println("5");
			}
		};
		a.noParamsAndReturns();
	}
	
	//将 Lambda 表达式赋值给函数式接口类型的变量
	@Test
	public void test_01(){
		InterfaceA a = () -> {
			System.out.println("1");
			System.out.println("2");
			System.out.println("3");
			System.out.println("4");
			System.out.println("5");
		};
		a.noParamsAndReturns();
	}
}
