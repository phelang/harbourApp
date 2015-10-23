package harbour.cput.ac.za.harbour.services;

import java.util.List;

import harbour.cput.ac.za.harbour.domain.PackageProduct;

/**
 * Created by qhuphe01 on 2015/09/27.
 */
public interface Services<H, ID> {

    public H findById(ID id);

    public String save(H entity);

    public String update(PackageProduct entity);

    public String delete(PackageProduct entity); // Getter, GET implements Resource Support, Post Supports Entity model

    public List<H> findAll();

}

