package com.example.gallusawa.multi_panelist;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ItemDetailsFragment extends Fragment {

    private Item item;

    public ItemDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        item = (Item) getArguments().getSerializable("item");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_item_details, container, false);

        TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        TextView tvBody = (TextView) view.findViewById(R.id.tvBody);
        tvTitle.setText(item.getTitle());
        tvBody.setText(item.getBody());

        return view;
    }


    // ItemDetailFragment.newInstance(item)
    public static ItemDetailsFragment newInstance(Item item) {
        ItemDetailsFragment fragmentDemo = new ItemDetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable("item", item);
        fragmentDemo.setArguments(args);
        return fragmentDemo;
    }
}