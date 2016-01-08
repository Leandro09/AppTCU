package aplicacion.movil.alfabetizar;

import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import java.util.Locale;
import android.text.style.UnderlineSpan;
import android.text.SpannableString;


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
    }

    public void leerLetra(String letra)
    {
        String letraSubrayar = letra.toLowerCase(Locale.US);

        switch (letraSubrayar)
        {
            case "a":
                colocarPalabras(letraSubrayar, 0); //Digamos que el 0 representa algo que me permite saber
                // a partir de adonde debo leer en la lista las palabras correspondientes a "a"
                break;
        }
    }

    //Por el momento el parametro posicion no sirve de nada ! Tendrá sentido cuando se cree la lista
    public void colocarPalabras(String letra, int posicion)
    {
        String letraSubrayar;
        SpannableString palabraSubrayada;
        palabraSubrayada  = new SpannableString("arana"); //Esto ahorita esta como default, pero
        //aqui debe ir una manera de leer de la lista una vez que sabe la posicion o algo que
        //identifique a partir de adonde en la lista debe leer

        if (letra.length() > 0 && !letra.trim().equals(""))
        {
            letraSubrayar = letra.toLowerCase(Locale.US);

            for(int contadorPosicion = 1; contadorPosicion < 4; ++contadorPosicion)
            {
                for (int i = 0; i < palabraSubrayada.length(); ++i)
                {
                    if (palabraSubrayada.charAt(i) == letraSubrayar.charAt(0)) {
                        palabraSubrayada.setSpan(new UnderlineSpan(), i, i + 1, 0);
                    }
                }
                if (contadorPosicion == 1)
                {
                    TextView t1 = (TextView) findViewById(R.id.textPrimera);
                    t1.setText(palabraSubrayada);
                    palabraSubrayada  = new SpannableString("amanecer"); //se debe reemplazar este default por
                            // la forma que permita leer de la lista la palabra
                }
                else if (contadorPosicion == 2)
                {
                    TextView t1 = (TextView) findViewById(R.id.textSegunda);
                    t1.setText(palabraSubrayada);
                    palabraSubrayada  = new SpannableString("atardecer"); //se debe reemplazar este default por
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

}
