package bleier.products;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductsServiceFactory {

    public ProductsService create() {

        // configure Retrofit for the dummyjson website
        //retrofit object allows us these services
        Retrofit retrofit = new Retrofit.Builder()
                //method calls
                //server that we can connect to
                .baseUrl("https://dummyjson.com/")
                // Configure Retrofit to use Gson to turn the Json into Objects
                .addConverterFactory(GsonConverterFactory.create())
                // Configure Retrofit to use Rx
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();

        return retrofit.create(ProductsService.class);
    }
}
