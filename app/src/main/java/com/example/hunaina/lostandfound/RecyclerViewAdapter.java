package com.example.hunaina.lostandfound;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
/**
 * Created by Hunaina on 8/19/2017.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    Context context;

    List<GetDataAdapter> getDataAdapter;

    public RecyclerViewAdapter(List<GetDataAdapter> getDataAdapter, Context context){

        super();

        this.getDataAdapter = getDataAdapter;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_items, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        GetDataAdapter getDataAdapter1 =  getDataAdapter.get(position);

        holder.NameTextView.setText(getDataAdapter1.getNames());

        holder.ItemTextView.setText(String.valueOf(getDataAdapter1.getItem()));

        holder.DescriptionTextView.setText(getDataAdapter1.getDescription());

        holder.LocationTextView.setText(getDataAdapter1.getLocation());

        holder.DateTextView.setText(getDataAdapter1.getDate());

    }

    @Override
    public int getItemCount() {

        return getDataAdapter.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView NameTextView;
        public TextView ItemTextView;
        public TextView DescriptionTextView;
        public TextView LocationTextView;
        public TextView DateTextView;

        public ViewHolder(View itemView) {

            super(itemView);
            NameTextView = (TextView) itemView.findViewById(R.id.textView1) ;
            ItemTextView = (TextView) itemView.findViewById(R.id.textView2) ;
            DescriptionTextView = (TextView) itemView.findViewById(R.id.textView3) ;
            LocationTextView = (TextView) itemView.findViewById(R.id.textView4) ;
            DateTextView = (TextView) itemView.findViewById(R.id.textView5) ;
        }
    }
}
