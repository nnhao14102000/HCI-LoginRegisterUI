package dev.nnhao.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import dev.nnhao.dto.Product;
import dev.nnhao.dto.ProductsRecViewAdapter;
import dev.nnhao.loginregisterui.R;

public class WaxFragment extends Fragment {

    private RecyclerView productsRecView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wax, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        productsRecView = getView().findViewById(R.id.productsRecViewWax);
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Vilain Gold Digger\nSpecial Edition 2020", "470,000₫", R.drawable.wax_1));
        products.add(new Product("Matte Separation\nWorkable Wax", "460,000₫", R.drawable.wax_2));
        products.add(new Product("BRITISH M\nDandy Hard Paste", "290,000₫", R.drawable.wax_3));
        products.add(new Product("Reuzel\nFiber Pomade", "271,000₫", R.drawable.wax_4));
        ProductsRecViewAdapter adapter = new ProductsRecViewAdapter(getContext());
        adapter.setProducts(products);

        productsRecView.setAdapter(adapter);
        productsRecView.setLayoutManager(new GridLayoutManager(getContext(), 2));
    }
}