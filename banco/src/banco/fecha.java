package banco;

public class fecha{
    private int dia,mes,año;
    public fecha(int d, int m,int a){
        if((d<0 || d>29) && m==2){
            System.err.println("Error: dia incorrecto");
        }else if(d<0 || d>31){
            System.err.println("Error: dia incorrecto");
        }
        else if(m<0 || m>12){
            System.err.println("Error: mes incorrecto");
        }
        else if(a<1950){
            System.err.println("Error: año incorrecto");
        }
        else{
        dia=d;
        mes=m;
        año=a;
        }
    }
    
    public fecha obtenerfecha(){
        return new fecha(dia,mes,año);
    }
    
    public void establecerfecha(int d, int m,int a){
        if((d<0 || d>29) && m==2){
            System.err.println("Error: dia incorrecto");
        }else if(d<0 || d>31){
            System.err.println("Error: dia incorrecto");
        }
        else if(m<0 || m>12){
            System.err.println("Error: mes incorrecto");
        }
        else if(a<0){
        
        }
        else{
        dia=d;
        mes=m;
        año=a;
        }
    }
    
    
    
}//fin clase