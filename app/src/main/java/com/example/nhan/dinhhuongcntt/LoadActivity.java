package com.example.nhan.dinhhuongcntt;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.nhan.dinhhuongcntt.Calss.Cauhoi;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LoadActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private ArrayList<Cauhoi> arrayList =new ArrayList<Cauhoi>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("TestIQ").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.d("cau hoi", "onDataChange: "+dataSnapshot.getChildren());

                for (DataSnapshot data:dataSnapshot.getChildren()){



                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        new DownloadFileFromServer().execute();
    }
    class DownloadFileFromServer extends AsyncTask<Void, Integer, Boolean> {
        private ProgressBar pbDownload;
        private TextView tvProgress;

        @Override
        protected void onPreExecute() {
            tvProgress=(TextView)findViewById(R.id.tvProgress);
            pbDownload=(ProgressBar)findViewById(R.id.pbDownload);
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(Void... params) {

            for(int i=0;i<100;i++){
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(i+1);
            }
            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            //lấy dữ liệu được gọi đến
            int progress =values[0];
            //Hiển thị process
            pbDownload.setProgress(progress);
            tvProgress.setText("Loading "+String.valueOf(progress)+"%");
            super.onProgressUpdate(values);
        }
        //Sau khi load xong dữ liệu phương thức onPostExecute sẽ được gọi sau khi phương thức này thực hiện xong
        //Asynctask sẽ stop. ở đây các bạn được phép sử dụng UI
        @Override
        protected void onPostExecute(Boolean aBoolean) {
            tvProgress.setText("Download complete");
            super.onPostExecute(aBoolean);

        }
    }
}
