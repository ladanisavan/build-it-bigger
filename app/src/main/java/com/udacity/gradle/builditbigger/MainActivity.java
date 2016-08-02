package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.JokeTeller;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.builditbigger.backend.jokeApi.JokeApi;
import com.udacity.gradle.builditbigger.backend.jokeApi.model.JokeBean;
import com.udacity.gradle.builditbigger.jokesdisplaylib.JokeDisplayActivity;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private JokeApi mJokeApi = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void tellJoke() {
       // Toast.makeText(this, JokeTeller.getRandomJoke(), Toast.LENGTH_SHORT).show();
        /*if (mJokeApi == null) {
            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://localhost:8085/_ah/api/");
            mJokeApi = builder.build();
        }
        try {
            Intent intent = new Intent(this, JokeDisplayActivity.class);
            intent.putExtra(JokeDisplayActivity.INTENT_JOKE, mJokeApi.getJoke().execute().getJoke());
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressbar);
        new EndpointsAsyncTask(this, progressBar).execute();
    }
}
