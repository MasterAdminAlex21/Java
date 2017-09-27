package geometria;

public class rectangulo{
    private String nombre;
    private punto a;
    private punto b;
    
    public rectangulo(){
        a=new punto(1,1);
        b=new punto(1,1);
        nombre="desconocido";
    }
    
    public rectangulo(String nom, punto a1, punto b1){
        nombre=nom;
        a=new punto(a1, "p");
        b=new punto(b1,"q");
    }
    
    public rectangulo(String nom, int x1,int y1,int x2, int y2){
        nombre=nom;
        a=new punto("p", x1, y1);
        b=new punto("q",x2,y2);
    }
    
    public rectangulo(rectangulo r){
        a=new punto(r.a);
        b=new punto(r.b);
        nombre="copia de "+r.nombre;
    }
    
    @Override
    public String toString(){
        return nombre+":["+a+","+b+"]";
    }
    
    //empiezan los metodos
    
    public rectangulo union(rectangulo r){
        rectangulo union;
        punto auxM,auxm;
        auxM=r.b.mayor(b);
        auxm=r.a.menor(a);
        union=new rectangulo("union", auxm, auxM);
        return union;
    }
    
    public rectangulo interseccion(rectangulo r){
        rectangulo inter;
        punto auxM,auxm;
        auxm=r.a.mayor(a);
        auxM=r.b.menor(b);
        inter=new rectangulo("interseccion",auxm,auxM);
        return inter;
    }
    
    //metodos auiliares
    public punto inicio(){
    return a;
    }
    public punto termino(){
        return b;
    }
    
    
    public boolean estaAdentro(punto x){
        if(x.obtenx()>=a.obtenx() && x.obtenx()<=b.obtenx())
            if(x.obteny()>=a.obteny() && x.obteny()<=b.obteny())
                return true;
            else return false;
        else return false;
    }
    
    public double area(){
        return (b.obtenx()-a.obtenx())*(b.obteny()-a.obteny());
    }
    
    public int comparar(rectangulo x){
        if(x.area()<this.area())
                return 1;
            
        
        else if(x.area()>this.area())
            
                return -1;

        
        else if(x.area()==this.area())
                return 0;
            else return 2;
        
    }
    
    public void moverRect(punto a1, punto b1){
        a=new punto("p", a1.obtenx(), a1.obteny());
        b=new punto("q",b1.obtenx(),b1.obteny());
    }
    
    public int comparar(rectangulo r, triangulo t){
    if(t==null && r!=null) return this.comparar(r);
    else if(r==null && t!=null){
        if(t.area()<this.area()) return 1;
        else if(t.area()>this.area()) return -1;
        else if(t.area()==this.area()) return 0;
        else return 2;
    }
    else return 2;
}
}