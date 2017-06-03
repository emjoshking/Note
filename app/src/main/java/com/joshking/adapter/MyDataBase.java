package com.joshking.adapter;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.joshking.data.Data;

import java.util.ArrayList;

/**
 * Created by Joshking on 2017/6/3.
 */

public class MyDataBase {

    Context context;
    MyOpenHelper myHelper;
    SQLiteDatabase myDatabase;

    public MyDataBase(Context con){
        this.context=con;
       // myHelper=new MyOpenHelper(context);
        myHelper = new MyOpenHelper(context);
    }

    public ArrayList<Data> getArray(){
        ArrayList<Data> array=new ArrayList<Data>();
        ArrayList<Data> array1=new ArrayList<Data>();
        myDatabase=myHelper.getWritableDatabase();
        Cursor cursor=myDatabase.rawQuery("select ids,title,times from mybook" , null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            int id=cursor.getInt(cursor.getColumnIndex("ids"));
            String title=cursor.getString(cursor.getColumnIndex("title"));
            String times=cursor.getString(cursor.getColumnIndex("times"));
            Data cun=new Data(title, times,id);
            array.add(cun);
            cursor.moveToNext();
        }
        myDatabase.close();
        for (int i = array.size(); i >0; i--) {
            array1.add(array.get(i-1));
        }
        return array1;
    }

    public Data getTiandCon(int id){
        myDatabase=myHelper.getWritableDatabase();
        Cursor cursor=myDatabase.rawQuery("select title,content from mybook where ids='"+id+"'" , null);
        cursor.moveToFirst();
        String title=cursor.getString(cursor.getColumnIndex("title"));
        String content=cursor.getString(cursor.getColumnIndex("content"));
        Data cun=new Data(title,content);
        myDatabase.close();
        return cun;
    }

    public void toUpdate(Data cun){
        myDatabase=myHelper.getWritableDatabase();
        myDatabase.execSQL("update mybook set title='"+ cun.getTitle()+"',times='"+cun.getTimes()+"',content='"+cun.getContent() +"' where ids='"+ cun.getIds()+"'");
        myDatabase.close();
    }

    public void toInsert(Data cun){
        myDatabase=myHelper.getWritableDatabase();
        myDatabase.execSQL("insert into mybook(title,content,times)values('"+ cun.getTitle()+"','"+cun.getContent()+"','"+cun.getTimes()+"')");
        myDatabase.close();
    }

    public void toDelete(int ids){
        myDatabase=myHelper.getWritableDatabase();
        myDatabase.execSQL("delete  from mybook where ids="+ids+"");
        myDatabase.close();
    }
}
