package com.kahel.sampledynamicview.customgenatedviews;

import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * Created by Mark on 8/30/2016.
 */
public class CreateTextView {

    public static TextView CreateTextView(Context context, String text, int id,int span){
        TextView textView = new TextView(context);
        textView.setText(Html.fromHtml(text));
        textView.setId(id);
        textView.setAllCaps(false);
        TableRow.LayoutParams params = new TableRow.LayoutParams();
        params.span = span;
        textView.setLayoutParams(params);
        textView.setTextColor(Color.parseColor("#000000"));

        return textView;
    }
}
