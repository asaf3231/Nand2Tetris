
import java.util.HashMap;

public class SymbolTable {

private static HashMap <String,Integer> symbolMap = new HashMap<>();
public static int newAdress ;

public SymbolTable(){
    initializeDefaultSymbols();
    newAdress = 16;
}

 private void initializeDefaultSymbols() {
    for (int i = 0; i <= 15; i++) {
        symbolMap.put("R" + i, i);
    }
    symbolMap.put("SCREEN", 16384);
    symbolMap.put("KBD", 24576);
    symbolMap.put("SP", 0);
    symbolMap.put("LCL", 1);
    symbolMap.put("ARG", 2);
    symbolMap.put("THIS", 3);
    symbolMap.put("THAT", 4);
}

public static void addEntry(String symbol, int address){
    symbolMap.put(symbol, address);
}
 
public static boolean contains(String symbol){
return symbolMap.containsKey(symbol);
}
public static int getAddress(String symbol){
return symbolMap.get(symbol);
}

}
