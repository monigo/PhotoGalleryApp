package com.photoof;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DisplayActivity extends AppCompatActivity implements IFirebaseLoadDone {

    private DatabaseReference ref ;
    private ImageAdapter adapter ;
    private ViewPager viewPager ;
    private String password ;
    IFirebaseLoadDone iFirebaseLoadDone ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_display);

        ref = FirebaseDatabase.getInstance().getReference("photos");

        password = getIntent().getStringExtra("password");

        iFirebaseLoadDone =  this;
        loadImges();


        viewPager = findViewById(R.id.view_pager);
        //if(viewPager==null)System.out.println("mar ja");
         viewPager.setPageTransformer(true,new DepthPageTransformer());

    }

    private void loadImges() {
        ref.orderByChild("key").equalTo(password).addValueEventListener(new ValueEventListener() {// ref.orderByChild("key").addListenerForSingleValueEvent(new ValueEventListener()
            List<UploadImage> list = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //System.out.println("Aaya gya yha pe");
                //int cnt = 0;
                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    list.add(snapshot.getValue(UploadImage.class));//cnt++;
                }
                iFirebaseLoadDone.OnFirebaseLoadSuccess(list);
                //System.out.println(cnt);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                iFirebaseLoadDone.OnFirebaseLoadFailed(databaseError.getMessage());
            }
        });
    }

    @Override
    public void OnFirebaseLoadSuccess(List<UploadImage> imageList) {
        adapter = new ImageAdapter(this,imageList,password);
        viewPager.setAdapter(adapter);
    }

    @Override
    public void OnFirebaseLoadFailed(String message) {
        Toast.makeText(DisplayActivity.this,""+message,Toast.LENGTH_SHORT).show();
    }
}
