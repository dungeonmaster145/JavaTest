
public class StringCalculator {

    public int Add(String n){
        String numbers[]=n.split(",|\n");

        if(n.isEmpty())
            return 0;
        else if(n.length()>1)
        {
            return getSum(numbers);
        }
        return StringToInt(n);

    }
    public int getSum(String numbers[]){
        int sum=0;
        for(String number:numbers){
            if(StringToInt(number)>1000)
                continue;
            else
                sum+=StringToInt(number);
        }
        return sum;
    }
    public int StringToInt(String n){

        int num=Integer.parseInt(n);
        if (num < 0) {
            throw new IllegalArgumentException("Negative input!");
        }
        else {
            return num;
        }
    }
}