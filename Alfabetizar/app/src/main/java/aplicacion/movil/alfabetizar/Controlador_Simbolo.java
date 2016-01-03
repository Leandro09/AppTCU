package aplicacion.movil.alfabetizar;

import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by Leandro on 29/12/2015.
 * Clase que contiene sonido y palabras para un símbolo en específico
 */
public class Controlador_Simbolo extends AppCompatActivity {


    Controlador_Sonidos sound;

    int prueba;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contenedor_Simbolo);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        sound = new Controlador_Sonidos(getApplicationContext());
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        prueba = sound.load(R.raw.prueba);
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
