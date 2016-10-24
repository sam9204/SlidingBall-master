package com.dalong.slidingball;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.dalong.francyconverflow.FancyCoverFlow;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cws on 2016/9/14.
 */

public class Fragment1 extends Fragment {

    private FancyCoverFlow mfancyCoverFlow;
    private MyFancyCoverFlowAdapter1 mMyFancyCoverFlowAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, null);
        mfancyCoverFlow = (FancyCoverFlow) view.findViewById(R.id.fancyCoverFlow);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        List<Item> mFancyCoverFlows = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Item item = new Item();
            item.setName((i + 1) + "天");
            item.setSelected(false);
            mFancyCoverFlows.add(item);
        }

        mMyFancyCoverFlowAdapter = new MyFancyCoverFlowAdapter1(getActivity(), mFancyCoverFlows);
        mfancyCoverFlow.setAdapter(mMyFancyCoverFlowAdapter);
        mMyFancyCoverFlowAdapter.notifyDataSetChanged();
        mfancyCoverFlow.setUnselectedAlpha(0.5f);//通明度
        mfancyCoverFlow.setUnselectedSaturation(0.5f);//设置选中的饱和度
        mfancyCoverFlow.setUnselectedScale(0.3f);//设置选中的规模
        mfancyCoverFlow.setSpacing(0);//设置间距
        mfancyCoverFlow.setMaxRotation(0);//设置最大旋转
        mfancyCoverFlow.setScaleDownGravity(0.5f);
        mfancyCoverFlow.setActionDistance(FancyCoverFlow.ACTION_DISTANCE_AUTO);
        int num = Integer.MAX_VALUE / 2 % mFancyCoverFlows.size();
        int selectPosition = Integer.MAX_VALUE / 2 - num;
        mfancyCoverFlow.setSelection(selectPosition);
        mfancyCoverFlow.setCallbackDuringFling(false);
        mfancyCoverFlow.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Item homeFancyCoverFlow = (Item) mfancyCoverFlow.getSelectedItem();
                if (homeFancyCoverFlow != null) {
                    Toast.makeText(getActivity(), homeFancyCoverFlow.getName(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
