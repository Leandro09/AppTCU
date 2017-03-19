package aplicacion.movil.alfabetizar;

import android.app.Dialog;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;


import java.util.Locale;


/**
 * Created by Leandro on 29/12/2015.
 * Clase que contiene sonido y palabras para un símbolo en específico
 */
public class Controlador_Simbolo extends AppCompatActivity {


    Controlador_Sonidos sound;
    int sonido1, sonido2, sonido3, sonido4; //Variables que van a contener los audios de cada boton

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contenedor_simbolo);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        //getIntent().getExtras().getChar("Letra");
        String letra = getIntent().getStringExtra("Letra");
        System.out.println("saf"+letra);

        sound = new Controlador_Sonidos(getApplicationContext());
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);

        leerLetra(letra); //Debe estar después de haberse inicializado la variable "sound"

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
        String inicioNombreImagen = "";
        int drawableResourceId = 0;   //Imagenes
        ImageView img;

        String nombreSonido = "";
        String inicioNombreSonido = "";
        int rawResourceId;        //Sonidos


        if(indicador == true) {
            inicioNombreImagen = "imagen";
            inicioNombreSonido = "audio";
        }else{
            inicioNombreImagen = "imagen_letra_especial";
            inicioNombreSonido = "audio_letra_especial";
        }

        for(int contadorPosicion = 1; contadorPosicion <= 4; ++contadorPosicion) {
            nombreImagen = inicioNombreImagen + posicion + "_" + contadorPosicion;
            drawableResourceId = getResources().getIdentifier( nombreImagen, "drawable", this.getPackageName());

            nombreSonido = inicioNombreSonido + posicion + "_" + contadorPosicion;
            rawResourceId = getResources().getIdentifier( nombreSonido, "raw", this.getPackageName());

            switch (contadorPosicion) {
                case 1:
                    img = (ImageView) findViewById(R.id.imagen1);
                    img.setImageResource(drawableResourceId);
                    mostrarZoom(img);

                    //Carga del audio de la segunda palabra
                    if (rawResourceId != 0) {
                        //Carga el audio si existe
                        sonido1 = sound.load(rawResourceId);
                    } else {
                        //Si el audio no existe entonces no muestra el boton en la pantalla
                        Button botonAudio = (Button)findViewById(R.id.btnSonido1);
                        botonAudio.setVisibility(View.INVISIBLE);
                    }
                    break;
                case 2:
                    img = (ImageView) findViewById(R.id.imagen2);
                    img.setImageResource(drawableResourceId);
                    mostrarZoom(img);

                    //Carga el audio de la segunda palabra
                    if (rawResourceId != 0) {
                        //Carga el audio si existe
                        sonido2 = sound.load(rawResourceId);
                    } else {
                        //Si el audio no existe entonces no muestra el boton en la pantalla
                        Button botonAudio = (Button)findViewById(R.id.btnSonido2);
                        botonAudio.setVisibility(View.INVISIBLE);
                    }
                    break;
                case 3:
                    img = (ImageView) findViewById(R.id.imagen3);
                    img.setImageResource(drawableResourceId);
                    mostrarZoom(img);

                    //Carga el audio de la tercer palabra
                    if (rawResourceId != 0) {
                        //Carga el audio si existe
                        sonido3 = sound.load(rawResourceId);
                    } else {
                        //Si el audio no existe entonces no muestra el boton en la pantalla
                        Button botonAudio = (Button)findViewById(R.id.btnSonido3);
                        botonAudio.setVisibility(View.INVISIBLE);
                    }
                    break;
                default:
                    img = (ImageView) findViewById(R.id.imagen4);
                    img.setImageResource(drawableResourceId);
                    mostrarZoom(img);

                    //Carga el audio de la "cuarta" palabra (letra)
                    if (rawResourceId != 0) {
                        //Carga el audio si existe
                        sonido4 = sound.load(rawResourceId);
                    } else {
                        //Si el audio no existe entonces no muestra el boton en la pantalla
                        Button botonAudio = (Button)findViewById(R.id.btnSonido4);
                        botonAudio.setVisibility(View.INVISIBLE);
                    }
                    break;

            }
        }

    }


    public void mostrarZoom(ImageView imageView){

        // Crea la ventana donde se va a mostrar la imagen
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.zoom);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.setCanceledOnTouchOutside(true);

        ImageView image = (ImageView) dialog.findViewById(R.id.imagenZoom);
        image.setImageDrawable(imageView.getDrawable());

        dialog.getWindow().setBackgroundDrawable(null);
        //Establece el tamaño de la ventana con respecto a las dimensiones de la pantalla
        dialog.getWindow().setLayout(
                // 65% del ancho de la pantalla
                (int) (Resources.getSystem().getDisplayMetrics().widthPixels * 0.65),
                // 55% del alto de la pantalla
                (int) (Resources.getSystem().getDisplayMetrics().heightPixels * 0.55)
        );

        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialog.show(); // Mostrar la ventana cuando se presione la imagen
            }
        });
    }

    public void reproducirSonido(View view){
    int id = view.getId();

    switch (id)
    {
        case R.id.btnSonido1:
            sound.play(sonido1);
            break;
        case R.id.btnSonido2:
            sound.play(sonido2);
            break;
        case R.id.btnSonido3:
            sound.play(sonido3);
            break;
        default:
            sound.play(sonido4);
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
