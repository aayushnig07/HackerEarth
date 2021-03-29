package hackerEarth.basicProgramming.inputOutput;

/*
* Bob's crush's name starts with a vowel. That's the reason Bob loves vowels too much.
* He calls a string "lovely string" if it contains either all the lowercase vowels or all
* the uppercase vowels or both, else he calls that string "ugly string". */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestClass {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        while (testCases != 0) {
            String s = br.readLine();
            if (checkLovelyString(s)) {
                System.out.println("lovely string");
            } else {
                System.out.println("ugly string");
            }
            testCases--;
        }


    }

    private static boolean checkLovelyString(String s) {
        List<Character> lowerCaseVowels = Stream.of('a','e','i','o','u').collect(Collectors.toList());
        List<Character> upperCaseVowels = Stream.of('A','E','I','O','U').collect(Collectors.toList());

        if(s.length()<5){
            return false;
        }
        int lowerCount=0;
        int upperCount=0;
        for(Character item : s.toCharArray()){
            if(lowerCaseVowels.contains(item)){
                lowerCount++;
                lowerCaseVowels.remove(item);
            }
            if(lowerCount==5){
                return true;
            }
            else{
                if(upperCaseVowels.contains(item)){
                    upperCount++;
                    upperCaseVowels.remove(item);
                }
                if(upperCount==5){
                    return true;
                }
            }
        }
        return false;
    }
}
