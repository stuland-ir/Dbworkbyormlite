package ir.stuland.dbworkbyormlite.dbModels;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by admin on 03/06/2015.
 */
@DatabaseTable(tableName = "personRoles")
public class personRoles {

    @DatabaseField(generatedId = true,index = true)
    public int id;

    @DatabaseField(foreign = true,columnName = "person_id")
    public person person;

    @DatabaseField(foreign = true,columnName = "role_id")
    public role role;

    public personRoles() {
    }

    public personRoles(ir.stuland.dbworkbyormlite.dbModels.role role, ir.stuland.dbworkbyormlite.dbModels.person person) {
        this.role = role;
        this.person = person;
    }
}
