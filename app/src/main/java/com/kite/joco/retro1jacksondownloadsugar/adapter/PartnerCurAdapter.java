package com.kite.joco.retro1jacksondownloadsugar.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.Filterable;

/**
 * Created by Mester József on 2015.12.14..
 */
public class PartnerCurAdapter extends CursorAdapter implements Filterable {

    Context context;
    Cursor c;

    public PartnerCurAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
        this.context = context;
        this.c =c;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return null;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

    }

    @Override
    public Cursor runQueryOnBackgroundThread(CharSequence constraint) {
        return super.runQueryOnBackgroundThread(constraint);
    }
}
