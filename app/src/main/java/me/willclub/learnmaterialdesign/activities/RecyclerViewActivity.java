package me.willclub.learnmaterialdesign.activities;

import android.os.Bundle;
import android.view.ViewGroup;

import me.willclub.learnmaterialdesign.R;

/**
 * Created by will on 4/16/15.
 */
public class RecyclerViewActivity extends BaseActivity {

    private ViewGroup containerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        containerView = (ViewGroup) findViewById(R.id.container);
    }

}
