package imaginarios;
import java.util.*;

public class menu{
    private Scanner leer=new Scanner(System.in);
    private int opc=0;
    public void menu(){
        matriz a,b,c,aux,copy;
        a=new matriz("",0);
        b=new matriz("",0);
        while(a.filas()==0 && a.columnas()==0){
        a=datos(1);
    }
        while(b.filas()==0 && b.columnas()==0){
        b=datos(2);
        }
        c=new matriz("", 0);
        aux=new matriz("", 0);
        copy=new matriz("",0);
        while(opc!=12){
            System.out.println("\nIngrese opcion");
            System.out.println("1. imprimir matrices \n2. crear matriz cuadrada \n3. sumar 2 matrices \n4. restar 2 matrices \n5. transpuesta de una matriz \n6. calculos \n7. multiplicar matrices \n8. comparar matrices \n9. imprimir en espiral \n10. matriz en polares \n11. copiar matriz \n 12. salir");
            opc=leer.nextInt();
            switch(opc){
                case 1://imprime matrices
                    a.imprimir();
                    System.out.println();
                    b.imprimir();
                    System.out.println();
                    if(c.filas()!=0 && c.columnas()!=0) c.imprimir();
                    if(aux.filas()!=0 && aux.columnas()!=0) aux.imprimir();
                    if(copy.filas()!=0 && copy.columnas()!=0) copy.imprimir();
                break;
                case 2://matriz cuadrada
                    c=cuad();
                    c.imprimir();
                break;
                case 3://suma matrices
                    System.out.println("1. almacenar en a \n2. almacenar en b \n3. crear nuevo ");
                    opc=leer.nextInt();
                    switch(opc){
                        case 1:
                            a.sumar(b);
                            a.imprimir();
                        break;
                        case 2:
                            b.sumar(a);
                            b.imprimir();
                        break;
                        case 3:
                            aux.sumar(a, b);
                            aux.imprimir();
                        break;
                    }
                    
                break;
                case 4://resta matrices
                    System.out.println("1. almacenar en a \n2. almacenar en b \n3. crear nuevo ");
                    opc=leer.nextInt();
                    switch(opc){
                        case 1:
                            a.restar(b);
                            a.imprimir();
                        break;
                        case 2:
                            b.restar(a);
                            b.imprimir();
                        break;
                        case 3:
                            aux.restar(a, b);
                            aux.imprimir();
                        break;
                    }
                break;
                case 5://transpuesta
                    System.out.println("1. transpuesta de a \n2. transpuesta de b");
                    opc=leer.nextInt();
                    switch(opc){
                        case 1:
                            a=a.transpuesta(a);
                            a.imprimir();
                        break;
                        case 2:
                            b=b.transpuesta(b);
                            b.imprimir();
                        break;
                    }
                break;
                case 6://calculos de la matriz
                    a.calculos();
                    b.calculos();
                    //System.out.println(c.filas()+"\n"+c.columnas());
                    if(c.filas()!=0 && c.columnas()!=0) c.calculos();
                break;
                case 7://multiplicar matrices
                    aux=aux.multiplicar(a, b);
                    aux.imprimir();
                break;
                case 8://compara matrices
                    if(a.equals(b))System.err.println("Son matrices iguales");
                    else System.err.println("Son matrices distintas");
                break;
                case 9://espiral
                    a.espiral();
                    System.out.println();
                    b.espiral();
                    System.out.println();
                    if(c.filas()!=0 && c.columnas()!=0) c.espiral();
                break;
                case 10:
                    a.polares();
                    b.polares();
                break;
                case 11:
                    System.out.println("1. copiar a \n2. copiar b");
                    opc=leer.nextInt();
                    switch(opc){
                        case 1:
                            copy=new matriz("copia de "+a.nombre(), a);
                        break;
                        case 2:
                            copy=new matriz("copia de "+b.nombre(), b);
                    }
                break;
                case 12://salir
                    
                    
                break;
                default: 
                    System.err.println("Opcion invalida");
                break;
                
            }
            
            
            
            
        }
        
        
    }
    
    public matriz datos(int i){
    int filas,columnas;
        String random;
        
        System.out.println("Ingrese datos matriz "+i+":");
        random=leer.nextLine();
        System.out.print("ingrese rango: ");
        random=leer.nextLine();
        System.out.print("ingrese filas: ");
        filas=leer.nextInt();
        System.out.print("ingrese columnas: ");
        columnas=leer.nextInt();
        
        matriz a=new matriz("matriz "+i, filas, columnas, random);
        return a;
    
    }
    
    public matriz cuad(){
        matriz cua;
        int tam;
        System.out.print("Ingrese tamaño: ");
        tam=leer.nextInt();
        cua=new matriz("matriz cuadrada", tam);
        cua.estabecer();
        return cua;
    }
    
}