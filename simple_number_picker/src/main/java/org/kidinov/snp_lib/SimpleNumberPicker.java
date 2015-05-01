package org.kidinov.snp_lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import jp.wasabeef.recyclerview.animators.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.animators.adapters.AnimationAdapter;
import jp.wasabeef.recyclerview.animators.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.animators.adapters.SlideInBottomAnimationAdapter;
import jp.wasabeef.recyclerview.animators.adapters.SlideInLeftAnimationAdapter;
import jp.wasabeef.recyclerview.animators.adapters.SlideInRightAnimationAdapter;

public class SimpleNumberPicker extends LinearLayout {
    private OnNewValueSelectedListener onNewValueSelected;
    private LinearLayoutManager llm;

    public SimpleNumberPicker(Context context) {
        this(context, null);
    }

    public SimpleNumberPicker(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.SNPickerStyle);
    }

    public SimpleNumberPicker(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        RecyclerView rv = new RecyclerView(context, attrs, defStyleAttr);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.SNPicker, defStyleAttr, 0);
        try {
            final Params params = readParams(typedArray);

            llm = new LinearLayoutManager(context,
                    typedArray.getBoolean(R.styleable.SNPicker_vertical, false) ? LinearLayoutManager.VERTICAL : LinearLayoutManager.HORIZONTAL, false);
            rv.setLayoutManager(llm);

            AnimationAdapter adapter;
            SimplePickerAdapter innerAdapter = new SimplePickerAdapter(context, params);
            if (typedArray.getString(R.styleable.SNPicker_animationType) == null) {
                adapter = new ScaleInAnimationAdapter(innerAdapter);
            } else {
                switch (typedArray.getString(R.styleable.SNPicker_animationType)) {
                    case "scale":
                        adapter = new ScaleInAnimationAdapter(innerAdapter);
                        break;
                    case "alpha":
                        adapter = new AlphaInAnimationAdapter(innerAdapter);
                        break;
                    case "slide_in_bottom":
                        adapter = new SlideInBottomAnimationAdapter(innerAdapter);
                        break;
                    case "slide_in_right":
                        adapter = new SlideInRightAnimationAdapter(innerAdapter);
                        break;
                    case "slide_in_left":
                        adapter = new SlideInLeftAnimationAdapter(innerAdapter);
                        break;
                    default:
                        adapter = new ScaleInAnimationAdapter(innerAdapter);
                }
            }

            adapter.setFirstOnly(false);
            adapter.setDuration(500);
            rv.setAdapter(adapter);

            rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    if (onNewValueSelected != null) {
                        onNewValueSelected.newValueSelected(params.getMin() + getValue());
                    }
                }
            });

        } finally {
            typedArray.recycle();
        }
        addView(rv);
    }

    private Params readParams(TypedArray ta) {
        Params.Builder builder = new Params.Builder();
        builder.setSmallTextColor(ta.getColor(R.styleable.SNPicker_smallTextColor, Color.parseColor("#727272")));
        builder.setBigTextColor(ta.getColor(R.styleable.SNPicker_bigTextColor, Color.parseColor("#212121")));

        builder.setBigTextSize(ta.getDimension(R.styleable.SNPicker_bigTextSize, EnvHelper.pxFromDp(getContext(), 10)));
        builder.setSmallTextSize(ta.getDimension(R.styleable.SNPicker_smallTextSize, EnvHelper.pxFromDp(getContext(), 3)));

        builder.setNotchSize(ta.getDimension(R.styleable.SNPicker_notchSize, EnvHelper.pxFromDp(getContext(), 10)));
        builder.setNotchColor(ta.getColor(R.styleable.SNPicker_notchColor, Color.parseColor("#B6B6B6")));

        builder.setDelimNumber(ta.getInt(R.styleable.SNPicker_delimNumber, 10));

        builder.setMin(ta.getInt(R.styleable.SNPicker_min, 0));
        builder.setMax(ta.getInt(R.styleable.SNPicker_max, 5000));

        builder.setVertical(ta.getBoolean(R.styleable.SNPicker_vertical, false));
        return builder.build();
    }

    private int getValue() {
        return llm.findFirstVisibleItemPosition() + (llm.findLastVisibleItemPosition() - llm.findFirstVisibleItemPosition()) / 2;
    }

    public void setOnNewValueSelectedListener(OnNewValueSelectedListener onNewValueSelected) {
        this.onNewValueSelected = onNewValueSelected;
    }
}
