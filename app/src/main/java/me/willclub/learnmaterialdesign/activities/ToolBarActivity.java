package me.willclub.learnmaterialdesign.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import me.willclub.learnmaterialdesign.R;
import me.willclub.learnmaterialdesign.Trace;

/**
 * Created by will on 4/16/15.
 */
public class ToolBarActivity extends BaseActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setupToolBar();
        setupActionBar();
    }

    private void setupToolBar() {
        toolbar.setTitle("Title");
        toolbar.setSubtitle("Subtitle");
        //navigationBarIcon = homeAsUpIndicator in ActionBar
        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
        toolbar.inflateMenu(R.menu.menu_toolbar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                handleMenuItem(menuItem);
                return false;
            }

        });
    }

    private void setupActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("ActionBar title");
        getSupportActionBar().setSubtitle("ActionBar subtitle");
        //default homeAsUpIndicator is an arrow heading to left
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        handleMenuItem(item);
        return super.onOptionsItemSelected(item);
    }

    private void handleMenuItem(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.actionItem1:
                Trace.d("actionItem1");
                break;
            case R.id.actionItem2:
                Trace.d("actionItem2");
                break;
            case R.id.actionItem3:
                Trace.d("actionItem3");
                break;
        }
    }

}
