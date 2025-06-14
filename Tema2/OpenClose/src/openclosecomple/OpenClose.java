/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package openclosecomple;



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
        Coche[] arregloCoches={ new Renault(),new Audi(),new Mercedes()};
        imprimirCoches(arregloCoches); 
    }
    
    public  static void imprimirCoches(Coche[] arregloCoches)
    {
        
        for (Coche coche:arregloCoches)
        {
            System.out.println(coche.precioMedioCoche());
            
        }

    
    }
}