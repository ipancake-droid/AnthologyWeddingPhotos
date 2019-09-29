package com.example.anthologyweddingphotos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Integer[] Photos = {R.drawable.weddingphoto1,R.drawable.weddingphoto2,R.drawable.weddingphoto3,R.drawable.weddingphoto4,R.drawable.weddingphoto5,
            R.drawable.weddingphoto6,R.drawable.weddingphoto7,R.drawable.weddingphoto8,R.drawable.weddingphoto9,
            R.drawable.weddingphoto10,};
    ImageView pic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView grid = (GridView)findViewById(R.id.gridView);
        final ImageView pic = (ImageView) findViewById(R.id.imgLarge);
        grid.setAdapter(new ImageAdapter(this));
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getBaseContext(), "Anthology Wedding Photo" + (i + l), Toast.LENGTH_SHORT).show();
                pic.setImageResource(Photos[i]);
            }
        });
    }
    public class ImageAdapter extends BaseAdapter {
        private Context context;
        public ImageAdapter (Context c){
            context=c;
        }

        @Override
        public int getCount() {
            return Photos.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            pic = new ImageView(context);
            pic.setImageResource(Photos[i]);
            pic.setScaleType(ImageView.ScaleType.FIT_XY);
            pic.setLayoutParams(new GridView.LayoutParams(330,300));
            return pic;
        }


    }
}
