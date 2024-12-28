package modelos;

import java.time.LocalDate;
import javax.swing.JOptionPane;

//--------------------
//Autor: Pedro Arruvito
//--------------------
public class FutbolMenores extends PartidosFutbol {

    //ATRIBUTOS
    public boolean usoTarjetas;

    //CONSTRUCTORES
    public FutbolMenores(int codigoPartido, String equipos, LocalDate fechaPartido, Double honorarios, String sede, boolean usoTarjetas) {
        super(codigoPartido, sede, equipos, fechaPartido, honorarios);
        this.usoTarjetas = usoTarjetas;
    }

    public FutbolMenores() {
    }

    //GETTER Y SETTER
    public boolean isUsoTarjetas() {
        return usoTarjetas;
    }

    public void setUsoTarjetas(boolean usoTarjetas) {
        this.usoTarjetas = usoTarjetas;
    }

    //METODOS
    @Override
    public void registrarPartido() {
        super.registrarPartido();

        if (cantidadPartidos == 0) {  // Verifica que no se ha registrado ningún partido (xq se cancelo todo) y retorna
            return;
        }

        String tarjetaRoja = JOptionPane.showInputDialog("¿Se aplican sanciones con tarjetas? (Ingrese S/N):");

        if (tarjetaRoja == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada. Volviendo al menú principal...");
            return; // Salir del método y volver al menú principal
        }

        this.usoTarjetas = tarjetaRoja.equalsIgnoreCase("S"); // Se asigna true si el usuario ingresa 'S'
        JOptionPane.showMessageDialog(null, "Partido registrado con éxito.");
    }

}
