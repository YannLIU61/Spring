package aop.xml;


public class CaculatorImp implements Caculator {

	public int add(int a, int b) {
		return a + b;
	}

	public int sub(int a, int b) {
		return a - b;
	}

	public int mul(int a, int b) {

		return a * b;
	}

	public int div(int a, int b) {	
		return  a / b;
	}


}
