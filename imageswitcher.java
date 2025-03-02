/*<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <ImageSwitcher
        android:id="@+id/imgSwitcher"
        android:layout_width="match_parent"
        android:layout_height="280dp"
        android:layout_gravity="center" />

    <Button
        android:id="@+id/btnNext"
        android:text="Click for Next"
        android:textSize="30sp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:layout_marginTop="230dp" />

</LinearLayout>
*/

package com.example.imgswitch1;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ImageSwitcher mimgSwitcher;
    Button mbtnNext;
    int imageIds[] = {R.drawable.peacock, R.drawable.peacock2};
    int count = imageIds.length;
    int currentIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mbtnNext = findViewById(R.id.btnNext);
        mimgSwitcher = findViewById(R.id.imgSwitcher);

        mimgSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView newImgView = new ImageView(getApplicationContext());
                newImgView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return newImgView;
            }
        });

        // Set fade-in and fade-out animations
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
        mimgSwitcher.setInAnimation(in);
        mimgSwitcher.setOutAnimation(out);


        mbtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex++;
                if (currentIndex == count) {
                    currentIndex = 0;
                }
                mimgSwitcher.setImageResource(imageIds[currentIndex]);
            }
        });
    }
}
