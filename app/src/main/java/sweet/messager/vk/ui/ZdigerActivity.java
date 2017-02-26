package sweet.messager.vk.ui;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import sweet.messager.vk.ApplicationName;
import sweet.messager.vk.R;
import sweet.messager.vk.adapters.StickerListAdapter;
import sweet.messager.vk.db.Method;

public class ZdigerActivity extends AppCompatActivity {

    ListView zdiger_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_zdiger2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setTitle("");
        setSupportActionBar(toolbar);
        ImageView bttn_back = (ImageView)findViewById(R.id.button_back_zdiger);
        FloatingActionButton bttn_add = (FloatingActionButton) findViewById(R.id.fab);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (ApplicationName.colors != null) {
            toolbar.setBackgroundColor(ApplicationName.colors.toolBarColor);
            fab.setBackgroundTintList(ColorStateList.valueOf(ApplicationName.colors.toolBarColor));
        }
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        zdiger_list = (ListView)findViewById(R.id.zdiger_list);

        ArrayList<String> names =new ArrayList<String>();
        ArrayList<String> list;
        Method sql = new Method();

        list = sql.getStickers();
        for (String l:list){
            names.add(l);
        }

        zdiger_list.setAdapter(new StickerListAdapter(ZdigerActivity.this,names));

        bttn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        bttn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Added in next version :D",Toast.LENGTH_LONG).show();
            }
        });

    }

}
