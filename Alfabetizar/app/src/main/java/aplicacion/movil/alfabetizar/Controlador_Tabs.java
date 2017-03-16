package aplicacion.movil.alfabetizar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Controlador_Tabs extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    int prueba;
    Controlador_Sonidos sound;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controlador__tabs);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the two
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        //Boton(flecha) de retorno
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (item.getItemId())
        {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        private ArrayAdapter<String> letrasAdapter;

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.contenedor_tabs, container, false);

            // Get a reference to the ListView, and attach this adapter to it.
            ListView listView = (ListView) rootView.findViewById(R.id.section_letters);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent newIntent = new Intent(getContext(), Controlador_Simbolo.class);

                    String selected = ((TextView) view.findViewById(R.id.lista_letras_textview)).getText().toString();

                    newIntent.putExtra("Letra", selected);
                    startActivity(newIntent);
                }
            });

            /*
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            */
            if(getArguments().getInt(ARG_SECTION_NUMBER) == 1){

                String[] vocales = {"A","E","I","O","U"};
                Integer[] imagenesVocales = {
                        R.drawable.abeja_imagen,
                        R.drawable.elefante_imagen,
                        R.drawable.iglesia_imagen,
                        R.drawable.oso_imagen,
                        R.drawable.uva_imagen
                };
                ListView listview;

           //     final List<String> listaVocales = new ArrayList<String>(Arrays.asList(vocales));

                Controlador_ListaImagenes adapter = new Controlador_ListaImagenes(getActivity(), vocales, imagenesVocales);
                listview = (ListView) rootView.findViewById(R.id.section_letters);
                listview.setAdapter(adapter);





         //       final List<String> listaVocales = new ArrayList<String>(Arrays.asList(vocales));

          /*      letrasAdapter =
                        new ArrayAdapter<String>(
                                getActivity(), // The current context (this activity)
                                R.layout.lista_letras_menu, // The name of the layout ID.
                                R.id.lista_letras_textview, // The ID of the textview to populate.
                                listaVocales); */

                //rootView = inflater.inflate(R.layout.contenedor_tabs, container, false);

                // Get a reference to the ListView, and attach this adapter to it.
                //ListView listView = (ListView) rootView.findViewById(R.id.section_letters);


            //    listView.setAdapter(letrasAdapter);

            }

            if(getArguments().getInt(ARG_SECTION_NUMBER) == 2){

                String[] consonantes = {
                        "B",
                        "C",
                        "D",
                        "F",
                        "G",
                        "J",
                        "K",
                        "L",
                        "LL",
                        "M",
                        "N",
                        "Ñ",
                        "P",
                        "Q",
                        "R",
                        "S",
                        "T",
                        "V",
                        "W",
                        "X",
                        "Y",
                        "Z"};

                Integer[] imagenesConsonantes = {
                        R.drawable.banano_imagen,
                        R.drawable.caballo_imagen,
                        R.drawable.dedo_imagen,
                        R.drawable.foca_imagen,
                        R.drawable.gota_imagen,
                        R.drawable.jirafa_imagen,
                        R.drawable.kiwi_imagen,
                        R.drawable.limon_imagen,
                        R.drawable.llave_imagen,
                        R.drawable.mono_imagen,
                        R.drawable.naranja_imagen,
                        R.drawable.una_imagen,
                        R.drawable.pajaron_imagen,
                        R.drawable.queque_imagen,
                        R.drawable.rosa_imagen,
                        R.drawable.sol_imagen,
                        R.drawable.tortuga_imagen,
                        R.drawable.vaca_imagen,
                        R.drawable.sandwich_imagen,
                        R.drawable.xilofono_imagen,
                        R.drawable.yogurt_imagen,
                        R.drawable.zanahoria_imagen
                };
                ListView listview;

                //     final List<String> listaVocales = new ArrayList<String>(Arrays.asList(vocales));

                Controlador_ListaImagenes adapter = new Controlador_ListaImagenes(getActivity(), consonantes, imagenesConsonantes);
                listview = (ListView) rootView.findViewById(R.id.section_letters);
                listview.setAdapter(adapter);


             //   List<String> listaConsonantes = new ArrayList<String>(Arrays.asList(consonantes));

            /*    letrasAdapter =
                        new ArrayAdapter<String>(
                                getActivity(), // The current context (this activity)
                                R.layout.lista_letras_menu, // The name of the layout ID.
                                R.id.lista_letras_textview, // The ID of the textview to populate.
                                listaConsonantes); */

                //rootView = inflater.inflate(R.layout.contenedor_tabs, container, false);

                // Get a reference to the ListView, and attach this adapter to it.
                //ListView listView = (ListView) rootView.findViewById(R.id.section_letters);


               /* listView.setAdapter(letrasAdapter); */

            }
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Crea dos pestañas.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            // Establece el titulo de las pestañas
            switch (position) {
                case 0:
                    return "VOCALES";
                case 1:
                    return "CONSONANTES";
            }

            return null;
        }
    }
}
