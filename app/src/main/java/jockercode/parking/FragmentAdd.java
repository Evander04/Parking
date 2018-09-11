package jockercode.parking;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.solver.widgets.Helper;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.sql.SQLData;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jockercode.parking.Pojo.Record;
import jockercode.parking.SQLite.HelperDB;
import nl.qbusict.cupboard.CupboardFactory;

public class FragmentAdd  extends Fragment{
    @BindView(R.id.textDescription)
    EditText description;
    @BindView(R.id.textLicensePlate)
    EditText textLicensePlate;
    @BindView(R.id.textCount)
    EditText textCount;
    @BindView(R.id.textType)
    Spinner textType;

    SQLiteDatabase db;

    public FragmentAdd() {
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_add,container,false);
        ButterKnife.bind(this,view);
        HelperDB helper= new HelperDB(view.getContext());
        db=helper.getWritableDatabase();
        return view;
    }
    @OnClick(R.id.btnAdd)
    public void saveRecord(){
        if (validateRecord()){
            Record record= new Record();
            record.setDescription(description.getText().toString());
            record.setLicensePlate(textLicensePlate.getText().toString());
            record.setCount(Integer.parseInt(textCount.getText().toString()));
            record.setType(textType.getSelectedItemPosition());
            record.setDateEntry(new Date());
            record.setStatus(0);
            Long id= CupboardFactory.cupboard().withDatabase(db).put(record);
            record.set_id(id);
            Log.i("print<>","save record=> "+record.toString());
            clean();
            Toast.makeText(getContext(),"Guardado correctamente",Toast.LENGTH_LONG).show();
        }
    }
    private void clean(){
        description.setText("");
        textLicensePlate.setText("");
        textCount.setText("");
        textType.setSelection(0);
    }
    private boolean validateRecord(){
        if (textLicensePlate.getText().toString().equals(""))
            return false;
        if (description.getText().toString().equals(""))
            return false;
        if (textType.getSelectedItemPosition()==0)
            return false;
        return true;
    }
}
