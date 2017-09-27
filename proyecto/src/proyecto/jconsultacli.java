package proyecto;
import javax.swing.*;
import java.awt.*;
import banco.*;

public class jconsultacli extends JFrame{
 private JTextArea consulta;
 private JLabel cons;
 private banco b;
  private JScrollPane vert;
 
 public jconsultacli(/*banco ba*/){
  setTitle("Consulta de clientes");
  setSize(500, 500);
  setLocation(250, 100);
  //setVisible(true);
  setResizable(false);
  setDefaultCloseOperation(HIDE_ON_CLOSE);
  //b=ba;
  
  //creacion de los componentes
  consulta=new JTextArea();
  consulta.setEditable(false);
  consulta.setSize(400,400);
  consulta.setText("");
  
  cons=new JLabel("Clientes del Banco: ");
  cons.setSize(150, 50);
  
  vert=new JScrollPane(consulta,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
  vert.setBounds(new Rectangle(20,20,400,400));
  
  //se acrea el panel
  Container pane=getContentPane();
  pane.setLayout(new GroupLayout(pane));
  
  //se agregan los componentes
  pane.add(vert).setLocation(50, 50);
  pane.add(cons).setLocation(50, 10);
 
  //consulta.setText("");
 }
 
 public void imprimir(){
  consulta.setText("");
  //se imprimen los clientes
  String cl=b.repCli();
  if(cl==null)
   consulta.setText(b+"\n");
  else consulta.setText(b+"\n"+cl);
 }
 public void obtenbanco(banco ba){
  b=ba;
 }
 /*
 public static void main(String args[]){
  new jconsultacli().setVisible(true);
 }
*/
}
