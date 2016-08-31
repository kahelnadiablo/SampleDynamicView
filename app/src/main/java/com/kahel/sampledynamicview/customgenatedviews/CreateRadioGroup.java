package com.kahel.sampledynamicview.customgenatedviews;

import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * Created by Mark on 8/30/2016.
 */
public class CreateRadioGroup {

    public static RadioGroup CreateRadioGroup(Context context, String[] text, int[] id, int orientation, boolean is_required, int span){
        RadioGroup radioGroup = new RadioGroup(context);

        for(int i=0;i<text.length;i++){
            RadioButton radioButton = new RadioButton(context);
            radioButton.setText(text[i]);
            radioButton.setId(id[i]);
            radioButton.setTextColor(Color.parseColor("#000000"));
            radioButton.setSingleLine(true);
            radioButton.setEllipsize(TextUtils.TruncateAt.END);
            if(i==0){radioButton.setChecked(is_required);}
            radioGroup.addView(radioButton);


        }

        TableRow.LayoutParams params = new TableRow.LayoutParams();
        params.span = span;
        radioGroup.setLayoutParams(params);
        radioGroup.setOrientation(orientation);

        return radioGroup;
    }
}
