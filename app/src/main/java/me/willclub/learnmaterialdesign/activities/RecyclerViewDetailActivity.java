package me.willclub.learnmaterialdesign.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import me.willclub.learnmaterialdesign.R;
import me.willclub.learnmaterialdesign.fragments.BaseFragment;
import me.willclub.learnmaterialdesign.fragments.RVAnimationFragment;
import me.willclub.learnmaterialdesign.fragments.RVMultiTypeFragment;
import me.willclub.learnmaterialdesign.utils.Constant;

/**
 * Created by will on 4/16/15.
 */
public class RecyclerViewDetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        int type = getIntent().getIntExtra(Constant.INTENT_KEY_INITIAL_VALUE, -1);
        if (type < 0) {
            finish();
        }
        handleType(type);
    }

    private void handleType(int type) {
        BaseFragment fragment = null;
        switch (type) {
            case Constant.RV_MULTITYPE:
                fragment = new RVMultiTypeFragment();
                break;
            case Constant.RV_ANIMATION:
                fragment = new RVAnimationFragment();
                break;
        }
        if (fragment != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container, fragment);
            transaction.commit();
        }
    }
}
