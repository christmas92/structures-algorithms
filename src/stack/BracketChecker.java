package stack;

public class BracketChecker {
	private String input;
	
	public BracketChecker(String input) {
		//this.input = new char[input.length()];
		this.input = input;
	}
	
	public void check(){
		StackX x = new StackX(input.length());
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			switch (ch) {
			case '(':
			case '[':
			case '{':
				x.push(ch);
				break;
			case ')':
			case ']':
			case '}':
				if(!x.isEmpty()){
					char chx = x.pop();
					if ((chx == '(' && ch != ')') || (chx == '[' && ch != ']') || (chx == '{' && ch != '}')) {
						System.out.println("not correct, " + chx + " doesn't match " + ch + ", " + ch + " at " + i);
						return;
					}
				}else {
					System.out.println("not correct, nothing matches final " + ch);
					return;
				}	
				break;
			default:
				break;
			}
		}
		if(!x.isEmpty()){
			System.out.println("not correct, nothing matches opening " + x.peek());
		}else {
			System.out.println("correct");
		}
	}
	
	public static void main(String[] args) {
		String str1 = "c[d]";
		String str2 = "a{b[c]d}e";
		String str3 = "a{b(c]d}e";
		String str4 = "a[b(c)d]e}";	
		String str5 = "a{b[c]";
		BracketChecker checker = new BracketChecker(str5);
		checker.check();
	}
}
