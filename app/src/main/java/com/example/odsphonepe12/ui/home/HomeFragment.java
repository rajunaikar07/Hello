package com.example.odsphonepe12.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.example.odsphonepe12.MainActivity;
import com.example.odsphonepe12.R;
import com.example.odsphonepe12.databinding.FragmentHomeBinding;
import com.example.odsphonepe12.R;
import com.example.odsphonepe12.databinding.FragmentHomeBinding;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class HomeFragment extends Fragment {

    private List<The_Slider_Item_Model_Class> listItems;
    private ViewPager page;
    private TabLayout tabLayout;
    private ViewPager page1;
    private  TabLayout tabLayout1;
    private List<The_Slider_Item_Model_Class1> listItems1;




    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        page = root.findViewById(R.id.my_pager);
        tabLayout = root.findViewById(R.id.my_tablayout);
        page1=root.findViewById(R.id.my_pager1);
        tabLayout1=root.findViewById(R.id.my_tablayout1);

//      seeall=root.findViewById(R.id.seeAll);
//      seeall.setOnClickListener(new View.OnClickListener() {
//          @Override
//          public void onClick(View view) {
//              loadFragment(new RechargeFragment());
//          }
//      });

        root.findViewById(R.id.seeAll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Fragment fragment = new RechargeFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.containerid,fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

/*
                MainActivity.fragmentManager.beginTransaction().replace(R.id.containerid,new RechargeFragment(),null).addToBackStack(null).commit();
*/

            }
        });
        listItems = new ArrayList<>();

        listItems.add(new The_Slider_Item_Model_Class(R.drawable.img_22));
        listItems.add(new The_Slider_Item_Model_Class(R.drawable.img_23));
        listItems.add(new The_Slider_Item_Model_Class(R.drawable.img_26));
        listItems.add(new The_Slider_Item_Model_Class(R.drawable.img_27));
        listItems.add(new The_Slider_Item_Model_Class(R.drawable.img_22));
        listItems.add(new The_Slider_Item_Model_Class(R.drawable.img_26));
        listItems.add(new The_Slider_Item_Model_Class(R.drawable.img_24));
        listItems.add(new The_Slider_Item_Model_Class(R.drawable.img_28));

        The_Slider_item_Page_Adapter itempager_adapter = new The_Slider_item_Page_Adapter(getContext(), listItems);
        page.setAdapter(itempager_adapter);

        java.util.Timer timer = new java.util.Timer();
        timer.scheduleAtFixedRate(new The_slider_timer(), 800, 1800);
        tabLayout.setupWithViewPager(page, true);



        listItems1 = new ArrayList<>();

        listItems1.add(new The_Slider_Item_Model_Class1(R.drawable.img_23));
        listItems1.add(new The_Slider_Item_Model_Class1(R.drawable.img_28));
        listItems1.add(new The_Slider_Item_Model_Class1(R.drawable.img_27));
        listItems1.add(new The_Slider_Item_Model_Class1(R.drawable.img_26));
        listItems1.add(new The_Slider_Item_Model_Class1(R.drawable.img_23));
        listItems1.add(new The_Slider_Item_Model_Class1(R.drawable.img_22));

        The_Slider_item_Page_Adapter1 itempager_adapter1 = new The_Slider_item_Page_Adapter1(getContext(), listItems1);
        page1.setAdapter(itempager_adapter1);

        java.util.Timer timer1 = new java.util.Timer();
        timer1.scheduleAtFixedRate(new The_slider_timer1(), 800, 1800);
        tabLayout1.setupWithViewPager(page1, true);


        return root;
    }
    private void loadFragment(RechargeFragment rechargeFragment) {
//        FragmentManager fm=getFragmentManager();
//        FragmentTransaction veriabelname=fm.beginTransaction();
//        veriabelname.replace(R.id.container,rechargeFragment);
//        veriabelname.commit();
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container,rechargeFragment );

        // transaction.addToBackStack(null);
        transaction.commit();


    }

    public class The_slider_timer extends TimerTask {

        @Override
        public void run() {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (page.getCurrentItem() < listItems.size() - 1) {
                        page.setCurrentItem(page.getCurrentItem() + 1);
                    } else
                        page.setCurrentItem(0);

                }
            });
        }
    }
    public class The_slider_timer1 extends TimerTask {

        @Override
        public void run() {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (page1.getCurrentItem() < listItems1.size() - 1) {
                        page1.setCurrentItem(page1.getCurrentItem() + 1);
                    } else
                        page1.setCurrentItem(0);

                }
            });
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}