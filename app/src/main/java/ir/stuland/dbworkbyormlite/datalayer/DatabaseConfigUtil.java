package ir.stuland.dbworkbyormlite.datalayer;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

import java.io.IOException;
import java.sql.SQLException;

import ir.stuland.dbworkbyormlite.dbModels.person;
import ir.stuland.dbworkbyormlite.dbModels.personRoles;
import ir.stuland.dbworkbyormlite.dbModels.post;
import ir.stuland.dbworkbyormlite.dbModels.role;

/**
 @author saeed khorsand @ stuland
 */
public class DatabaseConfigUtil extends OrmLiteConfigUtil {

    private static final Class<?>[] classes = new Class[]{
            person.class,
            role.class,
            personRoles.class,
            post.class};

	public static void main(String[] args) throws SQLException, IOException {
		writeConfigFile("ormlite_config.txt",classes);
	}
}
