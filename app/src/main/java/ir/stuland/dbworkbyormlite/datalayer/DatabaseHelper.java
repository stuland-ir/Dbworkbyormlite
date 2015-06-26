package ir.stuland.dbworkbyormlite.datalayer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import ir.stuland.dbworkbyormlite.R;
import ir.stuland.dbworkbyormlite.dbModels.person;
import ir.stuland.dbworkbyormlite.dbModels.personRoles;
import ir.stuland.dbworkbyormlite.dbModels.post;
import ir.stuland.dbworkbyormlite.dbModels.role;

/**
 * Database helper which creates and upgrades the database and provides the DAOs for the app.
 * 
 * @author saeed khorsand @ stuland
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

	//Suggested Copy/Paste code. Everything from here to the done block.

	private static final String DATABASE_NAME = "stuland_ormlite.db";
	private static final int DATABASE_VERSION = 3;

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
	}

	//Suggested Copy/Paste Done


    //init your class as Database Access Object
    private Dao<person, Integer> personDao=null;
    private Dao<role, Integer> roleDao=null;
    private Dao<post,Integer> postDao=null;
    private Dao<personRoles,Integer> personRolesDao=null;

    private RuntimeExceptionDao<person,Integer> personRuntimeDao=null;

	@Override
	public void onCreate(SQLiteDatabase sqliteDatabase, ConnectionSource connectionSource) {
		try {
			TableUtils.createTable(connectionSource, person.class);
			TableUtils.createTable(connectionSource, role.class);
            TableUtils.createTable(connectionSource, post.class);
            TableUtils.createTable(connectionSource, personRoles.class);
		} catch (SQLException e) {
			Log.e(DatabaseHelper.class.getName(), "Unable to create datbases", e);
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase sqliteDatabase, ConnectionSource connectionSource, int oldVer, int newVer) {
		try {
			TableUtils.dropTable(connectionSource, person.class, true);
			TableUtils.dropTable(connectionSource, role.class, true);
            TableUtils.dropTable(connectionSource, post.class, true);
            TableUtils.dropTable(connectionSource, personRoles.class, true);
			onCreate(sqliteDatabase, connectionSource);
		} catch (SQLException e) {
			Log.e(DatabaseHelper.class.getName(), "Unable to upgrade database from version " + oldVer + " to new "
					+ newVer, e);
		}
	}

    public Dao<person, Integer> getPersonDao() throws SQLException {
        if (personDao == null) {
                personDao = getDao(person.class);
        }
        return personDao;
    }

    public Dao<role, Integer> getRoleDao() throws SQLException{
        if (roleDao == null) {
                roleDao = getDao(role.class);
        }
        return roleDao;
    }

    public Dao<post, Integer> getPostDao() throws SQLException {
        if(postDao==null){
            postDao=getDao(post.class);
        }
        return postDao;
    }

    public Dao<personRoles, Integer> getPersonRoleseDao() throws SQLException{
        if (personRolesDao == null) {
                personRolesDao = getDao(personRoles.class);
        }
        return personRolesDao;
    }

    public RuntimeExceptionDao<person, Integer> getPersonRuntimeDao() {
        if(personRuntimeDao==null)
            personRuntimeDao=getRuntimeExceptionDao(person.class);
        return personRuntimeDao;
    }
}
