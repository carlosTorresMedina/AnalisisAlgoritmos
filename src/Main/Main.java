/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Entrada.ArchivoLeerTexto;
import Entrada.Cargar;
import Entrada.IForm;
import Util.Grafo;
import Util.Nodo;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *finalizado.
 * @author carlos
 */
public class Main implements IForm {

    private int m;
    private ArrayList<Grafo> grafo = new ArrayList();
    private Cargar cargar;

    public Main() {
        this.cargar = new Cargar(this, this);
        this.grafo = new ArrayList();
    }

    public void buscarPuntos() {



        for (Grafo g : this.grafo) {

            String resul = g.puntoDebil();
            System.out.println(resul);

        }
    }

    public static void main(String ar[]) {

        Main objeto = new Main();
        objeto.cargar.setVisible(true);

    }

    public void cargarArchivo(String cad) {
        ArrayList<String> resultado = new ArrayList();
        String[] v2 = new String[2];
        try {
            ArchivoLeerTexto file = new ArchivoLeerTexto(cad, "\n");
            String v[][] = file.leerTodo();

            for (String x[] : v) {
                resultado.addAll(Arrays.asList(x));
            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (String x : resultado) {

            v2 = x.split(" ");
            int a = Integer.parseInt(v2[0]);
            int b = Integer.parseInt(v2[1]);

            if (a == 0 && b == 0) {
//              System.out.print("entre");
                this.buscarPuntos();
                return;
            }


            this.crear(a, b);
        }


    }

    public void crear(int a, int b) {



        if (this.m == 0) {
            m = b;
            this.grafo.add(new Grafo());

            Grafo g = this.grafo.get(this.grafo.size() - 1);

            int i = 0;
            while (i < a) {
                g.adjuntarNodo(new Nodo(i));
                i++;

            }

        } else {

            Grafo g = this.grafo.get(this.grafo.size() - 1);

            g.crearEnlaces(a, b);
            m--;

        }
    }
}
