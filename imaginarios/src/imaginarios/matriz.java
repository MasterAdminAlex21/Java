package imaginarios;
import java.util.*;
import java.math.*;

public class matriz{
    
    private imaginario mat[][];
    private String nombre;
    private int filas;
    private int columnas;
    
    public matriz(String nom, int tam){
        nombre=nom;
        mat=new imaginario[tam][tam];
        filas=columnas=tam;
    }
    public matriz(String nom, int fil, int col){
        nombre=nom;
        filas=fil;
        columnas=col;
        mat=new imaginario[fil][col];
    }
    
    public matriz(String nom, matriz a){
        nombre=nom;
        filas=a.filas;
        columnas=a.columnas;
        mat=new imaginario[filas][columnas];
        for(int i=0;i<filas;i++){
            for(int j=0;j<columnas;j++){
                mat[i][j]=new imaginario(a.mat[i][j].real(), a.mat[i][j].imaginario());
            }
        }
        
        
    }
    
    public matriz(String nom,int fil, int col,String rand){
        
        
        if(rand.charAt(0)=='r'){
            
        mat=new imaginario[fil][col];
        nombre=nom;
        filas=fil;
        columnas=col;
        if(rand.charAt(1)=='*'){
            String random="";
            random=random.concat(rand.substring(2));
            int r=Integer.parseInt(random);
            for(int i=0;i<filas;i++){
                for(int j=0;j<columnas;j++){
                    mat[i][j]=new imaginario((int)((Math.random()*r)+(Math.random()*-r)), (int)((Math.random()*r)+(Math.random()*-r)));
                }
            }
        }
        
        else if(rand.charAt(1)=='+' || rand.charAt(1)=='-'){
           String random=rand.substring(1);
            //random=random.concat(rand.substring(1));
            int r=Integer.parseInt(random);
            for(int i=0;i<filas;i++){
                for(int j=0;j<columnas;j++){
                    mat[i][j]=new imaginario((int)((Math.random()*r)), (int)((Math.random()*r)));
                }
            } 
        }
        }
        else{
            System.err.println("ERROR: la sintaxis para el rango esta mal, intentelo de nuevo");
        }
        
        
        
    }
    
    public void imprimir(){
        System.out.println(nombre);
        for(int i=0;i<filas;i++){
            for (int j=0;j<columnas;j++){
                System.out.print("["+mat[i][j].toString()+"]");
            }
            System.out.println();
        }
    }
    
    //metodos de operaciones
    
    public void sumar(matriz a){
        if(a.filas==filas && a.columnas==columnas){
            for(int i=0;i<filas;i++){
                for(int j=0;j<columnas;j++){
                    mat[i][j].suma(a.mat[i][j]);
                }
            }
        }else{
            System.err.println("No se pueden sumar");
        }
        
    }
    
    public void sumar(matriz a,matriz b){
        if(a.filas==b.filas && a.columnas==b.columnas){
            mat=new imaginario[a.filas][a.columnas];
            for(int i=0;i<a.filas;i++){
                for(int j=0;j<a.columnas;j++){
                    imaginario aux=new imaginario();
                    aux.suma(a.mat[i][j],b.mat[i][j]);
                    mat[i][j]=new imaginario(aux.real(),aux.imaginario());
                }
            }
        }else{
            System.err.println("No se pueden sumar");
        }
    }
    
    public void restar(matriz a){
        if(a.filas==filas && a.columnas==columnas){
            for(int i=0;i<filas;i++){
                for(int j=0;j<columnas;j++){
                    mat[i][j].resta(a.mat[i][j]);
                }
            }
        }else{
            System.err.println("No se pueden restar");
        }
    }
    
    public void restar(matriz a,matriz b){
        if(a.filas==b.filas && a.columnas==b.columnas){
            mat=new imaginario[a.filas][a.columnas];
            for(int i=0;i<a.filas;i++){
                for(int j=0;j<a.columnas;j++){
                    imaginario aux=new imaginario();
                    aux.resta(a.mat[i][j],b.mat[i][j]);
                    mat[i][j]=new imaginario(aux.real(),aux.imaginario());
                }
            }
        }else{
            System.err.println("No se pueden restar");
        }
    }
    
    public matriz transpuesta(matriz a){
        matriz trans=new matriz(a.nombre, a.columnas, a.filas);
        for(int i=0;i<a.filas;i++){
            for(int j=0;j<a.columnas;j++){
                trans.mat[j][i]=new imaginario(a.mat[i][j].real(), a.mat[i][j].imaginario());
            }
        }
        return trans;
    }
    
