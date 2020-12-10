public class StringCalculator {
    public int add(String numbers) {
        if(numbers.length() == 0) return 0;

        String input[] = numbers.split(",|\n");
        int sum=0;
        for(String i:input){
            try{
            sum += Integer.parseInt(i);
            }
            catch(Exception e){
                System.out.println("Invalid Input");
                System.out.println(e);
                return Integer.MIN_VALUE;
            }
        }
        return sum;
    }
}
