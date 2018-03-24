package netmi;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class UrlTest {
	public static void main(String[] args) throws MalformedURLException, URISyntaxException {
		URI uri = new URI("//www.baidu.com/sadf");
		// URL url=new URL("//www.baidu.com/sadf");
		System.out.println(uri.getHost());
		System.err.println(uri.getPath());

		uri = new URI("/sadf/asdfaasdf/eee");
		System.out.println(uri.getHost());

	}
}
