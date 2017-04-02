/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.util.ArrayList;

public class Grafo {

    private ArrayList<Nodo> listaNodo;//declaracion de un listado que contendra a los dodos
    private int marcado = 1;
    private int conteo = 0;

    public Grafo() {
        listaNodo = new ArrayList<Nodo>();//creacion del listado

    }

    public void adjuntarNodo(Nodo nodo) {
        listaNodo.add(nodo);//ingreso del nodo a la lista
    }

    public void crearEnlaces(int nombreNodoPadre, int nombreNodoHijo) {//creacion de los enlaces
        Nodo padre = buscarNodo(nombreNodoPadre); //de donde va
        Nodo hijo = buscarNodo(nombreNodoHijo);//a donde va



        if (padre != null && hijo != null) {

            padre.setNodo(hijo);//indica que no esta dirigido el nodo
            hijo.setNodo(padre);
            return;

        }




    }

    public Nodo buscarNodo(int nombreNodo) {
        Nodo temp = null;//cra un nodo temporal nulo , por si no se encuentra el nodo en el listado
        for (int i = 0; i < listaNodo.size(); i++) {//recorre el listado de nodos
            if (nombreNodo == listaNodo.get(i).getDato()) {

                return listaNodo.get(i);// si el nombre del nodo esta en la lista y regresa el ndodo y su marca(visitado o no visitado)
            }
        }
        return temp;//si todo falla regresa dato nulo
    }

  

    public String puntoDebil() {
        long time_start, time_end;
        time_start = System.currentTimeMillis();

        String v[] = new String[2];
        v[0] = "";

        for (Nodo x : this.listaNodo) {
            marcado(x, v);
            x.visitado = true;

        }
        time_end = System.currentTimeMillis();

        return conteo + " " + v[0] + (time_end - time_start) + " milisegundos";
    }

    private void marcado(Nodo x, String[] v) {

        for (Nodo j : x.getHijos()) {

            if (j.visitado) {

                continue;
            }

            x.valor = marcado;
            j.valor = marcado;

            boolean va = x.recorre2(j, marcado);
            if (!va) {

                conteo++;
                v[0] += x.getDato() + " " + j.getDato() + " ";
            }
            marcado++;

        }

    }
}
