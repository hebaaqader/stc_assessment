import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        // ****** In case you want to enter the input string by yourself

        // Scanner scanner = new Scanner(System.in);
        // System.out.println("Enter input string: ");
        // String inputString = scanner.nextLine();
        // scanner.close();
        // StringBuilder resultString = reverseBetweenParentheses(inputString);
        // System.out.println("Result is: "+ resultString.toString());

        // ******** printing the given test cases

        String inputs[] = {"abd(jnb)asdf", "abdjnbasdf" , "dd(df)a(ghhh)"};
        for (String input : inputs) {
            System.out.println("Input: " + input);
            System.out.println("Output: " + reverseBetweenParentheses(input) + "\n");

        }


    }

    private static StringBuilder reverseBetweenParentheses(String inputString) {
        
        StringBuilder resultString = new StringBuilder();
        StringBuilder subStringToReverse = new StringBuilder();
        boolean openFlag = false;

        for( int i=0; i<inputString.length() ; i++){
            char currentChar = inputString.charAt(i);
            if(currentChar == '('){
                openFlag = true;
                resultString.append(currentChar);
                subStringToReverse = new StringBuilder();
            } else if(currentChar == ')'){    
                openFlag = false;
                resultString.append(subStringToReverse.reverse());
                resultString.append(currentChar);
            } else {
                if(openFlag){
                    subStringToReverse.append(currentChar);
                } else {
                    resultString.append(currentChar);
                }          
            }
        }
        return resultString;

    }

}
