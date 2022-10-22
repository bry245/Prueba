/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vinda
 */
public class NodoLSC_Propietario {
    private CatalogoPropietario elemento;
    private NodoLSC_Propietario siguiente;
    
    public NodoLSC_Propietario(){
        this.siguiente=null;
    }

    public CatalogoPropietario getElemento() {
        return elemento;
    }

    public void setElemento(CatalogoPropietario elemento) {
        this.elemento = elemento;
    }

    public NodoLSC_Propietario getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLSC_Propietario siguiente) {
        this.siguiente = siguiente;
    }
    
}
