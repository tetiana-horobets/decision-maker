package com.example.tetiana.randomversion2;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<String> stringList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewDynamic;


        public TextView getTextViewDynamic() {
            return textViewDynamic;
        }


        public ViewHolder(View itemView) {
            super(itemView);
            textViewDynamic = (TextView) itemView.findViewById(R.id.textViewDynamic);

        }
    }



    public RecyclerViewAdapter(List<String> strings) {
        this.stringList = strings;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_text_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.getTextViewDynamic().setText(stringList.get(position));
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }



}
