package geometria;
import java.math.*;

public class triangulo{
private punto a,b,c;
private String nombre;
public triangulo(){
    
    a=new punto(1,1);
    b=new punto(1,1);
    c=new punto(1,1);
    nombre="desconocido";
}

public triangulo(String nom,punto p,punto q,punto r){
    a=new punto(p);
    b=new punto(q);
    c=new punto(r);
    nombre=nom;
}

public triangulo(triangulo t){
    a=new punto(t.a);
    b=new punto(t.b);
    c=new punto(t.c);
    nombre="copia de "+t.nombre; 
}

public triangulo(String nom,int ax,int ay,int bx,int by,int cx, int cy){
    a=new punto(ax, ay);
    b=new punto(bx, by);
    c=new punto(cx, cy);
    nombre=nom;
}

@Override
public String toString(){
return nombre+":["+a+","+b+","+c+"]";
}

//empiezan los metodos

public boolean estadentro(punto x){
            if(x.obtenx()>=a.obtenx()  && x.obtenx()<=c.obtenx())
            if(x.obteny()<=b.obteny() && (x.obteny()>=a.obteny() || x.obtenx()>=c.obtenx()))
                return true;
            else return false;
        else return false;
}


//metodos auxiliares
public punto obtena(){
    return a;
}

public punto obtenb(){
    return b;
}

public punto obtenc(){
    return c;
}

public double area(){
    return (double)(1/2)*(double)(a.obtenx()*b.obteny() + a.obteny()*c.obtenx() + b.obtenx()*c.obteny() - b.obteny()*c.obtenx() - a.obteny()*b.obtenx() - a.obtenx()*c.obteny());
    
}

public int comparar(triangulo x){
    if(x.area()<this.area())
                return 1;
    
        else if(x.area()>this.area())            
                return -1;
    
        else if(x.area()==this.area())
                return 0;
            else return 2;
        
}

public int comparar(rectangulo r, triangulo t){
    if(r==null && t!=null) return this.comparar(t);
    else if(t==null && r!=null){
        if(r.area()<this.area()) return 1;
        else if(r.area()>this.area()) return -1;
        else if(r.area()==this.area()) return 0;
        else return 2;
    }
    else return 2;
}


}//fin clase
