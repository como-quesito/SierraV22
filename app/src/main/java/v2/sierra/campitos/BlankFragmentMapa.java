package v2.sierra.campitos;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;




/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BlankFragmentMapa.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BlankFragmentMapa#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragmentMapa extends Fragment {
    private static View view;

    static final LatLng PARQUE_SIERRA = new LatLng(19.611085, -99.089320);
    static final LatLng PARQUE_SIERRA2 = new LatLng(19.617190, -99.105070);
    private GoogleMap map;
    private SupportMapFragment mSupportMapFragment;
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
     * @return A new instance of fragment BlankFragmentMapa.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragmentMapa newInstance(String param1, String param2) {
        BlankFragmentMapa fragment = new BlankFragmentMapa();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public BlankFragmentMapa() {
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

        if (view != null) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null)
                parent.removeView(view);
        }
        try {
            view = inflater.inflate(R.layout.fragment_mapa, container, false);
            /* aqui el problema de invocar un fragment dentro de otros es que al salir duplcia el id, el cual queda resuelto con la parte del if de arria
             * ahora para llamar al objeto map, que es el Fragment hijo devemos usan getChildFragmentManager(9 , no getFragmentManager() */
            map = ((SupportMapFragment) getChildFragmentManager()
                    .findFragmentById(R.id.map)).getMap();
            if (map!=null){
                CameraUpdate center=
                        CameraUpdateFactory.newLatLng(PARQUE_SIERRA);
                CameraUpdate zoom= CameraUpdateFactory.zoomTo(13);

                map.moveCamera(center);
                map.animateCamera(zoom);

                Marker hamburg = map.addMarker(new MarkerOptions().position(PARQUE_SIERRA)
                        .title("Acceso principal")
                        .snippet("Acceso por Coacalco"));
                Marker kiel = map.addMarker(new MarkerOptions()
                        .position(PARQUE_SIERRA2)
                        .title("Acceso No.2")
                        .snippet("Este acceso es por Tultitlán")
                        .alpha(0.8f)

                        .icon(BitmapDescriptorFactory
                                .fromResource(R.drawable.localizacion)));
            }


        } catch (InflateException e) {
        /* map is already there, just return view as it is */
        }



return view;
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


    public void oyView() {
        super.onDestroyView();
        Fragment fragment = (getFragmentManager().findFragmentById(R.id.map));
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.remove(fragment);
        ft.commit();
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



    private void initilizeMap()
    {
        mSupportMapFragment = (SupportMapFragment) getFragmentManager().findFragmentById(R.id.map);
        if (mSupportMapFragment == null) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            mSupportMapFragment = SupportMapFragment.newInstance();
            fragmentTransaction.replace(R.id.map, mSupportMapFragment).commit();
        }
        if (mSupportMapFragment != null)
        {
            map = mSupportMapFragment.getMap();
            if (map != null)
                map.setOnMapClickListener(new GoogleMap.OnMapClickListener()
                {
                    @Override
                    public void onMapClick(LatLng point)
                    {
                        //TODO: your onclick stuffs
                    }
                });
        }
    }

}
