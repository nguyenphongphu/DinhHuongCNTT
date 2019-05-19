package com.example.nhan.dinhhuongcntt;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.nhan.dinhhuongcntt.Calss.Cauhoi;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    Button bt_test;
    private DatabaseReference mDatabase;
    private ArrayList<Cauhoi> arrayList =new ArrayList<Cauhoi>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        filebase(1);
        bt_test=findViewById(R.id.bt_test);
        bt_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,CauhoiActivity.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("mang",arrayList);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
    private void filebase( int id) {
        mDatabase.child("TestIQ").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.d("cau hoi", "onDataChange: "+dataSnapshot.getValue());
                for (DataSnapshot data:dataSnapshot.getChildren()){
                    arrayList.add(data.getValue(Cauhoi.class));
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
