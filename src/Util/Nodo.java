/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.util.ArrayList;

public class Nodo {

    private int dato;// define a dato como un objeo simple
    private ArrayList<Nodo> nodo;//define a los lugares en la lista como nodos
//    public boolean visitado = false;// define un parametro del tipo booleano para la marca visitado...... no se
    public int valor;//valor indica el elemnto que no se debe visitar
    public boolean visitado=false;

    public Nodo() {
    }

    public Nodo(int dato) {//metodo sobre cargado de Nodo
        this.dato = dato;//define un puntero para dato
        nodo = new ArrayList<Nodo>();//creacion del nodo en el arreglo
    }

    public void setDato(int dato) {//los metodos getDato y setDato sirven para poder marcar al nodo con un dato (el booleano)
        this.dato = dato;
    }

    public int getDato() {
        return this.dato;
    }

    public void setNodo(Nodo nodo) {//puntero para el nodo al agragarlo
        this.nodo.add(nodo);
    }

    public ArrayList<Nodo> getHijos() {//para identificar en el arreglo quien es nodo hijo y devolverlo
        return nodo;
    }

    /**
     * metodo que se encarga de valir si un nodo esta conectado
     * @param a
     * @return
     */
    public boolean validarConexion(Nodo b) {

        for (Nodo x : this.nodo) {
            if (x == b) {

                return true;

            }
        }


        return false;
    }

    
    //metodo en prueba...1.3  funciona no se a mirado complejidad
    boolean recorre2(Nodo datoBusqueda, int marcado) {
        boolean m = false;

        for (Nodo x : this.nodo) {

            //como saber cuando es un punto......

            if (x.valor == marcado) {

                continue;
            }

            x.valor = marcado;
            if (x.validarConexion(datoBusqueda)) {

                return true;
            }

            m = x.recorre2(datoBusqueda, marcado );

            if(m==true){
            return true;
            }
        }       
        return m;
    }
}
