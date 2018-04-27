package com.example.android.miwok;

import android.app.Activity;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId) {


        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);

        mColorResourceId = colorResourceId;
    }


    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_items, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
       Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView item_1TextView = (TextView) listItemView.findViewById(R.id.item_1);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        item_1TextView.setText(currentWord.getmMiwokeTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.item_2);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());
        //Find the ImageView in the list_view.xml
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.imageView);

        if(currentWord.hasImage()) {
            //Set the current word to have a specific Image
            iconView.setImageResource(currentWord.getImageView());

            //Make sure view is Visible
            iconView.setVisibility(View.VISIBLE);
        }
        else {//Otherwise hid Visibility
            iconView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.text_container);

        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
