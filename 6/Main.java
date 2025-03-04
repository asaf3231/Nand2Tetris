
public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Main <path_to_asm_file>");
            return;
        }
        
        try {
            HackAssembler.main(new String[]{args[0]});
        } catch (Exception e) {
            System.err.println("An error occurred while running the assembler: " + e.getMessage());
        }
    }
}