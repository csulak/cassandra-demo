package com.example.cassandra.cassandrademo.model;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("user")
public class User {

    /**
     * Sample explanation: If we want to have a composite primary key (using 2 fields)
     *
     * @PrimaryKeyColumn(name = "id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
     * @Column("id")
     * private int id;
     *
     * @PrimaryKeyColumn(name = "name", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
     * @Column("name")
     * private String name;
     *
     *
     * ##### TIP ######
     * If the class name or field name is going to be the same name as the table or the colum; We don't need to specify in @Table or in @Column the name
     *
     * */

    @PrimaryKey
    @Column("id")
    private int id;

    @Column("name")
    private String name;

    public User() {
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
