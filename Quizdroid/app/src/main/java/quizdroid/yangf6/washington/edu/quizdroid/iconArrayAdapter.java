package quizdroid.yangf6.washington.edu.quizdroid;

/**
 * Created by apple on 2/14/17.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;



public class iconArrayAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    public iconArrayAdapter(Context context, String[] values) {
        super(context, R.layout.icon_layout, values);
        this.context = context;
        this.values = values;
    }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.icon_layout, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.label);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        textView.setText(values[position]);

        imageView.setImageResource(R.mipmap.ic_launcher);


        return rowView;
    }

}
