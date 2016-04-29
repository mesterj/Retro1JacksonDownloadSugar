package com.kite.joco.retro1jacksondownloadsugar;

import android.app.Application;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FilterQueryProvider;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.kite.joco.retro1jacksondownloadsugar.entity.Dolgozok;
import com.kite.joco.retro1jacksondownloadsugar.entity.Partner;
import com.kite.joco.retro1jacksondownloadsugar.rest.DownloadAPI;
import com.kite.joco.retro1jacksondownloadsugar.rest.ServiceGenerator;
import com.orm.SugarRecord;
import com.orm.query.Condition;
import com.orm.query.Select;
import com.orm.util.NamingHelper;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    public static final String LOGTAG = "PROBA";
    EditText etPsKod;
    String ps;
    AutoCompleteTextView atvSearchByNev;

    SimpleCursorAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etPsKod = (EditText) findViewById(R.id.etPskod);

//        Field [] fields = SugarDb.class.getDeclaredFields();
        String [] psdb_nev = {"valami"};
        Log.i(LOGTAG,"A Partner db valódi neve: "+ psdb_nev);
        Log.i(LOGTAG,"A partnerKod mező neve: " +NamingHelper.toSQLNameDefault("partnerKod"));
        Cursor c = SugarRecord.getCursor(Partner.class," partner_nev = ?",psdb_nev,null,null,null);

                /*Log.i(LOGTAG, "Getting fields");
        for (int i=0;i<fields.length;i++){
            Log.i(LOGTAG,fields[i].getName());
        }*/

        atvSearchByNev = (AutoCompleteTextView) findViewById(R.id.atvSearchNev);

        mAdapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_1,null,
                new String[] {ContactsContract.Contacts.DISPLAY_NAME},new int[]{android.R.id.text1},0);


    atvSearchByNev.setAdapter(mAdapter);

    /*mAdapter.setFilterQueryProvider(new FilterQueryProvider() {
        @Override
        public Cursor runQuery(CharSequence constraint) {
            return null;
        }
    });

    mAdapter.setCursorToStringConverter(new SimpleCursorAdapter.CursorToStringConverter() {
        @Override
        public CharSequence convertToString(Cursor cursor) {
            return null;
        }
    });

    public Cursor getCursor(CharSequence str) {
        Iterator<Partner> cursor = Select.from(Partner.class).where(Condition.prop("partner_nev").like("%" + str + "%")).iterator();
        //SugarRecord.findAsIterator(Partner.class," partner_nev =? ", "%"+str+"%").

        //db = ((Application)SugarApp.sc.obtainDatabase();
        //SugarContext sc = SugarContext.getSugarContext();


        //Cursor c = SugarCursorFactory.newCursor((Application) SugarApp.getSugarContext()).obtainDatabase()
        //Cursor ujcursor = cursor.
    }*/
}


    public void onClick(View v){
        DownloadAPI service = ServiceGenerator.createService(DownloadAPI.class);
       /* service.getAsyncListofNyomtatvany(new Callback<List<Nyomtatvany>>() {
            @Override
            public void success(List<Nyomtatvany> nyomtatvanies, Response response) {
                for (Nyomtatvany ny : nyomtatvanies) {
                    Log.i("Lista ", "kod : " + ny.getNyomtKod() + " nev " + ny.getNyomtNev());
                    ny.save();
                }
            }

            @Override
            public void failure(RetrofitError error) {
                Log.i("Nyomtatvany lista", "sikertelen");
            }
        });*/
        //Log.i("kod",service.toString());
        //List<Nyomtatvany> nyomtatvanyList = service.getListofNyomtatvany();
        //for (Nyomtatvany ny:nyomtatvanyList){
         //   Log.i("Nyomtatvany","Kod " +ny.getNyomtKod());
       // }

        service.getAsyncListofPartner(new Callback<List<Partner>>() {
            @Override
            public void success(List<Partner> partners, Response response) {
                Calendar newcal = Calendar.getInstance(new Locale("HU"));
                Log.i("A mentés elkezdődött: ", newcal.getTime().toString());
                SugarRecord.saveInTx(partners);
                Calendar lastcal = Calendar.getInstance(new Locale("HU"));
                Log.i("A mentés befejeződött: ", lastcal.getTime().toString());
            }

            @Override
            public void failure(RetrofitError error) {
                Log.i("error", " nem sikerült a partnerek feldolgozása" + error.getMessage());
            }
        });

        Calendar c = new GregorianCalendar(1970,1,1,10,5);


     /*   Date d = c.getTime();
        //long timestamp = Calendar.getInstance().getTime() / 1000
        long timestamp = c.getTimeInMillis() / 1000;
        Log.i("real timestamp", " " + timestamp);

        service.getDolgozokbyModiTime(timestamp, new Callback<List<Dolgozok>>() {
            @Override
            public void success(List<Dolgozok> dolgozoks, Response response) {
                for (Dolgozok dolgozo : dolgozoks) {
                    Log.i("Dolgozok", dolgozo.getNev());
                }
            }

            @Override
            public void failure(RetrofitError error) {
                Log.i("Dolgozok ido szerint", "failure" + error.getResponse() + error.getMessage());
            }
        });*/

    }

    public void searchByPs(View v) {
        String keresett = etPsKod.getText().toString();
       /* try {
            List<Partner> partnerList = Partner.find(Partner.class, "partner_kod = ?", "100022");
            //Log.i(LOGTAG,NamingHelper.toSQLName(Partner.fie));
            if (partnerList == null) {
                Log.i(LOGTAG, "Object.find nem sikerült");
            } else {
                Partner p = partnerList.get(0);
                Log.i(LOGTAG, "Tanáltam egy partnert: " + p.getPartnerNev());
                Toast.makeText(this, "Talált partner az object.find" + p.getPartnerNev(), Toast.LENGTH_LONG).show();
            }
        }
        catch (Exception ex) {
            Log.i(LOGTAG,"Object.find nem jött be partnerkod"+ ex.getMessage());
        }*/



        try {
            ps = NamingHelper.toSQLName(Partner.class.getField("partner_kod"));
        }
        catch (NoSuchFieldException nex ){
            Log.i(LOGTAG,nex.getMessage()+" partner_kod nem jó");
            ps = "partner_kod";
        }
        try {

            //String ps = NamingHelper.toSQLName(Partner.class.getField("partnerKod"));
            //Log.i(LOGTAG,"A naminghelper által megtalált mezőnév a partnerKod-hoz:" + ps);
            List<Partner> partners = Select.from(Partner.class).where(Condition.prop(ps).eq(keresett)).list();
            if (partners == null || partners.size() == 0 ) {
                Log.i(LOGTAG, "Select.from NamingHelperrel nem jött be. ");
            } else {
                Partner p = partners.get(0);
                Log.i(LOGTAG, "Tanáltam egy partnert a select.from naminHelperrel: " + p.getPartnerNev());
                Toast.makeText(this, "Talált partner" + p.getPartnerNev(), Toast.LENGTH_LONG).show();
            }
        }catch (Exception ex){
            Log.i(LOGTAG,"Select nem jött be"+ex.getMessage());
        }
    }

}
