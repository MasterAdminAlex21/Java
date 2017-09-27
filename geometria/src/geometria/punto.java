package geometria;
import java.math.*;

public class punto{

private String nombre;
private int x;
private int y;

public punto(){
    x=y=0;
}
public punto(int cox,int coy){
    x=cox;
    y=coy;
    nombre="?";
}
public punto(String nom,int cox,int coy){
    x=cox;
    y=coy;
    nombre=nom;
}

public punto(punto a){
    x=a.x;
    y=a.y;
    nombre="?";
}

public punto(punto a, String nom){
    x=a.x;
    y=a.y;
    nombre=nom;
}

public int obtenx(){
    return x;
}
public int obteny(){
    return y;
}
@Override
public String toString(){
    return nombre+"("+x+","+y+")";
}
public double distancia(punto b){
    //recordar esto :v , distancia entre 2 puntos
    
    return Math.sqrt((double)((b.x - x)*(b.x - x))+(double)((b.y - y)*(b.y - y)));
}
public double distancia(){
    //distancia desde el origen
    return Math.sqrt((double)(x*x)+ (double)(y*y));
}
public int cuadrante(){
    if(x>0 && y>0) return 1;
    else if(x<0 && y>0) return 2;
    else if(x<0 && y<0) return 3;
    else if(x>0 && y<0) return 4;
    else if(x==0 && y>0) return 1;
    else if(x<0 && y==0) return 2;
    else if(x==0 && y<0) return 3;
    else if(x>0 && y==0) return 4;
    else return 0;
}


//clases auxiliares para rectangulo
public punto mayor(punto a){
    if(a.x > x && a.y>y) return a;
    else if(x> a.x && y>a.y) return new punto(nombre,x, y);
    else if(a.x==x){
        if(a.y>y)return a;
        else if(y>a.y) return new punto(nombre,x,y);
        else return a;
    }
    else if (x==0){
        if(a.x>x && a.y>y) return a;
        else if(a.x>x && (a.y==y || a.y>y))return a; 
        else return new punto(nombre,x,y); 
    }
    else if(a.x==0){
        if(a.x>x && a.y>y) return a;
        else if(a.x>x && (a.y==y || a.y>y))return a; 
        else return new punto(nombre,x,y); 
    }
    //nuevo punto
    else if(x<a.x && y>a.y) return new punto("medio",a.x,y);
    else if(x>a.x && y<a.y) return new punto("medio",x,a.y);
    
    else return null;
}

public punto menor(punto a){
    if(a.x < x && a.y<y) return a;
    else if(x< a.x && y<a.y) return new punto(nombre,x, y);
    else if(a.x==x){
        if(a.y<y)return a;
        else if(y<a.y) return new punto(nombre,x,y);
        else return a;
    }
    else if (x==0){
        if(a.x<x && a.y<y) return a;
        else if(a.x<x && (a.y==y || a.y<y))return a; 
        else return new punto(nombre,x,y);
    }
    else if(a.x==0){
        if(a.x<x && a.y<y) return a;
        else if(a.x<x && (a.y==y || a.y<y))return a;
        else return new punto(nombre,x,y);
    }
    //nuevo punto
    else if(x<a.x && y>a.y) return new punto("medio",x,a.y);
    else if(x>a.x && y<a.y) return new punto("medio",a.x,y);
    else return null;
}

}