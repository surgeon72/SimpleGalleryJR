package dronsntu.simplegalleryjr.appconst;

import android.content.Context;
import android.graphics.Point;
import android.support.v7.app.AlertDialog;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by ETP-ACER on 20.12.2015.
 */

public class functions {
    private Context _context;
    public functions(Context context) {
        this._context = context;
    }
    public ArrayList<String> getFilePaths() {
        ArrayList<String> filePaths = new ArrayList<String>();
        File directory = new File(android.os.Environment.getExternalStorageDirectory()+ File.separator + AppConst.PHOTO_ALBUM);
        if (directory.isDirectory()) {// directory check
            File[] listFiles = directory.listFiles();//file paths list
            if (listFiles.length > 0) {
                for (int i = 0; i < listFiles.length; i++) {
                    String filePath = listFiles[i].getAbsolutePath();// get file path
                    if (IsSupportedFile(filePath)) {
                        filePaths.add(filePath);// Add image path to array list
                    }
                }
                }
                else {
                    Toast.makeText(_context, AppConst.PHOTO_ALBUM
                            +" is empty. Please load some images in it !", Toast.LENGTH_LONG).show();
            }
        }
        else {
            AlertDialog.Builder alert = new AlertDialog.Builder(_context);
            alert.setTitle("Err!");
            alert.setMessage(AppConst.PHOTO_ALBUM
                    + " directory path is missing. Set the image directory name in AppConst.java class");
            alert.setPositiveButton("OK", null);
            alert.show();
        }
        return filePaths;
    }
    private boolean IsSupportedFile(String filePath) {
        String ext = filePath.substring((filePath.lastIndexOf(".") + 1), filePath.length());
        if (AppConst.FILE_EXTN.contains(ext.toLowerCase(Locale.getDefault())))
            return true;
        else
            return false;
    }
@SuppressWarnings("deprecation")
   public int getScreenWidth() {
        int columnWidth;
        WindowManager wm = (WindowManager) _context
                .getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();

        final Point point = new Point();
        try {
            display.getSize(point);
        } catch (java.lang.NoSuchMethodError ignore) { // Older device
            point.x = display.getWidth();
            point.y = display.getHeight();
        }
        columnWidth = point.x;
        return columnWidth;
    }
}