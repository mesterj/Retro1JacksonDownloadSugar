package com.kite.joco.retro1jacksondownloadsugar.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.Filterable;
import android.widget.TextView;

import com.kite.joco.retro1jacksondownloadsugar.R;

/**
 * Created by Mester József on 2015.12.14..
 */
public class PartnerCurAdapter extends CursorAdapter implements Filterable {

    Context context;
    Cursor c;
    private LayoutInflater cursorInflater;

    public PartnerCurAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
        this.context = context;
        this.c = c;
        cursorInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return cursorInflater.inflate(R.layout.partner_row, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tvPartnerNev = (TextView) view.findViewById(R.id.tvPartnerNev);
        String nev = cursor.getString(cursor.getColumnIndex("PARTNER_NEV"));
        tvPartnerNev.setText(nev);

        TextView tvPartnerKod = (TextView) view.findViewById(R.id.tvPartnerKod);
        String kod = cursor.getString(cursor.getColumnIndex("PARTNER_KOD"));
        tvPartnerKod.setText(kod);
    }

    @Override
    public CharSequence convertToString(Cursor cursor) {
        int j = cursor.getColumnIndex("PARTNER_KOD");
        return cursor.getString(j);
    }

    @Override
    public Cursor runQueryOnBackgroundThread(CharSequence constraint) {
        return super.runQueryOnBackgroundThread(constraint);
    }
}
