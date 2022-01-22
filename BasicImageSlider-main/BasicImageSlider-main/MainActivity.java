package com.example.imageswitcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button bnext, bprev;
    ImageView iv;
    boolean flag;

    int images[] = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4};
    int i = 0;
    int length = images.length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = (ImageView) findViewById(R.id.imageView);
        bnext = findViewById(R.id.next);
        bprev = findViewById(R.id.prev);

        bnext.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                i = (i+1)%length;
                iv.setImageResource(images[i]);
            }
        });

        bprev.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                i--;
                if(i==-1)
                {
                    i=length-1;
                }
                iv.setImageResource(images[i]);
            }
        });

    }
}