package me.willclub.learnmaterialdesign.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import me.willclub.learnmaterialdesign.R;

/**
 * Created by will on 4/17/15.
 */
public class BlendentActivity extends BaseActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blendent);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_blendent, menu);
        return super.onCreateOptionsMenu(menu);
    }

}
