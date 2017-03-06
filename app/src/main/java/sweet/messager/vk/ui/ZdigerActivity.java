package sweet.messager.vk.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import sweet.messager.vk.ApplicationName;
import sweet.messager.vk.R;
import sweet.messager.vk.adapters.StickerListAdapter;
import sweet.messager.vk.db.Method;

public class ZdigerActivity extends AppCompatActivity {

    ListView zdiger_list;
    TextView cat_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_zdiger2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        cat_title = (TextView) findViewById(R.id.cat_title);
        Intent intent = getIntent();

        toolbar.setTitle("");
        String cat = intent.getStringExtra("cat");
        cat_title.setText(cat);
        setSupportActionBar(toolbar);
        ImageView bttn_back = (ImageView)findViewById(R.id.button_back_zdiger);
        FloatingActionButton bttn_add = (FloatingActionButton) findViewById(R.id.fab);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (ApplicationName.colors != null) {
            toolbar.setBackgroundColor(ApplicationName.colors.toolBarColor);
            fab.setBackgroundTintList(ColorStateList.valueOf(ApplicationName.colors.toolBarColor));
        }

        zdiger_list = (ListView)findViewById(R.id.zdiger_list);

        ArrayList<String> names =new ArrayList<String>();
        ArrayList<String> list;
        Method sql = new Method();

        if(cat.equals("Мои аудио-стикеры")){
            list = sql.getMyStickers();
            for (String l:list){
                names.add(l);
            }
        }
        else {
            list = sql.getStickers();
            for (String l : list) {
                names.add(l);
            }
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
                Intent new_zdiger = new Intent(ApplicationName.getAppContext(),New_zdigerActivity.class);
                startActivity(new_zdiger);
            }
        });

    }

}
