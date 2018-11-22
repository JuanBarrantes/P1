package com.example.jhanxd.p1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imagen;
    Button btnfoto;
    static final int REQUEST_IMAGE_CAPTURE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnfoto= (Button) findViewById(R.id.btnfoto);
        imagen = (ImageView) findViewById(R.id.imgfoto);

        btnfoto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                llamarIntend();
            }
        });
    }

    private void llamarIntend (){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
    }

    @Override
    protected void onActivityResult (int requestcode, int resultcode, Intent data){
        if (requestcode == REQUEST_IMAGE_CAPTURE && resultcode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imagen.setImageBitmap(imageBitmap);
        }
    }
}
