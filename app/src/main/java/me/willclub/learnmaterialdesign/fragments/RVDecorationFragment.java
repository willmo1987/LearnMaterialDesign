package me.willclub.learnmaterialdesign.fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import me.willclub.learnmaterialdesign.R;
import me.willclub.learnmaterialdesign.decorations.DividerItemDecoration;
import me.willclub.learnmaterialdesign.utils.ArrayUtil;
import me.willclub.learnmaterialdesign.utils.DrawableUtil;

/**
 * Created by will on 4/18/15.
 */
public class RVDecorationFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private String[] contentArray;

    @Override
    protected boolean hasActionBar() {
        return true;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return LayoutInflater.from(getActivity()).inflate(R.layout.fragment_decoration, null);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        contentArray = getResources().getStringArray(R.array.multilayoutArray);
        Toolbar toolbar = (Toolbar) getView().findViewById(R.id.toolbar);
        setupActionBar(toolbar);
        enableHomeAsUp();
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        recyclerView = (RecyclerView) getView().findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(DrawableUtil.getDrawable(getActivity(), R.drawable.list_divider)));
        recyclerView.setAdapter(new DecorationAdapter());
    }

    private class DecorationAdapter extends RecyclerView.Adapter<DecorationViewHolder> {

        private LayoutInflater layoutInflater;

        public DecorationAdapter() {
            layoutInflater = LayoutInflater.from(getActivity());
        }

        @Override
        public int getItemCount() {
            if (ArrayUtil.isValid(contentArray)) {
                return contentArray.length;
            }
            return 0;
        }

        @Override
        public DecorationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new DecorationViewHolder(layoutInflater.inflate(R.layout.list_item_rect, parent, false));
        }

        @Override
        public void onBindViewHolder(DecorationViewHolder holder, int position) {
            holder.textView.setText(contentArray[position]);
        }

    }

    private class DecorationViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public DecorationViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView;
        }
    }


}
