package com.example.eecs.wear;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.wearable.view.BoxInsetLayout;
import android.support.wearable.view.CardFragment;
import android.support.wearable.view.DotsPageIndicator;
import android.support.wearable.view.FragmentGridPagerAdapter;
import android.support.wearable.view.GridPagerAdapter;
import android.support.wearable.view.GridViewPager;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.Wearable;

public class Main2Activity extends Activity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    GridView gv;
    Context context;
    ArrayList prgmName;
    private GoogleApiClient mApiClient;
    private String TAG = "PeaceMeal";
    private String pos = "empty";
    private List<Node> nodes = new ArrayList<>();


    public static String [] nameList={"Meal 1","Meal 2","Meal 3"};
    public static int [] imageList={R.drawable.meal1,R.drawable.meal2, R.drawable.meal3};

    public void onButtonClicked(int column){
        Toast.makeText(getApplicationContext(), "View position " + column+ " on Phone", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onButtonClicked");
        pos = String.valueOf(column);

        mApiClient = new GoogleApiClient.Builder( this )
                .addApi( Wearable.API )
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();

        mApiClient.disconnect(); mApiClient.connect();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final DotsPageIndicator mPageIndicator;
        final GridViewPager mViewPager;

        // Get UI references
        mPageIndicator = (DotsPageIndicator) findViewById(R.id.page_indicator);
        mViewPager = (GridViewPager) findViewById(R.id.pager);

        // Assigns an adapter to provide the content for this pager
        mViewPager.setAdapter(new myAdapter(this));
        mPageIndicator.setPager(mViewPager);


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mApiClient.disconnect();
    }

    @Override
    public void onConnected(Bundle bundle) {
        Log.d(TAG, "onConnected called");

        Wearable.NodeApi.getConnectedNodes(mApiClient).setResultCallback(new ResultCallback<NodeApi.GetConnectedNodesResult>() {
            @Override
            public void onResult(NodeApi.GetConnectedNodesResult getConnectedNodesResult) {
                nodes = getConnectedNodesResult.getNodes();

                sendMessage("/POSITION", pos);
                Log.d(TAG, "Sent Message: " + pos);
            }
        });


    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    private void sendMessage( final String path, final String text ) {
        Log.d(TAG, "Watch to Phone sendMessage called");

        for(Node node: nodes)
        {
            PendingResult result = Wearable.MessageApi.sendMessage(mApiClient,
                    node.getId(), path, text.getBytes());

            Log.d(TAG, " Sent message. Result: " + result.toString());
        }
    }

    public class myAdapter extends GridPagerAdapter {

        private final Context mContext;

        public myAdapter(Context ctx) {
            mContext = ctx;
        }

        @Override
        public Object instantiateItem(ViewGroup viewGroup, int row, int column){
            View view;
            view = LayoutInflater.from(mContext).inflate(R.layout.my_custom_card, null);

            TextView name = (TextView) view.findViewById(R.id.name);
            BoxInsetLayout box = (BoxInsetLayout) view.findViewById(R.id.box);

            name.setText(nameList[column]);
            box.setBackgroundResource(imageList[column]);
            final int position = column;
            box.setOnClickListener(new BoxInsetLayout.OnClickListener() {
                public void onClick(View view) {
                    onButtonClicked(position);
                }
            });
            viewGroup.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup viewGroup, int row, int column, Object object) {
            viewGroup.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object){
            return view.equals(object);
        }

        @Override
        public int getRowCount() {
            return 1;
        }

        @Override
        public int getColumnCount(int row) {
            return 2;
        }
    }
}
