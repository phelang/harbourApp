package harbour.cput.ac.za.harbour;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.graphics.Typeface;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TableRow.LayoutParams;
import android.widget.Toast;

import java.util.Date;
import java.util.List;
import harbour.cput.ac.za.harbour.model.PackageProductResource;
import harbour.cput.ac.za.harbour.services.PackageProductService;
import harbour.cput.ac.za.harbour.services.impl.PackageProductServiceImpl;


public class PackageProductAllTabActivity extends AppCompatActivity {

    TableLayout tl;
    TableRow tr;
    TextView companyTV,valueTV;

    //////////////// service

    PackageProductService service = new PackageProductServiceImpl();
    List<PackageProductResource> packages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_product_all_tab);


        tl = (TableLayout) findViewById(R.id.maintable);


        packages  = service.findAll();

        addHeaders();
        addData();
    }

    /** This function add the headers to the table **/
    public void addHeaders(){

        /** Create a TableRow dynamically **/
        tr = new TableRow(this);
        tr.setLayoutParams(new LayoutParams(
                LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT));

        /** Creating a TextView to add to the row **/
        /*TextView companyTV = new TextView(this);
        companyTV.setText("ID");
        companyTV.setTextColor(Color.GRAY);
        companyTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        companyTV.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
        companyTV.setPadding(3, 3, 3, 0);
        tr.addView(companyTV);  // Adding textView to tablerow.*/

        /** Creating another textview **/
        TextView valueTV = new TextView(this);
        valueTV.setText("Code");
        valueTV.setTextColor(Color.GRAY);
        valueTV.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        valueTV.setPadding(3, 3, 3, 0);
        valueTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(valueTV); // Adding textView to tablerow.

        /** Creating another textview **/
        TextView descr = new TextView(this);
        descr.setText("Description");
        descr.setTextColor(Color.GRAY);
        descr.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
        descr.setPadding(3, 3, 3, 0);
        descr.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(descr); // Adding textView to tablerow.




        /** Creating another textview **/
        TextView itemType = new TextView(this);
        itemType.setText("Item Type");
        itemType.setTextColor(Color.GRAY);
        itemType.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
        itemType.setPadding(5, 5, 5, 0);
        itemType.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(itemType); // Adding textView to tablerow.

        /** Creating another textview **/
        TextView date = new TextView(this);
        date.setText("Date");
        date.setTextColor(Color.GRAY);
        date.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
        date.setPadding(5, 5, 5, 0);
        date.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(date); // Adding textView to tablerow.

        /** Creating another textview **/
        TextView quantity = new TextView(this);
        quantity.setText("Quantity");
        quantity.setTextColor(Color.GRAY);
        quantity.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
        quantity.setPadding(5, 5, 5, 0);
        quantity.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(quantity); // Adding textView to tablerow.








        // Add the TableRow to the TableLayout
        tl.addView(tr, new TableLayout.LayoutParams(
                LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT));

        // we are adding two textviews for the divider because we have two columns
        tr = new TableRow(this);
        tr.setLayoutParams(new LayoutParams(
                LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT));

        /** Creating another textview **/
        /*TextView divider = new TextView(this);
        divider.setText("---------");
        divider.setTextColor(Color.BLUE);
        divider.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        divider.setPadding(5, 0, 0, 0);
        divider.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(divider); // */

        TextView divider2 = new TextView(this);
        divider2.setText("---------");
        divider2.setTextColor(Color.BLUE);
        divider2.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        divider2.setPadding(5, 0, 0, 0);
        divider2.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(divider2); // Adding textView to tablerow.

        TextView divider3 = new TextView(this);
        divider3.setText("---------");
        divider3.setTextColor(Color.BLUE);
        divider3.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        divider3.setPadding(5, 0, 0, 0);
        divider3.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(divider3); // Adding textView to tablerow.


        TextView divider4 = new TextView(this);
        divider4.setText("---------");
        divider4.setTextColor(Color.BLUE);
        divider4.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        divider4.setPadding(5, 0, 0, 0);
        divider4.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(divider4); // Adding textView to tablerow.

        TextView divider5 = new TextView(this);
        divider5.setText("----------------------------");
        divider5.setTextColor(Color.BLUE);
        divider5.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        divider5.setPadding(5, 0, 0, 0);
        divider5.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(divider5); // Adding textView to tablerow.

        TextView divider6 = new TextView(this);
        divider6.setText("---------");
        divider6.setTextColor(Color.BLUE);
        divider6.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        divider6.setPadding(5, 0, 0, 0);
        divider6.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(divider6); // Adding textView to tablerow.




        // Add the TableRow to the TableLayout
        tl.addView(tr, new TableLayout.LayoutParams(
                LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT));

    }

    public void addData() {


        /**-------------------------------**/
        /** Get a list of package products **/

        for (int i = 0; i < packages.size(); i++) {
            /** Create a TableRow dynamically **/
            tr = new TableRow(this);
            tr.setLayoutParams(new LayoutParams(
                    LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT));

            /** Creating a TextView to add to the row **/
            /*companyTV = new TextView(this);
            companyTV.setText(packages.get(i).getId().toString());
            companyTV.setTextColor(Color.GRAY);
            companyTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            companyTV.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
            companyTV.setPadding(5, 5, 5, 5);
            tr.addView(companyTV);  // Adding textView to tablerow.*/

            /** Creating another textview **/
            valueTV = new TextView(this);
            valueTV.setText(packages.get(i).getPackageCode().toString());
            valueTV.setTextColor(Color.GRAY);
            valueTV.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
            valueTV.setPadding(5, 5, 5, 5);
            valueTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            tr.addView(valueTV); // Adding textView to tablerow.


            //description

            /** Creating another textview **/
            valueTV = new TextView(this);
            valueTV.setText(packages.get(i).getDescription().toString());
            valueTV.setTextColor(Color.GRAY);
            valueTV.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
            valueTV.setPadding(5, 5, 5, 5);
            valueTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            tr.addView(valueTV); // Adding textView to tablerow.

            // iten type
            /** Creating another textview **/
            valueTV = new TextView(this);
            valueTV.setText(packages.get(i).getItemType().toString());
            valueTV.setTextColor(Color.GRAY);
            valueTV.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
            valueTV.setPadding(5, 5, 5, 5);
            valueTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            tr.addView(valueTV); // Adding textView to tablerow.

            //date

            /** Creating another textview **/
            valueTV = new TextView(this);

            long timestamp = packages.get(i).getPackageDate(); //Example -> in ms
            Date convertToDate = new Date(timestamp);
            valueTV.setText(convertToDate+ "");
            valueTV.setTextColor(Color.GRAY);
            valueTV.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
            valueTV.setPadding(5, 5, 5, 5);
            valueTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            tr.addView(valueTV); // Adding textView to tablerow.

            /// quantity

            /** Creating another textview **/
            valueTV = new TextView(this);
            valueTV.setText(packages.get(i).getQuantity()+ "");
            valueTV.setTextColor(Color.GRAY);
            valueTV.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
            valueTV.setPadding(5, 5, 5, 5);
            valueTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            tr.addView(valueTV); // Adding textView to tablerow.


            // Add the TableRow to the TableLayout
            tl.addView(tr, new TableLayout.LayoutParams(
                    LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT));
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        // put your code here...
        tl.removeAllViews();
        packages.clear();

        packages = service.findAll();

        addHeaders();
        addData();

    }
}
