package harbour.cput.ac.za.harbour.repositories.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


import harbour.cput.ac.za.harbour.domain.PackageProduct;
import harbour.cput.ac.za.harbour.model.PackageProductResource;
import harbour.cput.ac.za.harbour.repositories.RestAPI;


/**
 * Created by qhuphe01 on 2015/09/27.
 */
public class RestPackageProduct  implements RestAPI<PackageProductResource, Long> {

    final String BASE_URL = "http://harbour-phelang.rhcloud.com/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    public PackageProductResource get(Long id) {

        final String url = BASE_URL+"packageproducts/" +id.toString();

        HttpEntity<PackageProductResource> requestEntity = new HttpEntity<>(requestHeaders);
        //restTemplate.getMessageConverters();
        ResponseEntity<PackageProductResource> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, PackageProductResource.class);

        PackageProductResource packages = responseEntity.getBody();

        return packages;
    }

    @Override
    public String post(PackageProductResource entity) {

        final String url = BASE_URL+"packageproducts/create";
        HttpEntity<PackageProductResource> requestEntity = new HttpEntity<>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String put(PackageProduct entity) {

        final String url = BASE_URL+"packageproducts/update/"+entity.getId().toString();
        HttpEntity<PackageProduct> requestEntity = new HttpEntity<PackageProduct>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;

    }

    @Override
    public String delete(PackageProduct entity) {
        final String url = BASE_URL+"packageproducts/delete/"+entity.getId().toString();

        HttpEntity<String> requestEntity = new HttpEntity<String>(requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, String.class);

        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public List<PackageProductResource> getAll() {

        List<PackageProductResource> packages = new ArrayList<>();
        final String url = BASE_URL+"packageproducts/packages/";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<PackageProductResource[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, PackageProductResource[].class);
        PackageProductResource[] results = responseEntity.getBody();

        for (PackageProductResource subject : results) {
            packages.add(subject);
        }
        return packages;

    }
}



