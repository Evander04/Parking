package jockercode.parking.Records;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jockercode.parking.R;

public class FragmentRecords extends Fragment {
    public FragmentRecords() {
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_records,container,false);
        Log.i("jocker<>","Record fragment access");
        return view;
    }
}
