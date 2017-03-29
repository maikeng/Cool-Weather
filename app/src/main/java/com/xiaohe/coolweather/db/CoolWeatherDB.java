package com.xiaohe.coolweather.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.xiaohe.coolweather.model.City;
import com.xiaohe.coolweather.model.Country;
import com.xiaohe.coolweather.model.Province;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by xiaohe on 2017/3/29.
 */

public class CoolWeatherDB {
    /**
     * 数据库名
     */
    private static  final String DB_NAME = "cool_weather";
    /**
     * 数据库版本
     */
    private static  final int VERSION = 1;

    private static CoolWeatherDB coolWeatherDB;
    private SQLiteDatabase db;

    /**
     * 将构造方法私有化
     */
    private CoolWeatherDB(Context context){
        CoolWeatherOpenHelper openHelper = new CoolWeatherOpenHelper(context,DB_NAME,null,VERSION);
        db = openHelper.getWritableDatabase();
    }
      /**
     * 获取CoolWeatherDB实例
     */
    public  synchronized static CoolWeatherDB getInstance(Context context){
        if (coolWeatherDB==null){
            coolWeatherDB = new CoolWeatherDB(context);
        }
        return coolWeatherDB;
    }
    /**
     * 将province储存到数据库
     */

    public void saveProvince(Province province){
        if (province!=null){
            ContentValues values = new ContentValues();
            values.put("province_name",province.getProvinceName());
            values.put("province_code",province.getProvinceCode());
            db.insert("Province",null,values);
        }
    }
    /**
     * 从数据库读取所有省份的信息
     * cursor是每行的集合
     */
    public List<Province> readProvinces(){
        List<Province> list = new ArrayList<Province>();
        Cursor cursor = db.query("Province",null,null,null,null,null,null);
        if (cursor.moveToFirst()){
            do {
                Province province = new Province();
                province.setId(cursor.getInt(cursor.getColumnIndex("id")));
                province.setProvinceName(cursor.getString(cursor.getColumnIndex("province_name")));
                province.setProvinceCode(cursor.getString(cursor.getColumnIndex("province_code")));
                list.add(province);
            }while (cursor.moveToNext());
        }
        return list;
    }
    /**
     * 将city存入数据库
     */
    public void saveCity(City city){
        if (city!=null){
            ContentValues values = new ContentValues();
            values.put("City",city.getCityName());
            values.put("City",city.getCityCode());
            db.insert("City",null,values);
        }
    }
    /**
     * 从数据库读取所有城市的信息
     */

    public List<City> readCitys(){
        List<City> list = new ArrayList<City>();
        Cursor cursor = db.query("City",null,null,null,null,null,null);
        if (cursor.moveToFirst()){
            do {
                City city = new City();
                city.setId(cursor.getInt(cursor.getColumnIndex("id")));
                city.setCityName(cursor.getString(cursor.getColumnIndex("city_name")));
                city.setCityCode(cursor.getString(cursor.getColumnIndex("city_code")));
                list.add(city);
            }while (cursor.moveToNext());
        }
        return list;
    }
    /**
     *将country存入数据库
     */
    public void saveCountry(Country country){
        if (country!=null){
            ContentValues values = new ContentValues();
            values.put("Country",country.getCountryName());
            values.put("Country",country.getCountryCode());
            db.insert("Country",null,values);
        }
    }
    /**
     * 读取所有country信息
     */

    public List<Country> readCountrys(){
        List<Country> list = new ArrayList<Country>();
        Cursor cursor = db.query("Country",null,null,null,null,null,null);
        if (cursor.moveToFirst()){
            do {
                Country country = new Country();
                country.setId(cursor.getInt(cursor.getColumnIndex("id")));
                country.setCountryName(cursor.getString(cursor.getColumnIndex("country_name")));
                country.setCountryCode(cursor.getString(cursor.getColumnIndex("country_code")));
                list.add(country);
            }while (cursor.moveToNext());
        }
        return list;
    }
}
