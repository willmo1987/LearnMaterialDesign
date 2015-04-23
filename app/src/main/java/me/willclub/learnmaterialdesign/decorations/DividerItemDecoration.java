package me.willclub.learnmaterialdesign.decorations;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 只支持LinearLayoutManager
 */
public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    private Drawable dividerDrawable;

    public DividerItemDecoration(Drawable divider) {
        dividerDrawable = divider;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (dividerDrawable == null) {
            return;
        }
        //如果是第一个item，不需要divider，所以直接return
        if (parent.getChildLayoutPosition(view) < 1) {
            return;
        }
        int layoutOrientation = getOrientation(parent);
        if (layoutOrientation == LinearLayoutManager.VERTICAL) {
            outRect.top = dividerDrawable.getIntrinsicHeight();
        }
        else if(layoutOrientation == LinearLayoutManager.HORIZONTAL) {
            outRect.left = dividerDrawable.getIntrinsicWidth();
        }
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if (dividerDrawable == null) {
            return;
        }
        LinearLayoutManager layoutManager = getLinearLayoutManger(parent);
        int firstVisiblePosition = layoutManager.findFirstVisibleItemPosition();
        int orientation = getOrientation(layoutManager);
        int childCount = parent.getChildCount();
        if (orientation == LinearLayoutManager.VERTICAL) {
            int right = parent.getWidth();
            for (int i=0; i<childCount; i++) {
                //判断第一个item的下标是不是0，是则return，不需要draw divider
                if (i == 0 && firstVisiblePosition == 0) {
                    continue;
                }
                View childView = parent.getChildAt(i);
                RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) childView.getLayoutParams();
                int left = parent.getPaddingLeft() + childView.getPaddingLeft();
                int bottom = childView.getTop() - params.topMargin;
                int top = bottom - dividerDrawable.getIntrinsicHeight();
                dividerDrawable.setBounds(left, top, right, bottom);
                dividerDrawable.draw(c);
            }
        }
        else if(orientation == LinearLayoutManager.HORIZONTAL) {
            for (int i=0; i<childCount; i++) {
                if (i == 0 && firstVisiblePosition == 0) {
                    continue;
                }
                View childView = parent.getChildAt(i);
                RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) childView.getLayoutParams();
                int top = parent.getPaddingTop() + childView.getPaddingTop();
                int bottom = childView.getHeight() + parent.getPaddingTop();
                int right = childView.getLeft() - params.leftMargin;
                int left = right - dividerDrawable.getIntrinsicWidth();
                dividerDrawable.setBounds(left, top, right, bottom);
                dividerDrawable.draw(c);
            }
        }
    }

    private LinearLayoutManager getLinearLayoutManger(RecyclerView parent) {
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            return (LinearLayoutManager) layoutManager;
        }
        return null;
    }

    private int getOrientation(RecyclerView parent) {
        LinearLayoutManager layoutManager = getLinearLayoutManger(parent);
        if (layoutManager != null) {
            return layoutManager.getOrientation();
        }
        return -1;
    }

    private int getOrientation(LinearLayoutManager layoutManager) {
        if (layoutManager != null) {
            return layoutManager.getOrientation();
        }
        return -1;
    }

}
