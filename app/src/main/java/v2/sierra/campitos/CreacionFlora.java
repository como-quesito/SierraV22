package v2.sierra.campitos;

import android.content.Context;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by campitos on 2/02/15.
 */
public class CreacionFlora {


    public int obtenerImagenes(Context ctx){
        ImageView i1= new ImageView(ctx);
        i1.setImageResource(R.drawable.cascabel);

        int recurso=R.drawable.cincuate;
        return recurso;
    }

    public static ArrayList<Flora> obtenerFlora(Context ctx){
        /*
        Generamos todas las floras
         */
           ArrayList<Flora> flora=new ArrayList<Flora>();
        Flora f1=new Flora();
        f1.setId(R.drawable.paloloco);
        f1.setSinopsis("El palo loco es una planta muy bella, es originario de la sierra de guadalupe. \n Una vez fuimos y vimos muchos");
        f1.setTitulo("Palo loco");

        Flora f2=new Flora();
        f2.setId(R.drawable.palodulce);
        f2.setSinopsis("Arbol originario de México y parte de Estados Unidos. Planta leguminosa que retiene" +
                "nitrógeno a partir de los 3 meses de crecimiento. Arbol caducifolio renueva sus hojas cada año su ventaja es que " +
                "requieren poca agua y escazo mantenimiento. Fácil de propagar en viveros, tienen la propiedad de que" +
                " forman suelos. NOmbre científico Encynhardia Polystachia");
        f2.setTitulo("Palo Dulce");

        Flora f3=new Flora();
        f3.setId(R.drawable.mezquite);
        f3.setSinopsis("Arbol originario de México. Planta leguminosa fijadora de nitrógeno. Arbol caducifolio, en invierno pierde sus hojas" +
                ". Soporta bien la sequía, se usa para leña y producir carbón, muebles y objetos o juguetes. Ventajas: Requiere poca agua" +
                ", mantenimiento y capturan nitrógeno que nutre el suelo. Es una especie de lento crecimiento.");
        f3.setTitulo("Mezquite");

        flora.add(f1);
        flora.add(f2);
        flora.add(f3);
        return flora;

    }
}
