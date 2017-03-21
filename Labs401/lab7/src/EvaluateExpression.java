import java.util.Scanner;

/**
 * Created by shubhankar on 10/8/16.
 */
public class EvaluateExpression {
    public static void main(String[] args) {
        String postfix = EvaluateExpression.infixToPostfix();
        System.out.print("Corresponding postfix string: " + postfix + "\n");
        int evaluatedExpression = EvaluateExpression.EvaluatePostfix(postfix);
        System.out.print(evaluatedExpression);
    }

    public static int EvaluatePostfix(String postfix) {
        CS401StackLinkedListImpl<Integer> EvaluationStack = new CS401StackLinkedListImpl<>();

        System.out.print("Evaluation of postfix string: ");
        Scanner sc = new Scanner(postfix);
        String expression = sc.next();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            int cInt = (int) (c);
            if (c != '/' && c != '*' && c != '+' && c != '-') {
                EvaluationStack.push(cInt-48);
            }
            else if (c == '/') {
                int var1 = EvaluationStack.pop();
                int var2 = EvaluationStack.pop();
                int result = var2/var1;
                EvaluationStack.push(result);
            }
            else if (c == '*') {
                int var1 = EvaluationStack.pop();
                int var2 = EvaluationStack.pop();
                int result = var2*var1;
                EvaluationStack.push(result);
            }
            else if (c == '+') {
                int var1 = EvaluationStack.pop();
                int var2 = EvaluationStack.pop();
                int result = var2+var1;
                EvaluationStack.push(result);
            }
            else {
                int var1 = EvaluationStack.pop();
                int var2 = EvaluationStack.pop();
                int result = var2-var1;
                EvaluationStack.push(result);
            }
        }
        return EvaluationStack.pop();
    }


    public static String infixToPostfix() {
        CS401StackLinkedListImpl<Character> OperatorStack = new CS401StackLinkedListImpl<>();

        System.out.print("Enter infix string: ");
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String expression = sc.next();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c != '/' && c != '*' && c != '-' && c != '+') {
                sb = sb.append(c);
            }
            else {
                if (OperatorStack.peek() == null) {
                    OperatorStack.push(c);
                }
                else {
                    switch (c) {
                        case '/':
                            while (OperatorStack.peek() == '/' || OperatorStack.peek() == '*') {
                                char popValue = OperatorStack.pop();
                                sb = sb.append(popValue);
                                if(OperatorStack.is_empty()) break;
                            }
                            OperatorStack.push(c);
                            break;
                        case '*':
                            while (OperatorStack.peek() == '/' || OperatorStack.peek() == '*') {
                                char popValue = OperatorStack.pop();
                                sb = sb.append(popValue);
                                if(OperatorStack.is_empty()) break;
                            }
                            OperatorStack.push(c);
                            break;
                        case '+':
                            while (OperatorStack.peek() == '/' || OperatorStack.peek() == '*' || OperatorStack.peek() == '+' || OperatorStack.peek() == '-') {
                                char popValue = OperatorStack.pop();
                                sb = sb.append(popValue);
                                if(OperatorStack.is_empty()) break;
                            }
                            OperatorStack.push(c);
                            break;
                        case '-':
                            while (OperatorStack.peek() == '/' || OperatorStack.peek() == '*' || OperatorStack.peek() == '+' || OperatorStack.peek() == '-') {
                                char popValue = OperatorStack.pop();
                                sb = sb.append(popValue);
                                if(OperatorStack.is_empty()) break;
                            }
                            OperatorStack.push(c);
                            break;
                    }
                }
            }
        }
        while (OperatorStack.peek() != null) {
            sb = sb.append(OperatorStack.pop());
        }
        return sb.toString();
    }
}
