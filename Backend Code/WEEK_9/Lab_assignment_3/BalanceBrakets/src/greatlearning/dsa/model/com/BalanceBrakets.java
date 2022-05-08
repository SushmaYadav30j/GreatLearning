package greatlearning.dsa.model.com;
import java.util.Stack;

public class BalanceBrakets {
	
	public static boolean isBalanced(String Brackets) {

		int len = Brackets.length();
		if (len <= 0 || len % 2 != 0) {
			return false;
		}

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < len; i++) {
			char currentChar = Brackets.charAt(i);

			if (currentChar == '[' || currentChar == '{' || currentChar == '(') {
				stack.push(currentChar);
			} else if (!stack.isEmpty()) {
				if (currentChar == ']' || currentChar == '}' || currentChar == ')') {
					char top = stack.peek();
					boolean isParenthisis = top == '(' && currentChar == ')';
					boolean isFlower = top == '{' && currentChar == '}';
					boolean isSquare = top == '[' && currentChar == ']';

					if (isParenthisis || isFlower || isSquare) {
						stack.pop();
					} else {						
						return false;
					}
				}
			}
		}

		return stack.isEmpty();
	}
	public static void main(String args[]) {
		
		System.out.println("Are these Brackets balanced : " + isBalanced("({[]})"));
		System.out.println("Are these Brackets balanced : " + isBalanced("({[})"));
		System.out.println("Are these Brackets balanced : " + isBalanced("({[}})"));
	}
}
