
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vindas
 */
public class Metodos {
    
    private NodoR1 inicio;
    private NodoR1 fin;
    private NodoLSC_Propietario inicioCP;//cataoloPorpietrario
    private NodoLSC_Propietario finCP;
    
    public Metodos(){
        this.inicio=null;
        this.fin=null;
        this.inicioCP=null;
        this.finCP=null;
    }
    
    public boolean esvaciaLSPropietarios(){
        if(inicioCP==null){
            return true;
        }else{
            return false;
        }
    }
   public boolean esvacia(){
       if(inicio==null){
           return true;
       }else{
           return false;
       }
   }
   
   public void agregarUsuario(){//Modulo 1
       RegistroUsuario ru=new RegistroUsuario();
       ru.setNombre(JOptionPane.showInputDialog("Ingrese el nombre del usuario"));
       ru.setApellidos(JOptionPane.showInputDialog("Ingrese los apellidos del usuario"));
       ru.setUsuario(JOptionPane.showInputDialog("Ingrese el usuario (Nickname)"));
       ru.setContra(JOptionPane.showInputDialog("Establezca una contraseña para el usuario"));
       ru.setEstado(Integer.parseInt(JOptionPane.showInputDialog("Ingrese un '1' si el usuario se encuentra activo\n"
               + "Ingrese un '2' si el usuario se encuentra inactivo")));
       NodoR1 nuevo=new NodoR1();
       nuevo.setElementoRu(ru);
       if(esvacia()){
           inicio=nuevo;
           fin=nuevo;
       }else{
           fin.setSiguiente(nuevo);
           fin=nuevo;
       }
    JOptionPane.showMessageDialog(null,"Usuario Registrado con exito");
   }
   
   public void mostrarRegistro(){
       if(!esvacia()){
           String s="";
           String estado="";
           NodoR1 aux=inicio;
           while(aux!= null){
               if(aux.getElementoRu().getEstado()==1){
                   estado="Activo";
               }
               if(aux.getElementoRu().getEstado()==2){
                   estado="Inactivo";
               }
               
               s=s+"Nombre: "+aux.getElementoRu().getNombre()+"\n"
                       + "Apellidos: "+aux.getElementoRu().getApellidos()+"\n"
                       +"Usuario: " +aux.getElementoRu().getUsuario()+"\n"
                       +"Contraseña: "+aux.getElementoRu().getContra()+"\n"
                       +"Estado: "+estado+"\n\n";
               aux=aux.getSiguiente();
           }
           JOptionPane.showMessageDialog(null,s);
           
       }
       
   }
   public void ListaCatalogoPropietarios(){//agregar a lista
       CatalogoPropietario dato=new CatalogoPropietario();
       dato.setNombre(JOptionPane.showInputDialog("Ingrese el nombre"));
       dato.setApellidos(JOptionPane.showInputDialog("Ingrese los apellidos"));
       dato.setCiudad(JOptionPane.showInputDialog("Ingrese la ciudad a la que corresponde"));
       dato.setDireccion(JOptionPane.showInputDialog("Ingrese la dirección exacta"));
       dato.setTelefono(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de teléfono")));
       dato.setCorreo(JOptionPane.showInputDialog("Ingrese la dirección de correo"));
       dato.setEstado(Integer.parseInt(JOptionPane.showInputDialog("Ingrese un '1' si se ecncuentra activo o un '2' si está inactivo " )));
       
       NodoLSC_Propietario nuevo =new NodoLSC_Propietario();
       nuevo.setElemento(dato);
       if(esvaciaLSPropietarios()){
           inicioCP=nuevo;
           finCP=nuevo;
           finCP.setSiguiente(inicioCP);
       }else if(dato.getNombre().compareTo(inicioCP.getElemento().getNombre())<=0){
           nuevo.setSiguiente(inicioCP);
           inicioCP=nuevo;
           finCP.setSiguiente(inicioCP);
       }else if(dato.getNombre().compareTo(finCP.getElemento().getNombre())>0){
           finCP.setSiguiente(nuevo);
           finCP=nuevo;
           finCP.setSiguiente(inicioCP);
       }else{
           NodoLSC_Propietario aux=inicioCP;
           while(aux.getSiguiente().getElemento().getNombre().compareTo(dato.getNombre())<0){
               aux=aux.getSiguiente();
           }
           nuevo.setSiguiente(aux.getSiguiente());
           aux.setSiguiente(nuevo);
           finCP.setSiguiente(inicioCP);
       }
       
   }
   
   
   public void verCatalogoPropietario(){
       if(!esvaciaLSPropietarios()){
           String s="";
           String estado="";
           NodoLSC_Propietario aux=inicioCP;
           if(aux.getElemento().getEstado()==1){
               estado="Activo";
           }else{
               estado="Inactivo";
           }
           s=s+ "Nombre: "+aux.getElemento().getNombre()
                   + " Apellidos: "+aux.getElemento().getApellidos()
                   + " Ciudad: "+aux.getElemento().getCiudad()
                   + " Dirección: "+aux.getElemento().getDireccion()
                   + " Teléfono: "+aux.getElemento().getTelefono()
                   + " Correo: "+aux.getElemento().getCorreo()
                   + " Estado: "+estado+"\n\n";
           aux=aux.getSiguiente();
         while(aux!=inicioCP){
             if(aux.getElemento().getEstado()==1){
               estado="Activo";
           }else{
               estado="Inactivo";
           }
             s=s+ "Nombre: "+aux.getElemento().getNombre()
                   + " Apellidos: "+aux.getElemento().getApellidos()
                   + " Ciudad: "+aux.getElemento().getCiudad()
                   + " Dirección: "+aux.getElemento().getDireccion()
                   + " Teléfono: "+aux.getElemento().getTelefono()
                   + " Correo: "+aux.getElemento().getCorreo()
                   + " Estado: "+estado+"\n\n";
           aux=aux.getSiguiente();
         } 
         
         JOptionPane.showMessageDialog(null,"Catalogo Propietarios\n\n"+s);
       }
   }
           
   
   public void MenuCatalogo(int op){
       if(op!=4){
           op= Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la opción que desea realizar\n"
                   + "1. Catalogo Propietarios\n"
                   + "2. Catalogo Especies\n"
                   + "3. Catalogo Mascotas\n"
                   + "4. Salir"     ,"Menú catalogo"
                   ,JOptionPane.QUESTION_MESSAGE));
          
           if(op==1){
               String opc="";
               while(!opc.equals("Atrás")){
                   String [] opciones= {"Agregar al catalogo","Mostrar Catalogo","Editar","Activar o Inactivar","Atrás"};
                    opc= (String)JOptionPane.showInputDialog(null,"Seleccione la opcion que desea Realiazar","Catalogo Propietarios ",
                    JOptionPane.QUESTION_MESSAGE,null,opciones,opciones[0]);
                    
                    if(opc.equals("Agregar al catalogo")){
                      ListaCatalogoPropietarios();  
               }
                    if(opc.equals("Mostrar Catalogo")){
                        verCatalogoPropietario();
                    }
           }
       }
           MenuCatalogo(op);
           
       }
       
   }
    
    
}
