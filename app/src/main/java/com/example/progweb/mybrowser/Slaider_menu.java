package com.example.progweb.mybrowser;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;



import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.content.pm.ActivityInfo;

public class Slaider_menu extends AppCompatActivity {
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private String[] mCatTitles;
    private ListView mDrawerListView;
    private ListView myListView;
    private DrawerLayout mDrawer;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solad);

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBar actionBar = getSupportActionBar();
        initToolbar();


       /* Intent intentId = getIntent();
        String  categoryId = intentId.getStringExtra("journal_number");*/

     /*   Toast toast = Toast.makeText(getApplicationContext(),
                categoryId, Toast.LENGTH_SHORT);
        toast.show();
*/
      /*  PlaceholderFragment fragment2 = new PlaceholderFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putInt("ter", 11);
        fragment2.setArguments(bundle2);*/




        //Integer journal_number = Integer.valueOf(categoryId);

        /*if (categoryId == "79"){
            Intent intent = new Intent(Slaider_menu.this,Start.class);
            startActivity(intent);
        }else{}
        */


        class DrawerItemClickListener implements ListView.OnItemClickListener {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                        Intent intent = new Intent (Slaider_menu.this, ListDownload.class);
                        String categoryId = "0";
                        intent.putExtra("categoryId", categoryId);
                        startActivity(intent);
                        //startActivity(new Intent(SlaidMobile.this, SlaidMobile.class));
                        break;
                }

            }
        }

        mCatTitles = getResources().getStringArray(R.array.list_array_archive);
        mDrawerListView = (ListView) findViewById(R.id.left_drawer);
        myListView = (ListView) findViewById(R.id.left_drawer);
        myListView.setPadding(10, 10, 0, 0);
        mDrawerListView.setAdapter(new ArrayAdapter<String>(this,
        R.layout.drawer_list_item2, mCatTitles));
        mDrawerListView.setOnItemClickListener(new DrawerItemClickListener());
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                return false;
            }
        });
        toolbar.inflateMenu(R.menu.menu);
        toolbar.setLogo(R.drawable.logo_top);
    }

    public void doThis(MenuItem item){
        Toast.makeText(this, "", Toast.LENGTH_LONG).show();
        mDrawer.openDrawer(mDrawerListView);
        //mDrawer.openDrawer(mDrawer);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public static class PlaceholderFragment extends Fragment {
        static Integer Num;

        private static final String ARG_SECTION_NUMBER = "section_number";
        public PlaceholderFragment() {
        }

        public static PlaceholderFragment newInstance(int sectionNumber) {

            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            Num = 79;
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

           /*Bundle bundle2 = getArguments();
            int i = bundle2.getInt("ter");*/
          //  Intent intentId = getIntent();
          //   String  categoryId = intentId.getStringExtra("journal_number");
          //   String  categoryId = Intent(getActivity().getIntent().);

            String Item = getActivity().getIntent().getExtras().getString("journal_number");

            View rootView = inflater.inflate(R.layout.content_slaid_mobile, container, false);
            Integer pageNumber = getArguments() != null ? getArguments().getInt(ARG_SECTION_NUMBER) : 1;
            WebView mWebView = (WebView) rootView.findViewById(R.id.webView);
            WebSettings settings = mWebView.getSettings();
            settings.setDefaultTextEncodingName("utf-8");
            mWebView.getSettings().setBuiltInZoomControls(true);
            mWebView.setPadding(0, 0, 0, 0);
            mWebView.getSettings().setJavaScriptEnabled(true);

            String numberString = String.valueOf(pageNumber);
            Integer journal_number = Integer.valueOf(Item);

            if (journal_number == 79) {
                mWebView.loadUrl("file:///android_asset/" + journal_number + "/demo" + numberString + ".html");
            }else{
                mWebView.loadUrl("http://season.pa.infobox.ru/journal_number/" + journal_number + "/demo" + numberString + ".html");
            }

            return rootView;
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return 109;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }
    }
}
