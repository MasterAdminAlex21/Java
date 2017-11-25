package financieros;
import javax.swing.*;


public class prueba extends javax.swing.JFrame{
    
    private JLabel jlb1;
    private JButton jbt;
    
    
    public prueba(){
        initComponents();
    }
    
    private void initComponents(){
        jlb1=new JLabel();
        jbt=new JButton();
        jlb1.setText("ejemplo");
        jbt.setText("ok");
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(380, 420);
        jlb1.setSize(50, 15);
        jbt.setSize(50,15);
        jlb1.setVisible(true);
        jbt.setVisible(true);
        
        
    }
    
    public static void main(String args[]){
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                new prueba().setVisible(true);}
        });
    }
    
}
