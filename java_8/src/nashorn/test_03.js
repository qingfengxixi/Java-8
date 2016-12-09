
//通过构造函数形式继承抽象类
function fun1(){
	var AbsClass = Java.type("jdk_01.nashorn.TestExtAbsClass");
	var subClass = new AbsClass({
		hello : function(){
			print("fun1 : hell world!");
		}
	});
	subClass.hello();
}
//直接在 new 后面写参数
function fun2(){
	var AbsClass = Java.type("jdk_01.nashorn.TestExtAbsClass");
	var SubClass = new AbsClass{
		hello : function(){
			print("fun2 : hell world!");
		}
	}
	subClass.hello();
}
//如果抽象类只有一个抽象方法
function fun3(){
	var AbsClass = Java.type("jdk_01.nashorn.TestExtAbsClass");
	var SubClass = new AbsClass(function(){print("fun3 : hello world")});
	subClass.hello();
}