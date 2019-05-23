package th.ac.kku.plaekjangreed.anusorn.project;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private List<List_Data>listData;
    public interface  OnItemClickListener{
        void onItemClick(int position);
    }


    public MyAdapter(List<List_Data> listData) {
        this.listData = listData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_data,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final List_Data ld = listData.get(position);
        Picasso.get().load(ld.getImage()).into(holder.txtImage);
        holder.txtImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(ld.getLinkPdf()));
                context.startActivity(intent);
            }
        });
    }






    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView txtImage;
        private TextView link;
        public ViewHolder(View itemView) {
            super(itemView);
            link = (TextView) itemView.findViewById(R.id.tvlinkPdf);
            txtImage =(ImageView) itemView.findViewById(R.id.imagetxt);



        }
    }
}