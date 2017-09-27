package imaginarios;

public class ejemplo{

    public static void main(String args[]){
        imaginario a=new imaginario(-2,3);
        imaginario b=new imaginario(5,-3);
        System.out.println("Imaginario 1");
        System.out.println(a.toString());
        System.out.println("imaginario 2");
        System.out.println(b.toString());
        imaginario c=new imaginario();
        
      /*  c.multiplicacion(a,b);
        System.out.println(c);
        /**/
        System.out.println("\nmatriz");
        menu me=new menu();
        matriz im=me.datos(1);
                //new matriz("ejemplo1", 3, 2, "r*500");
                if(im.filas()!=0 && im.columnas()!=0) im.imprimir();
        /*
        matriz im1=new matriz("ejemplo2", 3, 3, "r*200");
        im1.imprimir();
       
        /*
        
        System.out.println("\ncopia");
        matriz copy=new matriz("copia", im);
        copy.imprimir();
        /*
        im1=im1.transpuesta(im1);
        im1.imprimir();
        
        //if(im1.equals(im1)) System.err.println("Son matrices iguales");
        //else System.err.println("Son matrices distintas");
        
        
        copy=copy.multiplicar(im, im1);
        if(copy!=null) copy.imprimir();
        System.out.println("\n");
        im1.espiral();*/
       c=a.mayor(a, b);
        
        System.out.println("mayor\n"+c);
        
        c=c.menor(a, b);
        System.out.println("\nmenor\n"+c);
        
        c.polar();
        
        /*
        copy.restar(im,im1);
        copy.imprimir();
        im.imprimir();
        im1.imprimir();
        
        
        /*
        System.out.println("\n\n");
        polar pol=new polar(a);
        pol.imprimir();
        
        
        
        
        for(int i=0;i<5001;i++){
            
            System.out.print((char)i+" ");
            if(i%100==0) System.out.println();
        }*/
    }
    
}

