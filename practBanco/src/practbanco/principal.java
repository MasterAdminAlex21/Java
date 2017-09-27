package practbanco;
import java.util.*;

public class principal{
    public static void main(String args[]){
        
        
        //u.setVisible(true);
        Scanner leer=new Scanner(System.in);
        ArrayList<cliente> cliente=new ArrayList<>();
        int opc=0,i;
        String nombre;
        cliente aux=new cliente("",null);
        double monto;
        //aqui va un menu
        
        while(opc!=6){
            System.out.println("Ingrese opcion: ");
            System.out.println("1. agregar cliente \n2. agregar cuenta\n3. consultar saldo\n4. depositar\n5. retirar \n6. salir");
            opc=leer.nextInt();
            switch(opc){
                case 1:
                    nombre=leer.nextLine();
                    System.out.println("Ingrese nombre del cliente: ");
                    nombre=leer.nextLine();
                    cliente.add(new cliente(nombre,new ArrayList<cuenta>()));
                break;
                case 2:
                    nombre=leer.nextLine();
                    System.out.println("Ingrese nombre: ");
                    nombre=leer.nextLine();
                    for(i=0;i<cliente.size();i++){
                        if(nombre.equals(cliente.get(i).nombre())){
                            aux=cliente.get(i);
                            //System.out.println(aux.nombre());
                            break;
                        }
                    }
                    if(i==cliente.size()){
                        System.err.println("\nNo hay un cliente con ese nombre");
                        break;
                    }
                    //System.out.println(aux.nombre());
                    System.out.println("Ingrese tipo cuenta: \n1. ahorros\n2. cheques \n3. credito");
                    opc=leer.nextInt();
                    switch(opc){
                        case 1:
                            nombre=leer.nextLine();
                            System.out.println("Ingrese monto: ");
                            monto=leer.nextDouble();
                            double tasa;
                            System.out.println("Ingrese tasa: ");
                            tasa=leer.nextDouble();
                            aux.agregarCuenta(new ahorros(new fecha((int)(Math.random()*31),(int)(Math.random()*12),2000),monto,tasa));
                            cliente.add(i, aux);
                        break;
                        case 2:
                            nombre=leer.nextLine();
                            System.out.println("Ingrese monto: ");
                            monto=leer.nextDouble();
                            double sobre;
                            System.out.println("Ingrese sobregiro: ");
                            sobre=leer.nextDouble();
                            aux.agregarCuenta(new cheques(monto,sobre,new fecha((int)(Math.random()*31),(int)(Math.random()*12),2000)));
                            cliente.add(i, aux);
                        break;
                        case 3:
                            nombre=leer.nextLine();
                            System.out.println("Ingrese monto: ");
                            monto=leer.nextDouble();
                            double tasac;
                            System.out.println("Ingrese tasa: ");
                            tasac=leer.nextDouble();
                            aux.agregarCuenta(new credito(monto,tasac,new fecha((int)(Math.random()*31),(int)(Math.random()*12),2000)));
                            cliente.add(i, aux);
                        break;
                    }
                break;
                case 3://consultar saldo
                    nombre=leer.nextLine();
                    System.out.println("Ingrese nombre del cliente:");
                    nombre=leer.nextLine();
                    for(i=0;i<cliente.size();i++){
                        if(nombre.equals(cliente.get(i).nombre())){
                            aux=cliente.get(i);
                           if(aux.exiscta(0)) System.out.println(aux.obtenerCuenta(0).toString());
                            if(aux.exiscta(1)) System.out.println(aux.obtenerCuenta(1).toString());
                            if(aux.exiscta(2)) System.out.println(aux.obtenerCuenta(2).toString());
                            break;
                        }
                    }
                    if(i==cliente.size()){
                        System.err.println("No hay un cliente con ese nombre\n");
                        break;
                    }
                    
                    // System.out.println(aux.nombre());
                            //System.out.println("\n\n");
                            
                break;
                case 4://depositar
                    nombre=leer.nextLine();
                    System.out.println("Ingrese nombre: ");
                    nombre=leer.nextLine();
                    System.out.println(nombre);
                    for(i=0;i<cliente.size();i++){
                        //System.out.println("entro al for");
                        if(nombre.equals(cliente.get(i).nombre())){
                            //System.out.println("entro al if");
                            aux=cliente.get(i);
                            break;
                        }
                    }
                    if(i==cliente.size()){
                        System.out.println("\nNo hay un cliente con ese nombre");
                        break;
                    }
                    //nombre=leer.nextLine();
                    System.out.println("Ingrese cuenta a depositar: ");
                    nombre=leer.nextLine();
                    if(nombre.equalsIgnoreCase("ahorros")){
                        System.out.println("Ingrese monto: ");
                        monto=leer.nextDouble();
                        aux.obtenerCuenta(0).depositar(monto);
                    }else if(nombre.equalsIgnoreCase("cheques")){
                        System.out.println("Ingrese monto: ");
                        monto=leer.nextDouble();
                        aux.obtenerCuenta(1).depositar(monto);
                    }else if(nombre.equalsIgnoreCase("credito")){
                        System.out.println("Ingrese monto: ");
                        monto=leer.nextDouble();
                        aux.obtenerCuenta(2).depositar(monto);
                    }else System.err.println("No existe esa cuenta\n");
                break;
                case 5://retirar
                    nombre=leer.nextLine();
                    System.out.println("Ingrese nombre: ");
                    nombre=leer.nextLine();
                    for(i=0;i<cliente.size();i++){
                        if(nombre.equals(cliente.get(i).nombre())){
                            aux=cliente.get(i);
                            break;
                        }
                    }
                    if(i==cliente.size()){
                        System.out.println("\nNo hay un cliente con ese nombre");
                        break;
                    }
                    nombre=leer.nextLine();
                    System.out.println("Ingrese cuetna a retirar: ");
                    nombre=leer.nextLine();
                    if(nombre.equalsIgnoreCase("ahorros")){
                        System.err.println("No se puede retirar de la cuenta de ahorros");
                    }else if(nombre.equalsIgnoreCase("cheques")){
                        System.out.println("Ingrese monto: ");
                        monto=leer.nextDouble();
                        aux.obtenerCuenta(1).retirar(monto);
                    }else if(nombre.equalsIgnoreCase("credito")){
                        System.out.println("Ingrese monto: ");
                        monto=leer.nextDouble();
                        aux.obtenerCuenta(2).retirar(monto);
                    }else System.err.println("No existe esa cuenta\n");
                break;
                case 6://salir
                    UML u=new UML();
                break;
                default:
                    System.err.println("ERROR: opcion invalida");
                break;
            }
            
        }
        
        
    }
}