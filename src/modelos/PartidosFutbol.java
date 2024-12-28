package modelos;

//--------------------
//Autor: Pedro Arruvito
//--------------------
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class PartidosFutbol {

    //ATRIBUTOS
    public int codigoPartido;
    public String sede;
    public String equipos;
    public LocalDate fechaPartido;
    public double honorarios;

    //CONSTRUCTORES
    public PartidosFutbol() {
    }

    public PartidosFutbol(int codigoPartido, String sede, String equipos, LocalDate fechaPartido, double honorarios) {
        this.codigoPartido = codigoPartido;
        this.sede = sede;
        this.equipos = equipos;
        this.fechaPartido = fechaPartido;
        this.honorarios = honorarios;
    }

    //GETTER Y SETTER
    public int getCodigoPartido() {
        return codigoPartido;
    }

    public void setCodigoPartido(int codigoPartido) {
        this.codigoPartido = codigoPartido;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getEquipos() {
        return equipos;
    }

    public void setEquipos(String equipos) {
        this.equipos = equipos;
    }

    public LocalDate getFechaPartido() {
        return fechaPartido;
    }

    public void setFechaPartido(LocalDate fechaPartido) {
        this.fechaPartido = fechaPartido;
    }

    public Double getHonorarios() {
        return honorarios;
    }

    public void setHonorarios(Double honorarios) {
        this.honorarios = honorarios;
    }

    //----------------METODOS----------------//
    /*
     * FUNCIONALIDADES: 
     * -Calcular Honorarios
     * -Buscar Codigo de Partidos
     * -Buscar Sedes de Partidos
     * -Ordenar Partidos por Codigo
     * -Generar Informe
     * -Eliminar registro
     */
    //----------------------------------------//
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Código: " + codigoPartido + ", Equipos: " + equipos + ", Fecha: " + fechaPartido.format(formatter)
                + ", Honorarios: " + honorarios + ", Sede: " + sede;
    }

    //ARRAY PARTIDOS   
    //static int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de Partidos que va a cargar:"));
    static PartidosFutbol[] partidos = new PartidosFutbol[105];  // Para almacenar los partidos  
    static int cantidadPartidos = 0;

    //METODOS
    public void registrarPartido() {
        if (cantidadPartidos >= partidos.length) {
            JOptionPane.showMessageDialog(null, "No se pueden registrar más partidos. Límite alcanzado.");
            return;
        }

        // Recolectamos los datos a través de JOptionPane:        
        //Cargar y Validar Codigo de Partido: 
        int codigoPartido = 0;
        while (true) {
            try {
                String codigoIngresado = JOptionPane.showInputDialog("Ingrese el código del partido (Ej: 01):");
                // Verificar si el usuario canceló la operación
                if (codigoIngresado == null) {
                    JOptionPane.showMessageDialog(null, "Operación cancelada. Volviendo al menú principal...");
                    return; // Salir del método y volver al menú principal
                }

                if (codigoIngresado == null || codigoIngresado == " ") {
                    throw new IllegalArgumentException("El código no puede estar vacío.");
                }
                codigoPartido = Integer.parseInt(codigoIngresado);
                if (codigoPartido < 0) {
                    throw new IllegalArgumentException("El codigo no es correcto. Por favor, ingrese el codigo nuevamente.");
                }
                break;

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Codigo inválido. Por favor, ingrese un codigo correcto");
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }

        //Cargar String SEDE
        String sede = JOptionPane.showInputDialog("Ingrese la sede (Ej: Monumental):");
        // Verificar si el usuario canceló la operación
        if (sede == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada. Volviendo al menú principal...");
            return; // Salir del método y volver al menú principal
        }

        //Cargar String EQUIPOS
        String equipos = JOptionPane.showInputDialog("Ingrese los equipos (Ej: Rojos vs Azules):");
        // Verificar si el usuario canceló la operación
        if (equipos == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada. Volviendo al menú principal...");
            return; // Salir del método y volver al menú principal
        }

        //Cargar y Validar FECHAS
        LocalDate fechaPartido;
        while (true) {
            String fechaIngresada = JOptionPane.showInputDialog("Ingrese la fecha (Ej: 24-05-2024):");
            // Verificar si el usuario canceló la operación
            if (fechaIngresada == null) {
                JOptionPane.showMessageDialog(null, "Operación cancelada. Volviendo al menú principal...");
                return; // Salir del método y volver al menú principal
            }
            try {
                fechaPartido = LocalDate.parse(fechaIngresada, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                break;

            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Fecha inválida. Por favor, use el formato dd-MM-yyyy");
            }
        }

        //Cargar y Validar HONORARIOS
        double honorarios = 0.0;
        while (true) {
            try {
                String honorariosIngresados = JOptionPane.showInputDialog("Ingrese los honorarios (Ej: 200):");
                // Verificar si el usuario canceló la operación
                if (honorariosIngresados == null) {
                    JOptionPane.showMessageDialog(null, "Operación cancelada. Volviendo al menú principal...");
                    return; // Salir del método y volver al menú principal
                }

                honorarios = Double.parseDouble(honorariosIngresados);
                if (honorarios < 0.0) {
                    throw new IllegalArgumentException("El monto no puede ser negativo. Por favor, ingrese un valor positivo.");
                }
                break;

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Monto inválido. Por favor, ingrese un numero correcto");
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        // Crear el objeto partido utilizando la clase PartidosFutbol
        PartidosFutbol partido = new PartidosFutbol(codigoPartido, sede, equipos, fechaPartido, honorarios);

        // Guardar el partido en el array
        partidos[cantidadPartidos] = partido;
        cantidadPartidos++;

    }

    static ImageIcon icono = new ImageIcon("src/img/arbitro2.png");

    //METODO PARA LISTAR PARTIDOS    
    public static void listarPartidos() {

        JOptionPane.showMessageDialog(null, "Listando Partidos... ");

        if (cantidadPartidos == 0) {
            JOptionPane.showMessageDialog(null, "No hay partidos registrados. Registre partidos antes de buscar.");
            return;
        }

        StringBuilder lista = new StringBuilder("✨✨  Lista de Partidos Registrados:  ✨✨\n ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        boolean listado = false;

        for (int i = 0; i < partidos.length; i++) {
            if (partidos[i] != null) {
                lista.append("\n")
                        .append("Codigo: ").append(partidos[i].getCodigoPartido())
                        .append("  ||  Fecha: ").append(partidos[i].getFechaPartido().format(formatter))
                        .append("  ||  Sede: ").append(partidos[i].getSede())
                        .append("  ||  Equipos: ").append(partidos[i].getEquipos());
                //.append("  ||  Juez de Linea: ").append(partidos[i]. ? "Sí" : "No")
                //.append("  ||  Femenino: ").append(getSexo())
                //.append("  ||  Tarjetas: ").append(getUsoTarjetas.....())
                //.append("\n");
                listado = true;
            }
        }
        if (listado) {
            JOptionPane.showMessageDialog(null, lista.toString(), "Lista de Partidos",
                    JOptionPane.INFORMATION_MESSAGE, icono);

        } else {
            JOptionPane.showMessageDialog(null, "No hay partidos registrados.");
        }
    }

    //METODO PARA CALCULAR HONORARIOS TOTALES: este metodo suma todos los montos que encuentra en el array
    public static double calcularHonorarios() {

        JOptionPane.showMessageDialog(null, "Calculando Honorarios totales... ");
        double totalHonorarios = 0;
        for (PartidosFutbol partido : partidos) {
            if (partido != null) { // Verificamos que no sea null
                totalHonorarios += partido.getHonorarios(); // Sumamos los honorarios del partido
            }
        }

        JOptionPane.showMessageDialog(null, "El total de Honorarios es de: $ " + totalHonorarios, "Honorarios Calculados", JOptionPane.INFORMATION_MESSAGE, icono);
        return totalHonorarios;
    }

    //METODO PARA BUSCAR CODIGOS DE PARTIDOS 
    // (Busqueda Lineal: recorre el arreglo completo de manera secuencial usando un bucle for.
    // Compara cada elemento del arreglo con el valor que se busca: if)
    public static void buscarCodigos() {
        String codigoIngresado = JOptionPane.showInputDialog("Ingrese el Codigo de Partido que desea buscar (Ej: 10): ");

        // Verificar si el usuario canceló la operación
        if (codigoIngresado == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada. Volviendo al menú principal...");
            return; // Salir del método y volver al menú principal
        }

        try {
            int codigoBuscar = Integer.parseInt(codigoIngresado);
            JOptionPane.showMessageDialog(null, "Buscando Codigo de Partido... ");
            StringBuilder resultadosCodigo = new StringBuilder();
            boolean found = false;

            for (PartidosFutbol partido : partidos) {
                if (partido != null && partido.getCodigoPartido() == codigoBuscar) {
                    resultadosCodigo.append(partido.toString()).append("\n----------------------\n");
                    found = true;
                }
            }
            if (found) {
                JOptionPane.showMessageDialog(null, "Partido con el Codigo \"" + codigoBuscar + "\":\n" + resultadosCodigo, "Partidos", JOptionPane.INFORMATION_MESSAGE, icono);
            } else {
                JOptionPane.showMessageDialog(null, "Codigo No encontrado");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número válido.");
        }
    }

    //METODO PARA BUSCAR SEDES: esta funcionalidad permite buscar la cancha donde se juega (TAMBIEN ES LINEAL)
    public static void buscarSedes() {

        String sedeBuscar = JOptionPane.showInputDialog("Ingrese el nombre de la Sede del partido que desea buscar (Ej: Milan): ");

        // Verificar si el usuario canceló la operación
        if (sedeBuscar == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada. Volviendo al menú principal...");
            return; // Salir del método y volver al menú principal
        }

        JOptionPane.showMessageDialog(null, "Buscando cancha... ");
        StringBuilder resultadosSede = new StringBuilder();
        boolean found = false;

        for (PartidosFutbol partido : partidos) {
            if (partido != null && partido.getSede().equalsIgnoreCase(sedeBuscar)) {
                resultadosSede.append(partido.toString()).append("\n----------------------\n");
                found = true;
            }
        }
        if (found) {
            JOptionPane.showMessageDialog(null, "Partidos en la sede \"" + sedeBuscar + "\":\n" + resultadosSede, "Sedes", JOptionPane.INFORMATION_MESSAGE, icono);
        } else {
            JOptionPane.showMessageDialog(null, "Sede No encontrada");
        }
    }

    //METODO PARA ORDENAMIENTO DE CODIGOS DE PARTIDO (x insercion: El bucle interno while (j >= 0 && codigos[j] > actual)  
    // desplaza elementos mayores hacia la derecha para hacer espacio para el elemento actual en su posición correcta....
    public static void ordenarCodigos() {

        JOptionPane.showMessageDialog(null, "Ordenando los partidos por código...");
        int pasadas = 0;

        for (int i = 1; i < cantidadPartidos; i++) {
            PartidosFutbol actualPartido = partidos[i];

            int j = i - 1;

            //--------------------------------------------------//
            // Desplaza los elementos mayores hacia la derecha //
            //--------------------------------------------------       
            while (j >= 0 && partidos[j].getCodigoPartido() > actualPartido.getCodigoPartido()) {
                partidos[j + 1] = partidos[j];
                j--;
            }

            // Insertar el elemento en su posición correcta
            partidos[j + 1] = actualPartido;
            pasadas++;

        }

        JOptionPane.showMessageDialog(null, "Partidos ordenados exitosamente.", "Orden", JOptionPane.INFORMATION_MESSAGE, icono);

        // Mostrar resultado final
        StringBuilder resultadosOrdenados = new StringBuilder("✨✨ Partidos Ordenados por Código: ✨✨\n");

        for (int i = 0; i < partidos.length; i++) {
            if (partidos[i] != null) { // Verifica que haya datos válidos
                resultadosOrdenados.append("|| Código: ").append(partidos[i].getCodigoPartido())
                        .append(" || Fecha: ").append(partidos[i].getFechaPartido())
                        .append(" || Sede: ").append(partidos[i].getSede())
                        .append(" || Equipos: ").append(partidos[i].getEquipos())
                        .append("\n");

            }
        }

        resultadosOrdenados.append("\nNúmero de pasadas: ").append(pasadas);
        JOptionPane.showMessageDialog(null, resultadosOrdenados.toString());
    }

    //METODO PARA GENERAR INFORME CON DATOS
    public static void generarInforme() {
        JOptionPane.showMessageDialog(null, "Generando Informe. Aguarde... ");

        double promedioGanancias = 0.0;
        double totalGanancias = 0.0;

        for (PartidosFutbol partido : partidos) {
            if (partido != null) { // Verificamos que no sea null
                totalGanancias += partido.getHonorarios(); // Sumamos los honorarios del partido
            }
        }

        int totalPartidos = 0;
        for (PartidosFutbol partido : partidos) {
            if (partido != null) {
                totalPartidos++;
            }
        }
        if (totalPartidos > 0) {
            promedioGanancias = totalGanancias / totalPartidos;
        }

        // Generamos el informe
        String informe = "\n INFORME:\n\n";

        informe += "Cantidad de partidos registrados: " + totalPartidos + "\n";
        informe += "Honorarios recaudados en total: " + String.format("%.2f", totalGanancias) + "\n";
        informe += "Promedio de ganancias por partido: " + String.format("%.2f", promedioGanancias) + "\n \n \n";

        // Mostramos el informe en un cuadro de mensaje
        JOptionPane.showMessageDialog(null, informe, "Informe de Partidos", JOptionPane.INFORMATION_MESSAGE, icono);
    }

    //METODO PARA ELIMINAR PARTIDOS
    public static void eliminarPartido() {
        String codigoEliminar = JOptionPane.showInputDialog("Ingrese el Código del Partido que quiere eliminar:");

        // Verificar si el usuario canceló la operación
        if (codigoEliminar == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada. Volviendo al menú principal...");
            return; // Salir del método y volver al menú principal
        }

        try {
            int partidoEliminado = Integer.parseInt(codigoEliminar);

            boolean found = false;

            for (int i = 0; i < partidos.length; i++) {
                if (partidos[i] != null && partidos[i].getCodigoPartido() == partidoEliminado) {
                    partidos[i] = null; // Elimina el partido estableciendo su posición a null
                    JOptionPane.showMessageDialog(null, "Eliminando Partido...");
                    JOptionPane.showMessageDialog(null, "El Partido '" + partidoEliminado + "' ha sido eliminado.", "Partido Eliminado", JOptionPane.INFORMATION_MESSAGE, icono);
                    found = true;
                    break; // Salir del bucle tras eliminar
                }
            }

            // Si no se encuentra el curso
            if (!found) {
                JOptionPane.showMessageDialog(null, "Partido no encontrado.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número válido.");
        }
    }

}
