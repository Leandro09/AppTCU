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
        seccion1.add("INSERTAR TEXTO #1... " +
                "\n" +
                "\uD83D\uDE0A");

        List<String> seccion2 = new ArrayList<String>();
        seccion2.add("INSERTAR TEXTO #2... " +
                "\n" +
                "\uD83D\uDE18");

        List<String> seccion3 = new ArrayList<String>();
        seccion3.add("INSERTAR TEXTO #3...  " +
                "\n" +
                "\uD83D\uDE33");


        expandableListDetail.put("INSERTAR TITULO #1... ", seccion1);
        expandableListDetail.put("INSERTAR TITULO #2... ", seccion2);
        expandableListDetail.put("INSERTAR TITULO #3... ", seccion3);
        return expandableListDetail;
    }
}
