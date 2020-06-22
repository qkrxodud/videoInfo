package com.example.myvideoinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;



public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();
    private TextView mFileInfoView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFileInfoView = (TextView) findViewById(R.id.tv_file_info_data);
        File sdcard = Environment.getExternalStorageDirectory();
        File  file = new File(sdcard,"/Android/data/test.mp4");
        makeFileInfoView(file);
       /* if (file.exists()) {
            Log.i(TAG, ".mp4 file Exist");

            MediaMetadataRetriever retriever = new MediaMetadataRetriever();
            try {
                FileInputStream inputStream = new FileInputStream(file.getAbsolutePath());
                FileDescriptor result  = inputStream.getFD();
                retriever.setDataSource(inputStream.getFD());
                for (int i = 0; i < 39; i++){
                    if(retriever.extractMetadata(i)!=null) {
                        if(i == 5) {
                            mFileInfoView.append(" 촬영날짜 :: " + retriever.extractMetadata(i)+"\n\n\n");
                        } else if (i==9) {
                            String time = retriever.extractMetadata(i);
                            long timeInmillisec = Long.parseLong( time );
                            long duration = timeInmillisec / 1000;
                            long hours = duration / 3600;
                            long minutes = (duration - hours * 3600) / 60;
                            long seconds = duration - (hours * 3600 + minutes * 60);
                            mFileInfoView.append(" 동영상길이 :: " + seconds+"s"+"\n\n\n");
                        } else if (i == 12) {
                            *//*Log.i(TAG, " 비디오 타입 :: " + retriever.extractMetadata(i));*//*
                            mFileInfoView.append(" 비디오 타입 :: " + retriever.extractMetadata(i)+"\n\n\n");
                        } else if (i == 16) {
                            mFileInfoView.append(" 트랙수:: " + retriever.extractMetadata(i)+"\n\n\n");
                        } else if (i == 18) {
                            mFileInfoView.append(" 동영상 넓이:: " + retriever.extractMetadata(i)+"\n\n\n");
                        } else if (i == 19) {
                            mFileInfoView.append(" 동영상 높이:: " + retriever.extractMetadata(i)+"\n\n\n");
                        }  else if (i == 20) {
                            mFileInfoView.append(" 비트전송률:: " + retriever.extractMetadata(i)+"\n\n\n");
                        }
                        Log.i(TAG, " 번호 :: " + i);
                        //mFileInfoView.append(retriever.extractMetadata(i)+"\n\n\n");
                    }
                }
                inputStream.close();
            } catch (Exception e) {
                Log.e(TAG, "Exception : " + e.getMessage());
            }
        } else {
            Log.e(TAG, ".mp4 file doesn´t exist.");
        }*/

    }

    public void makeFileInfoView(File  file) {
        if (file.exists()) {
            Log.i(TAG, ".mp4 file Exist");

            MediaMetadataRetriever retriever = new MediaMetadataRetriever();
            try {
                FileInputStream inputStream = new FileInputStream(file.getAbsolutePath());
                FileDescriptor result  = inputStream.getFD();
                retriever.setDataSource(inputStream.getFD());
                for (int i = 0; i < 39; i++){
                    if(retriever.extractMetadata(i)!=null) {
                        if(i == 5) {
                            mFileInfoView.append(" 촬영날짜 :: " + retriever.extractMetadata(i)+"\n\n\n");
                        } else if (i==9) {
                            String time = retriever.extractMetadata(i);
                            long timeInmillisec = Long.parseLong( time );
                            long duration = timeInmillisec / 1000;
                            long hours = duration / 3600;
                            long minutes = (duration - hours * 3600) / 60;
                            long seconds = duration - (hours * 3600 + minutes * 60);
                            mFileInfoView.append(" 동영상길이 :: " + seconds+"s"+"\n\n\n");
                        } else if (i == 12) {
                            /*Log.i(TAG, " 비디오 타입 :: " + retriever.extractMetadata(i));*/
                            mFileInfoView.append(" 비디오 타입 :: " + retriever.extractMetadata(i)+"\n\n\n");
                        } else if (i == 16) {
                            mFileInfoView.append(" 트랙수:: " + retriever.extractMetadata(i)+"\n\n\n");
                        } else if (i == 18) {
                            mFileInfoView.append(" 동영상 넓이:: " + retriever.extractMetadata(i)+"\n\n\n");
                        } else if (i == 19) {
                            mFileInfoView.append(" 동영상 높이:: " + retriever.extractMetadata(i)+"\n\n\n");
                        }  else if (i == 20) {
                            mFileInfoView.append(" 비트전송률:: " + retriever.extractMetadata(i)+"\n\n\n");
                        }
                        Log.i(TAG, " 번호 :: " + i);
                        //mFileInfoView.append(retriever.extractMetadata(i)+"\n\n\n");
                    }
                }
                inputStream.close();
            } catch (Exception e) {
                Log.e(TAG, "Exception : " + e.getMessage());
            }
        } else {
            Log.e(TAG, ".mp4 file doesn´t exist.");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemThatWasClickedId = item.getItemId();
        if (itemThatWasClickedId == R.id.action_search) {
            File sdcard = Environment.getExternalStorageDirectory();
            File  file = new File(sdcard,"/Android/data/test.mp4");
            makeFileInfoView(file);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
