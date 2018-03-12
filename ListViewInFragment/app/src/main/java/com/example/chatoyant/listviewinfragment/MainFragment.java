package com.example.chatoyant.listviewinfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by chatoyant on 18-3-11.
 */

public class MainFragment extends Fragment {

    ListView listView;
    ImageView album;
    ImageView avatar;
    MainAdapter mainAdapter;


    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        listView = (ListView) view.findViewById(R.id.list_view);

        // Construct and add Header
        View header = inflater.inflate(R.layout.listview_header, container, false);
        album = (ImageView) header.findViewById(R.id.list_header_album);
        avatar = (ImageView) header.findViewById(R.id.list_header_avatar);
        album.setImageResource(R.drawable.album);
        avatar.setImageResource(R.drawable.avatar);
        listView.addHeaderView(header);

        // Construct and set Adapter
        List<String> items = new ArrayList<>();
        for(int i = 1; i < 20; i++) items.add(new String(new char[i]).replace("\0", "朵"));
        mainAdapter = new MainAdapter(getContext(), android.R.layout.simple_list_item_1, items);
        listView.setAdapter(mainAdapter);
        return view;
    }

    public MainFragment newInstance() {
        return new MainFragment();
    }
}
