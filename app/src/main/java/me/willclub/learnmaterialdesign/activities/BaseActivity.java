package me.willclub.learnmaterialdesign.activities;

import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;

/**
 * Created by will on 4/16/15.
 */
public abstract class BaseActivity extends ActionBarActivity {

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)  {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
