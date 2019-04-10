package com.android.typinganimation;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start = findViewById(R.id.start);
        final TextView textView = findViewById(R.id.type_text);

        gradient(textView);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Typewriter typewriter = new Typewriter();
                typewriter.setTextView(textView);
                typewriter.setCharacterDelay(100);
                typewriter.animateText("My Animation");
            }
        });

    }

    private void gradient(TextView textView) {
        Shader textShader=new LinearGradient(0, 0, 200, 0,
                new int[]{getResources().getColor(R.color.colorPrimary), getResources().getColor(R.color.colorAccent)},
                new float[]{0, 1}, Shader.TileMode.CLAMP);
        textView.getPaint().setShader(textShader);
    }

}
