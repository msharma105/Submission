import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StringInput {

	public static void main(String[] args) {
		String s = "2-3/4";    //Input  string
		int slen = s.length();
		Stack<Integer> ch = new Stack<Integer>();
		Stack<String> in = new Stack<String>();
		LinkedList<String> list = new LinkedList<String>();
		int iterate = 0;
		while (iterate < slen) {

			String token = getIntFun(s, iterate);
			iterate += token.length();

			list.push(token);
		}

		String prevChar = "";
		for (int i = list.size() - 1; i >= 0; i--) {
			boolean isNumeric = true;
			int elem = 0;
			String elemS = list.get(i);
			// System.out.println(list);
			// System.out.println(elemS);
			try {
				elem = Integer.parseInt(elemS);
			} catch (NumberFormatException e) {
				isNumeric = false;
			}
			// System.out.println(isNumeric);
			if (isNumeric) {
				ch.push(elem);
			} else {
				if (precedence(prevChar) > precedence(elemS)) {
					ch.push(calculate(ch.pop(), ch.pop(), in.pop()));
				}
				in.push(elemS);
				prevChar = elemS;
			}
		}
		// System.out.println(ch.size());
		while (ch.size() > 1) {
			int ans = calculate(ch.pop(), ch.pop(), in.pop());
			ch.push(ans);
		}
		System.out.println(ch.pop());

	}

	public static String getIntFun(String s, int start) {
		StringBuffer a = new StringBuffer();
		int i = 0;
		for (i = start; i < s.length(); i++) {
			if ((s.charAt(i) != '+') && (s.charAt(i) != '-') && (s.charAt(i) != '*') && (s.charAt(i) != '/')) {
				a.append(s.charAt(i));	
			} else
				break;

		}
		if (a.length() == 0) {
			a.append(s.charAt(i));
			
		}
		return a.toString();

	}

	public static int precedence(String op) {
		if (op.equals("*") || op.equals("/"))
			return 2;
		else
			return 1;

	}

	public static int calculate(Integer operand1, Integer operand2, String operator) {
		switch (operator) {
		case "+":
			return (operand1 + operand2);

		case "-":
			return (operand2 - operand1);
		case "*":
			return (operand1 * operand2);
		case "/":
			return (operand2 / operand1);

		}
		return 1;

	}
}