package aplicacion.movil.alfabetizar;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import java.util.ArrayList;

/*
* Clase para iniciar aplicación
 */

public class Controlador_Principal extends AppCompatActivity {


    public static ArrayList<ArrayList<String>> listaPalabras;

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
                startActivity(new Intent(Controlador_Principal.this, Controlador_Lista.class));
            }
        });
    }

    public void llenarArreglo(){
        ArrayList<String> palabras = new ArrayList<String>();
        palabras.add("anillo");
        palabras.add("abeja");
        palabras.add("alambre");
        listaPalabras.add(palabras);

        palabras.clear();
        palabras.add("barco");
        palabras.add("beso");
        palabras.add("botella");
        listaPalabras.add(palabras);

        palabras.clear();
        palabras.add("caballo");
        palabras.add("casa");
        palabras.add("cocina");
        listaPalabras.add(palabras);


    }


}
