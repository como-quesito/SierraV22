package v2.sierra.campitos;

import android.content.Context;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by campitos on 3/02/15.
 */
public class CreacionReptiles {


    public int obtenerImagenes(Context ctx){
        ImageView i1= new ImageView(ctx);
        i1.setImageResource(R.drawable.cascabel);

        int recurso=R.drawable.cincuate;
        return recurso;
    }

    public static ArrayList<Reptil> obtenerReptiles(Context ctx){
        /*
        Generamos todas las floras
         */
        ArrayList<Reptil> reptiles=new ArrayList<Reptil>();
        Reptil r1=new Reptil();
        r1.setId(R.drawable.cascabel1);
        r1.setSinopsis("El palo loco es una planta muy bella, es originario de la sierra de guadalupe. \n Una vez fuimos y vimos muchos");
        r1.setTitulo("Víbora de cascabel");

        Reptil r2=new Reptil();
        r2.setId(R.drawable.cincuate);
        r2.setSinopsis("Arbol originario de México y parte de Estados Unidos. Planta leguminosa que retiene" +
                "nitrógeno a partir de los 3 meses de crecimiento. Arbol caducifolio renueva sus hojas cada año su ventaja es que " +
                "requieren poca agua y escazo mantenimiento. Fácil de propagar en viveros, tienen la propiedad de que" +
                " forman suelos. NOmbre científico Encynhardia Polystachia");
        r2.setTitulo("Cincuate");

        Reptil r3=new Reptil();
        r3.setId(R.drawable.cascabel);
        r3.setSinopsis("Arbol originario de México. Planta leguminosa fijadora de nitrógeno. Arbol caducifolio, en invierno pierde sus hojas" +
                ". Soporta bien la sequía, se usa para leña y producir carbón, muebles y objetos o juguetes. Ventajas: Requiere poca agua" +
                ", mantenimiento y capturan nitrógeno que nutre el suelo. Es una especie de lento crecimiento.");
        r3.setTitulo("Cascabel cola negra");

        reptiles.add(r1);
        reptiles.add(r2);
        reptiles.add(r3);
        return reptiles;

    }
}
