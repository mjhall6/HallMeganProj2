/**
 * CSCI463ProjectTwo: Use MyStack and MyQueue to write a project that check if a sentence is palindrom
 * 
 * @author Megan Hall
 * @version 02-18-2023
 */
import java.util.Scanner;

public class HallMeganProj2
{
    public static void main(String [] args)
    {
        Scanner input = new Scanner(System.in);
        String sentence;
        String again;
        do{
            System.out.println("Enter a sentence, I will tell you if it is a palindrome: ");
            sentence = input.nextLine();
            if(isPalindrome(sentence))
                System.out.println("\"" + sentence + "\" is a palindrome!");
            else
                System.out.println("\"" + sentence + "\" is not a palindrome!");
            System.out.println("Do you want another test (\"YES\" or \"NO\"): ");
            again = input.nextLine();
        }while(again.equalsIgnoreCase("YES"));
        
    }
    
    /**
     * isPalindrom returns true if the given String is a palindrom
     * @
     */
    public static boolean isPalindrome(String sentence)
    {
        // declare a MyStack s
        MyStack<Character> s = new MyStack<Character>();
        // declare a MyQueue q
        MyQueue<Character> q = new MyQueue<Character>();
        
        for(int i = 0; i < sentence.length(); i++)
        {
            // if ith character in sentence is a letter
                // convert to upper case and push it into s and q
                if(Character.isLetter(sentence.charAt(i))){
                    char c = Character.toUpperCase(sentence.charAt(i));
                    s.push(c);
                    q.push(c);
                }
        }
        while(!s.isEmpty()){
            // if the front of the queue not match the top of stack
                // return false
                if(s.peek() != q.peek()){
                    return false;
                }
            // pop out top of the stack and front of the queue
            s.pop();
            q.pop();
        }
        return true;
    } 
}