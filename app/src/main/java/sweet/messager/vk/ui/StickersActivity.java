package sweet.messager.vk.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import sweet.messager.vk.ApplicationName;
import sweet.messager.vk.R;
import sweet.messager.vk.adapters.StickerListAdapter;
import sweet.messager.vk.db.Method;

public class StickersActivity extends AppCompatActivity {

    ListView zdiger_list;
    Button buttonSend;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_stickers);
        zdiger_list = (ListView)findViewById(R.id.zdiger_list);
        ArrayList<String> names =new ArrayList<String>();
        ArrayList<String> list;
        Method sql = new Method();

        list = sql.getStickers();
        for (String l:list){
            names.add(l);
        }

        zdiger_list.setAdapter(new StickerListAdapter(StickersActivity.this,names));


    }




}
