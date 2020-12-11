public class StringCalculator {
    public int add(String numbers) {
        if(numbers.length() == 0) return 0;
        String delimiter = ",|\n";
        if(numbers.startsWith("//"))
        try{
            if(numbers.contains("[")){
                delimiter = numbers.substring(numbers.indexOf("[")+1,numbers.indexOf("]"));
            }
            else{
               delimiter = numbers.substring(numbers.indexOf("//")+2,numbers.indexOf("\n")); 
            }
            numbers = numbers.substring(numbers.indexOf("\n")+1);
        }
        catch(Exception e){
            return exceptionHandler(e);
        }

        delimiter = processDelimiterforRegex(delimiter);
        
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
            if(negatives.length() == 0 && n<=1000)sum += n;
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
    public String processDelimiterforRegex(String delimiter){
        if(delimiter.contains("+")||delimiter.contains("-")||delimiter.contains("*"))
        delimiter="\\Q"+delimiter+"\\E";
        
        if(!delimiter.contains("\n"))delimiter += "|\n";
        return delimiter;
    }
}
