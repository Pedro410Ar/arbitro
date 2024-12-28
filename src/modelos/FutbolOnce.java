package modelos;

import java.time.LocalDate;
import javax.swing.JOptionPane;

//--------------------
//Autor: Pedro Arruvito
//--------------------

public class FutbolOnce extends PartidosFutbol {

    //ATRIBUTOS
    public boolean juezLinea;

    //CONSTRUCTORES
    public FutbolOnce() {
    }

    public FutbolOnce(boolean juezLinea, int codigoPartido, String equipos, LocalDate fechaPartido, Double honorarios, String sede) {
        super(codigoPartido, sede, equipos, fechaPartido, honorarios);
        this.juezLinea = juezLinea;
    }

    //GETTER Y SETTER
    public boolean isJuezLinea() {
        return juezLinea;
    }

    public void setJuezLinea(boolean juezLinea) {
        this.juezLinea = juezLinea;
    }

    //METODOS    
    @Override
    public void registrarPartido() {
        super.registrarPartido();

        if (cantidadPartidos == 0) {  // Verifica que no se ha registrado ningún partido (xq se cancelo todo) y retorna
            return;  
        }

        String juez = JOptionPane.showInputDialog("¿Actúa como Juez de Línea? (Ingrese S/N):");
        
        if (juez == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada. Volviendo al menú principal...");
            return; // Salir del método y volver al menú principal
        }
        
        
        this.juezLinea = juez.equalsIgnoreCase("S"); // Se asigna true si el usuario ingresa 'S' 
        JOptionPane.showMessageDialog(null, "Partido registrado con éxito.");
    }
 
   
}
