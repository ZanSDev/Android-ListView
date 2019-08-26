package id.zein.wisataapps;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;


public class CustomListAdapterActivity extends ArrayAdapter<ModelRowItemActivity> {
    Context context;

    public CustomListAdapterActivity(Context context, int resourceId, List<ModelRowItemActivity> items) {
        super(context, resourceId, items);
        this.context = context;
    }

    /*private view holder class*/
    private class ViewHolder {
        ImageView imageView;
        TextView txtTitle;
        TextView txtDesc;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        ModelRowItemActivity modelRowItem = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_adapter_activity, null);
            holder = new ViewHolder();
            holder.txtDesc = convertView.findViewById(R.id.txt_keterangan);
            holder.txtTitle = convertView.findViewById(R.id.txt_judul);
            holder.imageView = convertView.findViewById(R.id.img_item_photo);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        holder.txtDesc.setText(modelRowItem.getDesc());
        holder.txtTitle.setText(modelRowItem.getTitle());
        holder.imageView.setImageResource(modelRowItem.getImage());

        return convertView;
    }
}
