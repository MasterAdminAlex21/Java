package proyecto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import banco.*;

public class jcliente extends JFrame implements ActionListener{
    private JLabel nombre;
    private JButton buscar;
    private JTextField nom;
    private banco ban;
    private String nomb;
    private hilo h;
    private joperacion op=new joperacion();
    
    public jcliente(/*banco b,hilo calen*/){
        setTitle("Cliente");
        setSize(480, 130);
        setLocation(400, 290);
        setResizable(false);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        //ban=b;
        //h=calen;
        
        //creacion de los componentes
        nombre=new JLabel("Nombre del cliente:");
        nombre.setSize(150, 20);
        
        nom=new JTextField();
        nom.setSize(300, 20);
        
        buscar=new JButton("Aceptar");
        buscar.setSize(90, 20);
        
        
        //se crea el panel
        Container pane=getContentPane();
        pane.setLayout(new GroupLayout(pane));
        
        //se agregan al panel
        pane.add(nombre).setLocation(20, 20);
        pane.add(nom).setLocation(150, 20);
        pane.add(buscar).setLocation(200, 60);
        
        //se agrega el listener
        buscar.addActionListener(this);
    }
    
//class busc implements ActionListener{
    public void actionPerformed(ActionEvent e){
        //buscar
        
        nomb=nom.getText();
        int i;
        for(i=0;i<ban.cli();i++){
         if(nomb.equalsIgnoreCase(ban.obtenerCliente(i).nombre())){
          op.obtendatos(ban.obtenerCliente(i),h);
          op.setVisible(true);
          this.setVisible(false);
          nom.setText("");
//          this.hide();
          break;
         }
        }
        
        if(i==ban.cli()){
         //aqui va el error
         //final JPanel error=new JPanel();
         JOptionPane.showMessageDialog(new JPanel(), "No existe el cliente","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void obtendatos(banco b,hilo fecha){
     ban=b;
     h=fecha;
    }
//}
/*
    public static void main(String args[]){
        new jcliente(new banco(""),new hilo()).setVisible(true);
    }//*/
    
}//fin clase


