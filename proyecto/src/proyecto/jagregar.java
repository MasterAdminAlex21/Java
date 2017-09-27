package proyecto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import banco.*;
import java.util.*;

public class jagregar extends JFrame implements ActionListener{
    private JLabel nombre;
    private JButton agregar;
    private JTextField nom;
    public String nomb;
    private banco b;
    
    public jagregar(/*banco ba*/){
        setTitle("Agregar Cliente");
        setLocation(440,250);
        setSize(430, 200);
        setResizable(false);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        //b=ba;
        //creacion de compoentes
        nombre=new JLabel("Ingrese nombre");
        nombre.setSize(100, 20);
        
        agregar=new JButton("Agregar cliente");
        agregar.setSize(150, 20);
        
        nom=new JTextField();
        nom.setSize(250, 20);
        
        //contenedor
        Container pane=getContentPane();
        pane.setLayout(new GroupLayout(pane));
        
        //se agregan los componentes
        pane.add(nombre).setLocation(20, 50);
        pane.add(nom).setLocation(130, 50);
        pane.add(agregar).setLocation(120, 100);
        
        //se agregan listeners
        
        agregar.addActionListener(this);
        
    }
    
    public void obtenbanco(banco ba){
     b=ba;
    }

//class agr implements ActionListener{
 public void actionPerformed(ActionEvent e){
  //agregar cliente
  //this.hide();//falta hacer validaciones
  
  int i;
  for(i=0;i<b.cli();i++){
   if(nom.getText().equalsIgnoreCase(b.obtenerCliente(i).nombre())){
    JOptionPane.showMessageDialog(new JPanel(), "Ya hay un cliente con ese nombre","Error",JOptionPane.ERROR_MESSAGE);
    break;
   }
  }
  if(i==b.cli()){
   b.agregarCliente(new cliente(nom.getText(),new ArrayList<cuenta>()));
   JOptionPane.showMessageDialog(new JPanel(), "Cliente agregado","OK",JOptionPane.OK_OPTION,new ImageIcon("C:\\Users\\Athena megumi\\Documents\\NetBeansProjects\\proyecto\\src\\imgns\\accepted icon.png"));
   this.setVisible(false);
  }
  nom.setText("");
  
  //jbanco.setVisible(true);
  
 }
//}
    /*
    public static void main(String args[]){
        new jagregar(new banco("ejemplo")).setVisible(true);
    }//*/
    
}//fin clase

