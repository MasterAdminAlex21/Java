package grafico;
import javax.swing.*;

public class rectangulo extends JFrame{
    
    private final int width=400;
    private final int height=300;
    
    public rectangulo(){
        setTitle("Area de un rectangulo");
        setSize(width,height);
        setVisible(true);
        setLocation(500, 200);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String args[]){
        rectangulo rec=new rectangulo();
    }
    
}
