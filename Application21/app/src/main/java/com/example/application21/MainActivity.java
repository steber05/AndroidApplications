package com.example.application21;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.BitmapFactory;
import android.graphics.drawable.DrawableContainer;
import android.os.Bundle;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.provider.MediaStore;
import android.renderscript.Allocation;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView damienImageView;
    Drawable damien;
    Bitmap bitmapImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        damienImageView = (ImageView) findViewById(R.id.damienImageView);
        damien = getResources().getDrawable(R.drawable.damien);
        damienImageView.setImageDrawable(damien);
    }

    public void original(View view){
        damienImageView.setImageDrawable(damien);
    }

    public void createOverlay(View view){
        Drawable[] layers = new Drawable[2];
        layers[0] = getResources().getDrawable(R.drawable.damien);
        layers[1] = getResources().getDrawable(R.drawable.grunge);
        LayerDrawable layerDrawable = new LayerDrawable(layers);
        damienImageView.setImageDrawable(layerDrawable);
    }

    public void createBitmap(View view){
        bitmapImage = BitmapFactory.decodeResource(getResources(),R.drawable.damien, null);
        Bitmap newPhoto = invertImage(bitmapImage);
        damienImageView.setImageBitmap(newPhoto);
    }

    public static Bitmap invertImage(Bitmap original){

        Bitmap finalImage = Bitmap.createBitmap(original.getWidth(), original.getHeight(), original.getConfig());

        int A, R, G, B;
        int pixelColour;
        int height = original.getHeight();
        int width = original.getWidth();

        for(int y = 0;y < height; y++){
            for(int x = 0;x < width; x++){
                pixelColour = original.getPixel(x, y);
                A = Color.alpha(pixelColour);
                R = 255 - Color.red(pixelColour);
                G = 255 - Color.green(pixelColour);
                B = 255 - Color.blue(pixelColour);
                finalImage.setPixel(x, y, Color.argb(A, R, G, B));
            }
        }
        return finalImage;
    }
}
