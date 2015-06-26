package ir.stuland.dbworkbyormlite.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.sql.SQLException;

import ir.stuland.dbworkbyormlite.R;
import ir.stuland.dbworkbyormlite.datalayer.DatabaseHelper;
import ir.stuland.dbworkbyormlite.dbModels.person;
import ir.stuland.dbworkbyormlite.dbModels.post;

public class Home extends Activity {
    TextView home_txtCounter;
    DatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        home_txtCounter=(TextView)findViewById(R.id.home_txtCounter);
        doPersons();
    }

    private void doPersons(){
        dbHelper= OpenHelperManager.getHelper(this,DatabaseHelper.class);

        RuntimeExceptionDao<person,Integer> personDao = dbHelper.getPersonRuntimeDao();
        try {
            Dao<post,Integer> postDao=dbHelper.getPostDao();
            //write
            person person=new person("saeed","Khorsand","","","info@stuland.ir");
            personDao.create(person);

            postDao.create(new post("my post",person));
            postDao.create(new post("my post 2",person));

            //read
            person _person = personDao.queryForId(person.getId());
            ForeignCollection<post> _posts=_person.getPosts();



            String postResults="";
            for(post _post : _posts){
                postResults+=" ["+_post.id+" : "+_post.Content +" ] ";
            }
            home_txtCounter.setText(_person.toString()+"posts : "+_posts.size() + "post results : " + postResults);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //create



        //query


        OpenHelperManager.releaseHelper();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void AddNewUser(){

    }
}
