package com.kahel.sampledynamicview.customgenatedviews;

import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableRow;

import com.kahel.sampledynamicview.R;
import com.kahel.sampledynamicview.Utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Mark on 8/30/2016.
 */
public class CreateDropDown {

    public static Spinner CreateDropDown(Context context, String[] text, int width, int id, int span){
        Spinner spinner = new Spinner(context);
        List<String> stringList = new ArrayList<String>(Arrays.asList(text));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                context, android.R.layout.simple_spinner_item, stringList);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setId(id);
        TableRow.LayoutParams params = new TableRow.LayoutParams(width, Utilities.dpToPx(45));
        params.span = span;
        spinner.setLayoutParams(params);
        spinner.setBackgroundResource(R.drawable.edit_text_background);

        return spinner;
    }
}
