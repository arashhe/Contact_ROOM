package com.arash.contactroom.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;



//imported from source
import androidx.room.Delete;
import androidx.room.Update;




import com.arash.contactroom.model.Contact;

import java.util.List;

@Dao
public interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert (Contact contact);

    @Query("DELETE FROM contact_table")
    void deleteAll();

    @Query("SELECT * FROM contact_table ORDER BY name ASC")
    LiveData<List<Contact>> getAllContacts();


    @Query("SELECT * FROM contact_table WHERE contact_table.id == :id")
    LiveData<Contact> get(int id);

    @Update
    void update(Contact contact);

    @Delete
    void delete(Contact contact);
}
