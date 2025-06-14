/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package openclosenocumple;

/**
 *
 * @author Dell
 */
public class OpenClose {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Coche[] arregloCoches={ new Coche("Renault"),new Coche("Audi"),new Coche("Mercedes")};
        imprimirCoches(arregloCoches); 
    }
    
    public  static void imprimirCoches(Coche[] arregloCoches)
    {
        
        for (Coche coche:arregloCoches)
        {
            if (coche.marca.equals("Renault")) 
            {
                System.out.println(18000);
            }
            if (coche.marca.equals("Audi")) 
            {
                System.out.println(21000);
            }
            if (coche.marca.equals("Mercedes")) 
            {
                System.out.println(27000);
            }
        }

    
    }
}