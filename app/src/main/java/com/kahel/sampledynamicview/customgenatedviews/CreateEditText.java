package com.kahel.sampledynamicview.customgenatedviews;

import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.TextView;

import com.kahel.sampledynamicview.R;

/**
 * Created by Mark on 8/30/2016.
 */
public class CreateEditText {

    public static EditText CreateEditText(Context context, String text, String hint, int width, int id, int span){
        EditText editText = new EditText(context);
        editText.setText(Html.fromHtml(text));
        editText.setId(id);
        TableRow.LayoutParams params = new TableRow.LayoutParams();
        editText.setWidth(width);
        editText.setAllCaps(false);
        editText.setHint(hint);
        params.span = span;
        editText.setLayoutParams(params);
        editText.setTextColor(Color.parseColor("#000000"));
        editText.setBackgroundResource(R.drawable.edit_text_background);

        return editText;
    }

    public static EditText CreateEditText(Context context, String text, String hint, int width, int id, int span, int min_lines){
        EditText editText = new EditText(context);
        editText.setText(Html.fromHtml(text));
        editText.setId(id);
        editText.setMinLines(min_lines);
        TableRow.LayoutParams params = new TableRow.LayoutParams();
        editText.setWidth(width);
        editText.setAllCaps(false);
        editText.setHint(hint);
        params.span = span;
        editText.setLayoutParams(params);
        editText.setTextColor(Color.parseColor("#000000"));
        editText.setBackgroundResource(R.drawable.edit_text_background);

        return editText;
    }
}
