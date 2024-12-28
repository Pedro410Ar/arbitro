package modelos;

//--------------------
//Autor: Pedro Arruvito
//--------------------
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class FutbolSala extends PartidosFutbol {

    //ATRIBUTOS
    public boolean pagoEfectivo;
    public String femenino;

    //CONSTRUCTORES
    public FutbolSala() {
    }

    public FutbolSala(boolean pagoEfectivo, String femenino, int codigoPartido, String sede, String equipos, LocalDate fechaPartido, Double honorarios) {
        super(codigoPartido, sede, equipos, fechaPartido, honorarios);
        this.pagoEfectivo = pagoEfectivo;
        this.femenino = femenino;
    }

    //GETTER Y SETTER
    public boolean isPagoEfectivo() {
        return pagoEfectivo;
    }

    public void setPagoEfectivo(boolean pagoEfectivo) {
        this.pagoEfectivo = pagoEfectivo;
    }

    public String getFemenino() {
        return femenino;
    }

    public void setFemenino(String femenino) {
        this.femenino = femenino;
    }

    //METODOS
    @Override
    public void registrarPartido() {
        super.registrarPartido();

        if (cantidadPartidos == 0) {  // Verifica que no se ha registrado ningún partido (xq se cancelo todo) y retorna
            return;
        }

        String cash = JOptionPane.showInputDialog("Se paga en efectivo?: (Ingrese S/N):");

        if (cash == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada. Volviendo al menú principal...");
            return; // Salir del método y volver al menú principal
        }

        this.pagoEfectivo = cash.equalsIgnoreCase("S"); // Se asigna true si el usuario ingresa 'S' 
        JOptionPane.showMessageDialog(null, "Partido registrado con éxito.");

    }

}
