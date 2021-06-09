package dev.nnhao.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

public class AllProductFragment extends Fragment {

    private RecyclerView productsRecView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_product, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        productsRecView = getView().findViewById(R.id.productsRecViewAll);
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("ESSEHAIR\nEnchancer shampoo", "750.000₫", R.drawable.shampoo_1));
        products.add(new Product("Tea Tree\nSpecial Shampoo", "537,000₫", R.drawable.shampoo_2));
        products.add(new Product("Reuzel\nScrub Shampoo", "211,000₫", R.drawable.shampoo_3));
        products.add(new Product("Reuzel\nThree-in-One", "196,000₫", R.drawable.shampoo_4));
        products.add(new Product("Davines\nRenewing Conditioner", "462,000₫", R.drawable.conditioner_2));
        products.add(new Product("Vilain Gold Digger\nSpecial Edition 2020", "470,000₫", R.drawable.wax_1));
        products.add(new Product("Matte Separation\nWorkable Wax", "460,000₫", R.drawable.wax_2));
        products.add(new Product("BRITISH M\nDandy Hard Paste", "290,000₫", R.drawable.wax_3));
        products.add(new Product("Reuzel\nFiber Pomade", "271,000₫", R.drawable.wax_4));
        products.add(new Product("TIGI Bed Head\nHard Head", "478,000₫", R.drawable.hairspray_1));
        products.add(new Product("TIGI RK Groupie\nHard Hold", "249,000₫", R.drawable.hairspray_2));
        products.add(new Product("FARCOM\nSCULPT & FREEZE", "399,000₫", R.drawable.hairspray_3));
        products.add(new Product("KMS Style Color\nInked Blue", "330,000₫", R.drawable.coloring_1));
        products.add(new Product("KMS Style Color\nVintage Blush", "330,000₫", R.drawable.coloring_2));
        products.add(new Product("KMS Style Color\nIced Concrete", "330,000₫", R.drawable.coloring_3));

        ProductsRecViewAdapter adapter = new ProductsRecViewAdapter(getContext());
        adapter.setProducts(products);

        productsRecView.setAdapter(adapter);
        productsRecView.setLayoutManager(new GridLayoutManager(getContext(), 2));
    }
}