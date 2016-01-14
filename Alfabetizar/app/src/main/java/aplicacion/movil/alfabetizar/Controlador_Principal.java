package aplicacion.movil.alfabetizar;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import java.util.ArrayList;

/*
* Clase para iniciar aplicación
 */

public class Controlador_Principal extends AppCompatActivity {


    public static ArrayList<ArrayList<String>> listaPalabras = new ArrayList<ArrayList<String>>();
    public static ArrayList<ArrayList<String>> listaPalabrasEspeciales = new ArrayList<ArrayList<String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contenedor_inicial);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        llenarArreglo();
        findViewById(R.id.btnIniciar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Controlador_Principal.this, Controlador_Tabs.class));
            }
        });

        //Boton(flecha) de retorno
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
    }

    public void llenarArreglo(){
        ArrayList<String> palabras = new ArrayList<String>();
        palabras.add("anillo");
        palabras.add("abejá");
        palabras.add("alambre");
        listaPalabras.add(palabras);


        palabras =  new ArrayList<String>();
     //   palabras.clear();
        palabras.add("barco");
        palabras.add("beso");
        palabras.add("botella");
        listaPalabras.add(palabras);

        palabras =  new ArrayList<String>();
     //   palabras.clear();
        palabras.add("caballo");
        palabras.add("casa");
        palabras.add("cocina");
        listaPalabras.add(palabras);

        palabras =  new ArrayList<String>();
     //   palabras.clear();
        palabras.add("dedo");
        palabras.add("dado");
        palabras.add("derecha");
        listaPalabras.add(palabras);

        palabras =  new ArrayList<String>();
     //   palabras.clear();
        palabras.add("elefante");
        palabras.add("esfera");
        palabras.add("escritorio");
        listaPalabras.add(palabras);

        palabras =  new ArrayList<String>();
     //   palabras.clear();
        palabras.add("fuego");
        palabras.add("familia");
        palabras.add("funda");
        listaPalabras.add(palabras);

        palabras =  new ArrayList<String>();
     //   palabras.clear();
        palabras.add("gato");
        palabras.add("gas");
        palabras.add("gota");
        listaPalabras.add(palabras);

        palabras =  new ArrayList<String>();
     //   palabras.clear();
        palabras.add("hora");
        palabras.add("hueco");
        palabras.add("huevo");
        listaPalabras.add(palabras);

        palabras =  new ArrayList<String>();
     //   palabras.clear();
        palabras.add("iglesia");
        palabras.add("izquierda");
        palabras.add("imán");
        listaPalabras.add(palabras);

        palabras =  new ArrayList<String>();
    //   palabras.clear();
        palabras.add("jaula");
        palabras.add("jarra");
        palabras.add("jugo");
        listaPalabras.add(palabras);

        palabras =  new ArrayList<String>();
     //   palabras.clear();
        palabras.add("kiwi");
        palabras.add("kilo");
        palabras.add("kiosco");
        listaPalabras.add(palabras);

        palabras =  new ArrayList<String>();
     //   palabras.clear();
        palabras.add("luna");
        palabras.add("león");
        palabras.add("lengua");
        listaPalabras.add(palabras);

        palabras =  new ArrayList<String>();
     //   palabras.clear();
        palabras.add("mapa");
        palabras.add("mano");
        palabras.add("mono");
        listaPalabras.add(palabras);

        palabras =  new ArrayList<String>();
    //    palabras.clear();
        palabras.add("nueces");
        palabras.add("nacer");
        palabras.add("nublado");
        listaPalabras.add(palabras);



        palabras =  new ArrayList<String>();
        //   palabras.clear();
        palabras.add("oso");
        palabras.add("ocho");
        palabras.add("oído");
        listaPalabras.add(palabras);


        palabras =  new ArrayList<String>();
        //  palabras.clear();
        palabras.add("pala");
        palabras.add("palo");
        palabras.add("puente");
        listaPalabras.add(palabras);

        palabras =  new ArrayList<String>();
        //  palabras.clear();
        palabras.add("queso");
        palabras.add("queque");
        palabras.add("quince");
        listaPalabras.add(palabras);

        palabras =  new ArrayList<String>();
     //   palabras.clear();
        palabras.add("ratón");
        palabras.add("roca");
        palabras.add("rana");
        listaPalabras.add(palabras);

        palabras =  new ArrayList<String>();
     //   palabras.clear();
        palabras.add("sol");
        palabras.add("salsa");
        palabras.add("sombrero");
        listaPalabras.add(palabras);

        palabras =  new ArrayList<String>();
      //  palabras.clear();
        palabras.add("tabla");
        palabras.add("tornillo");
        palabras.add("tornado");
        listaPalabras.add(palabras);

        palabras =  new ArrayList<String>();
    //    palabras.clear();
        palabras.add("unicornio");
        palabras.add("umbral");
        palabras.add("uniforme");
        listaPalabras.add(palabras);

        palabras =  new ArrayList<String>();
     //   palabras.clear();
        palabras.add("volcán");
        palabras.add("volar");
        palabras.add("vestido");
        listaPalabras.add(palabras);

        palabras =  new ArrayList<String>();
     //   palabras.clear();
        palabras.add("webcam");
        palabras.add("walkman");
        palabras.add("wafles");
        listaPalabras.add(palabras);

        palabras =  new ArrayList<String>();
     //   palabras.clear();
        palabras.add("xenofobia");
        palabras.add("xilófono");
        palabras.add("xerocopia");
        listaPalabras.add(palabras);

        palabras =  new ArrayList<String>();
     //   palabras.clear();
        palabras.add("ya");
        palabras.add("yayo");
        palabras.add("yayito");
        listaPalabras.add(palabras);

        palabras =  new ArrayList<String>();
      //  palabras.clear();
        palabras.add("zapato");
        palabras.add("zapallo");
        palabras.add("zanahoria");
        listaPalabras.add(palabras);

        //Finalmente se llena la lista con los acentos propios del idioma español como lo es la letra ñ
        palabras =  new ArrayList<String>();
        palabras.add("ña");
        palabras.add("ñañita");
        palabras.add("ñeeee");
        listaPalabrasEspeciales.add(palabras);
    }

    //Le da funcionalidad a la flecha de retorno
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
