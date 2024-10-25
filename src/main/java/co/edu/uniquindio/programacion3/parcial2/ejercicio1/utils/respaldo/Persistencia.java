package co.edu.uniquindio.programacion3.parcial2.ejercicio1.utils.respaldo;

import co.edu.uniquindio.programacion3.parcial2.ejercicio1.utils.loggin.Seguimiento;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.ResourceBundle;

public class Persistencia {

    private static final String RUTA = "persistencia.config";
    public Persistencia() {

    }


    //------------------------------------ Cargar configuracion
    public static String cargarConfiguracion(String propiedad) {
        ResourceBundle config = ResourceBundle.getBundle(RUTA);
        System.out.println("config: " + config.getString(propiedad));
        return config.getString(propiedad);
    }

    /**
     * Este metodo recibe una cadena con el contenido que se quiere guardar en el archivo
     * @param propiedad es la ruta o path donde esta ubicado el archivo
     */
    public static void guardarArchivo(String propiedad, String contenido, Boolean flagAnexarContenido) throws IOException {

        FileWriter fw = new FileWriter("src/main/resources/persistencia/archivos/" + propiedad, flagAnexarContenido);
        BufferedWriter bfw = new BufferedWriter(fw);
        bfw.write(contenido);
        bfw.close();
        fw.close();
    }

    /**
     * ESte metodo retorna el contendio del archivo ubicado en una ruta,con la lista de cadenas.
     */
    public static ArrayList<String> leerArchivo(String propiedad) throws IOException {

        ArrayList<String>  contenido = new ArrayList<String>();
        FileReader fr= new FileReader(cargarConfiguracion(propiedad));
        BufferedReader bfr=new BufferedReader(fr);
        String linea="";
        while((linea = bfr.readLine())!=null)
        {
            contenido.add(linea);
        }
        bfr.close();
        fr.close();
        return contenido;
    }


    //------------------------------------SERIALIZACIÓN  y XML
    /**
     * Escribe en el fichero que se le pasa el objeto que se le envia
     *
     * @param propiedad
     *            path del fichero que se quiere escribir
     */

    public static Object cargarRecursoSerializado(String propiedad)throws Exception
    {
        Object aux = null;
//		Empresa empresa = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(cargarConfiguracion(propiedad)))) {
            // Se crea un ObjectInputStream

            aux = ois.readObject();

        } catch (Exception e2) {
            throw e2;
        }
        return aux;
    }


    public static void salvarRecursoSerializado(String propiedad, Object object)	throws Exception {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(cargarConfiguracion(propiedad)))) {
            oos.writeObject(object);
        } catch (Exception e) {
            throw e;
        }
    }

    public static Object cargarRecursoSerializadoXML(String propiedad) throws IOException {

        XMLDecoder decodificadorXML;
        Object objetoXML;

        decodificadorXML = new XMLDecoder(new FileInputStream(cargarConfiguracion(propiedad)));
        objetoXML = decodificadorXML.readObject();
        decodificadorXML.close();
        return objetoXML;

    }

    public static void salvarRecursoSerializadoXML(String propiedad, Object objeto) throws IOException {

        XMLEncoder codificadorXML;

        codificadorXML = new XMLEncoder(new FileOutputStream(cargarConfiguracion(propiedad)));
        codificadorXML.writeObject(objeto);
        codificadorXML.close();

    }
}
