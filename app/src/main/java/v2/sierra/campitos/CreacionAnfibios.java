package v2.sierra.campitos;

import android.content.Context;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by campitos on 18/02/15.
 */
public class CreacionAnfibios {


    public int obtenerImagenes(Context ctx){
        ImageView i1= new ImageView(ctx);
        i1.setImageResource(R.drawable.cascabel);

        int recurso=R.drawable.cincuate;
        return recurso;
    }

    public static ArrayList<Anfibio> obtenerAnfibios(Context ctx){
        /*
        Generamos todas las floras
         */
        ArrayList<Anfibio> anfibios=new ArrayList<Anfibio>();
        Anfibio a1=new Anfibio();
        a1.setId(R.drawable.axolote);
        a1.setSinopsis("El AJOLOTE es un enigmático anfibio que desde hace cientos de años ha existido en aguas de ríos, canales, lagos y lagunas del valle de México. En sierra de Guadalupe se detectaron poblaciones en cuerpos de aguas. Sin embargo, el crecimiento desmedido de la ciudad, sequias, contaminación ambiental y el exterminio de este animal para consumo humano ó para remedios medicinales, han ocasionado la amenaza de extinción del (Ambystoma mexicanum)\n" +
                "El ajolote era un manjar exquisito para los habitantes del México prehispánico, pues su sabor es parecido al de la anguila. Actualmente se localiza en Lagos y canales de Xochimilco y en algunos lagos del Valle de México y se está estudiando sus propiedades regenerativas. ");
        a1.setTitulo("Axolote");

        Anfibio a2=new Anfibio();
        a2.setId(R.drawable.rana_arboricola);
        a2.setSinopsis("De esta rana arborícola se ha encontrado algunos individuos en una de las presas de Sierra de Guadalupe, no se sabe con certeza si es una población natural o es una especie introducida (exótica), ya que es muy común tenerla como mascota. Hyla  eximia e Hyla plicata son especies muy emparentadas que habitan en las mismas zonas y son morfológicamente muy parecidas, por lo cual es difícil diferenciarlas. A pesar de estas similitudes, se encuentran diferencias conductuales notables: el canto de cortejo de H. plicata es grave y largo mientras que el de H. eximia es agudo y corto.");
        a2.setTitulo("Rana Arborícola");

        Anfibio a3=new Anfibio();
        a3.setId(R.drawable.rana_de_labios_blancos);
        a3.setSinopsis("Se sabe poco de esta especie, se conoce una sola localidad al sur del Distrito Federal, en los campos de lava del Volcán Xitle. Fue encontrado en Algunos sitios alrededor de la Ciudad de México. Esta rana es endémica para México. Se encuentra en peligro de extinción debido a la continua disminución de la amplitud y la calidad de su hábitat. Info. Biol. Hugo Plata");
        a3.setTitulo("Rana de labios blancos");

        Anfibio a4=new Anfibio();
        a4.setId(R.drawable.anfibios);
        a4.setSinopsis("Son la especie que es considerada por expertos e investigaciones realizadas sobre cambio climático en peligro de extinción debido a la fragilidad de sus ecosistemas, perdida de cuerpos de agua y cambios de temperatura.\n" +
                "\n" +
                "La sierra de Guadalupe registra al menos 9 especies. Las características de los anfibios son: \n" +
                "Poseen 4 patas y 5 dedos en los pies y 4 dedos en las manos.\n" +
                "Tienen una piel desnuda provista de glándulas que la humedecen, con esto pueden absorber el oxígeno del aire y el agua a través de la piel.\n" +
                "Su respiración es por branquias, pulmones y la piel.\n" +
                "Poseen esqueleto interno, pues se trata de animales vertebrados.\n" +
                "Su reproducción a través de huevos (ovípara).\n" +
                "Los huevo están desprovisto de membrana protectora (anamniotas). Los huevos no tienen caparazón por lo que deben ser puestos en un medio húmedo para no deshidratarse.\n" +
                "Presentan una serie de cambios en el cuerpo de la larva (renacuajo) llamado metamorfosis que los prepara para la vida en la tierra.\n" +
                "Son animales heterotermos o de sangre fría como los peces.");
        a4.setTitulo("Introducción");


        anfibios.add(a4);
        anfibios.add(a1);
        anfibios.add(a2);
        anfibios.add(a3);
        return anfibios;

    }
}


