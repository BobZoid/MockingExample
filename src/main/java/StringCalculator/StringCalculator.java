package StringCalculator;


import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    private List<Integer> toInt(String input) {
        String[] numbersAsString = input.split(",");
        List<Integer> numbersAsInt = new ArrayList<>();
        for (String str: numbersAsString) {
            String strong=str.trim();
            int value = Integer.parseInt(strong);
            numbersAsInt.add(value);
        }
        return numbersAsInt;
    }


    public int add(String inputNum) {
        List<Integer> numbersAsInt = toInt(inputNum);
        Integer sum=0;
        for (Integer num: numbersAsInt) {
            sum+=num;
        }
        return sum;
    }

}
