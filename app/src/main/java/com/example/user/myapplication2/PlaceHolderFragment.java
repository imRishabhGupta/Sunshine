package com.example.user.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceHolderFragment extends Fragment {
private TextView tv;
    public PlaceHolderFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.fragment_detail, container, false);
        Intent intent=getActivity().getIntent();
        String forecast=intent.getStringExtra(Intent.EXTRA_TEXT);
        tv=(TextView)rootView.findViewById(R.id.fragtv);
        tv.setText(forecast);
        return  rootView;

    }

    @Override
    public void onCreateOptionsMenu(Menu menu,MenuInflater inflater) {
        inflater.inflate(R.menu.detail_fragment_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.action_share){
            Intent share=new Intent(Intent.ACTION_SEND);
            share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
            share.setType("text/plain");
            String toShare=tv.getText().toString()+" #MySunshineApp";
            share.putExtra(Intent.EXTRA_TEXT,toShare);
            startActivity(Intent.createChooser(share,"Share via"));
        }
        return super.onOptionsItemSelected(item);
    }
}
