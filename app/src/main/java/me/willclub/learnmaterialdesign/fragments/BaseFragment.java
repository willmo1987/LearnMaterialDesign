package me.willclub.learnmaterialdesign.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

/**
 * Created by will on 4/16/15.
 */
public abstract class BaseFragment extends Fragment {

    protected ActionBarActivity getActionBarActivity() {
        return (ActionBarActivity) getActivity();
    }

    protected boolean hasActionBar() {
        return false;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(hasActionBar());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            getActivity().finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void setupActionBar(Toolbar toolbar) {
        getActionBarActivity().setSupportActionBar(toolbar);
    }

    protected void setActionBarTitle(int titleRes) {
        getActionBarActivity().getSupportActionBar().setTitle(titleRes);
    }

    protected void enableHomeAsUp() {
        enableHomeAsUp(-1);
    }

    protected void enableHomeAsUp(int indicator) {
        getActionBarActivity().getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (indicator > 0) {
            getActionBarActivity().getSupportActionBar().setHomeAsUpIndicator(indicator);
        }
    }

}
