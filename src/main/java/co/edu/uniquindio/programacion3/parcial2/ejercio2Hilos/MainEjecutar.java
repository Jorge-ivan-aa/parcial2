package co.edu.uniquindio.programacion3.parcial2.ejercio2Hilos;

public class MainEjecutar {
    public static void main (String []args) throws InterruptedException {

        //creación de instancia de hilo t1 y t2
        Hilo1 t1 = new Hilo1();
        Hilo2 t2 = new Hilo2();

        //Inicialización de Hilos
        t1.start();
        t2.start();

        //Terminación de hilos
        t1.join();
        t2.join();

        //Obtencion de resultados S3
        int a=t1.getNumeroMenor();
        Double b=t2.getPromedioMatriz();
        Double c;
        if(b!=0){
            c=a/b;
            System.out.println("Resultado de C: " + c);
        }else{
            System.out.println("Resultado no valido. ");
        }
        System.out.println("Fin del programa :)");
    }

}