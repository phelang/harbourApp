package harbour.cput.ac.za.harbour.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by student on 2015/09/30.
 */
public class PackageProduct  implements Serializable {


    private Long id;
    private String packageCode;
    private long packageDate;
    private String description;
    private String itemType;
    private int quantity;


    private PackageProduct() {
    }


    public Long getId() {
        return id;
    }

    public String getPackageCode() {
        return packageCode;
    }

    public long getPackageDate() {
        return packageDate;
    }

    public String getDescription() {
        return description;
    }

    public String getItemType() {
        return itemType;
    }

    public int getQuantity() {
        return quantity;
    }

    public PackageProduct(Builder builder) {
        id = builder.id;
        packageCode = builder.packageCode;
        packageDate = builder.packageDate;
        description = builder.description;
        itemType = builder.itemType;
        quantity = builder.quantity;
    }

    public static class Builder {
        private Long id;
        private String packageCode;
        private long packageDate;
        private String description;
        private String itemType;
        private int quantity;

        public Builder(String code) {
            this.packageCode = code;
        }

        public Builder packageDate(long packageDate) {
            this.packageDate = packageDate;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }


        public Builder itemType(String itemType) {
            this.itemType = itemType;
            return this;
        }

        public Builder id(Long id){

            this.id = id;
            return this;

        }
        public Builder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder copy(PackageProduct value) {
            this.id = value.getId();
            this.packageCode = value.getPackageCode();
            this.packageDate = value.getPackageDate();
            this.description = value.getDescription();
            this.itemType = value.getItemType();
            this.quantity = value.getQuantity();
            return this;
        }

        public PackageProduct build() {
            return new PackageProduct(this);
        }
    }
}