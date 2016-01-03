package aplicacion.movil.alfabetizar;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

/**
 * Created by Leandro on 20/12/2015.
 * Clase para manejar sonidos
 */
public class Controlador_Sonidos {

    private Context pContext;
    private SoundPool sndPool;
    private float rate = 1.0f;
    private float leftVolume = 1.0f;
    private float rightVolume = 1.0f;

    public Controlador_Sonidos(Context appContext){
        SoundPool.Builder sound;
        pContext = appContext;
        if (android.os.Build.VERSION.SDK_INT == 21){
            sound = new SoundPool.Builder();
            sound.setMaxStreams(10);
            sndPool = sound.build();
        }else{
            sndPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 100);
        }
    }

    public int load(int idSonido){
        return sndPool.load(pContext, idSonido, 1);
    }

    public int play (int identificador){
        return sndPool.play(identificador,leftVolume,rightVolume,0,0,rate);
    }
}
