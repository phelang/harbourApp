package harbour.cput.ac.za.harbour.services.impl;


import java.util.List;

import harbour.cput.ac.za.harbour.domain.PackageProduct;
import harbour.cput.ac.za.harbour.model.PackageProductResource;
import harbour.cput.ac.za.harbour.repositories.RestAPI;
import harbour.cput.ac.za.harbour.repositories.rest.RestPackageProduct;
import harbour.cput.ac.za.harbour.services.PackageProductService;

/**
 * Created by qhuphe01 on 2015/09/27.
 */
public class PackageProductServiceImpl implements PackageProductService {

    final RestAPI<PackageProductResource,Long> rest = new RestPackageProduct();


    @Override
    public PackageProductResource findById(Long id) {
        return rest.get(id);
    }

    @Override
    public String save(PackageProductResource entity) {
        return rest.post(entity);
    }

    @Override
    public String update(PackageProduct entity) {
        return rest.put(entity);
    }

    @Override
    public String delete(PackageProduct entity) {

        return rest.delete(entity);
    }

    @Override
    public List<PackageProductResource> findAll() {
        return rest.getAll();
    }
}

