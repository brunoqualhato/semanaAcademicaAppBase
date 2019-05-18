package ifgoiano.edu.br.ceres.adapters;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ifgoiano.edu.br.ceres.R;
import ifgoiano.edu.br.ceres.model.MPalestra;

public class LinhaDoTempoAdapter extends RecyclerView.Adapter<LinhaDoTempoAdapter.ViewHolder> {
    private Context mContext;
    private List<MPalestra> mList;
    private ItemClickListener mClickListener;


    public LinhaDoTempoAdapter(Context context, List<MPalestra> list) {
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imagem.setImageResource(mList.get(position).getFotoLocal());
        holder.nome.setText(mList.get(position).getNomePalestra());
        holder.data.setText("Data: " + mList.get(position).getDataPalestra() + "\n" + mList.get(position).getHorarioPalestra());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public MPalestra getItem(int id) {
        return mList.get(id);
    }

    public void removerPosicao(int position) {
        mList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mList.size());
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imagem;
        TextView nome, data;

        ViewHolder(View view) {
            super(view);
            imagem = view.findViewById(R.id.image);
            nome = view.findViewById(R.id.text);
            data = view.findViewById(R.id.txt_data);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }
}
