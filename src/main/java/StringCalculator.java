public class StringCalculator {
    public int add(String numbers) {
        if(numbers.length() == 0) return 0;
        String delimiter = ",|\n";
        if(numbers.startsWith("//"))
        try{
        delimiter = numbers.substring(numbers.indexOf("//")+2,numbers.indexOf("\n"));
        numbers = numbers.substring(numbers.indexOf("\n")+1);
        }
        catch(Exception e){
            return exceptionHandler(e);
        }

        if(!delimiter.contains("\n"))delimiter += "|\n";

        String input[] = numbers.split(delimiter);
        int sum = 0;
        String negatives="";
        for(String i:input){
            try{
            int n = Integer.parseInt(i);
            if(n<0){
                if(negatives.length()==0)
                negatives += n;
                else
                negatives += ","+n;
            }
            if(negatives.length() == 0)sum += n;
            }
            catch(Exception e){
                return exceptionHandler(e);
            }
        }
        if(negatives.length()>0){
            throw new IllegalArgumentException("Negatives not allowed: " + negatives);
        }
        return sum;
    }

    public int exceptionHandler(Exception e){
        System.out.println("Invalid Input");
        System.out.println(e);
        return Integer.MIN_VALUE;
    }
}
