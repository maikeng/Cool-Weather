package com.xiaohe.coolweather.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by xiaohe on 2017/3/29.
 */

public class CoolWeatherOpenHelper extends SQLiteOpenHelper{

    /**
     *Province表建表语句
     *
     */
    private static  final String CREATE_PROVINCE ="create table Province("
            +"id interer primary key autoincrement,"
            +"province_name text,"
            +"province_code text)";

    /**
     *
     * city表建表语句
     */
    private static final String CREATE_CITY ="create table City("
            +"id integer primary key autoincrement,"
            +"city_name text,"
            +"city_code text,"
            +"province_id integer)";

    /**
     *
     * country表建表语句
     */
    private static final String CREATE_COUNTRY ="create table Country("
            +"id integer primary key autoincrement,"
            +"country_name text,"
            +"country_code text,"
            +"city_id integer)";

    public  CoolWeatherOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory
                                      factory,int version){
        super(context,name,factory,version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PROVINCE);//创建province表
        db.execSQL(CREATE_CITY);//创建city表
        db.execSQL(CREATE_COUNTRY);//创建country表
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
