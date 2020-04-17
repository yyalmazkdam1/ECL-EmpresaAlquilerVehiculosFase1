/* @author: Yumurdzhan Yalmaz;*/
package alquileres.modelo;

import java.util.ArrayList;
import java.util.Collections;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;



/**
 * La clase guarda en una colección List (un ArrayList) la flota de vehículos
 * que una agencia de alquiler posee
 * 
 * Los vehículos se modelan como un interface List que se instanciará como una
 * colección concreta ArrayList
 */
public class AgenciaAlquiler {
	private String nombre; // el nombre de la agencia
	private List<Vehiculo> flota; // la lista de vehículos

	/**
	 * Constructor
	 * 
	 * @param nombre el nombre de la agencia
	 */
	public AgenciaAlquiler(String nombre) {
		this.nombre = nombre;
		this.flota = new ArrayList<>();
	}

	/**
	 * añade un nuevo vehículo solo si no existe
	 * 
	 */
	public void addVehiculo(Vehiculo v) {
		if (!flota.contains(v)) {
			flota.add(v);
		}
		else {
			System.out.println("Vehiculo ya existente, no se ha podido añadir");
		}
	}

	/**
	 * Extrae los datos de una línea, crea y devuelve el vehículo correspondiente
	 * 
	 * Formato de la línea: C,matricula,marca,modelo,precio,plazas para coches
	 * F,matricula,marca,modelo,precio,volumen para furgonetas
	 * 
	 * 
	 * Asumimos todos los datos correctos. Puede haber espacios antes y después de
	 * cada dato
	 */
	private Vehiculo obtenerVehiculo(String linea) {
		return null;
		

	}

	/**
	 * La clase Utilidades nos devuelve un array con las líneas de datos de la flota
	 * de vehículos
	 */
	public void cargarFlota() {
		String[] datos = Utilidades.obtenerLineasDatos();
		String error = null;
		try {
			for (String linea : datos) {
				error = linea;
				Vehiculo vehiculo = obtenerVehiculo(linea);
				this.addVehiculo(vehiculo);

			}
		} catch (Exception e) {
			System.out.println(error);
		}

	}

	/**
	 * Representación textual de la agencia
	 */
	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder(this.nombre + "\n");
		for (Vehiculo v:flota) {
			sb.append(v.toString() + "\n");
		}
		return sb.toString();

	}

	/**
	 * Busca todos los coches de la agencia Devuelve un String con esta información
	 * y lo que costaría alquilar cada coche el nº de días indicado *
	 * 
	 */
	public String buscarCoches(int dias) {

		String str = "";
		for (Vehiculo v : flota) {
			if (v instanceof Coche) {
				double costeAlquiler = v.calcularPrecioAlquiler(dias);
				str += v.toString() + "\nCoste alquiler " + dias + " días: " + costeAlquiler + "\n";
			}
		}
		return str;

	}

	/**
	 * Obtiene y devuelve una lista de coches con más de 4 plazas ordenada por
	 * matrícula - Hay que usar un iterador
	 * 
	 */
	public List<Coche> cochesOrdenadosMatricula() {

		ArrayList<Coche> coches = new ArrayList<>();
		Iterator<Vehiculo> it = flota.iterator();
		while (it.hasNext()) {
			Vehiculo v = it.next();
			if (v instanceof Coche) {
				if (((Coche) v).getPlazas() > 4) {

					coches.add((Coche) v);
				}

			}
			
		}
		Collections.sort(coches);
		return coches;
	}

	/**
	 * Devuelve la relación de todas las furgonetas ordenadas de mayor a menor
	 * volumen de carga
	 * 
	 */
	public List<Furgoneta> furgonetasOrdenadasPorVolumen() {
		int i = 0;
		List<Furgoneta> furgo = new ArrayList<>();
		Iterator<Vehiculo> it = flota.iterator();
		while(it.hasNext()) {
			Vehiculo v = it.next();
			if (v instanceof Furgoneta) {
				furgo.add(i, (Furgoneta) v);
				i++;
				
			}
			
			
			
			
		}
		Collections.sort(furgo);
		
		return furgo;
		

	}

	/**
	 * Genera y devuelve un map con las marcas (importa el orden) de todos los
	 * vehículos que hay en la agencia como claves y un conjunto (importa el orden)
	 * de los modelos en cada marca como valor asociado
	 */
	public Map<String, Set<String>> marcasConModelos() {
		return null;
	}

}
