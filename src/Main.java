
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author vinda
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Metodos mt=new Metodos();
        int opc=0;
        while(opc!=5){
            opc=Integer.parseInt(JOptionPane.showInputDialog(null,"••• Bienvenido a vetereniaria HappyPet •••\n\n"
                    +"Seleccione la opción que desea realizar.\n"
                    + "1. Registrar usuario\n"
                    + "2. Mostrar Registro\n"
                    + "3. Catalogos\n"
                    + "5. Salir","Menú Principal", JOptionPane.QUESTION_MESSAGE));
             
            switch(opc){
            case 1:
                mt.agregarUsuario();
                break;
            case 2:
                mt.mostrarRegistro();
                break;
            case 3:
                int op=0;
                mt.MenuCatalogo(op);
                break;
            case 5:
                JOptionPane.showMessageDialog(null,"Gracias por visitarnos¡¡");
                
                
            
        }
        }
        
        
    }
    
}
