package com.culiu.sample.fatlistview;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.TextView;

import com.culiu.common.widget.PinnedHeaderListView;
import com.culiu.common.widget.SectionedBaseAdapter;

public class DemoActivity extends Activity {

    private String[] mSectionAStringArray;
    private String[] mSectionBStringArray;
    private String[] mSectionCStringArray;
    private String[] mSectionDStringArray;

    private SectionedBaseAdapter mListViewAdapter = new SectionedBaseAdapter() {

        @Override
        public Object getItem(int section, int position) {
            return null;
        }

        @Override
        public long getItemId(int section, int position) {
            return position;
        }

        @Override
        public int getSectionCount() {
            return 4;
        }

        @Override
        public int getCountForSection(int section) {
            switch (section) {
                case 0:
                    return mSectionAStringArray.length;
                case 1:
                    return mSectionBStringArray.length;
                case 2:
                    return mSectionCStringArray.length;
                case 3:
                    return mSectionDStringArray.length;
                default:
                    return 0;
            }
        }

        @Override
        public View getItemView(int section, int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                TextView textView = new TextView(DemoActivity.this);
                textView.setLayoutParams(new AbsListView.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
                textView.setTextColor(Color.WHITE);
                textView.setPadding(10, 10, 10, 10);
                textView.setBackgroundColor(Color.BLACK);
                textView.setTextSize(13);
                convertView = textView;
            }

            String[] dataArray = null;
            switch (section) {
                case 0:
                    dataArray = mSectionAStringArray;
                    break;
                case 1:
                    dataArray = mSectionBStringArray;
                    break;
                case 2:
                    dataArray = mSectionCStringArray;
                    break;
                case 3:
                    dataArray = mSectionDStringArray;
                    break;
                default:
                    break;
            }

            TextView textView = (TextView) convertView;
            textView.setText(dataArray[position]);

            return convertView;
        }

        @Override
        public View getSectionHeaderView(int section, View convertView, ViewGroup parent) {

            if (convertView == null) {
                TextView textView = new TextView(DemoActivity.this);
                textView.setLayoutParams(new AbsListView.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
                textView.setTextColor(Color.RED);
                textView.setPadding(10, 10, 10, 10);
                textView.setBackgroundColor(Color.YELLOW);
                textView.setTextSize(15);
                convertView = textView;
            }

            TextView textView = (TextView) convertView;
            switch (section) {
                case 0:
                    textView.setText("A Group");
                    break;
                case 1:
                    textView.setText("B Group");
                    break;
                case 2:
                    textView.setText("C Group");
                    break;
                case 3:
                    textView.setText("D Group");
                    break;
                default:
                    break;
            }

            return convertView;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        mSectionAStringArray = getResources().getStringArray(R.array.section_a_strings);
        mSectionBStringArray = getResources().getStringArray(R.array.section_b_strings);
        mSectionCStringArray = getResources().getStringArray(R.array.section_c_strings);
        mSectionDStringArray = getResources().getStringArray(R.array.section_d_strings);

        PinnedHeaderListView listView = (PinnedHeaderListView)
                this.findViewById(R.id.list_view);
        listView.setAdapter(mListViewAdapter);
    }
}
