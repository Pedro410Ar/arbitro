
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import modelos.FutbolMenores;
import modelos.FutbolOnce;
import modelos.FutbolSala;
import modelos.PartidosFutbol;

//--------------------------------------
//Autor: Pedro Arruvito
//Proyecto: APA - Aplicacion Para Arbitros 
//Finalidad: es un programa que permite a los arbitros gestionar eficientemente su trabajo.
//Materia: Programacion 1 (ACTIVIDAD FINAL)
//Año 2024 
//Version: 1.0
//--------------------------------------
public class MainPartidos {

    private static PartidosFutbol[] partidos = new PartidosFutbol[10];
    private static int cantidadPartidos = 0;

    //METODO MAIN QUE EJECUTA EL PROGRAMA 
    public static void main(String[] args) {

        //consigna(); 
        titulo();

        /*Menú desplegable */
        String seleccion = "0";
        // Cargar un ícono personalizado
        ImageIcon iconoMenu = new ImageIcon("src/img/arbitro3.png");

        do {

            String[] opcion = {"1. Registrar Partido", "2. Listar Partidos", "3. Calcular Honorarios", "4. Buscar Sede", "5. Buscar Partido x Codigo", "6. Partidos ordenados x Codigo", "7. Generar Informe", "8. Eliminar Partido", "9. Salir"};
            seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione un Ítem", "Menú Principal",
                    JOptionPane.QUESTION_MESSAGE, iconoMenu, opcion, opcion[0]);

            // Si el usuario presiona "Cancelar" o cierra el diálogo (seleccion == null), salimos del programa
            if (seleccion == null) {
                JOptionPane.showMessageDialog(null, "Operación cancelada. Saliendo del programa...");
                System.exit(0); // Cerrar el programa
            }

            switch (seleccion) {
                case "1. Registrar Partido":
                    registrarPartido();
                    break;
                case "2. Listar Partidos":
                    PartidosFutbol.listarPartidos();
                    break;
                case "3. Calcular Honorarios":
                    PartidosFutbol.calcularHonorarios();
                    break;
                case "4. Buscar Sede":
                    PartidosFutbol.buscarSedes();
                    break;
                case "5. Buscar Partido x Codigo":
                    PartidosFutbol.buscarCodigos();
                    break;
                case "6. Partidos ordenados x Codigo":
                    PartidosFutbol.ordenarCodigos();
                    break;
                case "7. Generar Informe":
                    PartidosFutbol.generarInforme();
                    break;
                case "8. Eliminar Partido":
                    PartidosFutbol.eliminarPartido();
                    break;
                case "9. Salir":
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema A.P.A...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.");
                    break;

            }

        } while (!seleccion.equals("9. Salir"));

    }

    //----------------METODOS----------------//
    //METODO QUE LLAMA AL TITULO 
    public static void titulo() {
        UIManager.put("OptionPane.messageFont", new Font("Segoe UI Emoji", Font.BOLD, 14)); // Cambia "Arial" y el tamaño según tus preferencias

        ImageIcon iconoTitulo = new ImageIcon("src/img/arbitro3.png");
        JOptionPane.showMessageDialog(null,
                "\n ✨ ✨"
                + "  A.P.A  ✨ ✨ "
                + "\n  "
                + "\n Aplicacion Para Arbitros"
                + "\n"
                + "\n",
                "Bienvenido Juan Angel",
                JOptionPane.INFORMATION_MESSAGE,
                iconoTitulo);

    }

    //METODO QUE EXPLICA LA CONSIGNA 
    public static void consigna() {
        JOptionPane.showMessageDialog(null, "ACTIVIDAD FINAL - CONSIGNA: Escribir un programa con los conceptos vistos en la materia");
    }

    //METODO QUE REGISTRA PARTIDOS USANDO POO
    public static void registrarPartido() {
        /* if (cantidadPartidos >= partidos.length) {
            JOptionPane.showMessageDialog(null, "No se pueden registrar más partidos.");
            return;
        } */

        String tipoPartido = JOptionPane.showInputDialog("Ingrese el tipo de partido: \n"
                + "\n"
                + "1 - Fútbol Once \n"
                + "2 - Fútbol Sala \n"
                + "3 - Fútbol Infantil");

        PartidosFutbol partido = null;

        // Si el usuario presiona "Cancelar" se vuelve al Menu anterior
        if (tipoPartido == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada. Volviendo al Menú Principal...");
            return; // Regresar al menú principal
        }

        switch (tipoPartido) {
            case "1" ->
                partido = new FutbolOnce();
            case "2" ->
                partido = new FutbolSala();
            case "3" ->
                partido = new FutbolMenores();
            default ->
                JOptionPane.showMessageDialog(null, "Tipo de partido no válido.");
        }

        if (partido != null) {
            partido.registrarPartido();
            partidos[cantidadPartidos++] = partido;
        }

        //------------------------------------------------------//
        //-----------------------------------------------------//
        // Crear un objeto FutbolOnce    
        /* 
        FutbolOnce p1 = new FutbolOnce();

        // Usar getters seteados a 0
        System.out.println("Partido: " + p1.getCodigoPartido());
        System.out.println("Honorarios: " + p1.getHonorarios());

        // Usar setters dando valores
        p1.setCodigoPartido("0234");
        p1.setHonorarios(250.00);

        // Imprimir seteados
        System.out.println("Codigo Partido: " + p1.getCodigoPartido());
        System.out.println("Honorarios: " + p1.getHonorarios());
         */
    }

}
