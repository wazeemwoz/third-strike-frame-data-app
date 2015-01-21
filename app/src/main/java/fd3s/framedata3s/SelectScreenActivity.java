package fd3s.framedata3s;

import android.app.LauncherActivity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.internal.view.menu.ListMenuItemView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import fd3s.framedata3s.adapters.SelectScreenImageAdapter;
import fd3s.framedata3s.moves.ShowDataCategoriesActivity;
import fd3s.framedata3s.moves.normals.ShowNormalsActivity;
import fd3s.framedata3s.preference.UserSettingActivity;
import fd3s.framedata3s.utils.ResourceHelper;

public class SelectScreenActivity extends ActionBarActivity {
    private SelectScreenActivity ref = this;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setTitle(ResourceHelper.SelectScreenTitle);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new SelectScreenImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                if(position == ResourceHelper.ThumbIds.length-1){
                    String url = "http://ensabahnur.free.fr/BastonNew/index.php";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }else {
                    Intent myIntent = new Intent(ref, ShowDataCategoriesActivity.class);
                    myIntent.putExtra(ResourceHelper.ResourceIds.CHARACTER_ID.name(), position);
                    startActivity(myIntent);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent myIntent = new Intent(ref, UserSettingActivity.class);
            startActivity(myIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
