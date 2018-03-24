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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.suishoucm.weixin.netmi.util.HttpUtils;
import cn.suishoucm.weixin.netmi.util.StringResponse;

@Controller

public class UrlLoadController {

	private static HttpClientContext context = HttpClientContext.create();

	static {
		context.setCookieStore(new BasicCookieStore());
	}

	@RequestMapping(value = "")

	public String openUrl(String url, Model model) throws Exception {
		Map<String, Object> result = new HashMap<>();
		String baseUrl = url;

		StringResponse sr = HttpUtils.get(baseUrl,context);
	
		
		System.out.println(sr.getResponseBody());
		Document doc = Jsoup.parse(sr.getResponseBody(), baseUrl);
		Elements eles= doc.getElementsByAttribute("src");
		for (Element ele : eles) {
			String src=ele.attr("src");
			URI uri=new URI(src);
			String host=uri.getHost();
			if(host!=null){
				String id=DigestUtils.md5Hex(host);
				map.put(id, host);
				src=id+uri.getPath();
				ele.attr("src",src);
			}
			//if(src.startsWith("//")+url2.get)
			
		}
		System.out.println();

		// result.put("html", sr.getResponseBody());
		System.out.println(doc.html());
		model.addAttribute("html", doc.html());

		return "/urlLoad/html";

	}

	private static Map<String, String> map = new HashMap<>();

	static {
		map.put("zzz", "http://www.baidu.com/");
		map.put("xxx", "http://www.icbc.com.cn/ICBC/%E9%87%8D%E8%A6%81%E5%85%AC%E5%91%8A/default1.htm");
	}

	@RequestMapping("{a1}/{a2:.+}")
	public String a1a2(@PathVariable("a1") String a1, @PathVariable("a2") String a2, Model model) throws Exception {
		String url = map.get(a1);
		System.out.println(url);
		return page(url, model);
	}

	@RequestMapping("{a1}/{a2}/{a3:.+}")
	public String a1a2a3(@PathVariable("a1") String a1, @PathVariable("a2") String a2, @PathVariable("a3") String a3,
			Model model) throws Exception {
		String relativePath = a2 + "/" + a3;

		String url = StringUtil.resolve(map.get(a1), relativePath);
		System.out.println(url);
		return page(url, model);
	}

	@RequestMapping("{a1}/{a2}/{a3}/{a4:.+}")
	public String a1a2a3a4(@PathVariable("a1") String a1, @PathVariable("a2") String a2, @PathVariable("a3") String a3,
			@PathVariable("a4") String a4, Model model) throws Exception {
		String relativePath = a2 + "/" + a3 + "/" + a4;
	
		String url = StringUtil.resolve(map.get(a1), relativePath);

		System.out.println(url);
		return page(url, model);
	}

	@RequestMapping("{a1}/{a2}/{a3}/{a4}/{a5:.+}")
	public String a1a2a3a4a5(@PathVariable("a1") String a1, @PathVariable("a2") String a2,
			@PathVariable("a3") String a3, @PathVariable("a4") String a4, @PathVariable("a5") String a5, Model model)
					throws Exception {
		String relativePath = a2 + "/" + a3 + "/" + a4 + "/" + a5;
		String url = StringUtil.resolve(map.get(a1), relativePath);
		System.out.println(url);
		return page(url, model);
	}

	@RequestMapping("{a1}/{a2}/{a3}/{a4}/{a5}/{a6:.+}")
	public String a1a2a3a4a5a6(@PathVariable("a1") String a1, @PathVariable("a2") String a2,
			@PathVariable("a3") String a3, @PathVariable("a4") String a4, @PathVariable("a5") String a5,
			@PathVariable("a6") String a6, Model model) throws Exception {
		String relativePath = a2 + "/" + a3 + "/" + a4 + "/" + a5 + "/" + a6;
		String url = StringUtil.resolve(map.get(a1), relativePath);
		System.out.println(url);
		return page(url, model);
	}

	@RequestMapping("{a1}/{a2}/{a3}/{a4}/{a5}/{a6}/{a7:.+}")
	public String a1a2a3a4a5a6a7(@PathVariable("a1") String a1, @PathVariable("a2") String a2,
			@PathVariable("a3") String a3, @PathVariable("a4") String a4, @PathVariable("a5") String a5,
			@PathVariable("a6") String a6, @PathVariable("a7") String a7, Model model) throws Exception {
		String relativePath = a2 + "/" + a3 + "/" + a4 + "/" + a5 + "/" + a6 + "/" + a7;
		
		String url = StringUtil.resolve(map.get(a1), relativePath);
		System.out.println(url);
		return page(url, model);
	}

	@RequestMapping("{a1}/{a2}/{a3}/{a4}/{a5}/{a6}/{a7}/{a8:.+}")
	public String a1a2a3a4a5a6a7a8(@PathVariable("a1") String a1, @PathVariable("a2") String a2,
			@PathVariable("a3") String a3, @PathVariable("a4") String a4, @PathVariable("a5") String a5,
			@PathVariable("a6") String a6, @PathVariable("a7") String a7, @PathVariable("a8") String a8, Model model)
					throws Exception {
		String relativePath = a2 + "/" + a3 + "/" + a4 + "/" + a5 + "/" + a6 + "/" + a7 + "/" + a8;
		String url = StringUtil.resolve(map.get(a1), relativePath);
		System.out.println(url);
		return page(url, model);
	}

	@RequestMapping("{a1}/{a2}/{a3}/{a4}/{a5}/{a6}/{a7}/{a8}/{a9:.+}")
	public String a1a2a3a4a5a6a7a9(@PathVariable("a1") String a1, @PathVariable("a2") String a2,
			@PathVariable("a3") String a3, @PathVariable("a4") String a4, @PathVariable("a5") String a5,
			@PathVariable("a6") String a6, @PathVariable("a7") String a7, @PathVariable("a8") String a8,
			@PathVariable("a9") String a9, Model model) throws Exception {
		String relativePath = a2 + "/" + a3 + "/" + a4 + "/" + a5 + "/" + a6 + "/" + a7 + "/" + a8 + "/" + a9;
		String url = StringUtil.resolve(map.get(a1), relativePath);
		System.out.println(url);
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
		System.out.println(url);
		return page(url, model);
	}

	private String page(String url, Model model) throws Exception {
		if (url.endsWith(".jpg") || url.endsWith(".gif") || url.endsWith(".png")) {
			model.addAttribute("binary", HttpUtils.getBinary(url).getResponseBody());
			return "/urlLoad/img";
		} else if (url.endsWith(".css")) {
			String html = HttpUtils.get(url,context).getResponseBody();
			model.addAttribute("css", html);
			return "/urlLoad/css";

		} else if (url.endsWith(".js")) {
			String html = HttpUtils.get(url,context).getResponseBody();
			model.addAttribute("js", html);
			return "/urlLoad/js";
		} else {
			String html = HttpUtils.get(url,context).getResponseBody();
			Document doc = Jsoup.parse(html);
			Elements eles = doc.getElementsByAttribute("src");
	
			eles = doc.getElementsByAttribute("href");
			model.addAttribute("html", doc.html());
			return "/urlLoad/html";
		}

	}

}
