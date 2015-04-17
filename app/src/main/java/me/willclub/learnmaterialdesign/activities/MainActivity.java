package me.willclub.learnmaterialdesign.activities;

import android.content.Intent;

import me.willclub.learnmaterialdesign.R;
import me.willclub.learnmaterialdesign.utils.ToastUtil;

/**
 * Created by will on 4/12/15.
 */
public class MainActivity extends BaseListActivity {

    private static final int POS_TOOLBAR = 0;
    private static final int POS_BLENDENT = 1;
    private static final int POS_RECYCLER_VIEW = 2;
    private static final int POS_CARD_VIEW = 3;
    private static final int POS_ANIMATION = 4;
    private static final int POS_GRID_LAYOUT = 5;

    @Override
    protected int contentArrayRes() {
        return R.array.contentArray;
    }

    @Override
    protected void onItemClick(String content, int position) {
        Intent intent = null;
        switch (position) {
            case POS_TOOLBAR:
                intent = new Intent(this, ToolBarActivity.class);
                break;
            case POS_BLENDENT:
                intent = new Intent(this, BlendentActivity.class);
                break;
            case POS_RECYCLER_VIEW:
                intent = new Intent(this, RecyclerViewListActivity.class);
                break;
            case POS_CARD_VIEW:
                break;
            case POS_ANIMATION:
                break;
            case POS_GRID_LAYOUT:
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
        else {
            ToastUtil.showToast(this, R.string.coming_soon);
        }
    }
}
