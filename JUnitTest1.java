/**
 * Created by GoobeMaster on 2015.02.14..
 */

import org.hamcrest.*;
import org.junit.*;
import gabor.HttpClient;

public class JUnitTest1 {
  HttpClient client;

  public void callService(String method, String path) throws Exception {
    this.client = new HttpClient("http://jsonplaceholder.typicode.com");
    this.client.addHeader("User-Agent", "Mozilla/5.0");
    this.client.addHeader("Accept-Language", "en-US,en;q=0.5");
    if (method.equals("GET")) {
      this.client.get(path);
    }
  }

  @Test
  public void serviceResponse() throws Exception {
    this.callService("GET", "/posts/1");

    org.junit.Assert.assertEquals("Service responded with error code!", 200, this.client.responseCode);
  }
}
