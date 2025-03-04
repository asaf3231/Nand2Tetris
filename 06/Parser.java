
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

    public class Parser {
    private static BufferedReader reader;
    private static String currLine;
    private static String nextLine;

        public Parser(File file) throws IOException {
            reader = new BufferedReader(new FileReader(file));
            currLine = null;
            nextLine = reader.readLine();
        }

        public static boolean hasMoreLines() throws IOException{
            while(nextLine != null && (nextLine.trim().isEmpty() || nextLine.charAt(0) == '/' )){
                currLine =nextLine.trim();
                nextLine= reader.readLine();
            }    
            return (nextLine != null);
        }

        public static void advance() throws IOException {
            currLine = nextLine;
            nextLine= reader.readLine();
        }
        
        public static String instructionType(){
            if (currLine.startsWith("@")) {
                return "A_INSTRUCTION" ; 
            }
            else if ( currLine.startsWith("(")){
                return "L_INSTRUCTION";
            }
            else{ return "C_INSTRUCTION";}
        }
        
        public static String symbol(){
            if (currLine.startsWith("@")) {
                return currLine.substring(1) ; 
            }
            else if (currLine.startsWith("(")){
                return currLine.substring(1, currLine.length() - 1) ; 
            }
            else{
                return "";
            }
        
        }

        public static String dest(){
          int index = currLine.indexOf('=');
          if (index == -1 ) {
            return null ;             
          }
          else{ return currLine.substring(0, index);}
        }


        public static String comp(){
            int indexEq = currLine.indexOf('=');
            int indexDot = currLine.indexOf(';');
        
            if (indexEq == -1 ) {
                if(indexDot == -1 ) return currLine;
                else if ( indexDot != -1 ) return currLine.substring(0, indexDot);
            }
            if( indexEq != -1 ){
                if (indexDot == -1 ) return currLine.substring(indexEq + 1);
                else if (indexDot != -1 ) return currLine.substring(indexEq + 1 , indexDot);
            }
        return null;
        }
        
        
        public static String jump(){
            int indexDot = currLine.indexOf(';');
                if(indexDot == -1 ) return null;
                else{return currLine.substring(indexDot + 1); }
        }

        public static boolean isNumber(String str) {
            try {
                Integer.parseInt(str);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
}