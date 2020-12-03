package vn.lucifer.hoctiengnhat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ramotion.foldingcell.FoldingCell;

import java.util.List;

import vn.lucifer.hoctiengnhat.R;
import vn.lucifer.hoctiengnhat.model.Gramma;

public class GrammaAdapter extends RecyclerView.Adapter<GrammaAdapter.MyViewHolder> {

    Context context;
    List<Gramma> grammaList;
    public GrammaAdapter(Context context, List<Gramma> grammaList){
        this.context = context;
        this.grammaList=grammaList;
    }

    @NonNull
    @Override
    public GrammaAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gramma, parent, false);
        return new GrammaAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final GrammaAdapter.MyViewHolder holder, int position) {
        Gramma gramma = grammaList.get(position);
        holder.tv_Gramma_name.setText(gramma.getName());
        String content = gramma.getContent();
        content = content.replace("$H$", "\n- ");
        content = content.replace("$C$", "\nGiải thích: ");
        content = content.replace("$E$", "\nVí dụ: ");
        content = content.replace("$T$", "          ");
        content = content.replace("$R$", "\n * ");
        holder.tv_Gramma_content.setText(content);
        holder.folding_cell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.folding_cell.toggle(false);
            }
        });
    }

    @Override
    public int getItemCount() {
        return grammaList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        FoldingCell folding_cell;
        TextView tv_Gramma_name,tv_Gramma_content;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            folding_cell=itemView.findViewById(R.id.folding_cell);
            tv_Gramma_name=itemView.findViewById(R.id.tv_Gramma_name);
            tv_Gramma_content=itemView.findViewById(R.id.tv_Gramma_content);
        }
    }
}
