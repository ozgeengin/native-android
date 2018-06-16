package example.ozgeengin.com.exampleapplication.storage;

import android.content.SharedPreferences;
import javax.inject.Inject;
import example.ozgeengin.com.exampleapplication.CustomApplication;

/**
 * Created by Özge Engin on 16.06.2018.
 *
 * Shared preference storage class is responsible for reading,writing and checking values
 * from the application's shared preference file.
 */
public class Storage implements IStorage {

    @Inject
    SharedPreferences sharedPreferences;
    @Inject
    SharedPreferences.Editor editor;

    public Storage(){
        CustomApplication.getAppComponent().inject(this);
    }

    /**
     * Reads string value from shared preference file and returns its value. If the tag has
     * no value then returns null.
     * @param tag string tag for file.
     * @return string value for tag
     */
    @Override
    public String Read(String tag) {
        String json = sharedPreferences.getString(tag, "error");
        if (!"error".equals(json)) return json;
        return null;
    }

    /**
     * Reads string value from shared preference file and returns its value. If the tag has
     * no value then returns -1.
     * @param tag string tag for file.
     * @return int value for tag
     */
    @Override
    public int ReadInteger(String tag) {
        return sharedPreferences.getInt(tag, -1);
    }


    /**
     * Writes the string value to shared preference file according to its tag.
     * @param tag string value for the tag
     * @param value string value
     */
    public void Write(String tag,String value) {
        editor.putString(tag, value);
        editor.apply();
    }

    /**
     * Writes the int value to shared preference file according to its tag.
     * @param tag string value for the tag
     * @param value int value
     */
    @Override
    public void WriteInteger(String tag,int value) {
        editor.putInt(tag, value);
        editor.apply();
    }

    /**
     * Returns true if the given tag is exists in the shared preference file, otherwise
     * returns false.
     * @param tag string tag
     * @return boolean
     */
    @Override
    public boolean ContainsTAG(String tag) {
        return sharedPreferences.contains(tag);
    }
}