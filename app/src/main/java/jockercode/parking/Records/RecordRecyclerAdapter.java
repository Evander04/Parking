package jockercode.parking.Records;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jockercode.parking.Pojo.Record;
import jockercode.parking.R;

public class RecordRecyclerAdapter extends RecyclerView.Adapter<RecordRecyclerAdapter.ViewHolder>{

    public List<Record> records;

    public RecordRecyclerAdapter(List<Record> records) {
        this.records = records;
    }

    @NonNull
    @Override
    public RecordRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view_record, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecordRecyclerAdapter.ViewHolder viewHolder, int i) {
        Record r=records.get(i);
        viewHolder.pos=i;
        viewHolder.description.setText(r.getDescription());
        viewHolder.licensePlate.setText(r.getLicensePlate());
        viewHolder.date.setText(r.getDateEntry().toString());
        viewHolder.image.setImageResource(r.getType()==1?R.drawable.ic_directions_bike_black_24dp
                :r.getType()==2?R.drawable.ic_directions_car_black_24dp:
                r.getType()==3?R.drawable.ic_airport_shuttle_black_24dp:
                R.drawable.ic_local_shipping_black_24dp);
    }

    @Override
    public int getItemCount() {
        return records.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private View mView;
        private int pos;
        @BindView(R.id.cardDesc)
        TextView description;
        @BindView(R.id.cardLicense)
        TextView licensePlate;
        @BindView(R.id.cardDate)
        TextView date;
        @BindView(R.id.cardImage)
        ImageView image;
        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            ButterKnife.bind(this,mView);
        }
    }
}
