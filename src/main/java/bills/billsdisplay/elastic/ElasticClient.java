package bills.billsdisplay.elastic;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;

public class ElasticClient {

    public static final String USERNAME = "elastic";
    public static final String PASSWORD = "changeme";

    public static RestClient createClient() {
        return createClient(new HttpHost("elastic", 9200),
            new UsernamePasswordCredentials("elastic", "changeme"));
    }

    public static RestClient createClient(HttpHost host, Credentials credentials) {
        return RestClient.builder(host).setHttpClientConfigCallback(use(credentials)).build();
    }

    private static RestClientBuilder.HttpClientConfigCallback use(Credentials credentials) {
        final CredentialsProvider provider = new BasicCredentialsProvider();
        provider.setCredentials(AuthScope.ANY, credentials);
        return new RestClientBuilder.HttpClientConfigCallback() {
            @Override
            public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder builder) {
                return builder.setDefaultCredentialsProvider(provider);
            }
        };
    }
}
