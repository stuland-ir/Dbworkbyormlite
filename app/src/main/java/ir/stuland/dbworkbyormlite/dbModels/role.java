package ir.stuland.dbworkbyormlite.dbModels;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by admin on 03/06/2015.
 */
@DatabaseTable(tableName = "roles")
public class role {
    @DatabaseField(generatedId = true,index = true)
    public int id;
    @DatabaseField(unique = true)
    private String Title;
    @DatabaseField()
    private String Description;

    public role() {
    }

    public role(String title, String description) {
        Title = title;
        Description = description;
    }

    @Override
    public String toString() {
        return "role{" +
                "Title='" + Title + '\'' +
                '}';
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}