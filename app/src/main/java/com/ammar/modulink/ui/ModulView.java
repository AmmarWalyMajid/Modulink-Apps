package com.ammar.modulink.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ammar.modulink.R;
import com.github.barteksc.pdfviewer.PDFView;

public class ModulView extends AppCompatActivity {

    PDFView book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulview);

        book=findViewById(R.id.pdf1);
        book.fromAsset("inputcontrols.pdf").load();
    }
}
