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
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.kahel.sampledynamicview.customgenatedviews.CreateDropDown;
import com.kahel.sampledynamicview.customgenatedviews.CreateEditText;
import com.kahel.sampledynamicview.customgenatedviews.CreateErrorText;
import com.kahel.sampledynamicview.customgenatedviews.CreateRadioGroup;
import com.kahel.sampledynamicview.customgenatedviews.CreateSubmitButton;
import com.kahel.sampledynamicview.customgenatedviews.CreateTextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends ActionBarActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener{

    @Bind(R.id.ll_container)
    ScrollView container_main;
    @Bind(R.id.btn_create) Button create_button;

    TableLayout container;
    TableRow rows;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = new TableLayout(getBaseContext());
        LinearLayout.LayoutParams layout_params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        container.setLayoutParams(layout_params);


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

        //loop on this to check number of elements and base the column count based on it

        //Create header
        rows = new TableRow(getBaseContext());
        rows.setLayoutParams(layout_params);
        rows.setGravity(Gravity.CENTER_VERTICAL);
        rows.setOrientation(LinearLayout.HORIZONTAL);
        rows.setPadding(Utilities.dpToPx(0), Utilities.dpToPx(5), Utilities.dpToPx(0), Utilities.dpToPx(5));
        rows.addView(CreateTextView.CreateTextView(getBaseContext(), "<b><u>Concordance Case Study Report Forms</u></b>", 0,4));
        container.addView(rows);

        //Create 1st layer
        //sample options fetched from JSON if ever
        String[] options = {"Whole Slide Image","Microscope Slide"};
        int[] ids = {2,3};

        rows = new TableRow(getBaseContext());
        rows.setLayoutParams(layout_params);
        rows.setGravity(Gravity.CENTER_VERTICAL);
        rows.setOrientation(LinearLayout.HORIZONTAL);
        rows.setPadding(Utilities.dpToPx(0), Utilities.dpToPx(5), Utilities.dpToPx(0), Utilities.dpToPx(5));
        rows.addView(CreateTextView.CreateTextView(getBaseContext(), "Modality", 1, 1));
        rows.addView(CreateRadioGroup.CreateRadioGroup(getBaseContext(),this, options, ids, LinearLayout.HORIZONTAL,true, 1)); //I made the option vertical but this can be horizontal as well
        container.addView(rows);

        //2nd layer
        rows = new TableRow(getBaseContext());
        rows.setLayoutParams(layout_params);
        rows.setGravity(Gravity.CENTER_VERTICAL);
        rows.setOrientation(LinearLayout.HORIZONTAL);
        rows.setPadding(Utilities.dpToPx(0), Utilities.dpToPx(5), Utilities.dpToPx(0), Utilities.dpToPx(5));
        rows.addView(CreateTextView.CreateTextView(getBaseContext(), "Pathologist:", 4, 1));
        rows.addView(CreateEditText.CreateEditText(getBaseContext(), "", "", Utilities.dpToPx(120), 5, 1));
        rows.addView(CreateTextView.CreateTextView(getBaseContext(), "Case Number:", 6, 1));
        rows.addView(CreateEditText.CreateEditText(getBaseContext(), "", "", Utilities.dpToPx(50), 7, 1));
        container.addView(rows);

        //3rd layer
        rows = new TableRow(getBaseContext());
        rows.setLayoutParams(layout_params);
        rows.setGravity(Gravity.CENTER_VERTICAL);
        rows.setOrientation(LinearLayout.HORIZONTAL);
        rows.setPadding(Utilities.dpToPx(0), Utilities.dpToPx(5), Utilities.dpToPx(0), Utilities.dpToPx(5));
        rows.addView(CreateTextView.CreateTextView(getBaseContext(), "# of Slides:", 8, 1));
        rows.addView(CreateEditText.CreateEditText(getBaseContext(), "", "",Utilities.dpToPx(50), 9, 1));
        rows.addView(CreateTextView.CreateTextView(getBaseContext(), "# of Images:", 10, 1));
        rows.addView(CreateEditText.CreateEditText(getBaseContext(), "", "",Utilities.dpToPx(50), 11, 1));
        container.addView(rows);

        //4th layer
        //sample options fetched from JSON if ever
        String[] options2 = {"Interpret","Defer"};
        int[] ids2 = {12,13};

        rows = new TableRow(getBaseContext());
        rows.setLayoutParams(layout_params);
        rows.setGravity(Gravity.CENTER_VERTICAL);
        rows.setOrientation(LinearLayout.HORIZONTAL);
        rows.setPadding(Utilities.dpToPx(0), Utilities.dpToPx(5), Utilities.dpToPx(0), Utilities.dpToPx(5));
        rows.addView(CreateTextView.CreateTextView(getBaseContext(), "Case Type:", 14, 1));
        rows.addView(CreateRadioGroup.CreateRadioGroup(getBaseContext(),this, options2, ids2, LinearLayout.HORIZONTAL, false, 1)); //I made the option vertical but this can be horizontal as well
        container.addView(rows);

        //5th layer
        //sample options fetched from JSON if ever
        String[] options3 = {"Yes","No"};
        int[] ids3 = {15,16};

        rows = new TableRow(getBaseContext());
        rows.setLayoutParams(layout_params);
        rows.setGravity(Gravity.CENTER_VERTICAL);
        rows.setOrientation(LinearLayout.HORIZONTAL);
        rows.setPadding(Utilities.dpToPx(0), Utilities.dpToPx(5), Utilities.dpToPx(0), Utilities.dpToPx(5));
        rows.addView(CreateTextView.CreateTextView(getBaseContext(), "Rescan Request", 17, 1));
        rows.addView(CreateRadioGroup.CreateRadioGroup(getBaseContext(),this, options3, ids3, LinearLayout.HORIZONTAL, false, 1)); //I made the option vertical but this can be horizontal as well
        container.addView(rows);

        //since this field is required we need additional text to display on this
        container.addView(CreateErrorText.CreateErrorText(getBaseContext(), "This field is required", 18, "error_request_rescan", View.GONE, 1));

        //The interpret view that can hide and show
        String[] sample_items = {"Item1", "Item2", "Item3"};

        rows = new TableRow(getBaseContext());
        rows.setLayoutParams(layout_params);
        rows.setGravity(Gravity.CENTER_VERTICAL);
        rows.setOrientation(LinearLayout.HORIZONTAL);
        rows.setPadding(Utilities.dpToPx(0), Utilities.dpToPx(25), Utilities.dpToPx(0), Utilities.dpToPx(5));
        rows.addView(CreateTextView.CreateTextView(getBaseContext(), "Cancer Protocol", 19, 1));
        rows.addView(CreateDropDown.CreateDropDown(getBaseContext(), sample_items, Utilities.dpToPx(100), 20, 1));
        rows.setId(100);
        container.addView(rows);

        rows = new TableRow(getBaseContext());
        rows.setLayoutParams(layout_params);
        rows.setGravity(Gravity.CENTER_VERTICAL);
        rows.setOrientation(LinearLayout.HORIZONTAL);
        rows.setPadding(Utilities.dpToPx(0), Utilities.dpToPx(5), Utilities.dpToPx(0), Utilities.dpToPx(5));
        rows.addView(CreateTextView.CreateTextView(getBaseContext(), "Diagnosis", 21, 1));
        rows.setId(101);
        container.addView(rows);

        rows = new TableRow(getBaseContext());
        rows.setLayoutParams(layout_params);
        rows.setGravity(Gravity.CENTER_VERTICAL);
        rows.setOrientation(LinearLayout.HORIZONTAL);
        rows.setPadding(Utilities.dpToPx(0), Utilities.dpToPx(5), Utilities.dpToPx(0), Utilities.dpToPx(5));
        rows.addView(CreateEditText.CreateEditText(getBaseContext(), "", "", Utilities.dpToPx(50), 22, 3, 3));
        rows.setId(102);
        container.addView(rows);


        rows = new TableRow(getBaseContext());
        rows.setLayoutParams(layout_params);
        rows.setGravity(Gravity.CENTER_VERTICAL);
        rows.setOrientation(LinearLayout.HORIZONTAL);
        rows.setPadding(Utilities.dpToPx(0), Utilities.dpToPx(5), Utilities.dpToPx(0), Utilities.dpToPx(5));
        rows.addView(CreateTextView.CreateTextView(getBaseContext(), "Reason for Case defferal:", 21, 1));
        rows.setId(103);
        container.addView(rows);

        rows = new TableRow(getBaseContext());
        rows.setLayoutParams(layout_params);
        rows.setGravity(Gravity.CENTER_VERTICAL);
        rows.setOrientation(LinearLayout.HORIZONTAL);
        rows.setPadding(Utilities.dpToPx(0), Utilities.dpToPx(5), Utilities.dpToPx(0), Utilities.dpToPx(5));
        rows.addView(CreateEditText.CreateEditText(getBaseContext(), "", "", Utilities.dpToPx(50), 22, 3, 3));
        rows.setId(104);
        container.addView(rows);


        //The send Button
        rows = new TableRow(getBaseContext());
        rows.setLayoutParams(layout_params);
        rows.setGravity(Gravity.CENTER_VERTICAL);
        rows.setOrientation(LinearLayout.HORIZONTAL);
        rows.setPadding(Utilities.dpToPx(0), Utilities.dpToPx(5), Utilities.dpToPx(0), Utilities.dpToPx(5));
        rows.addView(CreateSubmitButton.CreateSubmitButton(getBaseContext(), "Submit", Utilities.dpToPx(150), 300, this, 4));
        container.addView(rows);

        container_main.addView(container);


        hideShowContent(100, View.GONE);
        hideShowContent(101, View.GONE);
        hideShowContent(102, View.GONE);
        hideShowContent(103, View.GONE);
        hideShowContent(104, View.GONE);

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
                    Log.e("Test", "Yes is not Checked!");
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

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        RadioButton button = (RadioButton) findViewById(i);

        switch (i){
            case 12:
                if(button.isChecked()){
                    Log.e("Test", "Checked 12!");
                    hideShowContent(100, View.VISIBLE);
                    hideShowContent(101, View.VISIBLE);
                    hideShowContent(102, View.VISIBLE);
                    hideShowContent(103, View.GONE);
                    hideShowContent(104, View.GONE);
                }
                break;
            case 13:
                if(button.isChecked()){
                    Log.e("Test", "Checked 13!");
                    hideShowContent(100, View.GONE);
                    hideShowContent(101, View.GONE);
                    hideShowContent(102, View.GONE);
                    hideShowContent(103, View.VISIBLE);
                    hideShowContent(104, View.VISIBLE);
                }
                break;
            default:
                Log.e("Test", "Other is checked!");
        }
    }

    private void hideShowContent(int id, int visibility){

        TableRow layout = (TableRow) container_main.findViewById(id);
        Log.e("Test", String.valueOf(layout.getChildCount()));

        for (int i = 0; i < layout.getChildCount(); i++) {
            View child = layout.getChildAt(i);
            child.setVisibility(visibility);
        }

    }
}
