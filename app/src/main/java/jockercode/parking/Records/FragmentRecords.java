package jockercode.parking.Records;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jockercode.parking.Pojo.Record;
import jockercode.parking.R;
import jockercode.parking.SQLite.HelperDB;
import nl.qbusict.cupboard.CupboardFactory;

public class FragmentRecords extends Fragment {
    @BindView(R.id.recyclerRecords)
    RecyclerView mRecycler;
    public FragmentRecords() {
    }

    private List<Record> records= new ArrayList<>();
    SQLiteDatabase db;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_records, container, false);
        ButterKnife.bind(this, view);

        HelperDB helper = new HelperDB(view.getContext());
        db = helper.getWritableDatabase();

        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        records = CupboardFactory.cupboard().withDatabase(db).query(Record.class).withSelection("status=?",String.valueOf(0)).list();
        Log.i("print<>",records.toString());
        RecordRecyclerAdapter mAdapter=new RecordRecyclerAdapter(records);
        mRecycler.setAdapter(mAdapter);
        mRecycler.setItemAnimator(new DefaultItemAnimator());

        return view;
    }
}
