//继承具体类
function fun1(){
	var ExtendClass = Java.type("jdk_01.nashorn.TestExtConreteClass");
	var Extender = Java.extend(ExtendClass);
	var e = new Extender({
		hello : function(){
			print("this is e...")
		}
	});
	//说明 e 已经是一个类对象而不是一个类
	e.hello();
}

//调用父类方法
function fun2(){
	var ExtendClass = Java.type("jdk_01.nashorn.TestExtConreteClass");
	var Extender = Java.extend(ExtendClass);
	var e = new Extender({
		hello : function(){
			var _super_ = Java.super(e);
			_super_.hello();
		}
	});
	//说明 e 已经是一个类对象而不是一个类
	e.hello();
}