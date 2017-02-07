package aplicacion.movil.alfabetizar;

/**
 * Created by Lari on 2/26/2016.
 */
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
public class Controlador_ListaImagenes extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] letras;
    private final Integer[] idImagenes;

    public Controlador_ListaImagenes(Activity context, String[] letras, Integer[] idImagenes)
    {
        super(context, R.layout.lista_letras_menu, letras);
        this.context = context;
        this.letras = letras;
        this.idImagenes = idImagenes;

    }

    @Override
    public View getView(int position, View view, ViewGroup parent)
    {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.lista_letras_menu, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.lista_letras_textview);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.imagenLetras);
        txtTitle.setText(letras[position]);

        imageView.setImageResource(idImagenes[position]);
        return rowView;
    }
}
