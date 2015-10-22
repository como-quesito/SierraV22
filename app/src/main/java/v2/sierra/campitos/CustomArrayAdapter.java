package v2.sierra.campitos;

import android.app.Activity;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by campitos on 7/01/15.
 */
public class CustomArrayAdapter extends ArrayAdapter<String> {
    private  final Activity context;
    private final  String []elementos;
    private final Integer[] imageIds;
    private final String[] descripcion;

    public CustomArrayAdapter(Activity context, String[] elementos, String descripcion[], Integer[] imageIds){
        super(context, R.layout.layout_elementos,elementos);
        this.context=context;
        this.elementos=elementos;
        this.descripcion=descripcion;
        this.imageIds=imageIds;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        Log.d("CustomArrayAdapter", String.valueOf(position));
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.layout_elementos, null, true);

        //Aqui personalizamos la fuente :)
        Typeface tf = Typeface.createFromAsset(this.context.getAssets(),"Cinzel-Regular.otf");

        //La segunda para la descripcion
        Typeface tf2=Typeface.createFromAsset(this.context.getAssets(),"Gaspar_Bold.otf");

        //Obtenemos las referencias a los textos
        TextView textoelemento= (TextView) rowView.findViewById(R.id.textoelemento);
        //Ajustamo tipografia personalziada
        textoelemento.setTypeface(tf);
        TextView textodescripcion= (TextView) rowView.findViewById(R.id.textodescripcion);
        //Ajustamos su typeface2
        textodescripcion.setTypeface(tf2);
        ImageView imagen= (ImageView) rowView.findViewById(R.id.icon);

        //Personalizamos el contenido de cada elemento
        textoelemento.setText(elementos[position]);
        textodescripcion.setText(descripcion[position]);
        imagen.setImageResource(imageIds[position]);

        return rowView;

    }
}
