/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vinda
 */
public class NodoR1 {
    private RegistroUsuario elementoRu;
    private NodoR1 siguiente;
    
    public NodoR1(){
        this.siguiente=null;
    }

    public RegistroUsuario getElementoRu() {
        return elementoRu;
    }

    public void setElementoRu(RegistroUsuario elementoRu) {
        this.elementoRu = elementoRu;
    }

    public NodoR1 getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoR1 siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
