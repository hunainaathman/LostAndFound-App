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
public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder>{
    Context context;

    List<GetDataAdapter> dataAdapter;

    public RvAdapter(List<GetDataAdapter> dataAdapter, Context context){

        super();

        this.dataAdapter = dataAdapter;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_data, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        GetDataAdapter dataAdapter1 =  dataAdapter.get(position);

        holder.NameTextView.setText(dataAdapter1.getNames());

        holder.ItemTextView.setText(String.valueOf(dataAdapter1.getItem()));

        holder.DescriptionTextView.setText(dataAdapter1.getDescription());

        holder.LocationTextView.setText(dataAdapter1.getLocation());

        holder.DateTextView.setText(dataAdapter1.getDate());

    }

    @Override
    public int getItemCount() {

        return dataAdapter.size();
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
