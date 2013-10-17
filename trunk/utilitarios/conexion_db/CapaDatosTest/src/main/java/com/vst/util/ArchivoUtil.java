/**
 * 
 */
package com.vst.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class ArchivoUtil {

	private static Log log = LogFactoryUtil.getLog(DAO.class);

	public static File enFile(String nombreArchivo, byte[] arreglo) throws FileNotFoundException, IOException {
		log.debug("File nombreArchivo:" + nombreArchivo);
		if (TextoUtil.contieneAlgo(nombreArchivo) && arreglo != null) {
			File archivo = new File(nombreArchivo);
			OutputStream flujoSalida;
			flujoSalida = new FileOutputStream(archivo);
			flujoSalida.write(arreglo);
			flujoSalida.close();
			return archivo;
		}
		return null;
	}

	public static byte[] enArregloByte(File archivo) throws FileNotFoundException, IOException {
		log.debug("byte[] archivo:" + archivo);
		if (archivo != null) {
			InputStream flujoEntrada = new FileInputStream(archivo);
			int longitud = (int) archivo.length();
			byte[] arregloEntrada = new byte[longitud];
			flujoEntrada.read(arregloEntrada, 0, longitud);
			flujoEntrada.close();
			return arregloEntrada;
		}
		return null;
	}

	public static BufferedImage loadImage(String rutaImagen) throws IOException {
		log.debug("BufferedImage loadImage:" + rutaImagen);
		BufferedImage bimg = null;
		bimg = ImageIO.read(new File(rutaImagen));
		return bimg;
	}

	public static byte[] guardarImagen(byte[] fileBytes, String filename, String repositorio) throws IOException {
		log.debug("BufferedImage filename:" + filename + " repositorio:" + repositorio + " fileBytes: " + fileBytes);
		filename = new File(filename).getName();
		filename = repositorio + filename;
		FileOutputStream fileOut = new FileOutputStream(filename);
		fileOut.write(fileBytes, 0, fileBytes.length);
		fileOut.flush();
		fileOut.close();
		return fileBytes;
	}

	public static String obtenerNombreDeFile(String filename) {
		log.debug("BufferedImage obtenerNombreDeFile:" + filename);
		return filename = new File(filename).getName();
	}

}
