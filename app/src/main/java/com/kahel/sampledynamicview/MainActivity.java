package com.kahel.sampledynamicview;

import android.opengl.Visibility;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.kahel.sampledynamicview.customgenatedviews.CreateEditText;
import com.kahel.sampledynamicview.customgenatedviews.CreateErrorText;
import com.kahel.sampledynamicview.customgenatedviews.CreateRadioGroup;
import com.kahel.sampledynamicview.customgenatedviews.CreateSubmitButton;
import com.kahel.sampledynamicview.customgenatedviews.CreateTextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    @Bind(R.id.ll_container) LinearLayout container;
    @Bind(R.id.btn_create) Button create_button;

    LinearLayout rows;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_create)
    public void createViews(){
        create_button.setVisibility(View.GONE);

        //Logic here is to check if the view has the same y position then compute the view width based on the defined width.
        //Height will adjust based on the view as scrollable

        //There will be a loop here which will loop on the objects which will create views depending on the type specified

        //this part loop is just created manually for creating views

        LinearLayout.LayoutParams layout_params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        //Create header
        rows = new LinearLayout(getBaseContext());
        rows.setLayoutParams(layout_params);
        rows.setGravity(Gravity.CENTER_VERTICAL);
        rows.setOrientation(LinearLayout.HORIZONTAL);
        rows.setPadding(Utilities.dpToPx(0), Utilities.dpToPx(5), Utilities.dpToPx(0), Utilities.dpToPx(5));
        rows.addView(CreateTextView.CreateTextView(getBaseContext(), "<b><u>Concordance Case Study Report Forms</u></b>", 0));
        container.addView(rows);

        //Create 1st layer
        //sample options fetched from JSON if ever
        String[] options = {"Whole Slide Image","Microscope Slide"};
        int[] ids = {2,3};

        rows = new LinearLayout(getBaseContext());
        rows.setLayoutParams(layout_params);
        rows.setGravity(Gravity.CENTER_VERTICAL);
        rows.setOrientation(LinearLayout.HORIZONTAL);
        rows.setPadding(Utilities.dpToPx(0), Utilities.dpToPx(5), Utilities.dpToPx(0), Utilities.dpToPx(5));
        rows.addView(CreateTextView.CreateTextView(getBaseContext(), "Modality", 1));
        rows.addView(CreateRadioGroup.CreateRadioGroup(getBaseContext(), options, ids, LinearLayout.VERTICAL,true)); //I made the option vertical but this can be horizontal as well
        container.addView(rows);

        //2nd layer
        rows = new LinearLayout(getBaseContext());
        rows.setLayoutParams(layout_params);
        rows.setGravity(Gravity.CENTER_VERTICAL);
        rows.setOrientation(LinearLayout.HORIZONTAL);
        rows.setPadding(Utilities.dpToPx(0), Utilities.dpToPx(5), Utilities.dpToPx(0), Utilities.dpToPx(5));
        rows.addView(CreateTextView.CreateTextView(getBaseContext(), "Pathologist:", 4));
        rows.addView(CreateEditText.CreateEditText(getBaseContext(), "", "", Utilities.dpToPx(120), 5));
        rows.addView(CreateTextView.CreateTextView(getBaseContext(), "Case Number:", 6));
        rows.addView(CreateEditText.CreateEditText(getBaseContext(), "", "", Utilities.dpToPx(50), 7));
        container.addView(rows);

        //3rd layer
        rows = new LinearLayout(getBaseContext());
        rows.setLayoutParams(layout_params);
        rows.setGravity(Gravity.CENTER_VERTICAL);
        rows.setOrientation(LinearLayout.HORIZONTAL);
        rows.setPadding(Utilities.dpToPx(0), Utilities.dpToPx(5), Utilities.dpToPx(0), Utilities.dpToPx(5));
        rows.addView(CreateTextView.CreateTextView(getBaseContext(), "# of Slides:", 8));
        rows.addView(CreateEditText.CreateEditText(getBaseContext(), "", "",Utilities.dpToPx(50), 9));
        rows.addView(CreateTextView.CreateTextView(getBaseContext(), "# of Images:", 10));
        rows.addView(CreateEditText.CreateEditText(getBaseContext(), "", "",Utilities.dpToPx(50), 11));
        container.addView(rows);

        //4th layer
        //sample options fetched from JSON if ever
        String[] options2 = {"Interpret","Defer"};
        int[] ids2 = {12,13};

        rows = new LinearLayout(getBaseContext());
        rows.setLayoutParams(layout_params);
        rows.setGravity(Gravity.CENTER_VERTICAL);
        rows.setOrientation(LinearLayout.HORIZONTAL);
        rows.setPadding(Utilities.dpToPx(0), Utilities.dpToPx(5), Utilities.dpToPx(0), Utilities.dpToPx(5));
        rows.addView(CreateTextView.CreateTextView(getBaseContext(), "Case Type:", 14));
        rows.addView(CreateRadioGroup.CreateRadioGroup(getBaseContext(), options2, ids2, LinearLayout.HORIZONTAL, false)); //I made the option vertical but this can be horizontal as well
        container.addView(rows);

        //5th layer
        //sample options fetched from JSON if ever
        String[] options3 = {"Yes","No"};
        int[] ids3 = {15,16};

        rows = new LinearLayout(getBaseContext());
        rows.setLayoutParams(layout_params);
        rows.setGravity(Gravity.CENTER_VERTICAL);
        rows.setOrientation(LinearLayout.HORIZONTAL);
        rows.setPadding(Utilities.dpToPx(0), Utilities.dpToPx(5), Utilities.dpToPx(0), Utilities.dpToPx(5));
        rows.addView(CreateTextView.CreateTextView(getBaseContext(), "Rescan Request", 17));
        rows.addView(CreateRadioGroup.CreateRadioGroup(getBaseContext(), options3, ids3, LinearLayout.HORIZONTAL, false)); //I made the option vertical but this can be horizontal as well
        container.addView(rows);

        //since this field is required we need additional text to display on this
        container.addView(CreateErrorText.CreateErrorText(getBaseContext(), "This field is required", 18, "error_request_rescan", View.GONE));

        //The send Button
        rows = new LinearLayout(getBaseContext());
        rows.setLayoutParams(layout_params);
        rows.setGravity(Gravity.CENTER_VERTICAL);
        rows.setOrientation(LinearLayout.HORIZONTAL);
        rows.setPadding(Utilities.dpToPx(0), Utilities.dpToPx(5), Utilities.dpToPx(0), Utilities.dpToPx(5));
        rows.addView(CreateSubmitButton.CreateSubmitButton(getBaseContext(), "Submit", Utilities.dpToPx(150), 300, this));
        container.addView(rows);

    }


    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case 300:
                //Write Code For Click Here
                Log.e("Test", "Submit Button is Clicked!");
                RadioButton a = (RadioButton) findViewById(15);
                RadioButton b = (RadioButton) findViewById(16);
                TextView error = (TextView) findViewById(18);

                if(!a.isChecked()&&!b.isChecked()){
                    Log.e("Test", "Yes is Checked!");
                    error.setVisibility(View.VISIBLE);
                }else {
                    error.setVisibility(View.GONE);
                }
                break;
            default:
                Log.e("Test", String.valueOf(v.getId()));
                break;
        }
    }
}
