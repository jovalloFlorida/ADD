package es.florida.AE01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Actividad_AE01 {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.println("1. Funcionalidad getInformacion.");
		System.out.println("2. Funcionalidad creaCarpeta.");
		System.out.println("3. Funcionalidad creaFichero.");
		System.out.println("4. Funcionalidad elimina Fichero/Carpeta.");
		System.out.println("5. Funcionalidad renombra Fichero/Carpeta.");
		System.out.println("");
		System.out.print("Numero de funcionalidad (1 al 5): ");
		String numeroFuncionalidad = br.readLine();
		int numeroFuncion = Integer.parseInt(numeroFuncionalidad);
		switch (numeroFuncion) {
		case 1:
			getInformacion(args);
			break;
		case 2:
			creaCarpeta(args);
			break;
		case 3:
			creaFichero(args);
			break;
		case 4:
			eliminaFC(args);
			break;
		case 5:
			renombraFC(args);
			break;
		default:
			System.out.print("No existe ese nuemro de funcionalidad: ");
		}

	}

	public static void getInformacion(String[] args) {
		try {
			String ruta = args[0];
			File informacion = new File("/" + ruta + "/" + args[1]);
			if (informacion.exists()) {
				// Informacion del Fichero / Directorio
				System.out.println("Nombre de informacion: " + informacion.getName() + "\n");
				// Comprobamos si es un directorio o fichero
				if (informacion.isDirectory()) {
					System.out.println("Es directorio: " + informacion.isDirectory());
				} else if (informacion.isFile()) {
					System.out.println("Es archivo: " + informacion.isFile());
				}
				// ruta completa
				System.out.println("Absolute path: " + informacion.getAbsolutePath());

				// Calculo para la fecha
				long ultimaModificacion = informacion.lastModified();
				Date d = new Date(ultimaModificacion);
				Calendar c = new GregorianCalendar();
				c.setTime(d);
				String dia, mes, anyo, hora, minuto, segundos;
				dia = Integer.toString(c.get(Calendar.DATE));
				mes = Integer.toString(c.get(Calendar.MONTH));
				anyo = Integer.toString(c.get(Calendar.YEAR));
				hora = Integer.toString(c.get(Calendar.HOUR_OF_DAY));
				minuto = Integer.toString(c.get(Calendar.MINUTE));
				segundos = Integer.toString(c.get(Calendar.SECOND));
				System.out.println("Ultima modificacion: " + dia + "/" + mes + "/" + anyo + " " + hora + ":" + minuto
						+ ":" + segundos);
				System.out.println("Es oculto: " + informacion.isHidden());

				// Comprobacion si es fichero sacamos el tamaño en bytes
				if (informacion.isFile())
					System.out.println("Tamaño del archivo: " + informacion.length() + " bytes");
				// Comprobamos si es un directorio
				if (informacion.isDirectory()) {
					File[] numeroElementos = informacion.listFiles();
					System.out.println("En el directorio hay " + numeroElementos.length + " elementos");
					System.out.println("El espacio libre del directorio es: "
							+ informacion.getFreeSpace() / 1024 / 1024 / 1024 + " GB");
					System.out.println("El espacio disponible del directorio es: "
							+ informacion.getUsableSpace() / 1024 / 1024 / 1024 + " GB");
					System.out.println("El espacio total del directorio es: "
							+ informacion.getTotalSpace() / 1024 / 1024 / 1024 + " GB");
				}

				// Informacion adicional
				System.out.println("\nPermisos de escritura: " + informacion.canWrite());
				System.out.println("Permisos de lectura: " + informacion.canRead());
				System.out.println("Carpeta contenedora: " + informacion.getParent());
			} else {
				System.out.println("El Directorio/Fichero no existe.");
			}

		} catch (Exception e) {
			e.printStackTrace(); // dice que sucedio y en que parte del codigo sucedió
		}

	}

	public static void creaCarpeta(String[] args) {
		try {
			String ruta = args[0];
			File directorio = new File("/" + ruta + "/" + args[1]);
			// Si el directorio no existe es creado
			if (!directorio.exists()) {
				if (directorio.mkdirs()) {
					System.out.println("Directorio creado");
				}
			} else {
				System.out.println("Error al crear directorio, ya existe");
			}
		} catch (Exception e) {
			e.printStackTrace(); // dice que sucedio y en que parte del codigo sucedió
		}

	}

	public static void creaFichero(String[] args) {
		try {
			String ruta = "/" + args[0] + "/" + args[1];
			String contenido = "Contenido de ejemplo";
			File file = new File(ruta);
			// Si el archivo no existe es creado
			if (!file.exists()) {
				file.createNewFile();
				System.out.println("Fichero " + args[1] + " creado...");
			} else {
				System.out.println("Fichero " + args[1] + " ya existe.");
			}
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(contenido);
			bw.close();
		} catch (Exception e) {
			e.printStackTrace(); // dice que sucedio y en que parte del codigo sucedió
		}

	}

	public static void eliminaFC(String[] args) {
		try {
			String ruta = "/" + args[0] + "/" + args[1];
			File file = new File(ruta);
			// Si el archivo existe es eliminado
			if (file.exists()) {
				file.delete();
				System.out.println("Carpeta/Fichero " + args[1] + " eliminado.");
			} else {
				System.out.println("Carpeta/Fichero " + args[1] + " no existe.");
			}

		} catch (Exception e) {
			e.printStackTrace(); // dice que sucedio y en que parte del codigo sucedió
		}

	}

	public static void renombraFC(String[] args) {
		try {
			String oldRuta = "/" + args[0] + "/" + args[1];
			String newRuta = "/" + args[0] + "/" + args[2];
			File oldfile = new File(oldRuta);
			File newfile = new File(newRuta);
			if (oldfile.renameTo(newfile)) {
				System.out.println("Fichero/Carpeta renombrado");
			} else {
				System.out.println("Fichero/Carpeta no existe");
			}
		} catch (Exception e) {
			e.printStackTrace(); // dice que sucedio y en que parte del codigo sucedió
		}

	}

}
