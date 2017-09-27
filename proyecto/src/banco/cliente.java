package banco;
import java.util.*;

public class cliente{
    
    private String nombre,numcuenta;
    private int numctas=0;
    private ArrayList<cuenta> cuentas;
    public static int id;
    
    
    
    public cliente(String nom,ArrayList<cuenta> ctas){
     if(nom=="" || nom==null);
     else{
        nombre=nom;
        numcuenta=""+((int)(Math.random()*Math.pow(10, 6)));
        cuentas=ctas;
        numctas=0;
        id+=1;
        //mov=new ArrayList<movimientos>();
     }
    }
    
    public void agregarCuenta(cuenta cta){
        cuentas.add(cta);
        numctas+=1;
    }
    
    public cuenta obtenerCuenta(int i){
       /* int j=0;
        for(;j<cuentas.size();j++){
            if(cuentas.get(j).flag==bandera){
                //return cuentas.get(i);
                break;
            }
        }
        if(j==cuentas.size())return null;
        else return cuentas.get(j);*/
       if(i<=cuentas.size()){
           return cuentas.get(i);
       }else{
           return null;
       }
    }
    
    @Override
    public String toString(){
        String fechas="";
        
        for(int i=0;i<cuentas.size();i++){
            fechas=fechas.concat(cuentas.get(i).aper()+"\n");//revisar esta wea :'v
        }
        if(fechas.equals("") || fechas==null){
         return "Cliente: "+nombre+"\nNumero de cuenta: "+numcuenta+"\nNumero de cuentas: "+numctas+"\n";
        }else return "Cliente: "+nombre+"\nNumero de cuenta: "+numcuenta+"\nNumero de cuentas: "+numctas+"\nAperturas de cuentas: \n"+fechas;
    }
    
    public String nombre(){
        return nombre;
    }
    
    public boolean exiscta(int i){
        cuenta aux;
        aux=this.obtenerCuenta(i);
        if(aux==null) return false;
        else return true;
    }
    
    public int numctas(){
     return numctas;
    }
    public ArrayList<cuenta> cta(){
     return cuentas;
    }
    
    public String reportarEdosCtas(){
     String aux="";
     ahorros a1;
     cheques a2;
     credito a3;
     cuenta auxc;
     for(int i=0;i<cuentas.size();i++){
      auxc=cuentas.get(i);
      if(auxc instanceof ahorros){
       a1=(ahorros)auxc;
       aux=aux+"Ahorros "+a1.id()+"\n"+a1.leer()+"\n\n";
      }
      
      else if(cuentas.get(i) instanceof cheques){
       a2=(cheques)auxc;
       aux=aux+"Cheques "+a2.id()+"\n"+a2.leer()+"\n\n";
      }
      
      else if(cuentas.get(i) instanceof credito){
       a3=(credito)auxc;
       aux=aux+"Credito "+a3.id()+"\n"+a3.leer()+"\n\n";
      }
     }
     return aux;
    }
}//fin clase