package v2.sierra.campitos;

import android.app.Activity;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BlankFragmentMamiferos.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BlankFragmentMamiferos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragmentMamiferos extends Fragment implements BlankFragmentMamifero1.OnFragmentInteractionListener, BlankFragmentMamifero2.OnFragmentInteractionListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    ViewPager mViewPager;
    DemoCollectionPagerAdapter mDemoCollectionPagerAdapter;

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
     * @return A new instance of fragment BlankFragmentMamiferos.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragmentMamiferos newInstance(String param1, String param2) {
        BlankFragmentMamiferos fragment = new BlankFragmentMamiferos();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public BlankFragmentMamiferos() {
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
        //mViewPager = (ViewPager) getParentFragment().getView().findViewById(R.id.pager);



        // Inflate the layout for this fragment

        View result= inflater.inflate(R.layout.fragment_mamiferos, container, false);
        mDemoCollectionPagerAdapter = new DemoCollectionPagerAdapter(getFragmentManager());
        mViewPager=          (ViewPager)result.findViewById(R.id.pager);
        mViewPager.setAdapter(mDemoCollectionPagerAdapter);




        return  result;
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

    @Override
    public void onFragmentInteraction(Uri uri) {

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

    public static class DemoCollectionPagerAdapter extends FragmentStatePagerAdapter {

        public DemoCollectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            android.support.v4.app.Fragment fragmento[]= new Fragment[3];
            BlankFragmentMamifero1 fragment1=new BlankFragmentMamifero1();
            BlankFragmentMamifero2 fragment2=new BlankFragmentMamifero2();

            fragmento[0]=fragment1;
            fragmento[1]=fragment2;

            int seccion=i-1;
            return fragmento[i];
        }

        @Override
        public int getCount() {
            // For this contrived example, we have a 100-object collection.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "El Objetito que estas viendo es: " + (position + 1);
        }
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
