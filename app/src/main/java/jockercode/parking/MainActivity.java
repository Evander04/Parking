package jockercode.parking;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import jockercode.parking.Records.FragmentRecords;
import jockercode.parking.Resume.FragmentResume;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    final Fragment fragmentAdd= new FragmentAdd();
    final Fragment fragmentRecords= new FragmentRecords();
    final Fragment fragmentResume= new FragmentResume();
    final FragmentManager manager=getSupportFragmentManager();
    Fragment fragmentActive= fragmentAdd;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
    = (item)->{
        switch (item.getItemId()){
            case R.id.navigation_add:
                manager.beginTransaction().hide(fragmentActive).show(fragmentAdd).commit();
                fragmentActive=fragmentAdd;
                return  true;
            case R.id.navigation_records:
                manager.beginTransaction().hide(fragmentActive).show(fragmentRecords).commit();
                fragmentActive=fragmentRecords;
                return  true;
            case R.id.navigation_resume:
                manager.beginTransaction().hide(fragmentActive).show(fragmentResume).commit();
                fragmentActive=fragmentResume;
                return  true;
        }
        return false;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        setSupportActionBar(toolbar);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        manager.beginTransaction().add(R.id.main_container,fragmentResume,"resume").hide(fragmentResume).commit();
        manager.beginTransaction().add(R.id.main_container,fragmentRecords,"records").hide(fragmentRecords).commit();
        manager.beginTransaction().add(R.id.main_container,fragmentAdd,"add").commit();
    }

}
