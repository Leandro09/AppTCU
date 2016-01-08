package aplicacion.movil.alfabetizar;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Leandro on 27/12/2015.
 * Clase que se encargar de visualizar la lista extendible que aparece de consonantes y vocales
 */
public class Controlador_Lista extends AppCompatActivity {

    Controlador_ListaExtendible listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    int prueba;
    Controlador_Sonidos sound;
    Controlador_Simbolo nuevaPantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contenedor_lista_grupos);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lista);

        // preparing list data
        prepareListData();

        listAdapter = new Controlador_ListaExtendible(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
            //    v.getBackground().setColorFilter(Color.parseColor("#00ff00"), PorterDuff.Mode.DARKEN);
                v.setSelected(true);
                Intent intent = new Intent(Controlador_Lista.this, Controlador_Simbolo.class);
                intent.putExtra("Letra",listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition));
                startActivity(intent);

            //    nuevaPantalla = new Controlador_Simbolo();
            //    Controlador_Lista.this.finish();

                return false;
            }
        });


    }



    public void reproducirSonido(View view){
        int id = view.getId();

        switch (id)
        {
            case R.id.btnSonido:
                sound.play(prueba);
                break;

        }
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Vocales");
        listDataHeader.add("Consonantes");

        // Adding child data
        List<String> listaVocales = new ArrayList<String>();
        listaVocales.add("A");
        listaVocales.add("E");
        listaVocales.add("I");
        listaVocales.add("O");
        listaVocales.add("U");

        List<String> listaConsonantes = new ArrayList<String>();
        listaConsonantes.add("B");
        listaConsonantes.add("C");
        listaConsonantes.add("D");
        listaConsonantes.add("F");
        listaConsonantes.add("G");
        listaConsonantes.add("H");
        listaConsonantes.add("J");
        listaConsonantes.add("K");
        listaConsonantes.add("L");
        listaConsonantes.add("M");
        listaConsonantes.add("N");
        listaConsonantes.add("Ñ");
        listaConsonantes.add("P");
        listaConsonantes.add("Q");
        listaConsonantes.add("R");
        listaConsonantes.add("S");
        listaConsonantes.add("T");
        listaConsonantes.add("V");
        listaConsonantes.add("W");
        listaConsonantes.add("X");
        listaConsonantes.add("Y");
        listaConsonantes.add("Z");
        listDataChild.put(listDataHeader.get(0), listaVocales); // Header, Child data
        listDataChild.put(listDataHeader.get(1), listaConsonantes);

    }





}
