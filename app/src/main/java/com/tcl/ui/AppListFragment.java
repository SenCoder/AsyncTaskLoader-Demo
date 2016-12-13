package com.tcl.ui;

import android.content.Loader;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager;

import com.lidroid.xutils.util.LogUtils;
import com.tcl.async.model.AppEntry;
import com.tcl.async.model.AppListLoader;

import java.util.List;


public class AppListFragment extends ListFragment {

    private static final boolean DEBUG = true;
    private AppListAdapter mAdapter;
    private static final int LOADER_ID = 1;

    LoaderManager.LoaderCallbacks<List<AppEntry>> mCallbacks = new LoaderManager.LoaderCallbacks<List<AppEntry>>() {
        @Override
        public android.support.v4.content.Loader<List<AppEntry>> onCreateLoader(int id, Bundle args) {
            return null;
        }

        @Override
        public void onLoadFinished(android.support.v4.content.Loader<List<AppEntry>> loader, List<AppEntry> data) {

        }

        @Override
        public void onLoaderReset(android.support.v4.content.Loader<List<AppEntry>> loader) {

        }
//
    };

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
        mAdapter = new AppListAdapter(getActivity());
        setEmptyText("No Applications");
        setListAdapter(mAdapter);
        setListShown(false);

        if (getLoaderManager().getLoader(LOADER_ID) == null) {
            LogUtils.d("Initializing the new Loader...");
        } else {
            LogUtils.d("Reconnecting with existing Loader (id '1')...");
        }
        getLoaderManager().initLoader(LOADER_ID, null, mCallbacks);
    }
}
