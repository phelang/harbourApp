package harbour.cput.ac.za.harbour.repositories;

import java.util.List;

import harbour.cput.ac.za.harbour.domain.PackageProduct;

/**
 * Created by qhuphe01 on 2015/09/27.
 */
public interface RestAPI<S, ID> {

    S get(ID id);

    String post(S entity);

    String put(PackageProduct entity);

    String delete(PackageProduct entity);       // doesnot implement the same, one is Getter and one is Setter
                                                        // getter : ResourceSupport Setter Database Entity type
    List<S> getAll();
}
