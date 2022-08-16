/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoescaños;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author FINANZA-RN
 */
class UsuariosTxt {

    @SuppressWarnings("resource")

    public void GuardarDatos(String login,String Password,int nivel, String nombre, String Apellido,String Correo) throws IOException {
        try {
            FileWriter F1 = new FileWriter("c:archivo_usuarios1.txt", true);
            PrintWriter pw = new PrintWriter(F1);
            pw.println(login + "; " + Password + "; " + nivel + "; " + nombre + "; " + Apellido  + "; " + Correo);
            pw.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al grabar Archivo " + ex);
        }

    } // fin metodo GuardarDatos

    public void Modificar(String LineaAntigua, String nuevalinea) {

        File fNuevo = new File("c:archivo_usuarios2.txt");
        File fAntiguo = new File("c:archivo_usuarios1.txt");
        String aCadena = LineaAntigua;
        String nCadena = nuevalinea;

        BufferedReader br;
        try {
            if (fAntiguo.exists()) {
                br = new BufferedReader(new FileReader(fAntiguo));

                String linea;

                while ((linea = br.readLine()) != null) {
                    if (linea.equals(aCadena)) {
                        Escribir(fNuevo, nCadena);
                    } else {
                        Escribir(fNuevo, linea);
                    }
                } // fin while

                br.close();

                String nAntiguo = fAntiguo.getName();

                borrar(fAntiguo);

                fNuevo.renameTo(fAntiguo);
            } else {
                System.out.println("Fichero no Existe");
            }

        } // fin try
        catch (Exception e) {
            System.out.println(e);
        }
    } // fin metodo Modificar

    void Escribir(File fFichero, String cadena) {

        BufferedWriter bw;

        try {
            if (!fFichero.exists()) {
                fFichero.createNewFile();
            }

            bw = new BufferedWriter(new FileWriter(fFichero, true));
            bw.write(cadena + "\r\n");
            bw.close();

        }// fin try
        catch (Exception e) {
            System.out.println(e);
        }

    } // fin metodo Escribir

    void borrar(File Ffichero) {
        try {

            if (Ffichero.exists()) {
                Ffichero.delete();
                System.out.println("Ficherro Borrado");
            }

        } // fin try
        catch (Exception e) {
            System.out.println(e);
        }
    } 
    
    public boolean Validarletras(String datos){
        // Patron para validar el string
        return datos.matches("[ a-zA-ZñÑáéíóúÁÉÍÚÓ/.,$-]*");
        
    }
    public boolean Validarpass(String datos){
        // Patron para validar el string
        return datos.matches("[ a-zA-ZñÑáéíóúÁÉÍÚÓ/.,$-0-9]*");
        
    }
    public boolean Validarcod(String datos){
        // Patron para validar el string
        return datos.matches("[0-1]");
        
    }

    
    
}
