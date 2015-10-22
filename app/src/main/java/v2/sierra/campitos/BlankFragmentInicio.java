package v2.sierra.campitos;

import android.app.Activity;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
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


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BlankFragmentInicio.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BlankFragmentInicio#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragmentInicio extends Fragment {
    TextView tv;

    TextView tvtemper;
    ImageView icono;


    private SwipeRefreshLayout mSwipeRefreshLayout;
    private LinearLayout mListView;
    View v;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragmentInicio.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragmentInicio newInstance(String param1, String param2) {
        BlankFragmentInicio fragment = new BlankFragmentInicio();

        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public BlankFragmentInicio() {

        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         v= inflater.inflate(R.layout.blank_fragment_inicio, container, false);
        //Ponemos aqui los que aparecen el en onpostexecute patra que no salga nullpointer exception
        tv= (TextView) v.findViewById(R.id.textoUV);
        tvtemper=(TextView)v.findViewById(R.id.textoTemper);
        icono=(ImageView) v.findViewById(R.id.icono_alerta);
        mSwipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.swiperefresh);

        // BEGIN_INCLUDE (change_colors)
        // Set the color scheme of the SwipeRefreshLayout by providing 4 color resource ids
        mSwipeRefreshLayout.setColorScheme(
                R.color.swipe_color_1, R.color.swipe_color_2,
                R.color.swipe_color_3, R.color.swipe_color_4);
        // END_INCLUDE (change_colors)

        // Retrieve the ListView
        mListView = (LinearLayout) v.findViewById(android.R.id.list);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {


                initiateRefresh();


            }

        });

        TareaAsincronicaEstacion asin=new TareaAsincronicaEstacion(getActivity());
        asin.execute(null,null,null);
        TextView textoTemperatura= (TextView) v.findViewById(R.id.textoUV);
        TextView textoTemper=(TextView)v.findViewById(R.id.textoTemper);
        textoTemperatura.setText(asin.getMensaje()+" UV");
        textoTemper.setText(asin.getMensajeTemper()+"°C");


     TextView titulo= (TextView) v.findViewById(R.id.textoTitulo);
        Typeface typeface= Typeface.createFromAsset(getActivity().getAssets(),"Roboto-Light.ttf");
        Typeface typeface2= Typeface.createFromAsset(getActivity().getAssets(),"Roboto-Thin.ttf");
        titulo.setTypeface(typeface2);

        TextView textoSlogan= (TextView) v.findViewById(R.id.textoSlogan);
        textoTemperatura.setTypeface(typeface);
        textoSlogan.setTypeface(typeface2);
        textoTemper.setTypeface(typeface2);




        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }


    private void onRefreshComplete() {


        mSwipeRefreshLayout.setRefreshing(false);
    }

    private void initiateRefresh() {
        ImageView icono= (ImageView) getActivity() .findViewById(R.id.icono_alerta);
        icono.setImageResource(R.drawable.blanco);
        System.out.println("ESte es el PROGRESSSSSSSSSSSS");

        /**
         * Execute the background task, which uses {@link android.os.AsyncTask} to load the data.
         */
        TareaAsincronicaEstacion asin=new TareaAsincronicaEstacion(getActivity());
        asin.execute(null,null,null);
        TextView textoTemperatura= (TextView) v.findViewById(R.id.textoUV);
        TextView textoTemper= (TextView) v.findViewById(R.id.textoTemper);
        textoTemperatura.setText(asin.getMensaje()+" UV");
        textoTemper.setText(asin.getMensajeTemper()+"°C");

      //  mSwipeRefreshLayout.setRefreshing(false);


    }


    class TareaAsincronicaEstacion extends AsyncTask<String, Integer, Integer> {
        private Activity activity;

        private String mensaje="---";
        private String mensajeTemper="---";

        public String getMensajeTemper() {
            return mensajeTemper;
        }

        public void setMensajeTemper(String mensajeTemper) {
            this.mensajeTemper = mensajeTemper;
        }

        public String getMensaje() {
            return mensaje;
        }

        public void setMensaje(String mensaje) {
            this.mensaje = mensaje;
        }

        public TareaAsincronicaEstacion(Activity activity) {
            this.activity = activity;
        }

        @Override
        protected Integer doInBackground(String... params) {
            int progress=0;
            //Este no se ejecuta en el main Thread

            try {
                int horaActual= Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
                String temperaturaActual=leerTemepraturas("nalgas").get(horaActual).getUv();
                String temperActual=leerTemepraturas("nalgas").get(horaActual).getTemperatura();

                //Este es para invocar el getmensaje() y nos de la temperatura en el fragmento de pantallaInicial :)
                //sin embargo el ajuste del A TEMPERATURA DEBE ESTAR EN EL METODO QUE TIENE EL MAUL THREAD, AQUI NO,
                //BUSCALO ESTARA MAS ABAJO ..
                setMensaje(temperaturaActual);
                setMensajeTemper(temperActual);



                System.out.println("<<<<<<<<<<<<<<<" + temperaturaActual);
                System.out.println("SI SE RECIBIO BIEN");
            }catch(Exception e){
                System.out.println("<<ALGO MALO OCURRIO:"+e.getMessage());
                setMensaje("Sin conexión :(");
                setMensajeTemper("");
            }
            return progress;
        }

        @Override
        public void onProgressUpdate(Integer... valores){
            //Este corre en el main Thread

        }

        @Override
        protected void onPostExecute(Integer i){
            //Este correra en el main Thread
            //AQUI COMO ES EL MAIN THERAD LE INDICAMOS QUE QUEREMOS ACTUALIZAR EL VALOR DE LA TEMPERATURA


               //AQUI CHECAMOS LA ESCALA DE COLORES EN EL MAIN THREAD
               //El if que ves con el else es para que no ocurra la expcion
               if (getMensaje().equals("Sin conexión :(")) {
                   tv.setText(getMensaje());
                   tvtemper.setText(getMensajeTemper());
                   icono.setImageResource(R.drawable.blanco);
               } else {
                   float valor = Float.parseFloat(getMensaje());
                   System.out.println("<<<<<<<<<<<<<<<<<<" + valor);


                   if (valor < 3) icono.setImageResource(R.drawable.tres);
                   if (valor >= 3 && valor < 6) icono.setImageResource(R.drawable.tresseis);
                   if (valor >= 6 && valor < 8) icono.setImageResource(R.drawable.seisocho);
                   if (valor >= 8 && valor < 11) icono.setImageResource(R.drawable.ochoonce);
                   if (valor >= 11) icono.setImageResource(R.drawable.once);
                   ;
                   // if (valor >= 11) tv.setTextColor(Color.parseColor("#6C49CB"));
                   tv.setText(getMensaje() + "UV");
                   tvtemper.setText(getMensajeTemper() + "°C");
               }
               onRefreshComplete();

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


}
