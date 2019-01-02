package com.offcn.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.offcn.dao.BaiCaiDao;
import com.offcn.po.BaiCai;

public class CatBaiCai {

	public static void main(String[] args) throws Exception {
		//初始化spring环境
		int sum=0;
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
		 BaiCaiDao dao = context.getBean(BaiCaiDao.class);
		 for (int i = 1; i <20; i++) {
			 String url="http://www.xinfadi.com.cn/marketanalysis/0/list/"+i+".shtml?prodname=%E5%A4%A7%E7%99%BD%E8%8F%9C&begintime=2017-01-01&endtime=2018-01-01";
			 String html = catHtml(url);
			 List<BaiCai> list = parseHtml(html);
			 for (BaiCai baiCai : list) {
				 dao.save(baiCai);
				 sum++;
				 System.out.println(sum);
			 }
			
		}
		};
		
		/**
		 * httpclient抓取网页内容
		 */
		private static String catHtml(String url) {
			String html = null;
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet(url);
			try {
				CloseableHttpResponse response = httpClient.execute(httpGet);
				int i = response.getStatusLine().getStatusCode();
				if (i == 200) {
					HttpEntity en = response.getEntity();
					html = EntityUtils.toString(en, "utf-8");
				}else {
					System.out.println("状态码错误:"+i);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return html;
		}
		
		/**
		 * jsoup解析html源码，获取其中商品信息
		 * @throws Exception 
		 */
		public static List<BaiCai> parseHtml(String html) throws Exception {
			List<BaiCai> list = new ArrayList<BaiCai>();
			Document doc = Jsoup.parse(html);
			Element e = doc.select(".hq_table").first();
			Elements tr = e.select("tr");
			tr.remove(0);
			for (Element element : tr) {
				String e2 = element.text();
				System.out.println(e2);
				String[] ss = e2.split(" ");
				BaiCai baiCai = new BaiCai();
				baiCai.setName(ss[0]);
				baiCai.setMinprice(Float.valueOf(ss[1]));
				baiCai.setAverageprice(Float.valueOf(ss[2]));
				baiCai.setMaxprice(Float.valueOf(ss[3]));
				baiCai.setReleasedate(new SimpleDateFormat("yyyy-MM-dd").parse(ss[6]));
				System.out.println(baiCai);
				list.add(baiCai);
			}
			return list;
		}
	}
