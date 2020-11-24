package com.example.checkbox;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class questionAdapter extends ArrayAdapter<eachquestion> {
    RadioGroup radioUser;

    private static final String TAG = "questionAdapter";

    public questionAdapter(Context context, ArrayList<eachquestion> questions) {
        super(context, 0, questions);


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.question_list, parent, false);
        }



        eachquestion currentWord = getItem(position);



        TextView quesnumTextView = (TextView) listItemView.findViewById(R.id.ques_num);


        quesnumTextView.setText(currentWord.getMquestion_num());

        TextView quesTextView = (TextView) listItemView.findViewById(R.id.ques);

        quesTextView.setText(currentWord.getMquestion());

        TextView optiona = (TextView) listItemView.findViewById(R.id.optionA);

        optiona.setText(currentWord.getMoptionA());
        optiona.setTag("1");

        TextView optionb = (TextView) listItemView.findViewById(R.id.optionB);

        optionb.setText(currentWord.getMoptionB());
        optionb.setTag("2");

        TextView optionc = (TextView) listItemView.findViewById(R.id.optionC);

        optionc.setText(currentWord.getMoptionC());
        optionc.setTag("3");
        TextView optiond = (TextView) listItemView.findViewById(R.id.optionD);
        optiond.setText(currentWord.getMoptionD());
        optiond.setTag("4");

        TextView correctans = (TextView) listItemView.findViewById(R.id.correctans);


        correctans.setText("");//just for reference

        Button save=(Button)listItemView.findViewById(R.id.save);
        RadioGroup radioGroup=listItemView.findViewById(R.id.radioUser);
        View finalListItemView = listItemView;
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checkedid=radioGroup.getCheckedRadioButtonId();

                RadioButton rb = finalListItemView.findViewById(checkedid);
                Log.d(TAG, "onClick: "+rb.getText().toString());
                String userRes = rb.getTag().toString();

                Log.d(TAG, "onClick: Before Save -CurWord"+currentWord.getMuserResponse());
                currentWord.setMuserResponse(userRes);
                Log.d(TAG, "onClick: After Save CurWord"+currentWord.getMuserResponse());


            }


        });


        return listItemView;
    }

}