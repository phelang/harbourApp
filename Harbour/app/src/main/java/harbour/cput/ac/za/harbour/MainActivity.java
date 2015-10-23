package harbour.cput.ac.za.harbour;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    ListView listView;

    ArrayAdapter<String> adapter;

    String[] harbour_entities = {"",
            "Package Products",
            "Container",
            "Terminal",
            "Warehouse",
            "Dock",
            "Cargo",
            "Logistic Company",
            "Port"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        listView = (ListView) findViewById(R.id.list_View);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, harbour_entities);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                //Toast.makeText(getBaseContext(), parent.getItemIdAtPosition(position) + "is selected ", Toast.LENGTH_LONG).show();
                switch (position) {

                    case 1:
                        Intent pkg = new Intent(getBaseContext(), PackageProduct.class);
                        startActivity(pkg);
                        break;
                    case 2:
                        /*Intent container = new Intent(getBaseContext(), Container.class);
                        startActivity(container);*/
                        Toast.makeText(getApplicationContext(),
                                "Will be avilable in Version3.0",
                                Toast.LENGTH_LONG).show();
                        break;
                    case 3:
                        /*Intent terminal = new Intent(getBaseContext(), Terminal.class);
                        startActivity(terminal);*/
                        Toast.makeText(getApplicationContext(),
                                "Will be avilable in Version3.0",
                                Toast.LENGTH_LONG).show();
                        break;
                    case 4:
                        /*Intent warehouse = new Intent(getBaseContext(), Warehouse.class);
                        startActivity(warehouse);*/
                        Toast.makeText(getApplicationContext(),
                                "Will be avilable in Version3.0",
                                Toast.LENGTH_LONG).show();
                        break;
                    case 5:
                        /*Intent dock = new Intent(getBaseContext(), Dock.class);
                        startActivity(dock);*/
                        Toast.makeText(getApplicationContext(),
                                "Will be avilable in Version3.0",
                                Toast.LENGTH_LONG).show();
                        break;
                    case 6:
                        /*Intent cargo = new Intent(getBaseContext(), Cargo.class);
                        startActivity(cargo);*/
                        Toast.makeText(getApplicationContext(),
                                "Will be avilable in Version3.0",
                                Toast.LENGTH_LONG).show();
                        break;
                    case 7:
                        /*Intent logisticCompany = new Intent(getBaseContext(), LogisticCompany.class);
                        startActivity(logisticCompany);*/
                        Toast.makeText(getApplicationContext(),
                                "Will be avilable in Version3.0",
                                Toast.LENGTH_LONG).show();
                        break;
                    case 8:
                        /*Intent port = new Intent(getBaseContext(), Port.class);
                        startActivity(port);*/
                        Toast.makeText(getApplicationContext(),
                                "Will be avilable in Version3.0",
                                Toast.LENGTH_LONG).show();
                        break;

                }
            }
        });




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

}
