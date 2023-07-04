package Lavadora;

import javax.swing.*;
import java.util.ArrayList;

public class lavadoraMain{
    private static boolean ValidarKilos(String KilosRopa){
        double Kilos = Double.parseDouble(KilosRopa);
        if(Kilos >= 10 && Kilos <= 30)return false;
        else return true;
    }

    private static boolean isnumerico(String cadena){
        try {
            Double.parseDouble(cadena);
            return false;
        }catch (NumberFormatException nfe){
            return true;

        }

    }

    public static void main(String[] args) {
        double kilosropa = 0;
        String[] Opciones1 = {"Si","No"};
        ArrayList<String> tiposderopa = new ArrayList<>();
        tiposderopa.add("ropa de coleres");
        tiposderopa.add("algodon");
        tiposderopa.add("lycra");
        tiposderopa.add("sedas");
        tiposderopa.add("jeans");
        tiposderopa.add("sabanas");
        tiposderopa.add("toallas");

        Lavadora lavadora = new Lavadora(tiposderopa);
        JOptionPane.showMessageDialog(null,"Bienvenido al programa de Mabe (lavadora)");
        boolean Contnuar1 = true;
        do {
            String opcion2 = "";
            boolean Ex0 = true;
            do {
                try {
                    opcion2 = JOptionPane.showInputDialog("Ingrese una letra (o 'quit' para salir):");
                    if (opcion2.isBlank()){
                        JOptionPane.showMessageDialog(null,"Error, Campo en blanco","Error",JOptionPane.ERROR_MESSAGE);
                    } else if (isnumerico(opcion2) == false) {
                        JOptionPane.showMessageDialog(null,"Error, Digitaste un numero","Error",JOptionPane.ERROR_MESSAGE);
                    }else {
                        Ex0 = false;
                        break;
                    }
                }catch (NullPointerException ex){
                    JOptionPane.showMessageDialog(null,"Programa finalizado");
                    System.exit(0);
                    Ex0 = false;

                }
            }while (Ex0);
            while (true) {

                if (opcion2.equals("quit")) {
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                    System.exit(0);
                }

                JOptionPane.showMessageDialog(null, "Ejecutando el comando: " + opcion2);
                String nombre = JOptionPane.showInputDialog("Ingrese su nombre: ");
                String opcion = JOptionPane.showInputDialog("Ingrese la cantidad de ropa a lavar: ");
                if (opcion.isBlank()) {
                    JOptionPane.showMessageDialog(null, "Error, Kilos en blanco", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (isnumerico(opcion)) {
                    JOptionPane.showMessageDialog(null, "Error, Dato no requerido", "Error", JOptionPane.ERROR_MESSAGE);

                } else if (ValidarKilos(opcion)) {
                    JOptionPane.showMessageDialog(null, "Error, Valor necesario entre 10 y 30 kg", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    kilosropa = Double.parseDouble(opcion);
                    break;
                }
            }

            lavadora.mostrarRecomendacion();
            JOptionPane.showMessageDialog(null,"Tipos de ropa:\n" +
                    "Ropa de colores\n" +
                    "algodón\n" +
                    "Lycra\n" +
                    "Sedas\n" +
                    "Jeans\n" +
                    "Sabanas\n" +
                    "toallas");
            String tiporopa = "";
                    while (true){
                        tiporopa = JOptionPane.showInputDialog("Ingrese el tipo de ropa que va a lavar: ");
                        if (tiporopa.isBlank()){
                            JOptionPane.showMessageDialog(null,"Error, campo vacio","Error",JOptionPane.ERROR_MESSAGE);
                        } else if (isnumerico(tiporopa) == false) {
                            JOptionPane.showMessageDialog(null,"Error, campo con numeros","Error",JOptionPane.ERROR_MESSAGE);
                        }else break;
                    }
                        if (tiporopa.equals("ropa de colores")){
                JOptionPane.showMessageDialog(null, "Recomendaciones a lavar:\n " +
                        "(Agua fria 20o) lo mismo con algodón, lycra, sedas, prendas delicadas y telas que puedan achicarse\n");
            } else if (tiporopa.equals("jeans")) {
                JOptionPane.showMessageDialog(null,"Recomendaciones a lavar:\n•Agua tibia (entre 30 a 50o): se recomienda para jeans,\n" +
                "camperas, ropa muy sucia o poco delicada.\n");
            } else if (tiporopa.equals("toallas")) {
                JOptionPane.showMessageDialog(null,"Recomendaciones a lavar:\n•Agua caliente (entre 55 a 90o): se recomienda para toallas,\n" +
                "sábanas o acolchados, telas blancas gruesas y cortinas de tela.");
            } else if (tiporopa.equals("lycra")) {
                JOptionPane.showMessageDialog(null, "Recomendaciones a lavar: (Agua fria 20o) ");
            }
            String tiempolavado = "";
            int Tiempolavado = 0;
            while (true){
                tiempolavado = JOptionPane.showInputDialog("Ingrese el tiempo de lavado en minutos: ");
                if (tiempolavado.isBlank()){
                    JOptionPane.showMessageDialog(null,"Error, campo vacio","Error",JOptionPane.ERROR_MESSAGE);
                } else if (isnumerico(tiempolavado)) {
                    JOptionPane.showMessageDialog(null,"Error, campo con letras","Error",JOptionPane.ERROR_MESSAGE);
                }else{
                    Tiempolavado = Integer.parseInt(tiempolavado);
                    break;
                }
            }
            lavadora.setTiempoDeLavado(Tiempolavado);

            JOptionPane.showMessageDialog(null,"Iniciando ciclo de lavado...");
            System.out.println("Iniciando ciclo de lavado...");
            lavadora.inicio();
            lavadora.llenadoDeAgua();
            lavadora.AudioLlenandoAgua();
            lavadora.lavado();
            lavadora.AudioLlenandoAgua();
            lavadora.enjuague();
            lavadora.secado();
            lavadora.Centrifugado();
            lavadora.cicloTerminado("Miguel");


            boolean coloralgodon = tiporopa.equals("ropa de colores") || tiporopa.equals("Algodon");

            double costototalIVA = lavadora.calcularCostoLavado(kilosropa,coloralgodon);
            lavadora.mostrarCostoTotal(costototalIVA);

            double ganancia = lavadora.calcularGanancia(kilosropa, coloralgodon);
            System.out.println("el tipo de ropa de que usted eligio es: " + tiporopa);
            System.out.println("ganancia para el dueño: " + ganancia);
            System.out.println("----------------------------------");
            int ClientesAtendidos = lavadora.getClientesAtendidos();
            System.out.println("clientes atendidos: " + ClientesAtendidos);
            System.out.println("----------------------------------");
            int Respuesta1 = JOptionPane.showOptionDialog(null,"Desea lavar mas","Confirmacion",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,Opciones1,Opciones1[0]);
            switch (Respuesta1 + 1){
                case 1:
                    Contnuar1 = true;
                    break;
                case 2:
                    Contnuar1 = false;
                    JOptionPane.showMessageDialog(null,"Programa terminado");
                    break;
            }
        }while (Contnuar1);
    }
}