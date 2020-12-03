package vn.lucifer.hoctiengnhat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import vn.lucifer.hoctiengnhat.R;
import vn.lucifer.hoctiengnhat.model.TextHistory;

public class HistoryAdapter extends BaseAdapter {

    private Context context;
    private List<TextHistory> list;

    public HistoryAdapter(Context context, List<TextHistory> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final View convertView = LayoutInflater.from(context).inflate(R.layout.item_history, viewGroup, false);

        TextView tvTime;
        TextView tvName;

        tvTime = (TextView) convertView.findViewById(R.id.tvTime);
        tvName = (TextView) convertView.findViewById(R.id.tvName);


        TextHistory t = list.get(i);

        tvTime.setText(t.time);
        tvName.setText(t.name);

        return convertView;
    }
}
