package proyecto;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import banco.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class jmovimientos extends JFrame{
 private JTextArea movs;
 private JButton ac;
 private JTextField cta;
 private JLabel c;
 private cliente cl;
private JScrollPane barra;

 public jmovimientos(/*cliente cli*/){
  setTitle("Movimientos");
  setSize(400,400);
  setLocation(500,200);
  setDefaultCloseOperation(HIDE_ON_CLOSE);
  //setVisible(true);
  //cl=cli;
  
  //se crean los componentes
  movs=new JTextArea();
  movs.setEditable(false);
  movs.setSize(350, 300);
  
  ac=new JButton("Aceptar");
  ac.setSize(80, 20);
  
  cta=new JTextField();
  cta.setSize(50, 20);
  
  c=new JLabel("Numero de cuenta: ");
  c.setSize(150, 15);
  
  barra=new JScrollPane(movs,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
  barra.setBounds(new Rectangle(20,20,350,300));
  //se crea el panel
  Container pane=getContentPane();
  pane.setLayout(new GroupLayout(pane));
  
  //se agregan los componentes
  pane.add(c).setLocation(10,5);
  pane.add(cta).setLocation(125, 5);
  pane.add(ac).setLocation(180,5);
  pane.add(barra).setLocation(20, 25);
  
  movs.setText("");
  
  ace lis=new ace();
  ac.addActionListener(lis);
 }
 
 class ace implements ActionListener{
  public void actionPerformed(ActionEvent e){
   //se agrega el evento para consultar
   try{
   if(Integer.parseInt(cta.getText())>cl.numctas() || Integer.parseInt(cta.getText())-1==-1){
    JOptionPane.showMessageDialog(new JPanel(), "No existe esa cuenta","Error",JOptionPane.ERROR_MESSAGE);
   }else{
    ahorros aux;
    credito aux2;
    cheques aux3;
    cuenta ctaaux=cl.obtenerCuenta(Integer.parseInt(cta.getText())-1);
    
    if(ctaaux instanceof ahorros){
     aux=(ahorros)ctaaux;
     movs.setText(""+aux.leer());
    }else if(ctaaux instanceof credito){
     aux2=(credito)ctaaux;
     movs.setText(""+aux2.leer());
    }else if(ctaaux instanceof cheques){
     aux3=(cheques)ctaaux;
     movs.setText(""+aux3.leer());
    }
    
   }
   cta.setText("");
  }catch(NumberFormatException err){
   JOptionPane.showMessageDialog(new JPanel(), "Error al buscar cuenta","Error",JOptionPane.ERROR_MESSAGE);
  }
  }
 }

 public void obtencliente(cliente cli){
  cl=cli;
 }
 
 public void reiniciar(){
  movs.setText("");
 }
 /*
 public static void main(String args[]){
  new jmovimientos().setVisible(true);
 }//*/
}