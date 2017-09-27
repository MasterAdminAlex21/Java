package archivos;
import java.io.*;
import java.util.*;

//ESTA WEA ES LA QUE FUNCIONA :VVVVVV
 
public class arch{
    public static void main (String args[]){
        File ej,car;
        ej=new File("C:\\Users\\Athena megumi\\Documents\\NetBeansProjects\\archivos\\src\\archivos\\ejemplo.txt");
        car=new File("C:\\Users\\Athena megumi\\Documents\\NetBeansProjects\\archivos\\src\\ejemplo");
        car.mkdir();
        if(ej.exists()){
            System.out.println("Archivo abierto");
            Scanner leer=new Scanner(System.in);
            
            try{
                FileWriter o=new FileWriter(ej,true);
                for(int i=0;i<5;i++){
                    System.out.println("Ingrese texto: ");
                    String text= leer.nextLine();
                    o.write(text);
                    
                    o.write('\n');
                }
                
                o.close();
            }catch(IOException e){
                
            }
            
            try{
                FileReader l=new FileReader(ej);
                String cad="";
                int c=l.read();
                while(c!=-1){
                cad=cad+(char)c;
                    //System.out.println(cad);
                    c=l.read();
            }
                System.out.println(cad);
                l.close();
                
            }catch(IOException e){
                
            }
        }else{
            System.err.println("Archivo inexistente");
        }    
        
        
        
    }
}