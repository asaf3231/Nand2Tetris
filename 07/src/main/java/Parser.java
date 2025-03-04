
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
        
        public static String commandType(){
            if (logicalType(currLine)) {
                return "C_ARITHMETIC" ; 
            }
            else if (currLine.startsWith("push")){
                return "C_PUSH";
            }
            else if(currLine.startsWith("pop")){
                return "C_POP";
            }
            return null;
        }
        public static boolean logicalType(String command){
            switch (command) {
                case "add":   
                    return true;
                case "and":    
                    return true;
                case "or":                   
                    return true;
                case "neg":                   
                    return true;
                case "lt":                   
                    return true;
                case "gt":                   
                    return true;
                case "sub":                   
                    return true;
                case "eq":                   
                    return true;
                case "not":                   
                    return true;
                default:
                    return false;
            }
        }

        public static String arg1(){
            if (logicalType(currLine) ){
                return currLine;
            }
            else if (currLine.startsWith("pop") || currLine.startsWith("push")){
                String split[] =  currLine.split(" " , 3);
                return split[1];
            }
            return null;
        }
        public static int arg2(){
            if(currLine.startsWith("pop") || currLine.startsWith("push")){
                String split[] =  currLine.split(" " , 3);
                return  Integer.parseInt(split[2]);
            }
            return 0;
        }
    }