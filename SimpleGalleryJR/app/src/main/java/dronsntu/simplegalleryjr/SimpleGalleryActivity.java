package dronsntu.simplegalleryjr;

import dronsntu.simplegalleryjr.adapter.SimpleGalleryAdapter;
import dronsntu.simplegalleryjr.appconst.AppConst;
import dronsntu.simplegalleryjr.appconst.functions;

import java.util.ArrayList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.res.Resources;
import android.util.TypedValue;
import android.widget.GridView;

public class SimpleGalleryActivity extends AppCompatActivity {
    private functions functions;
    private ArrayList<String> imagePaths = new ArrayList<String>();
    private SimpleGalleryAdapter adapter;
    private GridView gridView;
    private int columnWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_gallery);
        gridView = (GridView) findViewById(R.id.grid_view);
        functions = new functions(this);
        InitilizeGridLayout();
        imagePaths = functions.getFilePaths();
        adapter = new SimpleGalleryAdapter(SimpleGalleryActivity.this, imagePaths, columnWidth);
        gridView.setAdapter(adapter);
    }
    private void InitilizeGridLayout() {
        Resources r = getResources();
        float padding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, AppConst.GRID_PADDING, r.getDisplayMetrics());
        columnWidth = (int) ((functions.getScreenWidth() - ((AppConst.NUM_OF_COLUMNS + 1) * padding)) / AppConst.NUM_OF_COLUMNS);
        gridView.setNumColumns(AppConst.NUM_OF_COLUMNS);
        gridView.setColumnWidth(columnWidth);
        gridView.setStretchMode(GridView.NO_STRETCH);
        gridView.setPadding((int) padding, (int) padding, (int) padding, (int) padding);
        gridView.setHorizontalSpacing((int) padding);
        gridView.setVerticalSpacing((int) padding);
    }
}
