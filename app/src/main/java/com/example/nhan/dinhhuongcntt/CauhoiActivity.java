package com.example.nhan.dinhhuongcntt;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nhan.dinhhuongcntt.Adapter.Customdanhsach;
import com.example.nhan.dinhhuongcntt.Calss.Cauhoi;
import com.example.nhan.dinhhuongcntt.Calss.Danhsach;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;



import java.util.ArrayList;


public class CauhoiActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private NavigationView mNavigationView;
    private DrawerLayout mdrawerLayout;
    private ImageButton menu_ds,bt_next,bt_previous;
    private ListView mListView;
    private RadioGroup radioGroup;
    private RadioButton KQ_A,KQ_B,KQ_C,KQ_D;
    private TextView tvcau,tvcauhoi;
    private DatabaseReference mDatabase;
    private Customdanhsach customGridView;
    private  ArrayList<Cauhoi> cauhoiArrayList=new ArrayList<Cauhoi>();
    public ArrayList<Danhsach> danhsachArrayList;
    {
        danhsachArrayList=new ArrayList<Danhsach>();
        if(cauhoiArrayList.isEmpty()){
            for(int i=0;i<cauhoiArrayList.size();i++){
                Danhsach ds=new Danhsach(i+1,"(Chưa làm)","invisible");
                danhsachArrayList.add(ds);
            }
        }

    }


    String[] mang;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cauhoi);
        anhxa();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        bt_onclick();
        danhsach();
        Bundle bundle=getIntent().getExtras();
        cauhoiArrayList=(ArrayList<Cauhoi>)bundle.getSerializable("mang");
    }

    private void anhxa() {
        menu_ds=findViewById(R.id.menu_ds);
        mdrawerLayout=findViewById(R.id.drawer);
        mNavigationView=findViewById(R.id.navvigationview);
        mNavigationView.setNavigationItemSelectedListener(this);
        mListView=findViewById(R.id.list_danhsach);
        bt_next=findViewById(R.id.bt_next);
        bt_previous=findViewById(R.id.bt_previous);
        radioGroup=findViewById(R.id.radio_bt_kq);
        KQ_A=findViewById(R.id.KQ_A);
        KQ_B=findViewById(R.id.KQ_B);
        KQ_C=findViewById(R.id.KQ_C);
        KQ_D=findViewById(R.id.KQ_D);
        tvcau=findViewById(R.id.tvcau);
        tvcauhoi=findViewById(R.id.tvcauhoi);

    }

    private void danhsach() {
        customGridView=new Customdanhsach(this,R.layout.item_list_danh_sach,danhsachArrayList);
        mListView.setAdapter(customGridView);
    }

    @Override
    protected void onStart() {

        super.onStart();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }
    private void bt_onclick() {
        menu_ds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mdrawerLayout.isDrawerOpen(GravityCompat.START)) {
                    mdrawerLayout.openDrawer(Gravity.START);
                } else {
                    mdrawerLayout.closeDrawer(Gravity.END);
                }
            }
        });
        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i= Integer.parseInt((String) tvcau.getText());
                Log.d("TsetIQ", String.valueOf(mDatabase.child("TsetIQ")));
                if(KQ_A.isChecked()||KQ_B.isChecked()||KQ_C.isChecked()||KQ_D.isChecked()){
                    if(i<cauhoiArrayList.size()){
                        Danhsach ds=new Danhsach(i,"(Đã làm)","VISIBLE");
                        danhsachArrayList.set(i-1,ds);
                        customGridView.notifyDataSetChanged();
                        Cauhois(i+1);
                        KQ_A.setChecked(false);
                        KQ_B.setChecked(false);
                        KQ_C.setChecked(false);
                        KQ_D.setChecked(false);
                    }else {

                    }

                }else {
                    Cauhois(i+1);
                }
            }
        });
        bt_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), danhsachArrayList.get(position).id,Toast.LENGTH_LONG).show();
            }
        });

    }
    /*private void filebase( int id) {
          final int i=id;
        mDatabase.child("TsetIQ").child(String.valueOf(id)).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.d("cau hoi", "onDataChange: "+dataSnapshot.getValue());
                Cauhoi cauhoi = dataSnapshot.getValue(Cauhoi.class);
                cauhoiArrayList.add(cauhoi);
                KQ_A.setText("A. "+cauhoi.getCauA());
                KQ_B.setText("B. "+cauhoi.getCauB());
                KQ_C.setText("C. "+cauhoi.getCauC());
                KQ_D.setText("D. "+cauhoi.getCauD());
                tvcauhoi.setText(cauhoi.getCauhoi());
                tvcau.setText(String.valueOf(i));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }*/
    public void Cauhois(int i){

        KQ_A.setText("A. "+cauhoiArrayList.get(i).getCauA());
        KQ_B.setText("B. "+cauhoiArrayList.get(i).getCauB());
        KQ_C.setText("C. "+cauhoiArrayList.get(i).getCauC());
        KQ_D.setText("D. "+cauhoiArrayList.get(i).getCauD());
        tvcauhoi.setText(cauhoiArrayList.get(i).getCauhoi());
        tvcau.setText(String.valueOf(i));
    }
}
