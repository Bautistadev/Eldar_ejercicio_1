package org.eldar.challenge.Repository;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Database {

    private Long key;
    private Map<Long,Object> database;

    public Database(){
        database = new HashMap<>();
        this.key = 0L;
    }

    public Map getAll(){
        return this.database;
    }
    public void add(Object element){
        this.key +=1;
        this.database.put(this.key,element);
    }




}
