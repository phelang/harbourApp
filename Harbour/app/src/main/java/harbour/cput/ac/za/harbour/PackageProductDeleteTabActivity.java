package harbour.cput.ac.za.harbour;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

import harbour.cput.ac.za.harbour.domain.PackageProduct;
import harbour.cput.ac.za.harbour.model.PackageProductResource;
import harbour.cput.ac.za.harbour.services.PackageProductService;
import harbour.cput.ac.za.harbour.services.impl.PackageProductServiceImpl;

public class PackageProductDeleteTabActivity extends AppCompatActivity {

    PackageProductService service = new PackageProductServiceImpl();


    PackageProductResource pkgProd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_product_delete_tab);


        // force connection to open
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        EditText myTextBox = (EditText) findViewById(R.id.editText);
        myTextBox.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

                // Clear
                EditText c1 = (EditText) findViewById(R.id.editText2);
                c1.getText().clear();
                EditText c2 = (EditText) findViewById(R.id.editText7);
                c2.getText().clear();

                pkgProd = null;


                try {


                    EditText id = ((EditText) findViewById(R.id.editText));

                    if (!(id.getText().toString().isEmpty())) { // || (id.getText().toString().length() != 0)


                        pkgProd = service.findById(Long.parseLong(id.getText().toString()));    //convert to long

                        if (pkgProd != null) {


                            EditText code = (EditText) findViewById(R.id.editText2);
                            code.setText(pkgProd.getPackageCode());

                            EditText decr = (EditText) findViewById(R.id.editText7);
                            decr.setText(pkgProd.getDescription());
                        }

                    }

                } catch (Exception e) {

                    Toast.makeText(PackageProductDeleteTabActivity.this, "Package Product does not exist\n"
                            , Toast.LENGTH_SHORT).show();

                }
            }

        });

        Button packadeDelete = (Button) findViewById(R.id.button_del);

        packadeDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder alertDialog = new AlertDialog.Builder(PackageProductDeleteTabActivity.this);

                // Setting Dialog Title
                alertDialog.setTitle("Confirm Delete...");

                // Setting Dialog Message
                alertDialog.setMessage("Are you sure you want delete Package?");

                // Setting Icon to Dialog
                //alertDialog.setIcon(R.drawable.delete);

                // Setting Positive "Yes" Button
                alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {

                        EditText id = ((EditText) findViewById(R.id.editText));
                        if (!(id.getText().toString().isEmpty()))
                        {// || (id.getText().toString().length() != 0)

                            try {

                                long timestamp = pkgProd.getPackageDate(); //Example -> in ms
                                Date d = new Date(timestamp);

                                PackageProduct pkgDel = new PackageProduct.Builder(pkgProd.getPackageCode())
                                        .id(pkgProd.getResId())
                                        .packageDate(pkgProd.getPackageDate())
                                        .description(pkgProd.getDescription())
                                        .itemType(pkgProd.getItemType())
                                        .quantity(pkgProd.getQuantity())
                                        .build();


                                String response = service.delete(pkgDel);


                                Toast.makeText(getApplicationContext(),
                                        "Package Deleted" + "\n" + pkgDel.getId() +"\n"
                                        + pkgProd.getDescription(),
                                        Toast.LENGTH_LONG).show();


                                // clear buttons
                                EditText code = (EditText) findViewById(R.id.editText2);
                                code.getText().clear();
                                EditText decr = (EditText) findViewById(R.id.editText7);
                                decr.getText().clear();

                                pkgProd = null;



                            } catch (Exception e) {
                                Toast.makeText(getApplicationContext(), "Could Not Delete", Toast.LENGTH_SHORT).show();
                                dialog.cancel();
                            }
                        }
                    }
                });

                // Setting Negative "NO" Button
                alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to invoke NO event
                        Toast.makeText(getApplicationContext(), "Canceled Transaction", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });
                // Showing Alert Message
                alertDialog.show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_package_product_delete_tab, menu);
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
