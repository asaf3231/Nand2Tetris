
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CodeWriter {

    String outputFileName;
    File targetFile;
    static BufferedWriter editor;
    static int counter = 0;
    static String fileName;

        public CodeWriter(String fileName) throws IOException{ 
            this.outputFileName = fileName; 
            this.targetFile = new File(outputFileName);
            this.editor = new BufferedWriter(new FileWriter(targetFile));
            String tempName = fileName.substring(fileName.lastIndexOf("/"), fileName.lastIndexOf("."));
            this.fileName = tempName.substring(1);
        }   

        public static void WritePushPop(String commandType , String segment , int index)throws IOException {
            String commandPhrase;
            if(commandType.equals("C_PUSH")){
                if ( segment.equals("constant") ){
                    commandPhrase = "@" + index + "\n" +
                                    "D=A\n" +
                                    "@SP\n" +
                                    "A=M\n" +
                                    "M=D\n" +
                                    "@SP\n" +
                                    "M=M+1\n" ;
                    editor.write(commandPhrase);
                    editor.newLine();
                }
                if ( segment.equals("local") ){
                    commandPhrase = "@LCL\n" +
                                    "D=M\n" +
                                    "@" + index + "\n" +
                                    "D=D+A\n" +
                                    "A=D\n" +
                                    "D=M\n" +
                                    "@SP\n" +
                                    "A=M\n" +
                                    "M=D\n" +
                                    "@SP\n" +
                                    "M=M+1\n" ;

                    editor.write(commandPhrase);
                    editor.newLine();
                }
                if ( segment.equals("argument") ){
                    commandPhrase = "@ARG\n" +
                                    "D=M\n" +
                                    "@" + index + "\n" +
                                    "D=D+A\n" +
                                    "A=D\n" +
                                    "D=M\n" +
                                    "@SP\n" +
                                    "A=M\n" +
                                    "M=D\n" +
                                    "@SP\n" +
                                    "M=M+1\n" ;

                    editor.write(commandPhrase);
                    editor.newLine();
                }
                if ( segment.equals("static") ){
                    commandPhrase = "@" + fileName + "." + index + "\n" + 
                                    "D=M\n"+
                                    "@SP\n" +
                                    "A=M\n" +
                                    "M=D\n" +
                                    "@SP\n" +
                                    "M=M+1\n"; 

                    editor.write(commandPhrase);
                    editor.newLine();
                    
                }
                if ( segment.equals("this") ){
                    commandPhrase = "@THIS\n" +
                                    "D=M\n" +
                                    "@" + index + "\n" +
                                    "D=D+A\n" +
                                    "A=D\n" +
                                    "D=M\n" +
                                    "@SP\n" +
                                    "A=M\n" +
                                    "M=D\n" +
                                    "@SP\n" +
                                    "M=M+1\n" ;

                    editor.write(commandPhrase);
                    editor.newLine();
                    
                }
                if ( segment.equals("that") ){
                    commandPhrase = "@THAT\n" +
                                    "D=M\n" +
                                    "@" + index + "\n" +
                                    "D=D+A\n" +
                                    "A=D\n" +
                                    "D=M\n" +
                                    "@SP\n" +
                                    "A=M\n" +
                                    "M=D\n" +
                                    "@SP\n" +
                                    "M=M+1\n" ;

                    editor.write(commandPhrase);
                    editor.newLine();
                    
                }
                if ( segment.equals("temp") ){
                    commandPhrase = "@5\n" +
                                    "D=A\n" +
                                    "@" + index + "\n" +
                                    "D=D+A\n" +
                                    "A=D\n" +
                                    "D=M\n" +
                                    "@SP\n" +
                                    "A=M\n" +
                                    "M=D\n" +
                                    "@SP\n" +
                                    "M=M+1\n" ;

                    editor.write(commandPhrase);
                    editor.newLine();
                    
                }
                if ( segment.equals("pointer") ){
                    if (index == 0) {
                        commandPhrase = "@THIS\n" + 
                                        "D=M\n" +   
                                        "@SP\n" +   
                                        "A=M\n" +   
                                        "M=D\n" +  
                                        "@SP\n" +   
                                        "M=M+1\n";  

                    editor.write(commandPhrase);
                    editor.newLine();
                    }
                    if (index == 1) {
                        commandPhrase = "@THAT\n" + 
                                        "D=M\n" +  
                                        "@SP\n" +   
                                        "A=M\n" +  
                                        "M=D\n" +   
                                        "@SP\n" +   
                                        "M=M+1\n";  
                                                
                    editor.write(commandPhrase);
                    editor.newLine();
                    
                    }
                }

            }






            else{ // for pop
                if ( segment.equals("local") ){
                    commandPhrase = "@LCL\n" +
                                    "D=M\n" +
                                    "@" + index + "\n" +
                                    "D=D+A\n" +
                                    "@R14\n" +
                                    "M=D\n" +
                                    "@SP\n" +
                                    "AM=M-1\n" +
                                    "D=M\n" +
                                    "@R14\n" +
                                    "A=M\n" +
                                    "M=D\n" ;
                                    
                    editor.write(commandPhrase);
                    editor.newLine();
                }
                if ( segment.equals("argument") ){
                    commandPhrase = "@ARG\n" +
                                    "D=M\n" +
                                    "@" + index + "\n" +
                                    "D=D+A\n" +
                                    "@R14\n" +
                                    "M=D\n" +
                                    "@SP\n" +
                                    "AM=M-1\n" +
                                    "D=M\n" +
                                    "@R14\n" +
                                    "A=M\n" +
                                    "M=D\n" ;
                                    
                    editor.write(commandPhrase);
                    editor.newLine();
                    
                }
                if ( segment.equals("static") ){
                    commandPhrase = "@SP\n" +
                                    "M=M-1\n" +
                                    "A=M\n" +
                                    "D=M\n" +
                                    "@" + fileName+ "." + index + "\n" +
                                    "M=D\n" ;

                    editor.write(commandPhrase);
                    editor.newLine();
                    
                }
                if ( segment.equals("this") ){
                    commandPhrase = "@THIS\n" +
                                    "D=M\n" +
                                    "@" + index + "\n" +
                                    "D=D+A\n" +
                                    "@R14\n" +
                                    "M=D\n" +
                                    "@SP\n" +
                                    "AM=M-1\n" +
                                    "D=M\n" +
                                    "@R14\n" +
                                    "A=M\n" +
                                    "M=D\n" ;
                                    
                    editor.write(commandPhrase);
                    editor.newLine();
                    
                }
                if ( segment.equals("that") ){
                    commandPhrase = "@THAT\n" +
                                    "D=M\n" +
                                    "@" + index + "\n" +
                                    "D=D+A\n" +
                                    "@R14\n" +
                                    "M=D\n" +
                                    "@SP\n" +
                                    "AM=M-1\n" +
                                    "D=M\n" +
                                    "@R14\n" +
                                    "A=M\n" +
                                    "M=D\n" ;
                                    
                    editor.write(commandPhrase);
                    editor.newLine();
                    
                }
                if ( segment.equals("temp") ){
                    commandPhrase = "@SP\n" +
                                    "M=M-1\n" +
                                    "A=M\n" +
                                    "D=M\n" +
                                    "@" + (5 + index) + "\n" +
                                    "M=D\n" ;

                    editor.write(commandPhrase);
                    editor.newLine();
                    
                }
                if ( segment.equals("pointer") ){
                    if (index == 0) {
                        commandPhrase = "@SP\n" +  
                                        "AM=M-1\n" + 
                                        "D=M\n" +   
                                        "@THIS\n" + 
                                        "M=D\n";

                        editor.write(commandPhrase);
                        editor.newLine();
                        
                    }
                    if (index==1) {
                        commandPhrase = "@SP\n" +  
                                        "AM=M-1\n" + 
                                        "D=M\n" +   
                                        "@THAT\n" + 
                                        "M=D\n";  

                    editor.write(commandPhrase);
                    editor.newLine();
                    }   
                        
                    
                }

            }
        } 
        public static void WriteArithmetic(String command)throws IOException {    
            String commandPhrase ; 
            if(command.equals("add")){
                commandPhrase = "@SP\n" + 
                                "M=M-1\n" +
                                "A=M\n" + 
                                "D=M\n" +
                                "@SP\n" + 
                                "M=M-1\n" + 
                                "A=M\n" +
                                "M=D+M\n" +
                                "@SP\n" +
                                "M=M+1\n";
                                
                        editor.write(commandPhrase);
                        editor.newLine();
            }
            if(command.equals("sub")){
                commandPhrase = "@SP\n" + 
                                "M=M-1\n" +
                                "A=M\n" + 
                                "D=M\n" +
                                "@SP\n" + 
                                "M=M-1\n" + 
                                "A=M\n" +
                                "M=M-D\n" +
                                "@SP\n" +
                                "M=M+1\n";
                                
                        editor.write(commandPhrase);
                        editor.newLine();

            }
            if(command.equals("neg")){
                commandPhrase = "@SP\n" + 
                                "M=M-1\n" +
                                "A=M\n" +   
                                "M=-M\n" +
                                "@SP\n" +  
                                "M=M+1\n";
                editor.write(commandPhrase);
                editor.newLine();


            }
            if(command.equals("eq")){
                commandPhrase = "@SP\n" + 
                                "M=M-1\n" +
                                "A=M\n" + 
                                "D=M\n" + 
                                "@SP\n" + 
                                "M=M-1\n" +
                                "A=M\n" + 
                                "D=M-D\n" +
                                "@ZERO" + counter + "\n" + 
                                "D;JEQ\n" +
                                "D=0\n" +
                                "@END" + counter + "\n"+
                                "0;JMP\n"+
                                "(ZERO" + counter + ")\n" + 
                                "D=-1\n" +
                                "(END" + counter + ")\n" +  
                                "@SP\n"+
                                "A=M\n"+
                                "M=D\n" +
                                "@SP\n" +
                                "M=M+1\n";
                                counter++;
                                
                editor.write(commandPhrase);
                editor.newLine();
                

            }
            if(command.equals("gt")){
                commandPhrase = "@SP\n" + 
                                "M=M-1\n" +
                                "A=M\n" + 
                                "D=M\n" + 
                                "@SP\n" + 
                                "M=M-1\n" +
                                "A=M\n" + 
                                "D=M-D\n" +
                                "@BIGI" + counter + "\n" + 
                                "D;JGT\n" +
                                "D=0\n" + 
                                "@END" + counter + "\n" +
                                "0;JMP\n" +
                                "(BIGI" + counter + ")\n" + 
                                "D=-1\n" +
                                "(END" + counter + ")\n" + 
                                "@SP\n"+
                                "A=M\n"+
                                "M=D\n" +
                                "@SP\n" +
                                "M=M+1\n";
                                counter++;
                editor.write(commandPhrase);
                editor.newLine();

            }
            if(command.equals("lt")){
                commandPhrase = "@SP\n" + 
                                "M=M-1\n" +
                                "A=M\n" + 
                                "D=M\n" + 
                                "@SP\n" + 
                                "M=M-1\n" +
                                "A=M\n" + 
                                "D=D-M\n" +
                                "@BIGI" + counter  + "\n" + 
                                "D;JGT\n" +
                                "D=0\n" + 
                                "@END" + counter + "\n" + 
                                "0;JMP\n" +
                                "(BIGI" + counter + ")\n" + 
                                "D=-1\n" +
                                "(END" + counter + ")\n" + 
                                "@SP\n"+
                                "A=M\n"+
                                "M=D\n" +
                                "@SP\n" +
                                "M=M+1\n";
                                counter++;
                editor.write(commandPhrase);
                editor.newLine();

            }
            if(command.equals("and")){
                commandPhrase = 
                                "@SP\n" + 
                                "AM=M-1\n" +
                                "D=M\n"  +     
                                "@SP\n" +
                                "AM=M-1\n" +  
                                "M=D&M\n" +   
                                "@SP\n" + 
                                "M=M+1\n" ;  

                editor.write(commandPhrase);
                editor.newLine();

            }
            if(command.equals("or")){
                 commandPhrase = 
                                "@SP\n" + 
                                "AM=M-1\n" +
                                "D=M\n"  +     
                                "@SP\n" +
                                "AM=M-1\n" +  
                                "M=D|M\n" +   
                                "@SP\n" + 
                                "M=M+1\n" ;  
                                
                editor.write(commandPhrase);
                editor.newLine();

            }
            if(command.equals("not")){
                  commandPhrase = 
                                "@SP\n" + 
                                "M=M-1\n" + 
                                "A=M\n" +                    
                                "M=!M\n" + 
                                "@SP\n" + 
                                "M=M+1\n"; 
                editor.write(commandPhrase);
                editor.newLine();

            }
        
        }

        public static void close() throws IOException{ 
            String commandPhrase;
            commandPhrase = "(FINISH)\n" + 
                            "@FINISH\n" + 
                            "0;JMP\n" ; 
            editor.write(commandPhrase);
            editor.close();
        }
    
} 
