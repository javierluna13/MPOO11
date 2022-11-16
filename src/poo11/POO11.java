/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poo11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author javierluna
 */
public class POO11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Alumno alumno= new Alumno();
        alumno.setNombre("Hugo");
        alumno.setApellidoPaterno("Hernandez");
        alumno.setApellidoMaterno("Rivera");
        alumno.setNumCuenta(319035241);
        alumno.setEdad(22);
        alumno.setPromedio(9.7f);
        
        //para el archivo
        System.out.println("####File####");
        File archivo = new File("archivo.txt");
        System.out.println(archivo.exists());
        boolean seCreo;
        try {
            seCreo=archivo.createNewFile();//bandera de control
            System.out.println(seCreo);//se crea
            System.out.println(archivo.exists());//se pregunta si se creo
        } catch (IOException ex) {
            Logger.getLogger(POO11.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //aprendemos a escribir desde terminal
        System.out.println("#### FileWrite, obtener desde ek teclado ####");
        try {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Escribe texto para el archivo: ");
        String texto= br.readLine();
            System.out.println(texto);
        } catch (IOException ex) {
            Logger.getLogger(POO11.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("#### Alumno ####");
        System.out.println("#### FileWrite ####");
        try {
            FileWriter fw= new FileWriter("listaAlumno.csv");
            BufferedWriter bw= new BufferedWriter(fw);
            try (PrintWriter salida = new PrintWriter(bw)) {
                salida.println(alumno.getNombre()+","+alumno.getApellidoPaterno()+","+alumno.getApellidoMaterno()+","+alumno.getNumCuenta()+","+alumno.getEdad()+","+alumno.getPromedio());
                salida.println("Esto es la segunda linea");
                for(int i=0; i<10; i++){
                    System.out.println("Linea de archivo"+ i);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(POO11.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("####FileReader####");
        try{
            FileReader fr= new FileReader("ListaAlumno.csv");
            BufferedReader br= new BufferedReader(fr);
            System.out.println("El texto es: ");
            String linea= br.readLine();
        
            System.out.println("#### StringTokenizador ####");
            StringTokenizer tokenizador= new StringTokenizer(linea, ",");
            while(tokenizador.hasMoreTokens()){
                System.out.println(tokenizador.nextToken());
            }
            br.close();
        }catch (FileNotFoundException ex){
            Logger.getLogger(POO11.class.getName()).log(Level.SEVERE,null, ex);
        }catch (IOException ex){
            Logger.getLogger(POO11.class.getName()).log(Level.SEVERE,null, ex);
        }
        System.out.println("####Alumno####");
        System.out.println(alumno);
    }
    
    
}
