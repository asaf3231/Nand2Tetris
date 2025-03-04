
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class VMTranslator {
    public static void main(String[] args) throws IOException{
        if(args.length == 0 ){
            System.out.println("please give an input file.");
            return; 
        }
        Parser parser = new Parser(new File(args[0]));
        String outputFileName = args[0].replace(".vm", ".asm");
        CodeWriter writer = new CodeWriter(outputFileName);

        while (parser.hasMoreLines()) {
            parser.advance(); 
            if ( parser.commandType().compareTo("C_ARITHMETIC") == 0  ) {
                writer.WriteArithmetic(parser.arg1());
                
            }
            if( parser.commandType().compareTo("C_PUSH") == 0  || parser.commandType().compareTo("C_POP") == 0  ) {
                writer.WritePushPop(parser.commandType(), parser.arg1(), parser.arg2());
            }
            
        }
        writer.close();
    }
}
