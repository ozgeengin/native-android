package example.ozgeengin.com.exampleapplication.storage;

/**
 * Created by Özge Engin on 16.06.2018.
 *
 * Interface for storage classes.
 */
public interface IStorage {
    String Read(String tag);
    void Write(String tag, String value);
    int ReadInteger(String tag);
    void WriteInteger(String tag, int value);
    boolean ContainsTAG(String tag);
}
