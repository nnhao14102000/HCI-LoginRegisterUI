package dev.nnhao.dto;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import dev.nnhao.loginregisterui.R;

public class ProductsRecViewAdapter extends RecyclerView.Adapter<ProductsRecViewAdapter.ViewHolder> {

    private ArrayList<Product> products = new ArrayList<>();

    private Context context;

    public ProductsRecViewAdapter(Context context){
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtName.setText(products.get(position).getName());
        holder.txtCost.setText(products.get(position).getCost());
        holder.image.setImageResource(products.get(position).getImageId());

//        holder.parent.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, products.get(position).getName() + " Selected", Toast.LENGTH_SHORT).show();
//            }
//        });
//        holder.image.setImageResource();
//        Glide.with(context)
//                .asBitmap()
//                .load(products.get(position).getImageUrl())
//                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtName, txtCost;
        private CardView parent;
        private ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            parent = itemView.findViewById(R.id.parent);
            txtCost = itemView.findViewById(R.id.txtCost);
            image = itemView.findViewById(R.id.image);
        }
    }
}
