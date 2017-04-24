package com.example.tetiana.randomversion2;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

class OptionsListAdapter extends RecyclerView.Adapter<OptionsListAdapter.ViewHolder> {

    private AppCompatActivity activity;
    private List<List<String>> options;

    OptionsListAdapter(AppCompatActivity activity, List<List<String>> options) {
        this.activity = activity;
        this.options = options;
    }

    void onDeleteElement(int position){
        options.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        return new ViewHolder(activity, view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.getContent().clear();
        holder.getContent().addAll(options.get(position));
        holder.getAdapter().notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return options.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private final List<String> content;
        private final ArrayAdapter<String> adapter;

        ViewHolder(AppCompatActivity activity, View itemView) {
            super(itemView);

            ListView childListView = (ListView) itemView.findViewById(R.id.childListView);

            content = new ArrayList<>();
            adapter = new ArrayAdapter<>(activity, R.layout.list_item, R.id.optionText, content);
            childListView.setAdapter(adapter);
        }

        List<String> getContent() {
            return content;
        }

        ArrayAdapter<String> getAdapter() {
            return adapter;
        }
    }
}
