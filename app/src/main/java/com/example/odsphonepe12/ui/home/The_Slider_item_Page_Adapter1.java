package com.example.odsphonepe12.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.odsphonepe12.R;
import com.example.odsphonepe12.R;

import java.util.List;

public class The_Slider_item_Page_Adapter1 extends PagerAdapter {
    private Context Mcontext;
    private List<The_Slider_Item_Model_Class1> the_slider_tem_odel_classList1;

    public The_Slider_item_Page_Adapter1(Context context, List<The_Slider_Item_Model_Class1> the_slider_tem_odel_classList1) {
        this.Mcontext = context;
        this.the_slider_tem_odel_classList1 = the_slider_tem_odel_classList1;
    }
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position){
        LayoutInflater inflater=(LayoutInflater) Mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View sliderLayout1=inflater.inflate(R.layout.slide_2,null);
        ImageView featured_image1=sliderLayout1.findViewById(R.id.my_featured_image1);
//        TextView caption_title=sliderLayout.findViewById(R.id.my_caption_title);
        featured_image1.setImageResource(the_slider_tem_odel_classList1.get(position).getFeatured_image1());
//        caption_title.setText(the_slider_tem_odel_classList.get(position).getThe_caption_title());
        container.addView(sliderLayout1);
        return sliderLayout1;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container,int position,@NonNull Object object){
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return the_slider_tem_odel_classList1.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }
}
