package com.photoof;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageAdapter extends PagerAdapter {


    private Context mContext;
    private List<UploadImage> imageList ;
    private LayoutInflater inflater ;
    private String password;

    public ImageAdapter(Context mContext, List<UploadImage> imageList , String password) {
        this.mContext = mContext;
        this.imageList = imageList;
        this.inflater = LayoutInflater.from(mContext);
        this.password = password ;
    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, int position) {
        View view = inflater.inflate(R.layout.view_pager_item,container,false);
        ImageView person_image = view.findViewById(R.id.person_image);
        TextView image_name = view.findViewById(R.id.image_title);
        //TextView image_description = view.findViewById(R.id.image_description);

        if(password.equals(imageList.get(position).getKey())){
            Picasso.get().load(imageList.get(position).getmImageUrl()).into(person_image);
        }

        //image_name.setText("Beautiful");
        //image_description.setText("dffsdf\ndfdsfsdf\ndfsdfdsf\ndfsfsf\nsfdsfsf");

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(mContext,"Is Clicked",Toast.LENGTH_SHORT).show();
            }
        });
        container.addView(view);
        return  view;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        (container).removeView((View) object);
    }
}
