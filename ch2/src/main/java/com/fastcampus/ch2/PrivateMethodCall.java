package com.fastcampus.ch2;

import java.lang.reflect.Method;	// �޼ҵ� ���� �� ���

public class PrivateMethodCall {
	public static void main(String[] args) throws Exception{
//		Hello hello = new Hello();
//		hello.main();	// private�� �ܺ� ȣ�� �Ұ�
		
		// Reflection API�� ��� - Ŭ���� ������ ��� �ٸ� �� �ִ� ������ ��� ����
		// java.lang.reflect��Ű���� ����
		// HelloŬ������ Class��ü(Ŭ������ ������ ��� �ִ� ��ü)�� ���´�.
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");
		Hello hello = (Hello)helloClass.newInstance(); // newInstance() : Class��ü�� ���� ������ ��ü ����
		
		// getDeclaredMethod()�� ���ڷ� �޼ҵ��� �Ķ���� ������ �Ѱ��ָ� ��ġ�ϴ� ���� ã���ݴϴ�.
		Method main = hello.getClass().getDeclaredMethod("main");
		main.setAccessible(true); // private�� main()�� ȣ�� �����ϰ� �Ѵ�.
		
		main.invoke(hello);		// hello.main()�� ������.
	}
}