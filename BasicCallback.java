package basiccallback;

interface ResultListener{
    void onSuccess();
    void onFail();
}

class NumberReq{
    
    /**
     * first number to compare
     */
    private int num1;
  
    /**
     * second number to compare
     */
    private int num2;
  
    /**
     * interface "object" that will response when comparation has been finished
     */
    private ResultListener firstListener;
    
    NumberReq(int num1, int num2){
        this.num1 = num1;
        this.num2 = num2;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }
    
    /**
     * checkMajor is a method that, given an interface "object" will
     * execute other checkMajor method
     */
    public void checkMajor(ResultListener firstListener){
        this.firstListener = firstListener;
        checkMajor();
    }
    
    /**
     * compares instantializate  attributes
     * if first number is major than second, calls onSuccess method of interface
     * this will be listened by the parameter of checkMajor
     */
    private void checkMajor(){
        if(num1>num2){
            this.firstListener.onSuccess();
        }else{
            this.firstListener.onFail();
        }
    }
    
}

public class BasicCallback {
  
    public static void main(String[] args) {
      
        NumberReq n = new NumberReq(15,12);
        n.checkMajor(new ResultListener(){
            @Override
            public void onSuccess() {
                console("Number " + n.getNum1() + " > " + n.getNum2());
            }

            @Override
            public void onFail() {
                console(n.getNum1() + " IS NOT MAJOR THAN " + n.getNum2());
            }
            
        });
    }
    
    public static void console(String t){
        System.out.println(t);
    }
    
}