    public void calculos(){
        imaginario max,min,prom;
        prom=new imaginario();
        min=new imaginario(mat[0][0].real(),mat[0][0].imaginario());
        max=new imaginario(mat[0][0].real(),mat[0][0].imaginario());
        for(int i=0;i<filas;i++){
            for(int j=0;j<columnas;j++){
                 prom.suma(mat[i][j]);
                //falta el minimo y maximo
             min=min.menor(min, mat[i][j]);
             max=max.mayor(max, mat[i][j]);
            }
        }   
        
        if(prom.imaginario()>0 && prom.real()!=0){
            System.out.println("Promedio: "+(prom.real()/(filas*columnas))+"+"+(prom.imaginario()/(filas*columnas))+"i");
        }else if(prom.imaginario()<0){
            System.out.println("Promedio: "+(prom.real()/(filas*columnas))+(prom.imaginario()/(filas*columnas))+"i");
        }else if(prom.real()==0){
            System.out.println("Promedio: "+(prom.imaginario()/(filas*columnas))+"i");
        }else if(prom.imaginario()==0 && prom.real()!=0){
            System.out.println("Promedio: "+(prom.real()/(filas*columnas)));
        }
        //falta imprimir minimo y maximo
        System.out.println("maximo: "+max);
        System.out.println("min: "+min);
    }
    
    public boolean equals(matriz a){
        if(a.filas!=filas || a.columnas!=columnas) return false;
        else if(a.filas==filas && a.columnas==columnas){
            int cont=0;
            for(int i=0;i<filas;i++)
                for(int j=0;j<columnas;j++){
                    if(a.mat[i][j].equals(mat[i][j])) cont+=1;
                }
            if(cont==filas*columnas) return true;
            else return false;
        }
        else return false;
    }
    
    public matriz multiplicar(matriz a, matriz b){
        if(a.filas!=b.columnas){
            System.err.println("No se pueden multiplicar");
            return null;
        }else{
            
            matriz c=new matriz("multiplicacion", a.filas, b.columnas);
            for(int i=0;i<a.filas;i++){
                imaginario aux=new imaginario(0, 0);
                imaginario tot=new imaginario(0,0);
                for(int j=0;j<b.columnas;j++){
                    for(int k=0;k<a.columnas;k++){
                     aux.multiplicacion(a.mat[i][k], b.mat[k][j]);
                     tot.suma(aux);
                    }
                c.mat[i][j]=new imaginario(tot);
                }
                
            }
            return c;
        }
        
    }
    
    public void espiral(){
        System.out.println(nombre);
       if((columnas%3)==0 && filas%3==0){
            for(int i=0;i<(columnas/2)+1;i++){
            //System.out.println("\n1");
            for(int j=i;j<columnas-i;j++){
                System.out.print("["+mat[i][j]+"]");
            }
            //System.out.println("\n2");
            for(int j=i+1;j<filas-i;j++){
                System.out.print("["+mat[j][columnas-(i+1)]+"]");
            }
            //System.out.print("->");
            //System.out.println("\n3");
            for(int j=columnas-(i+2);j>=i;j--){
                System.out.print("["+mat[filas-(i+1)][j]+"]");
            }
            //System.out.print("->");
            //System.out.println("\n4");
            for(int j=filas-(i+1);j>i+1;j--){
                System.out.print("["+mat[j-1][i]+"]");
            }
        }
        }
       else{
        for(int i=0;i<(columnas/2);i++){
            //System.out.println("\n1");
            for(int j=i;j<columnas-i;j++){
                System.out.print("["+mat[i][j]+"]");
            }
            //System.out.println("\n2");
            for(int j=i+1;j<filas-i;j++){
                System.out.print("["+mat[j][columnas-(i+1)]+"]");
            }
            //System.out.print("->");
            //System.out.println("\n3");
            for(int j=columnas-(i+2);j>=i;j--){
                System.out.print("["+mat[filas-(i+1)][j]+"]");
            }
            //System.out.print("->");
            //System.out.println("\n4");
            for(int j=filas-(i+1);j>i+1;j--){
                System.out.print("["+mat[j-1][i]+"]");
            }
        }
       }
    }
    
    
    public void estabecer(){
        int r,im;
        Scanner leer=new Scanner(System.in);
        for(int i=0;i<filas;i++){
            for(int j=0;j<columnas;j++){
                System.out.print("Ingrese real: ");
                r=leer.nextInt();
                System.out.print("Ingrese imaginario: ");
                im=leer.nextInt();
                mat[i][j]=new imaginario(r,im);
            }
        }
    }
    
    
    //matriz cuadrada
    public int filas(){
        return filas;
    }
    public int columnas(){
        return columnas;
    }
    public void polares(){
        System.out.println(nombre);
        for(int i=0;i<filas;i++){
            for (int j=0;j<columnas;j++){
                mat[i][j].polar();
            }
            System.out.println();
        }
    }
    
    public String nombre(){
        return nombre;
    }
    
}//fin clase