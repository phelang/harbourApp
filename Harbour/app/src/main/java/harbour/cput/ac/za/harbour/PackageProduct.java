package harbour.cput.ac.za.harbour;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;


public class PackageProduct extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_product);

        TabHost tabHost = (TabHost)findViewById(android.R.id.tabhost);

        TabHost.TabSpec create = tabHost.newTabSpec("Create");
        TabHost.TabSpec read = tabHost.newTabSpec("Read");
        TabHost.TabSpec update = tabHost.newTabSpec("Update");
        TabHost.TabSpec delete = tabHost.newTabSpec("Delete");
        TabHost.TabSpec showAll = tabHost.newTabSpec("Show All");

        // Set the Tab name and Activity
        // that will be opened when particular Tab will be selected
        create.setIndicator("Create");
        create.setContent(new Intent(this,PackageProductCreateTabActivity.class));

        read.setIndicator("Read");
        read.setContent(new Intent(this,PackageProductReadTabActivity.class));

        update.setIndicator("Update");
        update.setContent(new Intent(this,PackageProductUpdateTabActivity.class));

        delete.setIndicator("Delete");
        delete.setContent(new Intent(this,PackageProductDeleteTabActivity.class));

        showAll.setIndicator("All");
        showAll.setContent(new Intent(this,PackageProductAllTabActivity.class));


        /*showAll.setIndicator("Show All");
        showAll.setContent(new Intent(this,ShowAllPackages.class));*/



        /** Add the tabs  to the TabHost to display. */
        tabHost.addTab(create);
        tabHost.addTab(read);
        tabHost.addTab(update);
        tabHost.addTab(delete);
        tabHost.addTab(showAll);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_package_product, menu);
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
