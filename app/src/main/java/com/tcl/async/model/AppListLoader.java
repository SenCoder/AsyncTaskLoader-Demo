package com.tcl.async.model;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.pm.PackageManager;

import java.text.Collator;
import java.util.Comparator;
import java.util.List;

/**
 * Created by shengyuan on 16-12-13.
 */

public class AppListLoader extends AsyncTaskLoader<List<AppEntry>> {

    private static final boolean DEBUG = true;
    final PackageManager mPackageManager;
    private List<AppEntry> mAppEntries;


    public AppListLoader(Context context) {
        super(context);
        mPackageManager = context.getPackageManager();
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
    }

    @Override
    protected void onForceLoad() {
        super.onForceLoad();
    }

    @Override
    public List<AppEntry> loadInBackground() {
        return null;
    }

    @Override
    public void deliverResult(List<AppEntry> data) {
        super.deliverResult(data);
    }

    @Override
    protected void onStopLoading() {
        super.onStopLoading();
    }

    @Override
    protected void onReset() {
        super.onReset();
    }

    @Override
    public void onCanceled(List<AppEntry> data) {
        super.onCanceled(data);
    }

    /**
     * Helper method to take care of releasing resources associated with an
     * actively loaded data set.
     */
    private void releaseResources(List<AppEntry> apps) {
        // For a simple List, there is nothing to do. For something like a Cursor,
        // we would close it in this method. All resources associated with the
        // Loader should be released here.
    }

    /**
     * Performs alphabetical comparison of {@link AppEntry} objects. This is
     * used to sort queried data in {@link }.
     */
    private static final Comparator<AppEntry> ALPHA_COMPARATOR = new Comparator<AppEntry>() {
        Collator sCollator = Collator.getInstance();

        @Override
        public int compare(AppEntry object1, AppEntry object2) {
            return sCollator.compare(object1.getLabel(), object2.getLabel());
        }
    };

}
