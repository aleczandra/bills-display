package bills.billsdisplay.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

import bills.billsdisplay.elastic.ElasticClient;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.springframework.stereotype.Component;

@Component
public class BillsReader {

    public String performSearch() throws IOException {

        RestClient client = ElasticClient.createClient();
        Map<String, String> params = Collections.singletonMap("pretty", "true");
        Response response = client.performRequest("GET", "/billsindex/bills/_search", params);
        HttpEntity entity = response.getEntity();
        String s = EntityUtils.toString(entity);
        return s;
    }
}
