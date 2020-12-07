import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import javax.lang.model.util.ElementScanner6;

/**
 * 
 */
public class BalanceBrackets {


    /**
     * If a string is balanced, return true, otherwise, return false.
     * Runtime O(n)
     */
    static boolean isBalanced(String s) {

        // **** sanity check(s) ****
        if (s.length() == 0)
            return true;

        if (s.length() == 1)
            return false;

        // **** initialization ****
        Stack<Character> stack = new Stack<>();

        // **** process the string one character at a time ****
        for (char ch : s.toCharArray()) {

            // **** closing bracket (pop from stack)****
            if (ch == ')' || ch == ']' || ch == '}') {

                // **** check if stack is empty ****
                if (stack.isEmpty())
                    return false;

                // **** pop top from stack (if matching) ****
                if (ch == ')' && stack.peek() == '(')
                    stack.pop();
                else if (ch == ']' && stack.peek() == '[')
                    stack.pop();
                else if (ch == '}' && stack.peek() == '{')
                    stack.pop();
                else 
                    return false;
            }

            // **** opening bracket (push to stack) ****
            else if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }

            // **** not a bracket ****
            else {
                System.out.println("isBalanced <<< unexpected ch: " + ch);
                return false;
            }
        }

        // **** check if stack is not empty ****
        if (!stack.isEmpty())
            return false;

        // **** brackets are balanced ****
        return true;
    }


    /**
     * Test scaffolding
     * 
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read line ****
        String s = br.readLine().trim();

        // **** close buffered reader ****
        br.close();

        // ???? ????
        System.out.println("main <<< s ==>" + s + "<==");

        // **** process string and display result ****
        System.out.println("main <<< isBalanced: " + isBalanced(s));
    }
}