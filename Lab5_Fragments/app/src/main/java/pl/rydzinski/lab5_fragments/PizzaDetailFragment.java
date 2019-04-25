package pl.rydzinski.lab5_fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.FragmentTransaction;

import pl.rydzinski.lab5_fragments.DAO.Pizza;

public class PizzaDetailFragment extends Fragment {
    private long pizzaId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            pizzaId = savedInstanceState.getLong("pizzaId");
        }

        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        PizzaDetailsP2Fragment pizzaDetailsP2Fragment = new PizzaDetailsP2Fragment();
        ft.replace(R.id.pizzaDetails2_container, pizzaDetailsP2Fragment);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();

        return inflater.inflate(R.layout.fragment_pizza_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            Pizza pizza = Pizza.pizzas[(int) pizzaId];

            TextView title = view.findViewById(R.id.textTitle);
            title.setText(pizza.getName());

            TextView description = view.findViewById(R.id.textDescription);
            description.setText(pizza.getDescription());

            ImageView imageView = view.findViewById(R.id.photo);
            imageView.setImageResource(pizza.getImageResourceId());

            TextView price = view.findViewById(R.id.price);
            price.setText("$"+pizza.getPrice());
        }


    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putLong("pizzaId", pizzaId);
    }

    public void setPizzaId(long id) {
        this.pizzaId = id;
    }
}
