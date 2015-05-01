package org.kidinov.snp_lib;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class SimplePickerAdapter extends RecyclerView.Adapter {
    private Context ctx;
    private Params params;
    private LayoutInflater li;

    public SimplePickerAdapter(Context ctx, Params params) {
        this.ctx = ctx;
        this.params = params;
        li = LayoutInflater.from(ctx);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (params.isVertical()) {
            return new ViewHolder(li.inflate(R.layout.weight_item_vert, parent, false), params);
        } else {
            return new ViewHolder(li.inflate(R.layout.weight_item, parent, false), params);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int index) {
        ViewHolder h = (ViewHolder) holder;
        h.bind(index);
    }

    @Override
    public int getItemCount() {
        return params.getMax() - params.getMin();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final RelativeLayout view;
        private TextView textView;
        private View notch;
        private Params params;

        public ViewHolder(View v, Params params) {
            super(v);
            this.params = params;
            view = (RelativeLayout) v;
            textView = ((TextView) view.findViewById(R.id.text));
            notch = view.findViewById(R.id.notch);
            if (params.isVertical()) {
                ((RelativeLayout.LayoutParams) notch.getLayoutParams()).width = (int) params.getNotchSize();
                ((RelativeLayout.LayoutParams) notch.getLayoutParams()).height = (int) EnvHelper.pxFromDp(v.getContext(), 1);
            } else {
                ((RelativeLayout.LayoutParams) notch.getLayoutParams()).height = (int) params.getNotchSize();
                ((RelativeLayout.LayoutParams) notch.getLayoutParams()).width = (int) EnvHelper.pxFromDp(v.getContext(), 1);
            }
            notch.setBackgroundColor(params.getNotchColor());
        }

        public void bind(int index) {
            index += params.getMin();
            if (index % params.getDelimNumber() != 0) {
                textView.setText(String.valueOf(index));
                textView.setTextSize(params.getSmallTextSize());
                textView.setTypeface(textView.getTypeface(), Typeface.NORMAL);
                textView.setTextColor(params.getSmallTextColor());
                notch.setVisibility(View.VISIBLE);
            } else {
                textView.setText(String.valueOf(index));
                textView.setTextSize(params.getBigTextSize());
                textView.setTypeface(textView.getTypeface(), Typeface.BOLD);
                textView.setTextColor(params.getBigTextColor());
                notch.setVisibility(View.INVISIBLE);
            }
        }
    }
}
