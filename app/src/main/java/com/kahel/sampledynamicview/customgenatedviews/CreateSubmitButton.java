package com.kahel.sampledynamicview.customgenatedviews;

import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.kahel.sampledynamicview.MainActivity;
import com.kahel.sampledynamicview.R;

/**
 * Created by Mark on 8/30/2016.
 */
public class CreateSubmitButton {

    public static Button CreateSubmitButton(Context context, String text, int width, int id, MainActivity activity){
        Button button = new Button(context);
        button.setText(Html.fromHtml(text));
        button.setId(id);
        button.setWidth(width);
        button.setAllCaps(false);
        button.setTextColor(Color.parseColor("#ffffff"));
        button.setBackgroundResource(R.drawable.button_background);
        button.setOnClickListener(activity);

        return button;
    }
}
