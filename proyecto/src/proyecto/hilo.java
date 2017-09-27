package proyecto;

import banco.fecha;

public class hilo extends Thread{
    private int dia,mes,año;
    private fecha fec;
    public hilo(){
        super("Fecha");
        System.out.println("Hilo fecha: "+this);
        start();
    }
    
    private void cal(){
         if( dia==31 && mes==12){
            año+=1;
            mes=1;
            dia=1;
            
        }else if(dia==29 && mes==2 ){
            dia=1;
            mes+=1;
            
        }else if(dia==30 && (mes==4 || mes==6 || mes==9 || mes==11)){
            dia=1;
            mes+=1;
            
        }else if(dia==31 &&(mes==1 || mes==3 || mes==5 || mes==7 || mes==8 || mes==10)){
            dia=1;
            mes+=1;
            
        }else if(dia==28 && (mes==2) && año%4!=0){
            dia=1;
            mes+=1;
            
        }else if(dia==29 && mes==2 && año%4==0){
            dia=1;
            mes+=1;
        }else{
            dia+=1;
        }
        
    }
    
    public fecha calendario(){
        return new fecha(dia,mes,año);
    }

    
    public void run(){
        mes=1;
        año=1950;
        try{
            while(true){
                cal();
                fec=calendario();
                //System.out.println(fec);
                Thread.sleep(500);
                if(año==5000) break;
                    
            }
        }catch(InterruptedException e){
            System.out.println("Se murio el calendario");
            System.exit(0);
        }
    }
    
}

class prin{
    public static void main(String args[]){
        new hilo();
    }
}