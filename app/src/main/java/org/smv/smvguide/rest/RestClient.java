package org.smv.smvguide.rest;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import java.io.IOException;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by root on 12/5/16.
 */
public class RestClient {

        private static Retrofit mRetrofit;

        public static Retrofit getRetrofit() {
            if(mRetrofit == null){
                buildRetrofit();
            }
            return mRetrofit;
        }

        private static void buildRetrofit() {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl("http://www.smvhistory.org/wp-json/wp/v2/")
                    .client(createClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }


        private static OkHttpClient createClient(){
            OkHttpClient client = new OkHttpClient();
            client.interceptors().add(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request();

                    request = request.newBuilder()
                            /*.addHeader("X-Parse-Application-Id", Constants.APPID)
                            .addHeader("X-Parse-REST-API-Key", Constants.RESTKEY)
                            .addHeader("X-Parse-Master-Key" , Constants.MASTERKEY)
                            .addHeader("Content-Type", "Json")*/
                            .build();

                    Response response = chain.proceed(request);
                    return response;
                }
            });
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            client.interceptors().add(interceptor);

            return client;
        }

}
