package harbour.cput.ac.za.harbour;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;


import java.util.Date;

import harbour.cput.ac.za.harbour.model.PackageProductResource;
import harbour.cput.ac.za.harbour.services.PackageProductService;
import harbour.cput.ac.za.harbour.services.impl.PackageProductServiceImpl;


public class PackageProductCreateTabActivity extends Activity { //AppCompatActivity {

    PackageProductService service = new PackageProductServiceImpl();


    private EditText packageCode;
    private EditText description;
    private EditText itemType;
    private EditText quantity;

    private DatePicker date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_product_create_tab);


        // force connection to open
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        // set button
        Button packadeSave = (Button) findViewById(R.id.save_button);

        packadeSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                packageCode = (EditText) findViewById(R.id.pkgCode_editText);
                description = (EditText) findViewById(R.id.DescriptioneditText);
                itemType = (EditText) findViewById(R.id.ItemTypeeditText);
                quantity = (EditText) findViewById(R.id.QuantityeditText);

                long millis = new java.util.Date().getTime();

                try {

                    PackageProductResource pkgProdRes = new PackageProductResource.
                            Builder(packageCode.getText().toString())
                            .resid(1L)
                            .description(description.getText().toString())
                            .itemType(itemType.getText().toString())
                            .packageDate(millis)
                            .quantity(Integer.parseInt(quantity.getText().toString()))   // get package products
                            .build();

                    String  response = service.save(pkgProdRes);     // save Item

                    packageCode.getText().clear();
                    description.getText().clear();
                    itemType.getText().clear();
                    quantity.getText().clear();


                    Toast.makeText(getApplicationContext(),
                            "Package Saved",
                            Toast.LENGTH_SHORT).show();

                } catch (Exception e) {


                    Toast.makeText(getApplicationContext(),
                            "Could not save, Make sure that data is entered correctly",
                            Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_package_product_create_tab, menu);
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
