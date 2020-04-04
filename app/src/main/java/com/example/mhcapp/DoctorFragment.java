package com.example.mhcapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class DoctorFragment extends Fragment {

    SearchView mySearchView;
    ListView myListView;
    ArrayAdapter<Spanned> adapter;
    ArrayList<Spanned> list;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        myListView = getView().findViewById(R.id.myList);
        mySearchView = getView().findViewById(R.id.searchView);

        //for changing text color of search view
        int id = mySearchView.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
        TextView textView = mySearchView.findViewById(id);
        textView.setTextColor(Color.BLACK);
        textView.setHintTextColor(Color.parseColor("#b5b5b5"));

        myListView.setDivider(null);
        list = new ArrayList<>();

        list.add(Html.fromHtml("<b><font color=\"black\">" + " Jatin Acharya" + "</b></font>" + "<br>- Mumbai(Chembur)"));
        list.add(Html.fromHtml("<b><font color=\"black\">" + " Swapnil Gore" + "</b></font>" + "<br>- Navi Mumbai(Chembur)"));
        list.add(Html.fromHtml("<b><font color=\"black\">" + " Vedant Sawant" + "</b></font>" + "<br>- Mumbai(Chembur)"));
        list.add(Html.fromHtml("<b><font color=\"black\">" + " Asish Sharma" + "</b></font>" + "<br>- Delhi"));
        list.add(Html.fromHtml("<b><font color=\"black\">" + " Neha Vasant" + "</b></font>" + "<br>- Kashmir"));
        list.add(Html.fromHtml("<b><font color=\"black\">" + " Abhijeet Jadhav" + "</b></font>" + "<br>- Bihar"));
        list.add(Html.fromHtml("<b><font color=\"black\">" + " Nikhil Shinde" + "</b>color=\"black\"" + "<br>- Pune"));
        list.add(Html.fromHtml("<b><font color=\"black\">" + " Aakash Vaidya" + "</b></font>" + "<br>- Navi Mumbai(Chembur)"));
        list.add(Html.fromHtml("<b><font color=\"black\">" + " Nishant Bangar" + "</b></font>" + "<br>- Satara"));
        list.add(Html.fromHtml("<b><font color=\"black\">" + " Omkar Bhilare" + "</b></font>" + "<br>- Delhi"));
        list.add(Html.fromHtml("<b><font color=\"black\">" + " Amanshu Tiwari" + "</b></font>" + "<br>- Uttar Pradesh"));
        list.add(Html.fromHtml("<b><font color=\"black\">" + " Saheel Patil" + "</b></font>" + "<br>- Bengalaru"));

        adapter  = new ArrayAdapter(view.getContext(), R.layout.listview_1, list);
        myListView.setAdapter(adapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String temp = parent.getItemAtPosition(position).toString().substring(3,7).trim();

                if(temp.equals("ant")){
                    Intent intent = new Intent(getActivity(), doc_1.class);
                    startActivity(intent);
                }else if(temp.equals("7400")){
                    //Intent intent = new Intent(getActivity(), NandGate.class);
                    //startActivity(intent);
                }else if(temp.equals("7402")){
                    //Intent intent = new Intent(getActivity(), NorGate.class);
                    //startActivity(intent);
                }else if(temp.equals("7404")){
                    //Intent intent = new Intent(getActivity(), NotGate.class);
                    //startActivity(intent);
                }else if(temp.equals("7408")){
                    //Intent intent = new Intent(getActivity(), AndGate2.class);
                    //startActivity(intent);
                }else if(temp.equals("7432")){
                    //Intent intent = new Intent(getActivity(), OrGate.class);
                    //startActivity(intent);
                }else if(temp.equals("7486")){
                    //Intent intent = new Intent(getActivity(), XorGate.class);
                    //startActivity(intent);
                }
            }
        });
        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                // listening upon completion
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //continuous listening
                adapter.getFilter().filter(newText);
                return false;
            }
        });
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.doctor_fragment,container,false);


    }
}
