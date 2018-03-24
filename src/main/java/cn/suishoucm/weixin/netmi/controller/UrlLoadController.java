package cn.suishoucm.weixin.netmi.controller;

import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.protocol.HttpContext;
import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.suishoucm.weixin.netmi.util.HttpUtils;
import cn.suishoucm.weixin.netmi.util.StringResponse;

@Controller

public class UrlLoadController {
	Logger logger = LoggerFactory.getLogger(UrlLoadController.class);
	private static HttpClientContext context = HttpClientContext.create();

	static {
		context.setCookieStore(new BasicCookieStore());
	}

	@RequestMapping(value = "")

	public String openUrl(String url, Model model) throws Exception {

		return page(url, model);

	}

	private static Map<String, String> map = new HashMap<>();

	@RequestMapping("{a1}/{a2:.+}")
	public String a1a2(@PathVariable("a1") String a1, @PathVariable("a2") String a2, Model model) throws Exception {
		String url = StringUtil.resolve(map.get(a1), a2);
		return page(url, model);
	}

	@RequestMapping("{a1}/{a2}/{a3:.+}")
	public String a1a2a3(@PathVariable("a1") String a1, @PathVariable("a2") String a2, @PathVariable("a3") String a3,
			Model model) throws Exception {
		String relativePath = a2 + "/" + a3;

		String url = StringUtil.resolve(map.get(a1), relativePath);

		return page(url, model);
	}

	@RequestMapping("{a1}/{a2}/{a3}/{a4:.+}")
	public String a1a2a3a4(@PathVariable("a1") String a1, @PathVariable("a2") String a2, @PathVariable("a3") String a3,
			@PathVariable("a4") String a4, Model model) throws Exception {
		String relativePath = a2 + "/" + a3 + "/" + a4;

		String url = StringUtil.resolve(map.get(a1), relativePath);

		return page(url, model);
	}

	@RequestMapping("{a1}/{a2}/{a3}/{a4}/{a5:.+}")
	public String a1a2a3a4a5(@PathVariable("a1") String a1, @PathVariable("a2") String a2,
			@PathVariable("a3") String a3, @PathVariable("a4") String a4, @PathVariable("a5") String a5, Model model)
					throws Exception {
		String relativePath = a2 + "/" + a3 + "/" + a4 + "/" + a5;
		String url = StringUtil.resolve(map.get(a1), relativePath);
		return page(url, model);
	}

	@RequestMapping("{a1}/{a2}/{a3}/{a4}/{a5}/{a6:.+}")
	public String a1a2a3a4a5a6(@PathVariable("a1") String a1, @PathVariable("a2") String a2,
			@PathVariable("a3") String a3, @PathVariable("a4") String a4, @PathVariable("a5") String a5,
			@PathVariable("a6") String a6, Model model) throws Exception {
		String relativePath = a2 + "/" + a3 + "/" + a4 + "/" + a5 + "/" + a6;
		String url = StringUtil.resolve(map.get(a1), relativePath);
		return page(url, model);
	}

	@RequestMapping("{a1}/{a2}/{a3}/{a4}/{a5}/{a6}/{a7:.+}")
	public String a1a2a3a4a5a6a7(@PathVariable("a1") String a1, @PathVariable("a2") String a2,
			@PathVariable("a3") String a3, @PathVariable("a4") String a4, @PathVariable("a5") String a5,
			@PathVariable("a6") String a6, @PathVariable("a7") String a7, Model model) throws Exception {
		String relativePath = a2 + "/" + a3 + "/" + a4 + "/" + a5 + "/" + a6 + "/" + a7;

		String url = StringUtil.resolve(map.get(a1), relativePath);
		return page(url, model);
	}

