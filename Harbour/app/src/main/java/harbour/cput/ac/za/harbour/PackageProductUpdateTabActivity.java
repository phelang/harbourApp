package harbour.cput.ac.za.harbour;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

import harbour.cput.ac.za.harbour.model.PackageProductResource;
import harbour.cput.ac.za.harbour.services.PackageProductService;
import harbour.cput.ac.za.harbour.services.impl.PackageProductServiceImpl;
import harbour.cput.ac.za.harbour.domain.PackageProduct;


public class PackageProductUpdateTabActivity extends AppCompatActivity {

    PackageProductService service = new PackageProductServiceImpl();

    PackageProductResource pkgProd;

    PackageProduct pkgDel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_product_update_tab);

        EditText myTextBox = (EditText) findViewById(R.id.editText8);
        myTextBox.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

                // Clear


                EditText c1 = (EditText) findViewById(R.id.editText9);
                c1.getText().clear();

                EditText c2 = (EditText) findViewById(R.id.editText10);
                c2.getText().clear();

                EditText c3 = (EditText) findViewById(R.id.editText11);
                c3.getText().clear();

                EditText c4 = (EditText) findViewById(R.id.editText12);
                c4.getText().clear();

                EditText c5 = (EditText) findViewById(R.id.editText13);
                c5.getText().clear();

                try {

                    EditText id = (EditText) findViewById(R.id.editText8);

                    if (!(id.getText().toString().isEmpty())) { // (id.getText().toString().length() != 0)


                        pkgProd = service.findById(Long.parseLong(id.getText().toString()));    //convert to long


                        EditText code = (EditText) findViewById(R.id.editText9);
                        code.setText(pkgProd.getPackageCode());

                        EditText decr = (EditText) findViewById(R.id.editText10);
                        decr.setText(pkgProd.getDescription());

                        EditText type = (EditText) findViewById(R.id.editText12);
                        type.setText(pkgProd.getItemType());

                        EditText date = (EditText) findViewById(R.id.editText11);
                        long timestamp = pkgProd.getPackageDate(); //Example -> in ms
                        Date convertToDate = new Date(timestamp);
                        date.setText(convertToDate + "");

                        EditText qty = (EditText) findViewById(R.id.editText13);
                        qty.setText(pkgProd.getQuantity() + "");


                    }

                } catch (Exception e) {
                    Toast.makeText(PackageProductUpdateTabActivity.this, "Package Product does not exist.", Toast.LENGTH_SHORT).show();
                }


            }
        });


        Button packadeUpdate = (Button) findViewById(R.id.button_update);

        packadeUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder alertDialog = new AlertDialog.Builder(PackageProductUpdateTabActivity.this);

                // Setting Dialog Title
                alertDialog.setTitle("Confirm Update...");

                // Setting Dialog Message
                alertDialog.setMessage("Are you sure you want update Package?");

                // Setting Icon to Dialog
                //alertDialog.setIcon(R.drawable.delete);

                // Setting Positive "Yes" Button
                alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        try {


                            long timestamp = pkgProd.getPackageDate(); //Example -> in ms
                            Date convertToDate = new Date(timestamp);

                            EditText code = (EditText) findViewById(R.id.editText9);
                            EditText decr = (EditText) findViewById(R.id.editText10);
                            EditText type = (EditText) findViewById(R.id.editText12);
                            EditText qty = (EditText) findViewById(R.id.editText13);


                            pkgDel = new PackageProduct.Builder(code.getText().toString())
                                    .id(pkgProd.getResId())
                                    .packageDate(timestamp)         // date of package shall stay the same
                                    .description(decr.getText().toString())
                                    .itemType(type.getText().toString())
                                    .quantity(Integer.parseInt(qty.getText().toString()))
                                    .build();


                            String d = service.update(pkgDel);          // update package product

                            Toast.makeText(getApplicationContext(), "Packag Updated."
                                    , Toast.LENGTH_SHORT).show();

                        } catch (Exception e) {

                            Toast.makeText(getApplicationContext(), "Couldnot update, make sure" +
                                    " data is entered correctly"
                                    , Toast.LENGTH_SHORT).show();
                            dialog.cancel();
                        }
                    }
                });

                // Setting Negative "NO" Button
                alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to invoke NO event
                        Toast.makeText(getApplicationContext(), "Canceled Update", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });
                // Showing Alert Message
                alertDialog.show();
            }
        });

    }
}
