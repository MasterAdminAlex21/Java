package banco;

public class usuarioBanco{
    public static void main(String args[]){
        banco sant=new banco();
        sant.agregaClientes("yo", "02564");
        System.out.println(sant.obtenerNumClientes());
        sant.imprimirClientes();
        
        sant.agregaClientes("otro men", "02365");
        System.out.println(sant.obtenerNumClientes());
        sant.imprimirClientes();
        
        
       
    }
}