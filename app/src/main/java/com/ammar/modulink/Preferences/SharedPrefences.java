package com.ammar.modulink.Preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPrefences {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public SharedPrefences(Context context){
        sharedPreferences = context.getSharedPreferences("latihan_shared_preferences", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveString(String value){
        editor.putString("ini_string",value);
        editor.commit();
    }

    public String getString(){
        return sharedPreferences.getString("ini_string", "");
    }

    public String getUsername(){
        return sharedPreferences.getString("sp_username", "19.02.0383");
    }

    public String getPassword(){
        return sharedPreferences.getString("sp_password", "26040");
    }

    public void saveIsLogin(Boolean value){
        editor.putBoolean("sp_islogin",value);
        editor.commit();
    }


    public Boolean getIsLogin(){
        return sharedPreferences.getBoolean("sp_islogin", false);
    }

//    static final String KEY_USER_TEREGISTER ="user", KEY_PASS_TEREGISTER ="pass";
//    static final String KEY_USERNAME_SEDANG_LOGIN = "Username_logged_in";
//    static final String KEY_STATUS_SEDANG_LOGIN = "Status_logged_in";
//
//    private static SharedPreferences getSharedPreference(Context context){
//        return PreferenceManager.getDefaultSharedPreferences(context);
//    }
//
//    public static void setRegisteredUser(Context context, String username){
//        SharedPreferences.Editor editor = getSharedPreference(context).edit();
//        editor.putString(KEY_USER_TEREGISTER, username);
//        editor.apply();
//    }
//
//    public static String getRegisteredUser(Context context){
//        return getSharedPreference(context).getString(KEY_USER_TEREGISTER,"");
//    }
//
//    public static void setRegisteredPass(Context context, String password){
//        SharedPreferences.Editor editor = getSharedPreference(context).edit();
//        editor.putString(KEY_PASS_TEREGISTER, password);
//        editor.apply();
//    }
//
//    public static String getRegisteredPass(Context context){
//        return getSharedPreference(context).getString(KEY_PASS_TEREGISTER,"");
//    }
//
//    public static void setLoggedInUser(Context context, String username){
//        SharedPreferences.Editor editor = getSharedPreference(context).edit();
//        editor.putString(KEY_USERNAME_SEDANG_LOGIN, username);
//        editor.apply();
//    }
//
//    public static String getLoggedInUser(Context context){
//        return getSharedPreference(context).getString(KEY_USERNAME_SEDANG_LOGIN,"");
//    }
//
//    public static void setLoggedInStatus(Context context, boolean status){
//        SharedPreferences.Editor editor = getSharedPreference(context).edit();
//        editor.putBoolean(KEY_STATUS_SEDANG_LOGIN,status);
//        editor.apply();
//    }
//
//    public static boolean getLoggedInStatus(Context context){
//        return getSharedPreference(context).getBoolean(KEY_STATUS_SEDANG_LOGIN,false);
//    }
//
//    public static void clearLoggedInUser (Context context){
//        SharedPreferences.Editor editor = getSharedPreference(context).edit();
//        editor.remove(KEY_USERNAME_SEDANG_LOGIN);
//        editor.remove(KEY_STATUS_SEDANG_LOGIN);
//        editor.apply();
//    }

}
