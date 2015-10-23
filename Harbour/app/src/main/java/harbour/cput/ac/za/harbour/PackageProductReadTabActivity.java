package harbour.cput.ac.za.harbour;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;
import java.util.InputMismatchException;

import harbour.cput.ac.za.harbour.model.PackageProductResource;
import harbour.cput.ac.za.harbour.services.PackageProductService;
import harbour.cput.ac.za.harbour.services.impl.PackageProductServiceImpl;

public class PackageProductReadTabActivity extends AppCompatActivity {

    PackageProductService service = new PackageProductServiceImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_product_read_tab);

        // allow connection to web --- very important point
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        EditText myTextBox = (EditText) findViewById(R.id.IdeditText);
        myTextBox.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {


                // clear text fields
                EditText c1 = (EditText) findViewById(R.id.DescreditText);
                c1.getText().clear();
                EditText c2 = (EditText) findViewById(R.id.editText3);
                c2.getText().clear();

                EditText c3 = (EditText) findViewById(R.id.editText4);
                c3.getText().clear();
                EditText c4 = (EditText) findViewById(R.id.editText5);
                c4.getText().clear();
                EditText c5 = (EditText) findViewById(R.id.editText6);
                c5.getText().clear();


                try {

                    EditText id = ((EditText) findViewById(R.id.IdeditText));

                    if (!(id.getText().toString().isEmpty())) { // || (id.getText().toString().length() != 0)


                        PackageProductResource pkgProd = service.findById(Long.parseLong(id.getText().toString()));    //convert to long





                        if (pkgProd != null) {

                            try {


                                EditText code = (EditText) findViewById(R.id.DescreditText);
                                code.setText(pkgProd.getPackageCode());

                                EditText decr = (EditText) findViewById(R.id.editText3);
                                decr.setText(pkgProd.getDescription());

                                EditText type = (EditText) findViewById(R.id.editText4);
                                type.setText(pkgProd.getItemType());

                                EditText date = (EditText) findViewById(R.id.editText5);

                                long timestamp = pkgProd.getPackageDate(); //Example -> in ms
                                Date convertToDate = new Date(timestamp);
                                date.setText(convertToDate.toString() + "");

                                EditText qty = (EditText) findViewById(R.id.editText6);
                                qty.setText(pkgProd.getQuantity() + "");

                            } catch (InputMismatchException e) {

                            }

                        }
                    }
                } catch (Exception e) {

                    Toast.makeText(PackageProductReadTabActivity.this, "Package Product does not exist\n"
                            , Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}



















