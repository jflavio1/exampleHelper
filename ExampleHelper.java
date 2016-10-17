package exampleHelper;

import java.util.ArrayList;
import java.util.Scanner;

class ArrayBit64Helper{
    public static ArrayList<String> getArray(String num){
        ArrayList<String> myArray = new ArrayList<>();
        for (int i = 0; i < num.length(); i++) {
            myArray.add(String.valueOf(num.charAt(i)));
        }
        return myArray;
    }
}

class CapicuaHelper{
    public static int getInteger(char integer){
        return (String.valueOf(integer).equals("")) ? 0: Integer.parseInt(String.valueOf(integer)) ;
    }
    public static boolean isCapicua(String num){
        boolean isCapicua = false;
        try{
            ArrayList<String> myArray = ArrayBit64Helper.getArray(num);
            ArrayList<String> myArray2 = ArrayBit64Helper.getArray(num);
            if(myArray != null){
                for (String n : myArray) {
                    isCapicua = n.equalsIgnoreCase(myArray2.get(myArray2.size()-1));
                    myArray2.remove(myArray2.size()-1);
                }
            }
            return isCapicua;
        }catch(Exception e){
            System.out.println(MessageHelper.ERROR_CALCULATING_MESSAGE);
            return isCapicua;
        }
       
    }
}

class MessageHelper{
    public static final String STARTER_MESSAGE = "Escribe algo para saber si es capicúa: ";
    public static final String ERROR_MESSAGE = "NO es capicúa";
    public static final String SUCCESS_MESSAGE = "Sí es capicúa";
    public static final String RESPONSE_MESSAGE = "Lo que escribiste %s %s";
    public static final String CONTINUE_MESSAGE = "¿Desea continua? Sí: 1 ; NO: 0  -> ";
    public static final String ERROR_CALCULATING_MESSAGE = "Ha ocurrido un error... ";
}

public class ExampleHelper {
    
    private static final Scanner SCANNER = new Scanner(System.in);
   
    
    public static void main(String[] args) {
        
        int op = 1;
        while(op != 0){
            knowCapicua();
            op = cont();
        }
        
    }
    
    private static void knowCapicua(){
        String result = MessageHelper.ERROR_MESSAGE;
       
        System.out.print(MessageHelper.STARTER_MESSAGE);
        String num = SCANNER.next();
        
        if(CapicuaHelper.isCapicua(num)){
            result = MessageHelper.SUCCESS_MESSAGE;
        }
        
        System.out.println(String.format(MessageHelper.RESPONSE_MESSAGE, num, result));
    }
    
    private static int cont(){
        System.out.print(MessageHelper.CONTINUE_MESSAGE);
        int result = SCANNER.nextInt();
        return result == 1 ? 1: result;
    }
    
}
