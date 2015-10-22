package v2.sierra.campitos;


import android.content.Intent;
import android.net.Uri;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

import android.support.v4.widget.DrawerLayout;


public class MainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks,
        BlankFragmentMamiferos.OnFragmentInteractionListener,
        BlankFragmentMapa.OnFragmentInteractionListener, BlankFragmentMamifero1.OnFragmentInteractionListener,
        BlankFragmentMamifero2.OnFragmentInteractionListener,BlankFragmentReptiles1.OnFragmentInteractionListener, BlankFragmentInicio.OnFragmentInteractionListener
{

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */

   ;
    private NavigationDrawerFragment mNavigationDrawerFragment;





    /**
     * Used to store the last scre
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {


        FragmentManager manager=getSupportFragmentManager();
              manager.beginTransaction().replace(R.id.container, obtenerFragmento(position)).commit();
    }

    /*
    Seleccionamos los Fragmentos que compondran nuestro menu de tipo transient
     */

    public Fragment obtenerFragmento(int id){


        Fragment fragmentos[]=new Fragment[7];
        fragmentos[0]=new BlankFragmentInicio();
        fragmentos[1]=new BlankFragmentMamiferos();
        fragmentos[2]=new BlankFragmentReptiles();
        fragmentos[3]=new BlankFragmentAnfibios();
        fragmentos[4]=new BlankFragmentFlora();
        fragmentos[5]=new BlankFragmentClima();
        fragmentos[6]=new BlankFragmentMapa();


        return fragmentos[id];
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);

            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
if(id==R.id.fesibu){
    Intent i=new Intent(this,MainActivityFeisbu.class);
    startActivity(i);
    finish();
}


        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }






}
