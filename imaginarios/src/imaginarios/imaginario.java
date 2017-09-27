package imaginarios;

public class imaginario{
    private int real;
    private int imagin;
    private double radio;
    private double angulo;
    public imaginario(){
        real=1;
        imagin=1;
        
        radio=0;
        angulo=0;
    }
    public imaginario(int r,int im){
        real=r;
        imagin=im;
        
        radio=0;
        angulo=0;
    }
    public imaginario(imaginario a){
        real=a.real;
        imagin=a.imagin;
        
        radio=a.radio;
        angulo=a.angulo;
    }
    
    public void suma(imaginario a, imaginario b){
        real=a.real + b.real;
        imagin=a.imagin + b.imagin;
    }
    public void suma(imaginario a){
        real+=a.real;
        imagin+=a.imagin;
    }
    public void resta(imaginario a, imaginario b){
        real=a.real - b.real;
        imagin=a.imagin - b.imagin;
    }
    public void resta(imaginario a){
        real-=a.real;
        imagin-=a.imagin;
    }
    
    public void multiplicacion(imaginario a, imaginario b){
        real=(a.real * b.real)- (a.imagin * b.imagin);
        imagin=(a.real * b.imagin) + (a.imagin * b.real);
    }
    
    @Override
    public String toString(){
        if(imagin>0 && real!=0){
            if (imagin==1) return real+"+"+"i";  
            else if(imagin==(-1)) return real+"-i";
            else return real+"+"+imagin+"i";
        }else if(imagin==0){
            return real+"";
        }else if(real==0){
            if(imagin==1)return "i";
            else if(imagin==(-1)) return "-i";
            else return imagin+"i";
        }else{
            if(imagin==1) return real+"+i";
            else if(imagin==(-1)) return real+"-i";
            else return real+""+imagin+"i";
        }
    }
    
    //para polares
    
    protected int real(){
        return real;
    }
    protected int imaginario(){
        return imagin;
    }
    
    public void polar(){
        radio=Math.sqrt((real*real)+(imagin*imagin));
        if(real==0){
            angulo=90;
        }else{
            angulo=Math.toDegrees(Math.atan((double)(imagin)/(double)(real)));
        }
        
        System.out.print("["+radio+"|_"+angulo+"]");
    }
    
    public boolean equals(imaginario a){
        if(a.real==real && a.imagin== imagin) return true;
        else return false;
    }
    
    //generar algoritomo para mayor y menor
    
    public imaginario mayor(imaginario a, imaginario b){
        //imaginario may;
        if(a.real>b.real){
            if(a.imagin>b.imagin) return new imaginario(a.real,a.imagin);
            else if (b.imagin==0 && a.imagin>0) return new imaginario(a.real,a.imagin);
            else if(a.imagin==0 && b.imagin<=0) return new imaginario(a.real,0);
            else if(b.real<0 ) return new imaginario(a.real,a.imagin);
            else if(a.imagin<b.imagin) return new imaginario(b.real,b.imagin);
            else return null;
        }
        
        else if(b.real>a.real){
           if(b.imagin>a.imagin) return new imaginario(b.real,b.imagin);
            else if (a.imagin==0 && b.imagin>0) return new imaginario(b.real,b.imagin);
            else if(b.imagin==0 && a.imagin<=0) return new imaginario(b.real,0);
            else if(a.real<0 ) return new imaginario(b.real,b.imagin);
            else if(b.imagin<a.imagin) return new imaginario(a.real,a.imagin);
            else return null; 
        }
        else if(a.real==b.real){
            if(a.imagin>b.imagin) return new imaginario(a.real,a.imagin);
            else if(a.imagin<b.imagin) return new imaginario (b.real,b.imagin);
            else if(a.imagin==b.imagin) return new imaginario(a.real,a.imagin);
            else return null;
        }
        
        
        else return null;
    }
    
    public imaginario menor(imaginario a, imaginario b){
        
        if(a.real<b.real){
            if(a.imagin<b.imagin) return new imaginario(a.real,a.imagin);
            else if (b.imagin==0 && a.imagin<0) return new imaginario(a.real,a.imagin);
            else if(a.imagin==0 && b.imagin>=0) return new imaginario(a.real,0);
            else if(b.real>0 ) return new imaginario(a.real,a.imagin);
            else if(a.imagin>b.imagin) return new imaginario(b.real,b.imagin);
            else return null;
        }
        
        else if(b.real<a.real){
           if(b.imagin<a.imagin) return new imaginario(b.real,b.imagin);
            else if (a.imagin==0 && b.imagin<0) return new imaginario(b.real,b.imagin);
            else if(b.imagin==0 && a.imagin>=0) return new imaginario(b.real,0);
            else if(a.real>0 ) return new imaginario(b.real,b.imagin);
            else if(b.imagin>a.imagin) return new imaginario(a.real,a.imagin);
            else return null; 
        }
        else if(a.real==b.real){
            if(a.imagin<b.imagin) return new imaginario(a.real,a.imagin);
            else if(a.imagin>b.imagin) return new imaginario (b.real,b.imagin);
            else if(a.imagin==b.imagin) return new imaginario(a.real,a.imagin);
            else return null;
        }
        
        
        else return null;
        
    }
    
}