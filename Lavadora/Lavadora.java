package Lavadora;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
import java.io.File;
import javax.swing.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Lavadora{ /* Aqui creo los metodos */
    private ArrayList<String> tiposDeRopa;
    private int tiempoDeLavado;
    private double costoPorKilo;
    private int clientesAtendidos;

    private String nombre;


    public Lavadora(ArrayList<String> tiposDeRopa) {
        this.tiposDeRopa = tiposDeRopa;
        this.tiempoDeLavado = 0;
        this.costoPorKilo = 4000; // Costo por kilo sin IVA
        this.clientesAtendidos = 0;
    }

    public void setTiempoDeLavado(int minutos) {
        this.tiempoDeLavado = minutos;
    }

    public void llenadoDeAgua() {
        System.out.println("Llenando la lavadora de agua...");
        delay(7000); // retraso de 7 segundos para simular el tiempo de llenado
        System.out.println("Llenando... llenando...");
    }

    public void lavado() {
        System.out.println("Realizando ciclo de lavado...");
        delay(tiempoDeLavado * 1000); // retraso de tiempoDeLavado segundos para simular el lavado
        System.out.println("Lavado completado.");
    }

    public void enjuague() {
        System.out.println("Realizando el enjuague...");
        delay(3000); // Retraso de 3 segundos para simular el enjuague
        System.out.println("Enjuague completado.");
    }

    public void secado() {
        System.out.println("Realizando secado...");
        delay(5000); // retraso de 5 segundos para simular el secado
        System.out.println("Secado completado.");
    }

    public void cicloTerminado(String nombreCliente) { /* creo un metodo finalizando el ciclo y que me mustre el tiempo de lavado tambien me muestra cada  cliente que este utilizando el programa*/
        System.out.println("Ciclo de lavado terminado.");
        mostrarTiempoDeLavado();
        mostrarInformacionCliente(nombreCliente);
        clientesAtendidos++;
    }

    public void AudioLlenandoAgua() { /*Creo un metodo para cada ciclo de la lavadora se utiliza para agregar el audio*/
        try {
            String filePath = "D:\\javaz\\src\\Lavadora\\y2mate.com-Lavado-de-lavadora-efecto-de-sonido.wav";
            File audioFile = new File(filePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
            AudioFormat audioFormat = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
            SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
            line.open(audioFormat);
            line.start();
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            int bytesRead = 0;
            while (bytesRead != -1) {
                bytesRead = audioInputStream.read(buffer, 0, buffer.length);
                if (bytesRead >= 0) {
                    line.write(buffer, 0, bytesRead);
                }
            }
            line.drain();
            line.close();
            audioInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Centrifugado() {
        try {
            String filePath = "D:\\javaz\\src\\Lavadora\\X2Download.app-Centrifugado_-efecto-de-sonido-_128-kbps_.wav";
            File audioFile = new File(filePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
            AudioFormat audioFormat = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
            SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
            line.open(audioFormat);
            line.start();
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            int bytesRead = 0;
            while (bytesRead != -1) {
                bytesRead = audioInputStream.read(buffer, 0, buffer.length);
                if (bytesRead >= 0) {
                    line.write(buffer, 0, bytesRead);
                }
            }
            line.drain();
            line.close();
            audioInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void inicio() {
        try {
            String filePath = "D:\\javaz\\src\\Lavadora\\X2Download.app-Música-lavadora-LG-_144p_.wav";
            File audioFile = new File(filePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
            AudioFormat audioFormat = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
            SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
            line.open(audioFormat);
            line.start();
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            int bytesRead = 0;
            while (bytesRead != -1) {
                bytesRead = audioInputStream.read(buffer, 0, buffer.length);
                if (bytesRead >= 0) {
                    line.write(buffer, 0, bytesRead);
                }
            }
            line.drain();
            line.close();
            audioInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void mostrarRecomendacion() {
        String[] Opciones = {"Si","No"};
        int RespuestaRecomedaciones = JOptionPane.showOptionDialog(null,"Quiere ver las recomendaciones","Respuesta",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,Opciones,Opciones[0]);
        switch (RespuestaRecomedaciones + 1){
            case 1:
                JOptionPane.showMessageDialog(null,"Recomendaciones:\n Las distintas temperaturas del agua en el ciclo de lavado:\n" +
                        "•Agua fría (hasta 20 o): se recomienda para ropa de colores,\n" +
                        "algodón, lycra, sedas, prendas delicadas y telas que puedan\n" +
                        "achicarse.\n" +
                        "•Agua tibia (entre 30 a 50o): se recomienda para jeans,\n" +
                        "camperas, ropa muy sucia o poco delicada.\n" +
                        "•Agua caliente (entre 55 a 90o): se recomienda para toallas,\n" +
                        "sábanas o acolchados, telas blancas gruesas y cortinas de tela.");
                break;
            case 2:
                JOptionPane.showMessageDialog(null,"Empezar a lavar");
                break;
        }
    }
    private void delay(int milliseconds){ /*suspende la ejecucion durante el numero de milisegundos*/
        try {
            Thread.sleep(milliseconds);
            /*y se maneja la excepcion InterruptedException si el tiempo es interrrumpido  mientras esata en el estado de espera*/
        } catch (InterruptedException e) {
            e.printStackTrace();/*se muestra por la salida de errores que se han producido*/
        }
    }

    private void mostrarTiempoDeLavado() { /*muestra el tiempo de lavado en minutos y segundos*/
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime inicioLavado = now.minusSeconds(tiempoDeLavado);
        long minutos = inicioLavado.until(now, java.time.temporal.ChronoUnit.MINUTES);
        long segundos = inicioLavado.until(now, java.time.temporal.ChronoUnit.SECONDS);

        System.out.println("El lavado de ropa duro: " + minutos + " minutos y " + segundos + " segundos.");
    }
    public double calcularCostoLavado(double kilosRopa, boolean esColorOAlgodon) {
        double costoLavado = kilosRopa * costoPorKilo;

        if (esColorOAlgodon) {
            // aumento el 5% en el costo si es color o algodon
            costoLavado += costoLavado * 0.05;
        }

        double costoTotalIVA = costoLavado * 1.19;
        return costoTotalIVA;
    }

    public int getClientesAtendidos() {
        return clientesAtendidos;
    }



    public double calcularGanancia(double kilosRopa, boolean esColorOAlgodon) {
        double costoLavado = calcularCostoLavado(kilosRopa, esColorOAlgodon);
        double ganancia = costoLavado * 0.3; // 30% de la ganancia para el dueño
        return ganancia;
    }

    public void mostrarCostoTotal(double costoTotalIVA) {
        System.out.println("El costo total de lavado para el cliente, incluyendo el IVA, es de: $" + costoTotalIVA);
    }

    private void mostrarInformacionCliente(String nombre) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Cliente: " + nombre);
        System.out.println("Fecha y hora del lavado: " + now);
    }
}
