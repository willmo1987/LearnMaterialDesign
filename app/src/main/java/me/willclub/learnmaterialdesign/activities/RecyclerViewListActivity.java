package me.willclub.learnmaterialdesign.activities;

import android.content.Intent;
import android.os.Bundle;

import me.willclub.learnmaterialdesign.R;
import me.willclub.learnmaterialdesign.utils.Constant;
import me.willclub.learnmaterialdesign.utils.ToastUtil;

/**
 * Created by will on 4/16/15.
 */
public class RecyclerViewListActivity extends BaseListActivity {

    @Override
    protected int contentArrayRes() {
        return R.array.optionRecyclerViewArray;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        enableHomeAsUp();
    }

    @Override
    protected void onItemClick(String content, int position) {
        if (position != 3) {
            Intent intent = new Intent(this, RecyclerViewDetailActivity.class);
            intent.putExtra(Constant.INTENT_KEY_INITIAL_VALUE, position);
            startActivity(intent);
        }
        else {
            ToastUtil.showToast(this, R.string.coming_soon);
        }
    }

}
