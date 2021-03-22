package StringCalculator;


import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    private List<Integer> toInt(String input) {
        String[] numbersAsString = input.split("[,\n]");
        List<Integer> numbersAsInt = new ArrayList<>();
        for (String str: numbersAsString) {
            String strong=str.trim();
            int value = Integer.parseInt(strong);
            if (value<1001) numbersAsInt.add(value);
        }
        return numbersAsInt;
    }


    public int add(String inputNum){
        String input;
        if (inputNum.startsWith("//")) input=changeDelimiter(inputNum);
        else input=inputNum;
        if (input.equals("")) return 0;
        List<Integer> numbersAsInt = toInt(input);
        List<Integer> negatives = new ArrayList<>();
        numbersAsInt.stream().filter(x -> x<0).forEach(negatives::add);
        if (negatives.size()>0){
            throw new IllegalArgumentException("Negative values not allowed: " + negatives);
        }
        Integer sum=0;
        for (Integer num: numbersAsInt) {
            sum+=num;
        }
        return sum;
    }

    private String changeDelimiter(String inputNum) {
        String input = inputNum.substring(4);
        char delimiter = inputNum.charAt(2);
        if (delimiter==('[')) {
            input=customDelimiters(inputNum);
            return input;
        }
        input = input.replace(delimiter, ',');
        return input;
    }

    private String customDelimiters(String input) {
        int start;
        int end;
        while(true) {
            start = input.indexOf('[');
            end = input.indexOf(']');
            String delimiter =input.substring(start+1, end);
            input=input.substring(end+1);
            input=input.replace(delimiter, ",");
            if(input.charAt(0)!='[') break;

        }
        input=input.substring(1);
        return input;
    }


}
