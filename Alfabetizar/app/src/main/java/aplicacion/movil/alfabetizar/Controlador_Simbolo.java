package aplicacion.movil.alfabetizar;

import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;


/**
 * Created by Leandro on 29/12/2015.
 * Clase que contiene sonido y palabras para un símbolo en específico
 */
public class Controlador_Simbolo extends AppCompatActivity {


    Controlador_Sonidos sound;
    int prueba;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contenedor_simbolo);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        //getIntent().getExtras().getChar("Letra");
        String letra = getIntent().getStringExtra("Letra");
        System.out.println("saf"+letra);
        leerLetra(letra);
        sound = new Controlador_Sonidos(getApplicationContext());
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        prueba = sound.load(R.raw.prueba);

        //Boton(flecha) de retorno
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
    }

    public void leerLetra(String letra)
    {

        String letraSubrayar = letra.toLowerCase(Locale.US);
        char letraLeida = letraSubrayar.charAt(0);
        int asciiLetra =  (int)letraLeida;
        int posicion = asciiLetra - 'a';
        int cantidadPalabras = 3;
      //  Toast.makeText(getApplicationContext(), "posicion: " + posicion, Toast.LENGTH_SHORT).show();
        ArrayList<String> lista = Controlador_Principal.listaPalabras.get(1);
        String pala = Controlador_Principal.listaPalabras.get(1).get(0);
        SpannableString palabrita = new SpannableString(lista.get(0));
       /* Toast.makeText(getApplicationContext(), "palabra 1: " + palabrita, Toast.LENGTH_SHORT).show();
        palabrita = new SpannableString(lista.get(1));
        Toast.makeText(getApplicationContext(), "palabra 2: " + palabrita, Toast.LENGTH_SHORT).show();
        palabrita = new SpannableString(lista.get(2));
        Toast.makeText(getApplicationContext(), "palabra 3: " + palabrita, Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), "palabrix: " + pala, Toast.LENGTH_SHORT).show(); */
        colocarPalabras(letraSubrayar, posicion);


    /*    switch (letraSubrayar)
        {
            case "a":
                letraLeida = letraSubrayar.charAt(0);
                asciiLetra = (int)letraLeida;
                colocarPalabras(letraSubrayar, 0); //Digamos que el 0 representa algo que me permite saber
                // a partir de adonde debo leer en la lista las palabras correspondientes a "a"
                break;

            case "b":
                letraLeida = letraSubrayar.charAt(0);
                asciiLetra = (int)letraLeida;
                posicion = asciiLetra - 'a';
                colocarPalabras(letraSubrayar, posicion);
                break;

            case "c":
                letraLeida = letraSubrayar.charAt(0);
                asciiLetra = (int)letraLeida;
                posicion = asciiLetra - 'a';
                colocarPalabras(letraSubrayar, posicion);
                break;

            case "d":
                letraLeida = letraSubrayar.charAt(0);
                asciiLetra = (int)letraLeida;
                posicion = asciiLetra - 'a';
                colocarPalabras(letraSubrayar, posicion);
                break;

            case "e":
                letraLeida = letraSubrayar.charAt(0);
                asciiLetra = (int)letraLeida;
                posicion = asciiLetra - 'a';
                colocarPalabras(letraSubrayar, posicion);
                break;

            case "f":
                letraLeida = letraSubrayar.charAt(0);
                asciiLetra = (int)letraLeida;
                posicion = asciiLetra - 'a';
                colocarPalabras(letraSubrayar, posicion);
                break;

            case "g":
                letraLeida = letraSubrayar.charAt(0);
                asciiLetra = (int)letraLeida;
                posicion = asciiLetra - 'a';
                colocarPalabras(letraSubrayar, posicion);
                break;

            case "h":
                letraLeida = letraSubrayar.charAt(0);
                asciiLetra = (int)letraLeida;
                posicion = asciiLetra - 'a';
                colocarPalabras(letraSubrayar, posicion);
                break;

            case "i":
                letraLeida = letraSubrayar.charAt(0);
                asciiLetra = (int)letraLeida;
                posicion = asciiLetra - 'a';
                colocarPalabras(letraSubrayar, posicion);
                break;

            case "j":
                letraLeida = letraSubrayar.charAt(0);
                asciiLetra = (int)letraLeida;
                posicion = asciiLetra - 'a';
                colocarPalabras(letraSubrayar, posicion);
                break;

            case "k":
                letraLeida = letraSubrayar.charAt(0);
                asciiLetra = (int)letraLeida;
                posicion = asciiLetra - 'a';
                colocarPalabras(letraSubrayar, posicion);
                break;

            case "l":
                letraLeida = letraSubrayar.charAt(0);
                asciiLetra = (int)letraLeida;
                posicion = asciiLetra - 'a';
                colocarPalabras(letraSubrayar, posicion);
                break; */



    //    }
    }

    //Por el momento el parametro posicion no sirve de nada ! Tendrá sentido cuando se cree la lista
    public void colocarPalabras(String letra, int posicion)
    {
        String letraSubrayar;
        SpannableString palabraSubrayada;
        int indice = 0;
        String letraTildada = " ";
        ArrayList<String> lista = Controlador_Principal.listaPalabras.get(posicion);

        palabraSubrayada  = new SpannableString(lista.get(0));

        if (letra.length() > 0 && !letra.trim().equals(""))
        {
            letraSubrayar = letra.toLowerCase(Locale.US);

            for(int contadorPosicion = 1; contadorPosicion < 4; ++contadorPosicion)
            {
                for (int i = 0; i < palabraSubrayada.length(); ++i)
                {

                    switch(letra)
                    {
                        case "a":
                            letraTildada = "á";
                            break;

                        case "e":
                            letraTildada = "é";
                            break;

                        case "i":
                            letraTildada = "í";
                            break;

                        case "o":
                            letraTildada = "ó";
                            break;

                        case "u":
                            letraTildada = "ú";
                            break;

                        default:
                            letraTildada = " ";
                    }

                    if ( (palabraSubrayada.charAt(i) == letraSubrayar.charAt(0)) || (palabraSubrayada.charAt(i) == letraTildada.charAt(0))  ) {

                        palabraSubrayada.setSpan(new UnderlineSpan(), i, i + 1, 0);
                    }
                }
                if (contadorPosicion == 1)
                {
                    TextView t1 = (TextView) findViewById(R.id.textPrimera);
                    t1.setText(palabraSubrayada);
                    palabraSubrayada  = new SpannableString(lista.get(1)); //se debe reemplazar este default por
                            // la forma que permita leer de la lista la palabra
                }
                else if (contadorPosicion == 2)
                {
                    TextView t1 = (TextView) findViewById(R.id.textSegunda);
                    t1.setText(palabraSubrayada);
                    palabraSubrayada  = new SpannableString(lista.get(2)); //se debe reemplazar este default por
                    // la forma que permita leer de la lista la palabra
                }
                else
                {
                    TextView t1 = (TextView) findViewById(R.id.textTercera);
                    t1.setText(palabraSubrayada);
                }

            }
        }
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
