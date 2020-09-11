package com.encoding;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Encode {
    private static String text = "<jobfeed>\n" +
            "<joblisting action=\"INSERT\" num_of_vacancies=\"1\" organisation_id=\"82190\" reference_id=\"Eas2a6ssv3sAssBE\" sender_id=\"8112\">\n" +
            "<workfield id=\"10006000\"/>\n" +
            "<geography id=\"198\"/>\n" +
            "<sector id=\"14000\"/>\n" +
            "<contracttype id=\"901\"/>\n" +
            "<worktype id=\"80001\"/>\n" +
            "<experience id=\"90002\"/>\n" +
            "<channel_list>\n" +
            "<channel>DE</channel>\n" +
            "</channel_list>\n" +
            "<jobdetails>\n" +
            "<language><![CDATA[DE]]></language>\n" +
            "<jobtitle><![CDATA[designer civiel - industriebouw]]></jobtitle>\n" +
            "<joboneliner><![CDATA[designer civiel - industriebouw]]></joboneliner>\n" +
            "<joblocation><![CDATA[Antwerp]]></joblocation>\n" +
            "<description><![CDATA[<p>- binnen Michal Sobolewski 8:58 AM\n" +
            "äöüß het projectteam sta je in voor het ontwerpen en uittekenen van nieuwe gebouwen en constructies alsook  aanpassingen van bestaande constructies\n" +
            "</p><ul><li>i.s.m. de engineer en de projectomschrijving zorg je voor de basic engineering, opvolging/ controle van de detailed via het engineeringbureau<br/> - je houdt rekening bij het ontwerpen van gebouwen en ruimtes met de bouwvoorschriften en technische voorschriften\n" +
            "</li><li>opstellen van de specs in functie van prijsvragen\n" +
            "</li><li>opstellen van kostenramingen en planning i.s.m. de engineer\n" +
            "</li><li>adviseren/ toelichting geven aan de interne klanten over de uitgewerkte voorstellen zowel technisch, budgettaire als realisatietermijn.\n" +
            "</li></ul>]]></description>\n" +
            "<profile><![CDATA[<p>- je hebt een degelijke ervaring in een soortgelijke functie\n" +
            "</p><ul><li>je hebt een goede kennis van staal en beton\n" +
            "</li><li>autocad en/of microstation hebben voor jou geen geheimen meer\n" +
            "</li><li>je zorgt voor een professionele en aangename communicatie naar onze klant<br/>\n" +
            "</li></ul>]]></profile>\n" +
            "<offer><![CDATA[<p>Contract van onbepaalde duur met extra legale voordelen.<br/>Ontwikkeling en je carrièrepad worden door AUSY serieus genomen. <br/>Ben je freelancer en heb je interesse? Reageer snel!</p>\n" +
            "]]></offer>\n" +
            "<physical_location>\n" +
            "<postal_address>\n" +
            "<country_code><![CDATA[BE]]></country_code>\n" +
            "<municipality><![CDATA[ANTWERPEN 4]]></municipality>\n" +
            "<postal_code><![CDATA[2040]]></postal_code>\n" +
            "</postal_address>\n" +
            "</physical_location>\n" +
            "</jobdetails>\n" +
            "<contact>\n" +
            "<name><![CDATA[Freya Mariën]]></name>\n" +
            "<phone><![CDATA[03 200 28 06]]></phone>\n" +
            "<address1><![CDATA[City Link]]></address1>\n" +
            "<city><![CDATA[Berchem]]></city>\n" +
            "<postcode><![CDATA[2600]]></postcode>\n" +
            "<country><![CDATA[Belgium]]></country>\n" +
            "<apply_link><![CDATA[https://banners.knollenstein.com/adnetwork/servlet/advertBeans.TrackingServlet?seid=410109]]></apply_link>\n" +
            "<companyintroduction><![CDATA[<p>FT\">�</Zin om het engineeringteam te vervoegen en je technische kennis te delen?<br/></p>\n" +
            "\n" +
            "<p>We zoeken ter uitbreiding van ons team in de Antwerpse Haven bij onze klant versterking!</p>\n" +
            "]]></companyintroduction>\n" +
            "</contact>\n" +
            "<template id=\"1\">\n" +
            "<field1><![CDATA[<p>Zin om het engineeringteam te vervoegen en je technische kennis te delen?<br/></p>\n" +
            "\n" +
            "<p>We zoeken ter uitbreiding van ons team in de Antwerpse Haven bij onze klant versterking!</p>\n" +
            "]]></field1>\n" +
            "<field2><![CDATA[<p>- binnen het projectteam sta je in voor het ontwerpen en uittekenen van nieuwe gebouwen en constructies alsook  aanpassingen van bestaande constructies\n" +
            "</p><ul><li>i.s.m. de engineer en de projectomschrijving zorg je voor de basic engineering, opvolging/ controle van de detailed via het engineeringbureau<br/> - je houdt rekening bij het ontwerpen van gebouwen en ruimtes met de bouwvoorschriften en technische voorschriften\n" +
            "</li><li>opstellen van de specs in functie van prijsvragen\n" +
            "</li><li>opstellen van kostenramingen en planning i.s.m. de engineer\n" +
            "</li><li>adviseren/ toelichting geven aan de interne klanten over de uitgewerkte voorstellen zowel technisch, budgettaire als realisatietermijn.\n" +
            "</li></ul><IMG src=\"{SCMHitCounterURL}\" height=\"1\" width=\"1\">]]></field2>\n" +
            "<field3><![CDATA[<p>- je hebt een degelijke ervaring in een soortgelijke functie\n" +
            "</p><ul><li>je hebt een goede kennis van staal en beton\n" +
            "</li><li>autocad en/of microstation hebben voor jou geen geheimen meer\n" +
            "</li><li>je zorgt voor een professionele en aangename communicatie naar onze klant<br/>\n" +
            "</li></ul>]]></field3>\n" +
            "<field4><![CDATA[<p>Contract van onbepaalde duur met extra legale voordelen.<br/>Ontwikkeling en je carrièrepad worden door AUSY serieus genomen. <br/>Ben je freelancer en heb je interesse? Reageer snel!</p>\n" +
            "]]></field4>\n" +
            "<field5><![CDATA[{JobContactUsText}]]></field5>\n" +
            "<field6/>\n" +
            "<field7/>\n" +
            "<field8/>\n" +
            "<image/>\n" +
            "</template>\n" +
            "</joblisting>\n" +
            "</jobfeed>\n";
    private static byte[] sourceBytes;

    static {
        try {
            sourceBytes = text.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private static String data;

    static {
        try {
            data = new String(sourceBytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

//        String s2 = new String(data.getBytes("UTF-8"), "UTF-8");
//        System.out.println("dsad");

        call();
    }


    private static void call() throws IOException {
        String urlParameters = "&recruiter=Nora%2BFeskens%2Bjob%2540proalpha.com&feedName=de-proalpha_new&recruiterid=216319&Send=Send";
        byte[] postData = urlParameters.getBytes("UTF-8");
        String s = new String(postData, "UTF-8");
        int postDataLength = postData.length;
        String request = "http://jobfeedweb.stepstone.com/jobfeed-web/save_recruitermapping.jz";
        URL url = new URL(request);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setInstanceFollowRedirects(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
        conn.setUseCaches(false);
        try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
            wr.write(postData);
        }
        System.out.println("respone: " + conn.getResponseCode());
        System.out.println(conn.getResponseMessage());
    }
}