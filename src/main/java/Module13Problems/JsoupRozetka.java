package Module13Problems;

import org.jsoup.Jsoup;

import java.io.IOException;

public class JsoupRozetka {
    public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect("https://www.amazon.eg/%D8%A8%D8%B1%D8%B0%D8%A7%D8%B0-%D8%A8%D8%A7%D9%84%D9%85%D9%88%D8%AC%D8%A7%D8%AA-%D8%A7%D9%84%D8%B5%D9%88%D8%AA%D9%8A%D8%A9-%D9%88%D8%AA%D8%B1%D8%AA%D8%B1%D8%8C-%D8%A7%D9%84%D9%87%D9%88%D8%A7%D8%A1/dp/B0BHC5C9XG/ref=asc_df_B0BHC5C9XG/?tag=egoshpaddear-21&linkCode=df0&hvadid=544938494770&hvpos=&hvnetw=g&hvrand=961056272241901806&hvpone=&hvptwo=&hvqmt=&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9112342&hvtargid=pla-1897256247326&psc=1&language=en_AE")
                //.header("contentType", "application/json") тільки для джейсонів
                .get();
        Element element = document.selectFirst("span.a-price-whole");
        System.out.println("element.text() = " + element.text());
        long parseLong = Long.parseLong(element.text().replace(".", "").replace(",", ""));
        System.out.println("parseLong = " + parseLong);


    }
}
