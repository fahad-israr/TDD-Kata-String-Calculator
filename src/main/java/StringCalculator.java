import java.util.ArrayList;
public class StringCalculator {
    public int add(String numbers) {
        if(numbers.length() == 0) return 0;
        String delimiter = ",|\n";
        ArrayList<String> allDelimiters=new ArrayList<String>();
        if(numbers.startsWith("//"))
        try{
            if(numbers.contains("[")){  
                String delimit[] = numbers.split("\\Q[\\E");
                for(String i:delimit){
                    if(i.equals("//"))continue;
                    String d=i.substring(0,i.indexOf("]"));
                    allDelimiters.add(processEscapeDelimiters(d));
                }

            }
            else{
               delimiter = numbers.substring(numbers.indexOf("//")+2,numbers.indexOf("\n")); 
            }
            numbers = numbers.substring(numbers.indexOf("\n")+1);
        }
        catch(Exception e){
            return exceptionHandler(e);
        }


        String processDelimitersList = processDelimiterforRegex(allDelimiters);
        if(processDelimitersList.length()>0)
        delimiter=processDelimitersList;

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
    public String processDelimiterforRegex(ArrayList<String> delimiter){
        return String.join("|",delimiter);

    }
    public String processEscapeDelimiters(String delimiter){
        if(delimiter.contains("+")||delimiter.contains("-")||delimiter.contains("*"))
        delimiter="\\Q"+delimiter+"\\E";
        return delimiter;
    }
}
