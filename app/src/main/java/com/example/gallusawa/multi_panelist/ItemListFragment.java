package com.example.gallusawa.multi_panelist;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ItemListFragment extends Fragment  {


    private ArrayAdapter<Item> adapterItems;
    private ListView lvItems;


    public ItemListFragment() {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<Item> items = Item.getItems();

        adapterItems = new ArrayAdapter<Item>(getActivity(),
                android.R.layout.simple_list_item_activated_1, items);
    }




    private OnListItemSelectedListener listener;

    public interface OnListItemSelectedListener {
        public void onItemSelected(View item);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnListItemSelectedListener) {
            listener = (OnListItemSelectedListener) activity;
        } else {
            throw new ClassCastException(
                    activity.toString()
                            + " must implement ItemsListFragment.OnListItemSelectedListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_item_list, container,
                false);

        lvItems = (ListView) view.findViewById(R.id.lvItems);
        lvItems.setAdapter(adapterItems);
        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View item,
                                    int position, long rowId) {

          //      Item item = adapterItems.getItem(position);

                listener.onItemSelected(item);
            }
        });
        return view;
    }


    public void onItemSelected(Item item) {

        Intent i = new Intent(this, ItemDetailActivity.class);
        i.putExtra("item", item);
        startActivity(i);
             }

}




