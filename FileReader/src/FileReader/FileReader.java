package FileReader;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.io.FileNotFoundException; 

public class FileReader {
	public static void main(String[] args) {
	    try {
	      File myObj = new File("Entrada.txt");
	      Scanner myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        imprimirDistintos(data.replaceAll("\\s+", "") );
	      }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	  }

	private static void imprimirDistintos(String txt) {
	    Set<Character> uniqueStr = new HashSet<Character>();
	    String salida = "";
	    for (int i = 0; i < txt.length(); i++) {
	        uniqueStr.add(txt.charAt(i));
	    }
	    Character[] array = new Character[uniqueStr.size()];
	    uniqueStr.toArray(array);
	    for ( int x = 0; x<uniqueStr.size(); x++ ) {
	    	salida = salida +  array[x] + "->" +contarCaracteres( txt, array[x] )+  ",";
	    }
	    salida = salida.substring(0, salida.length() -1 ) ;
	    System.out.println( salida );
    	
		
	}
	
	public static int contarCaracteres(String cadena, Character caracter) {
        int posicion, contador = 0;
        //se busca la primera vez que aparece
        posicion = cadena.indexOf(caracter);
        while (posicion != -1) { //mientras se encuentre el caracter
            contador++;           //se cuenta
            //se sigue buscando a partir de la posición siguiente a la encontrada                                 
            posicion = cadena.indexOf(caracter, posicion + 1);
        }
        return contador;
	}
}
