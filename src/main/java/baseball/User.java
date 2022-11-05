package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class User {
    public static ArrayList<Integer> userNumber;

    public static ArrayList<Integer> setUserNumber() throws IllegalArgumentException{
        String answer;
        userNumber = new ArrayList<>();

        inputMessage();
        answer = Console.readLine();

        verifyUserNumber(answer);

        return userNumber;
    }
    private static void inputMessage(){
        System.out.print("숫자를 입력해 주세요: ");
    }

    private static void verifyUserNumber(String answer)throws IllegalArgumentException{
            checkSize(answer);
            checkDigit(answer);
            addUserNumber(answer);
    }
    private static void addUserNumber(String answer)throws IllegalArgumentException{
        for(int i=0; i<answer.length(); i++){
            int answerChar = answer.charAt(i)-'0';
            if(userNumber.contains(answerChar)){
                throw new IllegalArgumentException("User Number dup error");
            }
            userNumber.add(answerChar);
        }
    }
    private static void checkSize(String answer) throws IllegalArgumentException{
        if(answer.length()!=3){
            throw new IllegalArgumentException("Size error");
        }
    }

    private static void checkDigit(String answer) throws IllegalArgumentException{
        for(int i=0; i<answer.length(); i++){
            char answerNum = answer.charAt(i);
            if(answerNum<48 || answerNum>57){
                throw new IllegalArgumentException("Digit error");
            }
        }
    }

    public static int finishInput() throws IllegalArgumentException {
        String finishNumber;

        finishNumber = Console.readLine();

        return verifyFinishNumber(finishNumber);
    }
    private static int verifyFinishNumber(String finishNumber)throws IllegalArgumentException{
        int restart=1;
        int exit=0;
        if(finishNumber.equals("1")){
            return restart;
        } else if(finishNumber.equals("2")){
            return exit;
        }
        throw new IllegalArgumentException("User Finish Input Error");
    }
}
