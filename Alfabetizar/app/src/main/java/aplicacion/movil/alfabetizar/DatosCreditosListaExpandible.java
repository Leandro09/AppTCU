package aplicacion.movil.alfabetizar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jedups on 06/02/2017.
 */

public class DatosCreditosListaExpandible {

    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> seccion1 = new ArrayList<String>();
        seccion1.add(
                "Dra. María Marta Camacho Alvarez\n" +
                "Profesora Catedrática \n" +
                "Universidad de Costa Rica " +
                "\n\n" +
                "Dra. Marielos Murillo Rojas\n" +
                "Profesora Catedrática\n" +
                "Universidad de Costa Rica " +
                "\n\n" +
                "Dr. Carlos Sánchez Avendaño\n" +
                "Profesor Catedrático\n" +
                "Universidad de Costa Rica");

        List<String> seccion2 = new ArrayList<String>();
        seccion2.add(
                "Señor\n" +
                "Adrián Brenes Jiménez \n" +
                "Técnico en Grabación\n" +
                "Radioemisoras UCR" +
                "\n\n" +
                "Señora\n" +
                "Catherine Prado Goyenaga\n" +
                "Coordinadora General \n" +
                "Radioemisoras UCR");

        List<String> seccion3 = new ArrayList<String>();
        seccion3.add(
                "Señorita\n" +
                "Isabel Acuña Calderón\n" +
                "Estudiante de Diseño Gráfico \n" +
                "Universidad de Costa Rica");

        List<String> seccion4 = new ArrayList<String>();
        seccion4.add(
                "Señorita\n" +
                "Larissa Arroyo Castillo\n" +
                "Estudiante de Computación e Informática \n" +
                "Universidad de Costa Rica" +
                "\n\n" +
                "Señorito\n" +
                "Luis Leandro Jiménez\n" +
                "Estudiante de Computación e Informática \n" +
                "Universidad de Costa Rica"  +
                "\n\n" +
                "Señorito\n" +
                "José Eduardo Picado Salas\n" +
                "Estudiante de Computación e Informática \n" +
                "Universidad de Costa Rica");


        expandableListDetail.put("Programación", seccion4);
        expandableListDetail.put("Diseño", seccion3);
        expandableListDetail.put("Audio", seccion2);
        expandableListDetail.put("Coordinación ", seccion1);


        return expandableListDetail;
    }
}
