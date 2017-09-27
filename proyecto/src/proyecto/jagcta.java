package proyecto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import banco.*;

public class jagcta extends JFrame implements ActionListener{
 private JRadioButton ahorros,cheques,credito;
 private JLabel monto,tasa,sobregiro;
 private JTextField mon,tas,sobre;
 private ButtonGroup sel;
 private JButton ac;
 private cliente clien;
 private hilo h;
 
 public jagcta(/*cliente cli,hilo fec*/){
  setTitle("Agregar cuenta");
  setSize(250,250);
  setResizable(false);
  setLocation(300,100);
  setDefaultCloseOperation(HIDE_ON_CLOSE);
  //clien=cli;
  //h=fec;
  
  //se crean los componentes
  ahorros=new JRadioButton("Ahorros",true);
  ahorros.setSize(74,15);
  
  cheques=new JRadioButton("Cheques",false);
  cheques.setSize(75,15);
  
  credito=new JRadioButton("Credito",false);
  credito.setSize(74,15);
  
  sel=new ButtonGroup();
  sel.add(ahorros);
  sel.add(cheques);
  sel.add(credito);
  
  monto=new JLabel("Monto");
  monto.setSize(80,20);
  
  tasa=new JLabel("Tasa(%)");
  tasa.setSize(80,20);
  
  sobregiro=new JLabel("Sobregiro");
  sobregiro.setSize(80, 20);
  
  mon=new JTextField();
  mon.setSize(100,20);
  
  tas=new JTextField();
  tas.setSize(100,20);
  
  sobre=new JTextField();
  sobre.setSize(100,20);
  
  ac=new JButton("Aceptar");
  ac.setSize(80,20);
  
  //se crea el panel
  Container pane=getContentPane();
  pane.setLayout(new GroupLayout(pane));
  
  //se agregan los componentes
  pane.add(ahorros).setLocation(20,10);
  pane.add(cheques).setLocation(95,10);
  pane.add(credito).setLocation(170,10);
  pane.add(monto).setLocation(10,50);
  pane.add(mon).setLocation(100,50);
  pane.add(ac).setLocation(90,160);
  
  pane.add(sobregiro).setLocation(10,110);
  pane.add(sobre).setLocation(100,110);
  
  
  pane.add(tasa).setLocation(10,80);
  pane.add(tas).setLocation(100,80);
  
  //se agregan eventos
  cheq lis=new cheq();
  cheques.addActionListener(lis);
  
  cre lis2=new cre();
  credito.addActionListener(lis2);
  
  ahorros.addActionListener(lis2);
  ac.addActionListener(this);
 }
 
 private class cheq implements ActionListener{
 public void actionPerformed(ActionEvent e){
   //radio button cheques
   if(cheques.isSelected()){
   tasa.setVisible(false);
   tas.setVisible(false);
   
   sobregiro.setVisible(true);
   sobre.setVisible(true);
  }
 }
}
 
 
private class cre implements ActionListener{
 public void actionPerformed(ActionEvent e){
  //radio button credito
  if(ahorros.isSelected()==true || credito.isSelected()==true){
   tasa.setVisible(true);
   tas.setVisible(true);
   
   sobregiro.setVisible(false);
   sobre.setVisible(false);
  }
 }
}

//private class aceptar implements ActionListener{
 public void actionPerformed(ActionEvent e){
  try{
  fecha ap=h.calendario();
  if(ahorros.isSelected()==true){
   if(Double.parseDouble(tas.getText())>=100 || Double.parseDouble(tas.getText())<1){
    JOptionPane.showMessageDialog(new JPanel(), "Tasa erronea","Error",JOptionPane.ERROR_MESSAGE);
   }else{
   clien.agregarCuenta(new ahorros(clien.nombre(), ap, Double.parseDouble(mon.getText()),(Double.parseDouble(tas.getText()))/100));
   JOptionPane.showMessageDialog(new JPanel(), "Cuenta agregada","OK",JOptionPane.OK_OPTION,new ImageIcon("C:\\Users\\Athena megumi\\Documents\\NetBeansProjects\\proyecto\\src\\imgns\\accepted icon.png"));
   this.setVisible(false); 
   }
  }else if(credito.isSelected()==true){
   if(Double.parseDouble(tas.getText())>=100 || Double.parseDouble(tas.getText())<1){
    JOptionPane.showMessageDialog(new JPanel(), "Tasa erronea","Error",JOptionPane.ERROR_MESSAGE);
   }else{
   clien.agregarCuenta(new credito(clien.nombre(), Double.parseDouble(mon.getText()), (Double.parseDouble(tas.getText()))/100, ap));
   JOptionPane.showMessageDialog(new JPanel(), "Cuenta agregada","OK",JOptionPane.OK_OPTION,new ImageIcon("C:\\Users\\Athena megumi\\Documents\\NetBeansProjects\\proyecto\\src\\imgns\\accepted icon.png"));
   this.setVisible(false);
   }
  }else if(cheques.isSelected()==true){
   clien.agregarCuenta(new cheques(clien.nombre(), Double.parseDouble(mon.getText()), Double.parseDouble(sobre.getText()), ap));
   JOptionPane.showMessageDialog(new JPanel(), "Cuenta agregada","OK",JOptionPane.OK_OPTION,new ImageIcon("C:\\Users\\Athena megumi\\Documents\\NetBeansProjects\\proyecto\\src\\imgns\\accepted icon.png"));
   this.setVisible(false);
  }
  }catch(NumberFormatException err){
   JOptionPane.showMessageDialog(new JPanel(), "Ingrese digitos","ERROR",JOptionPane.ERROR_MESSAGE);
  }
  mon.setText("");
  sobre.setText("");
  tas.setText("");
  
  //this.hide();
 }
 
 public void obtendatos(cliente cli,hilo fec){
  clien=cli;
  h=fec;
 }
//}
 /*
 public static void main(String args[]){
  new jagcta().setVisible(true);
 }*/
}//fin clase


