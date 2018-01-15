package forian.bellanger.mytodolist;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by bellangf on 15/01/2018.
 */
public class TodoActivity extends Activity implements
        View.OnClickListener {
    private ListView laListView;
    private Button validerBoutton;
    private Button viderButton;
    private EditText inputText;
    private TextView protoListe;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_layout);

        Singleton.getInstance();
        laListView = (ListView)findViewById(R.id.todoListView);
        validerBoutton = (Button) findViewById(R.id.ValiderButton);
        viderButton = (Button) findViewById(R.id.gotEmptyButton);
        inputText = (EditText) findViewById(R.id.thingToDoText);
        protoListe = (TextView) findViewById(R.id.todoText);

        laListView.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1,Singleton.getInstance().getAllTodo()));

        validerBoutton.setOnClickListener(this);
        viderButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ValiderButton) {
            //protoListe.setText(inputText.getText());
            Singleton.getInstance().addTodo(inputText.getText().toString());
            laListView.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1,Singleton.getInstance().getAllTodo()));
            inputText.setText("");
        }

        if (v.getId() == R.id.gotEmptyButton) {

            Singleton.getInstance().emptyTodo();
            laListView.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1,Singleton.getInstance().getAllTodo()));
        }

    }
}
