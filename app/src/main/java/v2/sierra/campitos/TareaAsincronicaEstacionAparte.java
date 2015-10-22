package v2.sierra.campitos;

import android.app.Activity;
import android.graphics.Color;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.TextView;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

import java.util.Collections;

/**
 * Created by campitos on 20/02/15.
 */
public class TareaAsincronicaEstacionAparte extends AsyncTask<String, Integer, Integer>{
    private Activity activity;

    private String mensaje="---";

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public TareaAsincronicaEstacionAparte(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected Integer doInBackground(String... params) {
        int progress=0;
        //Este no se ejecuta en el main Thread
        try {
            int horaActual= Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
            String temperaturaActual=leerTemepraturas("nalgas").get(horaActual).getUv();

          //Este es para invocar el getmensaje() y nos de la temperatura en el fragmento de pantallaInicial :)
          //sin embargo el ajuste del A TEMPERATURA DEBE ESTAR EN EL METODO QUE TIENE EL MAUL THREAD, AQUI NO,
           //BUSCALO ESTARA MAS ABAJO ..
               setMensaje(temperaturaActual);



          System.out.println("<<<<<<<<<<<<<<<" + temperaturaActual);
            System.out.println("SI SE RECIBIO BIEN");
        }catch(Exception e){
            System.out.println("<<ALGO MALO OCURRIO:"+e.getMessage());
            setMensaje("Sin conexión :(");
        }
        return progress;
    }

    @Override
    public void onProgressUpdate(Integer... valores){
        //Este corre en el main Thread
        System.out.println("ESte es el PROGRESSSSSSSSSSSS");
    }

    @Override
    protected void onPostExecute(Integer i){
        //Este correra en el main Thread
        //AQUI COMO ES EL MAIN THERAD LE INDICAMOS QUE QUEREMOS ACTUALIZAR EL VALOR DE LA TEMPERATURA
        TextView tv= (TextView) activity.findViewById(R.id.textoUV);
        ImageView icono= (ImageView) activity.findViewById(R.id.icono_alerta);

        //AQUI CHECAMOS LA ESCALA DE COLORES EN EL MAIN THREAD
        //El if que ves con el else es para que no ocurra la expcion
        if(getMensaje().equals("Sin conexión :(")){
            tv.setText(getMensaje());
            icono.setImageResource(R.drawable.blanco);
        }
            else{
            float valor = Float.parseFloat(getMensaje());
            System.out.println("<<<<<<<<<<<<<<<<<<" + valor);


            if (valor < 3) icono.setImageResource(R.drawable.tres);
            if (valor >= 3 && valor < 6) icono.setImageResource(R.drawable.tresseis);
            if (valor >= 6 && valor < 8) icono.setImageResource(R.drawable.seisocho);
            if (valor >= 8 && valor < 11)icono.setImageResource(R.drawable.ochoonce);
            if (valor >= 11) icono.setImageResource(R.drawable.once);;
           // if (valor >= 11) tv.setTextColor(Color.parseColor("#6C49CB"));
            tv.setText(getMensaje()+"UV");
        }


        System.out.println("Una vez terminado se ejecutara el POST EXECUTEEEE");
        super.onPostExecute(i);
    }


    public String  enviarMensaje()throws Exception{
        String leido="nada se leyo  :(";

        HttpHeaders requestHeaders=new HttpHeaders();
        requestHeaders.setAccept(Collections.singletonList(new MediaType("text", "html")));

        HttpEntity<?> requestEntity=new HttpEntity<Object>(requestHeaders);

        String url="http://campitos-ley.whelastic.net/uv/servicios/celulares/enviar2/"+mensaje;

        RestTemplate restTemplate=new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

        ResponseEntity<String> responseEntity=restTemplate.exchange(url, HttpMethod.GET,requestEntity, String.class);
        leido=responseEntity.getBody();

        ObjectMapper mapper=new ObjectMapper();
        leido=mapper.readValue(leido, new TypeReference<String>(){});

        return leido;

    }


    public ArrayList<EstacionCompleta> leerTemepraturas(String miurl)throws Exception{
        String leido="nada se leyo  :(";

        HttpHeaders requestHeaders=new HttpHeaders();
        requestHeaders.setAccept(Collections.singletonList(new MediaType("application","json")));

        HttpEntity<?> requestEntity=new HttpEntity<Object>(requestHeaders);

        String url="http://campitos.elasticbeanstalk.com/estacion/temperatura";

        RestTemplate restTemplate=new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

        ResponseEntity<String> responseEntity=restTemplate.exchange(url, HttpMethod.GET,requestEntity, String.class);
        leido=responseEntity.getBody();

        ObjectMapper mapper=new ObjectMapper();
        ArrayList<EstacionCompleta> temperaturas=mapper.readValue(leido, new TypeReference<ArrayList<EstacionCompleta>>(){});

        return temperaturas;

    }

}
