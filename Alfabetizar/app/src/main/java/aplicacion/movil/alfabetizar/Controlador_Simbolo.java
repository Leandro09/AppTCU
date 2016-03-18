package aplicacion.movil.alfabetizar;

import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.juliomarcos.ImageViewPopUpHelper;

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
        int resultado = -1;
        int posicion = -1;
        String letraSubrayar = letra.toLowerCase(Locale.US);
        char letraLeida = letraSubrayar.charAt(0);
        int asciiLetra =  (int)letraLeida;

        resultado = verificarTipoLetra(letraSubrayar);
        if( resultado == -1){
            posicion = asciiLetra - 'a';
            colocarImagen(posicion,true);
        }else{
            colocarImagen(resultado, false);
        }

    }


    //metodo para buscar en arreglo de letras especiales
    public int verificarTipoLetra(String letra){
        int longitud = Controlador_Principal.letrasEspeciales.size();
        int contador = 0;
        Boolean indicador = false;
        while(indicador == false && contador < longitud){
            if(letra.equals(Controlador_Principal.letrasEspeciales.get(contador))==true){
                indicador = true;
            }else{
                ++contador;
            }
        }

        if(indicador == false){
            contador = -1;
        }

        return contador;
    }


    //metodo para colocar imagenes de acuerdo a la letra selecciona
    public void colocarImagen(int posicion, boolean indicador ){
        String nombreImagen = "";
        String ubicacionImagen = "";
        String inicioNombre = "";
        int res = 0;
        ImageView img;

        if(indicador == true) {
            inicioNombre = "imagen";
        }else{
            inicioNombre = "imagen_letra_especial";
        }

        for(int contadorPosicion = 1; contadorPosicion <= 4; ++contadorPosicion) {
            nombreImagen = inicioNombre + posicion + "_" + contadorPosicion;
            res = getResources().getIdentifier(nombreImagen, "drawable", this.getPackageName());

            switch (contadorPosicion) {
                case 1:
                    img = (ImageView) findViewById(R.id.imagen1);
                    img.setImageResource(res);
                    ImageViewPopUpHelper.enablePopUpOnClick(this, img);
                    break;
                case 2:
                    img = (ImageView) findViewById(R.id.imagen2);
                    img.setImageResource(res);
                    ImageViewPopUpHelper.enablePopUpOnClick(this, img);
                    break;
                case 3:
                    img = (ImageView) findViewById(R.id.imagen3);
                    img.setImageResource(res);
                    ImageViewPopUpHelper.enablePopUpOnClick(this, img);
                    break;
                default:
                    img = (ImageView) findViewById(R.id.imagen4);
                    img.setImageResource(res);
                    ImageViewPopUpHelper.enablePopUpOnClick(this, img);
                    break;

            }
        }



    }


    public void colocarPalabras(String letra, int posicion)
    {
        /*SpannableString palabraSubrayada;
        String letraTildada = " ";
        int contador = 0;
        ArrayList<String> lista = new ArrayList<String>();

        if(letra.contentEquals("ñ"))
        {
            while(contador < Controlador_Principal.listaPalabrasEspeciales.size() && letra.charAt(0) != Controlador_Principal.listaPalabrasEspeciales.get(contador).get(0).charAt(0))
            {
                ++contador;
            }

            if(contador < Controlador_Principal.listaPalabrasEspeciales.size() )
            {
                lista = Controlador_Principal.listaPalabrasEspeciales.get(contador);
            }
       }
        else
        {
            lista = Controlador_Principal.listaPalabras.get(posicion);
        }

        if (letra.length() > 0 && !letra.trim().equals(""))
        {
                palabraSubrayada  = new SpannableString(lista.get(0).toLowerCase(Locale.US));

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

                   if ( (palabraSubrayada.charAt(i)  == letra.charAt(0)) || (palabraSubrayada.charAt(i) == letraTildada.charAt(0))  ) {

                        palabraSubrayada.setSpan(new UnderlineSpan(), i, i + 1, 0);
                    }

                }
               if (contadorPosicion == 1)
                {
                    TextView t1 = (TextView) findViewById(R.id.textPrimera);
                    t1.setText(palabraSubrayada);
                    palabraSubrayada  = new SpannableString(lista.get(1).toLowerCase(Locale.US));
                }
                else if (contadorPosicion == 2)
                {
                    TextView t1 = (TextView) findViewById(R.id.textSegunda);
                    t1.setText(palabraSubrayada);
                    palabraSubrayada  = new SpannableString(lista.get(2).toLowerCase(Locale.US));
                }
                else
                {
                    TextView t1 = (TextView) findViewById(R.id.textTercera);
                    t1.setText(palabraSubrayada);
                }

            }
        }*/
    }

    public void reproducirSonido(View view){
        int id = view.getId();

        switch (id)
        {
            case R.id.btnSonido1:
                sound.play(prueba);
                break;
            case R.id.btnSonido2:
                sound.play(prueba);
                break;
            default:
                sound.play(prueba);
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
