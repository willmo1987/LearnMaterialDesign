package me.willclub.learnmaterialdesign.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import me.willclub.learnmaterialdesign.R;
import me.willclub.learnmaterialdesign.utils.ArrayUtil;

/**
 * Created by will on 4/16/15.
 */
public abstract class BaseListActivity extends BaseActivity {

    protected RecyclerView recyclerView;
    protected Toolbar toolbar;
    protected String[] contentArray;

    protected abstract int contentArrayRes();
    protected abstract void onItemClick(String content, int position);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_recyclerview);
        if (contentArrayRes() < 0) {
            finish();
        }
        contentArray = getResources().getStringArray(contentArrayRes());
        setupToolBar();
        setupRecyclerView();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void setupRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new BaseListAdapter());
    }

    protected void enableHomeAsUp() {
        enableHomeAsUp(-1);
    }

    protected void enableHomeAsUp(int indicator) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (indicator > 0) {
            getSupportActionBar().setHomeAsUpIndicator(indicator);
        }
    }

    private class BaseListAdapter extends RecyclerView.Adapter<ViewHolder> {

        private LayoutInflater layoutInflater;

        public BaseListAdapter() {
            layoutInflater = LayoutInflater.from(BaseListActivity.this);
        }

        @Override
        public int getItemCount() {
            if (ArrayUtil.isValid(contentArray)) {
                return contentArray.length;
            }
            return 0;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(layoutInflater.inflate(R.layout.list_item_main, parent, false));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.textView.setText(contentArray[position]);
        }

    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int layoutPosition = getLayoutPosition();
                    onItemClick(contentArray[layoutPosition], layoutPosition);
                }
            });
        }
    }

}
