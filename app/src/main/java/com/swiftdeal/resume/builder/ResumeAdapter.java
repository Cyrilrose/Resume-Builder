package com.swiftdeal.resume.builder;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by abhishek on 01-01-2016.
 */
public class ResumeAdapter extends CursorAdapter {
    public static class ViewHolder {
        public final TextView nameView;
        public final TextView ColnameView;
        public final TextView MobView;
        public final TextView degreeView;

        public ViewHolder(View view) {

            nameView = (TextView) view.findViewById(com.swiftdeal.resume.builder.R.id.list_item_name_textview);
            ColnameView = (TextView) view.findViewById(com.swiftdeal.resume.builder.R.id.list_item_college_textview);
            MobView = (TextView) view.findViewById(com.swiftdeal.resume.builder.R.id.list_item_mob_textview);
            degreeView = (TextView) view.findViewById(com.swiftdeal.resume.builder.R.id.list_item_degree_textview);
        }
    }
    public ResumeAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        int viewType = getItemViewType(cursor.getPosition());
        int layoutId = -1;
        layoutId = com.swiftdeal.resume.builder.R.layout.listitem_resume;
        View view = LayoutInflater.from(context).inflate(layoutId, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        view.setTag(viewHolder);

        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        ViewHolder viewHolder = (ViewHolder) view.getTag();
        String name = cursor.getString(fragmentresumedisp.COL_RESUME_NAME);
        viewHolder.nameView.setText(name);
        String colname = cursor.getString(fragmentresumedisp.COL_RESUME_COLNAME);
        viewHolder.ColnameView.setText(colname);
        String mobile = cursor.getString(fragmentresumedisp.COL_RESUME_MOBILE);
        viewHolder.MobView.setText(mobile);
        String degree = cursor.getString(fragmentresumedisp.COL_RESUME_QUALIFY1);
        viewHolder.degreeView.setText(degree);
    }

}
