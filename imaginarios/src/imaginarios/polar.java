package imaginarios;
import java.math.*;

public class polar{
    private double angulo;
    private double radio;
    
    public polar(){
        angulo=0;
        radio=0;
    }
    
    public polar(imaginario a){
        radio=Math.sqrt((a.real()*a.real())+(a.imaginario()*a.imaginario()));
        if(a.real()==0){
            angulo=90;
        }else {
            //double aux=0;
            //System.out.println((double)a.imaginario()/(double)a.real());
            //angulo=Math.atan((double)a.imaginario()/(double)a.real());
            angulo=Math.toDegrees(Math.atan(0.5));
        }
        
        
        
    }
    
    @Override
    public String toString(){
        return (radio+"|_"+angulo);
    }

    public void imprimir(){
        System.out.println(this.toString());
    }
    
    
    
    
    
    
}