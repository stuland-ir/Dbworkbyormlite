package ir.stuland.dbworkbyormlite.dbModels;

/**
 * Created by admin on 03/06/2015.
 */

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "persons")
public class person {

    @DatabaseField(generatedId = true,index = true)
    public int id;
    @DatabaseField()
    public String name;
    @DatabaseField()
    public String family;
    @DatabaseField()
    public String address;
    @DatabaseField()
    public String phone;
    @DatabaseField(index = true)
    public String email;

    @ForeignCollectionField
    ForeignCollection<post> posts;

    public person() {

    }

    public person(String _name,String _family,String _address,String _phone,String _email){
        this.name=_name;
        this.family=_family;
        this.address=_address;
        this.phone=_phone;
        this.email=_email;
    }


    @Override
    public String toString() {
        return "person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", posts=" + posts +
                '}';
    }

    public int getId() {
        return id;
    }

    public ForeignCollection<post> getPosts() {
        return posts;
    }
}
