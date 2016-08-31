package com.kahel.sampledynamicview.customgenatedviews;

import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * Created by Mark on 8/30/2016.
 */
public class CreateErrorText {

    public static TextView CreateErrorText(Context context, String text, int id, String tag, int visibility, int span){
        TextView textView = new TextView(context);
        textView.setText(Html.fromHtml(text));
        textView.setId(id);
        textView.setAllCaps(false);
        textView.setTag(tag);
        textView.setVisibility(visibility);
        TableRow.LayoutParams params = new TableRow.LayoutParams();
        params.span = span;
        textView.setLayoutParams(params);
        textView.setTextColor(Color.parseColor("#F5183D"));

        return textView;
    }
}
