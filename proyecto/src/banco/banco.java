package banco;

public class banco{
    private cliente clientes[];
    private String nombre;
    private int numcli;
    
    public banco(String nom){
        clientes=new cliente[1];
        nombre=nom;
        numcli=0;
    }
    
    public banco(String nom,cliente cli[]){
        nombre=nom;
        numcli=cli.length;
        clientes=cli;
    }
    
    public void agregarCliente(cliente cli){
        //agregar un cliente en el arreglo
        clientes=(cliente[])this.clone();
        numcli+=1;
        clientes[numcli-1]=cli;
    }
    
    public cliente obtenerCliente(int index){
        //retorna un cliente
        return clientes[index];
    }
    
    public void reportarClientes(){
        //muestra los clientes existentes
        for(int i=0;i<clientes.length;i++){
            //se imprimen losclientes
            System.out.println(clientes[i]);
        }
    }
    
    public String repCli(){
     
     if(clientes.length==1) return null;
     else{
      String cl="";
     for(int i=0;i<clientes.length-1;i++){
            //se imprimen los clientes
            cl=cl+clientes[i]+"\n";
        }
     return cl;
     }
    }
    
    @Override
    public Object clone(){
        //se agrega el nuevo cliente
        cliente aux[]=new cliente[clientes.length+1];
        for(int i=0;i<clientes.length;i++){
           aux[i]=obtenerCliente(i);
        }
        return aux;
    }
    
    @Override
    public String toString(){
        return "BANCO "+nombre+"\nClientes: "+numcli+"\n";
    }
    
    public String nomb(){
     return nombre;
    }
    
    public int cli(){
     return numcli;
    }
}