	@RequestMapping("{a1}/{a2}/{a3}/{a4}/{a5}/{a6}/{a7}/{a8:.+}")
	public String a1a2a3a4a5a6a7a8(@PathVariable("a1") String a1, @PathVariable("a2") String a2,
			@PathVariable("a3") String a3, @PathVariable("a4") String a4, @PathVariable("a5") String a5,
			@PathVariable("a6") String a6, @PathVariable("a7") String a7, @PathVariable("a8") String a8, Model model)
					throws Exception {
		String relativePath = a2 + "/" + a3 + "/" + a4 + "/" + a5 + "/" + a6 + "/" + a7 + "/" + a8;
		String url = StringUtil.resolve(map.get(a1), relativePath);
		return page(url, model);
	}

	@RequestMapping("{a1}/{a2}/{a3}/{a4}/{a5}/{a6}/{a7}/{a8}/{a9:.+}")
	public String a1a2a3a4a5a6a7a9(@PathVariable("a1") String a1, @PathVariable("a2") String a2,
			@PathVariable("a3") String a3, @PathVariable("a4") String a4, @PathVariable("a5") String a5,
			@PathVariable("a6") String a6, @PathVariable("a7") String a7, @PathVariable("a8") String a8,
			@PathVariable("a9") String a9, Model model) throws Exception {
		String relativePath = a2 + "/" + a3 + "/" + a4 + "/" + a5 + "/" + a6 + "/" + a7 + "/" + a8 + "/" + a9;
		String url = StringUtil.resolve(map.get(a1), relativePath);
		return page(url, model);
	}

	@RequestMapping("{a1}/{a2}/{a3}/{a4}/{a5}/{a6}/{a7}/{a8}/{a9}/{a10:.+}")
	public String a1a2a3a4a5a6a7a9a10(@PathVariable("a1") String a1, @PathVariable("a2") String a2,
			@PathVariable("a3") String a3, @PathVariable("a4") String a4, @PathVariable("a5") String a5,
			@PathVariable("a6") String a6, @PathVariable("a7") String a7, @PathVariable("a8") String a8,
			@PathVariable("a9") String a9, @PathVariable("a10") String a10, Model model) throws Exception {
		String relativePath = a2 + "/" + a3 + "/" + a4 + "/" + a5 + "/" + a6 + "/" + a7 + "/" + a8 + "/" + a9 + "/"
				+ a10;
		String url = StringUtil.resolve(map.get(a1), relativePath);
		return page(url, model);
	}

	private String page(String url, Model model) throws Exception {
		URI baseUri = new URI(url);
		System.out.println("œ¬‘ÿ£∫" + url);
		if (url.endsWith(".jpg") || url.endsWith(".gif") || url.endsWith(".png")) {
			model.addAttribute("binary", HttpUtils.getBinary(url).getResponseBody());
			return "/urlLoad/img";
		} else if (url.endsWith(".css")) {
			String html = HttpUtils.get(url, context).getResponseBody();
			model.addAttribute("css", html);
			return "/urlLoad/css";

		} else if (url.endsWith(".js")) {
			String html = HttpUtils.get(url, context).getResponseBody();
			model.addAttribute("js", html);
			return "/urlLoad/js";
		} else {
			String html = HttpUtils.get(url, context).getResponseBody();
			Document doc = Jsoup.parse(html);

			Elements eles = doc.getElementsByAttribute("src");
			attrFilter(eles, baseUri, "src");

			eles = doc.getElementsByAttribute("href");
			attrFilter(eles, baseUri, "href");

			model.addAttribute("html", doc.html());
			return "/urlLoad/html";
		}

	}

	private void attrFilter(Elements eles, URI baseUri, String attrName) {
		for (Element ele : eles) {
			try {
				String src = ele.attr(attrName);
				URI uri = new URI(src);
				String host = uri.getHost();
				if (host == null) {
					host = baseUri.getHost();
				}
				String id = DigestUtils.md5Hex(host);
				String scheme = uri.getScheme();
				if (scheme == null) {
					scheme = baseUri.getScheme();
				}
				map.put(id, scheme + "://" + host);
				src = id + uri.getPath();
				ele.attr(attrName, "/" + src + (uri.getQuery() == null ? "" : "?" + uri.getQuery()));
			} catch (Exception e) {
				logger.error(ele.toString(), e);
			}

		}
	}

}
