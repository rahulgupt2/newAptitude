package com.domain;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.NaiDuniaNews;
import com.model.NaiDuniaOneNews;
import com.model.Response;
import com.util.DocumentBuilder;

@Component("websiteReaderImplNews")
public class WebsiteReaderImplNews implements WebSiteReaderNews {

	@Autowired
	WebSiteInitReader webSiteInitReader;

	@Autowired
	DocumentBuilder documentBuilder;

	private static final Logger LOG = LoggerFactory.getLogger(WebsiteReaderImplNews.class);

	@Override
	public Response webSiteReader(String cityName) {

		Response response = new Response();

		Document documentNews = null;
		try {
			documentNews = webSiteInitReader.getDoc();
		} catch (Exception e) {
			LOG.error("Exception is : ", e);
			response.setSucceeded("false");
			response.setResponse("Not Found init");

			return response;
		}

		if (cityName == null) {
			response.setSucceeded("false");
			response.setResponse("cannot find cityName");
			return response;
		}
		/*
		 * if(cityName.length() > 20 ) { response.setSucceeded("false");
		 * response.setResponse("canot find cityName");
		 * 
		 * return response; }
		 */
		String url = documentBuilder.urlBuilderNaiDuniaMadhyaPradesh(cityName);
		LOG.info("url is :", url);
		documentNews = documentBuilder.getDocumnet(url);

		if (documentNews == null) {
			response.setSucceeded("false");
			response.setResponse("cannot call make url");
			return response;
		}

		Elements elemetsMp = documentNews.getElementsByClass("article-list");
		LOG.info("size is : " + elemetsMp.size());

		if (elemetsMp.size() == 0) {
			response.setSucceeded("false");
			response.setResponse("please provide valid city name");
			return response;
		}

		NaiDuniaNews naiduniaNewsAll = new NaiDuniaNews();
		List<NaiDuniaOneNews> naiDuniaOneNewsList = new ArrayList<NaiDuniaOneNews>();

		elemetsMp.forEach(link -> {

			if (link != null) {
				NaiDuniaOneNews naiDuniaNews = new NaiDuniaOneNews();
				Elements elemetsLeft = link.getElementsByClass("left-listing");

				// element left gives us img
				if (elemetsLeft == null) {

					naiDuniaNews.setImageUrl("no image");
				} else {
					elemetsLeft.forEach(linkLeft -> {

						if (linkLeft != null) {
							Elements imageElements = linkLeft.select("img");
							if (imageElements == null) {
								naiDuniaNews.setImageUrl("no image");
							} else {
								if (imageElements.size() == 0) {
									naiDuniaNews.setImageUrl("no image");
								} else {
									Element elementImgUrl = imageElements.get(0);
									if (elementImgUrl == null) {
										naiDuniaNews.setImageUrl("no image");
									} else {
										LOG.info("linkImage get(0) tag is left-listing : " + elementImgUrl.attr("src"));
										LOG.info("linkImage get(0) tag is left-listing : " + elementImgUrl.outerHtml());

										String imageUrl = elementImgUrl.attr("src");
										if (imageUrl == null) {
											naiDuniaNews.setImageUrl("no image");
										} else if (imageUrl.equals("")) {
											naiDuniaNews.setImageUrl(elementImgUrl.absUrl("data-src"));
										} else {
											naiDuniaNews.setImageUrl(elementImgUrl.absUrl("src"));
										}

									}

								}
							}
							// naiDuniaNews.setImageUrl(elementImgUrl.absUrl("src"));
							// LOG.info("link news tag is left-listing : " +
							// linkLeft.select("a[href]").attr("abs:href"));
						}

					});

				}
				// element left gives us news link, news heading, news time,
				// para news
				// --- right
				Elements elemetsRight = link.getElementsByClass("right-listing");

				if (elemetsRight == null) {
					naiDuniaNews.setNewsUrl("no url");
					naiDuniaNews.setHeadingNews("no heading");
					naiDuniaNews.setTime(" no time");
					naiDuniaNews.setParaNews("no text");
				} else {

					elemetsRight.forEach(linkRight -> {
						if (linkRight != null) {

							Elements newsElements = linkRight.select("a[href]");

							if (newsElements == null) {
								naiDuniaNews.setNewsUrl("no url");
								naiDuniaNews.setHeadingNews("no heading");
							} else {
								Element newsUrl = newsElements.get(0);
								if (newsUrl == null) {
									naiDuniaNews.setNewsUrl("no url");
									naiDuniaNews.setHeadingNews("no heading");
								} else {
									LOG.info("news url is : " + newsUrl.attr("abs:href"));
									naiDuniaNews.setNewsUrl(newsUrl.attr("abs:href"));
									LOG.info("news heading  is : " + newsUrl.ownText());
									naiDuniaNews.setHeadingNews(newsUrl.ownText());
								}
							}

							Elements timeElements = linkRight.select("p");

							if (timeElements == null) {
								naiDuniaNews.setTime(" no time");
								naiDuniaNews.setParaNews("no text");
							} else {

								if (timeElements.size() != 2) {
									naiDuniaNews.setTime(" no time");
									naiDuniaNews.setParaNews("no text");
								} else {
									Element time = timeElements.first();
									if (time == null) {
										naiDuniaNews.setTime(" no time");
										naiDuniaNews.setParaNews("no text");
									} else {
										LOG.info("time is : " + time.text());
										naiDuniaNews.setTime(time.text());
										Element paraNews = timeElements.get(1);
										LOG.info("para news is : " + paraNews.text());
										naiDuniaNews.setParaNews(paraNews.text());
									}
								}
							}
						}
					});

				}

				naiDuniaOneNewsList.add(naiDuniaNews);
			}
		});

		naiduniaNewsAll.setNaiDuniaAllNews(naiDuniaOneNewsList);

		Elements paginationElements = documentNews.getElementsByClass("pagination");
		List<String> paginationUrls = new ArrayList<String>();

		if (paginationElements == null) {

		} else {
			Element paginationElement = paginationElements.get(0);
			if (paginationElement == null) {

			} else {
				Elements elementLinks = paginationElement.select("a[href]");
				// LOG.info("links of pages : " + elementLinks.outerHtml());
				if (elementLinks == null) {

				} else {
					elementLinks.forEach(link -> {
						String title = link.attr("title");
						LOG.info("title is : " + title);
						if (title == null) {
							paginationUrls.add("no page");
						} else {
							if (title.equals("")) {
								LOG.info("pagination urls are : " + link.attr("href"));
								paginationUrls.add(link.attr("href"));
							}
						}

					});
				}
			}
		}
		naiduniaNewsAll.setPageinationUrls(paginationUrls);

		response.setSucceeded("true");
		response.setNaiDuniaNews(naiduniaNewsAll);
		response.setResponse("successful attempt");

		return response;
		// return "news read sucssful";

	}

}
