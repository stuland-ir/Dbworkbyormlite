package ir.stuland.dbworkbyormlite.dbModels;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by admin on 19/06/2015.
 */
@DatabaseTable(tableName = "posts")
public class post {

    @DatabaseField(generatedId = true,index = true)
    public int id;

    @DatabaseField
    public String Content;

    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName ="author_person_id")
    public person Author;

    public post() {

    }

    public post(String content, person author) {
        Content = content;
        Author = author;
    }

    @Override
    public String toString() {
        return "post{" +
                "id=" + id +
                ", Content='" + Content + '\'' +
                '}';
    }
}
