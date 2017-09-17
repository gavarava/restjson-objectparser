package org.restjson.client.http;

import org.restjson.json.deserialize.JSONUtils;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class HttpClientUtilsTest {
    private static String POST_SRC_URL = "https://jsonplaceholder.typicode.com/posts";

    @Test
    public void theReadURLResponseAsStringReturnsStringDataForValidUrl() throws Exception {
        String urlResponseAsString = HttpClientUtils.readURLResponseAsString(POST_SRC_URL);
        assertThat(urlResponseAsString, is(notNullValue()));
    }

    @Test(expected = RuntimeException.class)
    public void theReadURLResponseAsStringThrowsExceptionForInvalidURL() throws Exception {
        HttpClientUtils.readURLResponseAsString("http://" + System.currentTimeMillis() + ".se");
    }

    @Test
    public void thatSendGetReturnsResponseContentTypeJSONForExampleURL() throws Exception {
        String urlResponseAsString = HttpClientUtils.readURLResponseAsString(POST_SRC_URL);
        final boolean isValidJSONObjectOrArray = JSONUtils.validateJSON(urlResponseAsString) || JSONUtils.checkIsValidJSONArray(urlResponseAsString);
        assertTrue("Invalid JSON String", isValidJSONObjectOrArray);
    }



}