package com.example.finalsports;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;

import java.util.ArrayList;

public class Custom_Adapter extends ArrayAdapter<Custom_Choice> {
    private static final String LOG_TAG = Custom_Adapter.class.getSimpleName();

    public Custom_Adapter(Activity context, ArrayList<Custom_Choice> custom_choices) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, custom_choices);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.updated_choice, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Custom_Choice choice=getItem(position);
        CheckedTextView checkedTextView=(CheckedTextView) listItemView.findViewById(R.id.checkedTextView);
        checkedTextView.setText(choice.getMessage());
        checkedTextView.setChecked(choice.isChecked());
        return listItemView;
    }
}
