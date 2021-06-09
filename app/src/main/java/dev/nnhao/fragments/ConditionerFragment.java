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

public class ConditionerFragment extends Fragment {

    private RecyclerView productsRecView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_conditioner, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        productsRecView = getView().findViewById(R.id.productsRecViewConditioner);
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Reuzel\nThree-in-One", "196,000₫", R.drawable.shampoo_4));
        products.add(new Product("Davines\nRenewing Conditioner", "462,000₫", R.drawable.conditioner_2));

        ProductsRecViewAdapter adapter = new ProductsRecViewAdapter(getContext());
        adapter.setProducts(products);

        productsRecView.setAdapter(adapter);
        productsRecView.setLayoutManager(new GridLayoutManager(getContext(), 2));
    }
}