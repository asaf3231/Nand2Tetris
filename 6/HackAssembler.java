
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class HackAssembler {

    public static void main(String[] args) throws IOException{
        if(args.length == 0 ){
            System.out.println("please give an input file.");
            return; 
        }
        try {
            Parser firstParser = new Parser(new File(args[0]));
            int labelline = 0 ; 
            SymbolTable table = new SymbolTable();
            String outputFileName = args[0].replace(".asm", ".hack");
            File targetFile = new File(outputFileName);    
            BufferedWriter editor = new BufferedWriter(new FileWriter(targetFile));
            Code code = new Code();
            
            targetFile.createNewFile();

            while (firstParser.hasMoreLines()) {
                firstParser.advance();                

                if (firstParser.instructionType().equals("L_INSTRUCTION")) {
                    String label = firstParser.symbol();
                    table.addEntry(label, labelline);
                }
                if (firstParser.instructionType().equals("C_INSTRUCTION") || firstParser.instructionType().equals("A_INSTRUCTION")){
                    labelline++;
                }
            }

            Parser secondParser = new Parser(new File(args[0]));

            while (secondParser.hasMoreLines()) {
                secondParser.advance();

                if (secondParser.instructionType().equals("A_INSTRUCTION")) {

                    if(!table.contains(secondParser.symbol())){
                        table.addEntry(secondParser.symbol(),table.newAdress);
                        table.newAdress++;
                    }

                    if (secondParser.isNumber(secondParser.symbol())) {
                        int num = Integer.parseInt(secondParser.symbol());
                        String binary = String.format("%16s", Integer.toBinaryString(num)).replace(' ', '0');
                        editor.write(binary);
                        editor.newLine();

                        
                    }

                    if (!secondParser.isNumber(secondParser.symbol())) {
                        int num = table.getAddress(secondParser.symbol());
                        String binary = String.format("%16s", Integer.toBinaryString(num)).replace(' ', '0');
                        editor.write(binary);
                        editor.newLine();

                    }

                }
                else if (secondParser.instructionType().equals("C_INSTRUCTION")) {
                    String binaryDest = code.dest(secondParser.dest());
                    String binarycomp = code.comp(secondParser.comp());
                    String binaryjump = code.jump(secondParser.jump());
                    String binary = "111" + binarycomp + binaryDest + binaryjump;        
                    editor.write(binary);
                    editor.newLine();

                }
            }
            editor.close();

        }catch (IOException e){
            System.err.println("file not found");
        }
    }



}


