package com.kahel.sampledynamicview;

import android.content.res.Resources;

/**
 * Created by Mark on 8/30/2016.
 */
public class Utilities {
    public static int dpToPx(int dp)
    {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }
}
