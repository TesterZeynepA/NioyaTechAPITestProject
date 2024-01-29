package pages;

import io.restassured.response.Response;
import utilities.ConfigReader;
import static pages.MethodsClass.makeRequest;

public class CatFacts {

    Response response;

    public void getListOf(String url, String endPoint) {
        response= makeRequest("GET", url + endPoint, null);
        response.prettyPrint();

    }

    public void verifyStatusCode(int statusCode) {
        getListOf(ConfigReader.getProperty("url"),"/breeds");
        response.then().assertThat().statusCode(statusCode);
    }

    public void verifyContentType(String contentType){
        getListOf(ConfigReader.getProperty("url"),"/breeds");
        response.then().assertThat().contentType(contentType);
    }


    /*
    //    onemli olan burada log4j mesaj seviyeleri..
    //    All  – Günlük kaydı düzeyip her şeyi günlüğe kaydeder. (Tüm günlükleri açar)
    //    DEBUG – Hata ayıklama bilgilerini yazdırır ve geliştirme aşamasında yardımcı olur.
    //    INFO – Uygulamanın ilerleyişini vurgulayan bilgi mesajı yazdırır.
    //    WARN – Hatalı ve beklenmeyen sistem davranışıyla ilgili bilgileri yazdırır.
    //    ERROR – Sistemin devam etmesine izin verebilecek bir hata mesajı yazdırır.
    //    FATAL – Uygulamanın çökmesine neden olan sistemin kritik bilgilerini yazdırır.
    //    OFF – Kayıt yok.


        Logger logger = LogManager.getLogger(C56_Log4j.class.getName());

        logger.trace("bu bir trace mesajidir");//trace
        logger.debug("bu bir debug mesajidir");//debug
        logger.info("bu bir info mesajidir");//info
        logger.warn("bu bir warn mesajidir");//warn
        logger.error("bu bir error mesajidir");//error
        logger.fatal("bu bir fatal mesajidir");//fatal

    }
    //logger ile configurasyon olmadan sadece
    // ERROR C56_Log4j bu bir error mesajidir
    // FATAL C56_Log4j bu bir fatal mesajidir
    //yukardaki ciktilari alabilirz..bunu duzenlemek icin konfigurrasyon yapmaliyiz..*/

    /*//Logger ları import ederken dikkat edelim, hata alabiliriz...
    public static void main(String[] args) {

        //loglarımızı configure etmek için
        PropertyConfigurator.configure("log4j.properties");

        Logger logger = Logger.getLogger(C57_Log4j_UseProperties.class);

        logger.trace("bu bir trace mesajidir");//trace
        logger.debug("bu bir debug mesajidir");//debug
        logger.info("bu bir info mesajidir");//info
        logger.warn("bu bir warn mesajidir");//warn
        logger.error("bu bir error mesajidir");//error
        logger.fatal("bu bir fatal mesajidir");//fatal
    }*/

}
