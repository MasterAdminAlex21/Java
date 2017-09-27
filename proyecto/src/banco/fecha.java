package banco;

public class fecha{
    private int dia,mes,año;
    
    public fecha(int d,int m, int a){
        if(d<0 || d>31 || (d>29 && m==2 ) || (d>31 && (m==3 || m==5 || m==7 || m==8 || m==10 || m==12)) ){
            System.err.println("ERROR: fecha incorrecta");
        }else{
            if(a<1950) System.err.println("ERROR: fecha incorrecta");
            else{
                dia=d;
                mes=m;
                año=a;
            }
        }
    }
    
    public fecha obtenerfecha(){
       return new fecha(dia,mes,año); 
    }
    
    public void establecerfecha(int d,int m,int a){
        if(d<0 || d>31 || (d>28 && m==2 ) || (d>30 && (m==3 || m==5 || m==7 || m==8 || m==10 || m==12)) ){
            System.err.println("ERROR: fecha incorrecta");
        }else{
            if(a>1950) System.err.println("ERROR: fecha incorrecta");
            else{
                dia=d;
                mes=m;
                año=a;
            }
        }
    }
    
    @Override
    public String toString(){
        return dia+"/"+mes+"/"+año;
    }
    
    public int dia(){
     return dia;
    }
    public int mes(){
    return mes;
    }
    public int año(){
     return año;
    }
}//fin clase