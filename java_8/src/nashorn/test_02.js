

function fun1 (){
	var TestImpInterface = Java.type("jdk_01.nashorn.TestImpInterface");
	var obj = new TestImpInterface(){
		say : function(){
			print("hello...")
		}
	}
	obj.say();
	
}
