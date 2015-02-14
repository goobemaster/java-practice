package gabor;

import java.net.*;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HttpClient {
  URL serverUrl;
  Map<String, String> headers;
  public int responseCode;
  public String response;

//  public static void main(String[] args) throws Exception {
//    HttpClient client = new HttpClient("http://jsonplaceholder.typicode.com");
//    client.addHeader("User-Agent", "Mozilla/5.0");
//    client.addHeader("Accept-Language", "en-US,en;q=0.5");
//
//    System.out.println("Test - Send HTTP GET request");
//    client.get("/posts/1");
//    System.out.println("Response code: " + client.responseCode);
//    System.out.println("Response: \n" + client.response);
//  }

  public HttpClient(String url) throws MalformedURLException {
    this.serverUrl = new URL(url);
    this.headers = new HashMap<String, String>(0);
    this.responseCode = 0;
  }

  public void setHeaders(HashMap<String, String> headers) {
    this.headers = headers;
  }

  public String getHeader(String key) {
    return this.headers.get(key);
  }

  public boolean addHeader(String key, String value) {
    if (this.getHeader(key) == null) {
      this.headers.put(key, value);
      return true;
    } else {
      return false;
    }
  }

  private String getResponse(HttpURLConnection httpConnection) throws Exception {
    BufferedReader inputStream = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
    String inputLine;
    StringBuffer response = new StringBuffer();

    while ((inputLine = inputStream.readLine()) != null) {
      response.append(inputLine);
    }
    inputStream.close();

    return response.toString();
  }

  public Boolean get(String path) throws Exception {
    URL url = new URL(this.serverUrl + path);
    HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
    httpConnection.setRequestMethod("GET");

    for (Map.Entry<String, String> entry : this.headers.entrySet()) {
      httpConnection.addRequestProperty(entry.getKey(), entry.getValue());
    }

    this.responseCode = httpConnection.getResponseCode();
    this.response = getResponse(httpConnection);

    if (this.responseCode == 200) {
      return true;
    } else {
      return false;
    }
  }


}
