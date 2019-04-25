package pl.rydzinski.lab5_fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


public class PizzaDetailsP2Fragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_pizza_details_p2, container, false);
        ImageView imageView = layout.findViewById(R.id.photo);
        imageView.setOnClickListener(this);
        return layout;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.photo) {
            Toast.makeText(getActivity(),
                    "Order Accepted!", Toast.LENGTH_LONG).show();
        }
    }
}
