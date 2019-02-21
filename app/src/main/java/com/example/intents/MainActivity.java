package com.example.intents;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button google,contactos,numero,whats,facebook,maps,camara, enviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        google = findViewById(R.id.btngoogle);
        contactos = findViewById(R.id.btncontactos);
        numero = findViewById(R.id.btnnumero);
        whats = findViewById(R.id.btnwhats);
        facebook = findViewById(R.id.btnfacebook);
        maps = findViewById(R.id.btnmaps);
        camara = findViewById(R.id.btncamara);
        enviar = findViewById(R.id.btnenviar);

        View.OnClickListener click = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId())
                {
                    case R.id.btngoogle:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com/")));
                        break;
                    case R.id.btncontactos:
                        startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("content://contacts/people/")));
                        break;
                    case R.id.btnnumero:
                        startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("tel:7323327")));
                        break;

                    case R.id.btnwhats:
                        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.whatsapp");
                        startActivity(launchIntent);
                        break;

                    case R.id.btnfacebook:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/")));
                        break;

                    case R.id.btncamara:
                        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(i,0);
                        break;
                    case R.id.btnmaps:
                        Intent intent = new Intent().setAction(Intent.ACTION_VIEW);
                        intent.setType("image/*");
                        startActivity(intent);
                        break;

                    case R.id.btnenviar:
                        Intent intent1 = new Intent();
                        intent1.putExtra("Mensaje","Hola");
                        intent1.setType("text/plain");
                        startActivity(Intent.createChooser(intent1,"Elige la aplicación"));
                        break;
                }
            }
        };

        google.setOnClickListener(click);
        contactos.setOnClickListener(click);
        numero.setOnClickListener(click);
        whats.setOnClickListener(click);
        facebook.setOnClickListener(click);
        camara.setOnClickListener(click);
        maps.setOnClickListener(click);
        enviar.setOnClickListener(click);
    }
}
