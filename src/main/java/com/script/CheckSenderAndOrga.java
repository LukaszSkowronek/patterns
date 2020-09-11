//package com.script;
//
//import org.w3c.dom.Document;
//import org.w3c.dom.NodeList;
//import org.xml.sax.InputSource;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.xpath.XPath;
//import javax.xml.xpath.XPathConstants;
//import javax.xml.xpath.XPathExpression;
//import javax.xml.xpath.XPathExpressionException;
//import javax.xml.xpath.XPathFactory;
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.StringReader;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Map;
//import java.util.Objects;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//public class CheckSenderAndOrga {
//
//
//    private static String JWFData = "/Users/skowrl01/OneDrive - StepStone Group/Documents/pattern/src/main/resources/static/SenderCheck.txt";
//    private static String sourceCodeData = "/Users/skowrl01/IdeaProjects/jobfeed-stepstone/jobfeed-stepstone-live/src/main/resources/feeds/";
//
//
//    public static void main(String[] args) {
//        List<String> feedLine = new ArrayList<>();
//        readFeedDataFromJWF(feedLine);
//        try (Stream<Path> paths = Files.walk(Paths.get(sourceCodeData))) {
//            Map<String, Document> feedsContent = paths
//                    .filter(Files::isRegularFile)
//                    .map(p -> {
//                        try {
//                            return Files.readString(p, StandardCharsets.ISO_8859_1);
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                        return "";
//                    })
//                    .map(CheckSenderAndOrga::convertToXml)
//                    .filter(Objects::nonNull)
////                    .map(CheckSenderAndOrga::takeCustomer)
//                    .collect(Collectors.toMap(CheckSenderAndOrga::takeCustomer, Function.identity()));
//            System.out.println(feedsContent);
//
//            List<FeedInfo> listOfFeeds = feedLine.stream()
//                    .map(FeedInfo::mapToObject)
//                    .collect(Collectors.toList());
//            List<String> senderIdNotMached = new ArrayList<>();
//            List<String> orgaIdNotMached = new ArrayList<>();
//            List<String> channelNotMached = new ArrayList<>();
//
//            for (FeedInfo f : listOfFeeds) {
//                Document document = feedsContent.get(f.getCustomer());
//
//                if (feedsContent.get(f.getCustomer()) != null) {
//                    if (!f.getSenderId().equals(takeSenderId(document))) {
//                        senderIdNotMached.add(f.getCustomer());
//                    }
//
//                    if (!f.getOrgaId().equals(takeOrgaId(document))) {
//                        orgaIdNotMached.add(f.getCustomer());
//                    }
//
//                    if (!f.getChannel().equals(takeChannel(document))) {
//                        channelNotMached.add(f.getCustomer());
//                    }
//                }
//            }
//
//
//            System.out.println("Wrong sender id:---------------- ");
//            senderIdNotMached.forEach(System.out::println);
//            System.out.println("Wrong orga id:---------------- ");
//            orgaIdNotMached.forEach(System.out::println);
//            System.out.println("Wrong channel id:----------- ");
//            channelNotMached.forEach(System.out::println);
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    private static String takeOrgaId(Document doc) {
//        XPathFactory xPathfactory = XPathFactory.newInstance();
//        XPath xpath = xPathfactory.newXPath();
//        XPathExpression expr = null;
//        try {
//            expr = xpath.compile("//feed[@orga-id]");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        NodeList nl = null;
//        try {
//            nl = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if (nl != null && nl.getLength() != 0) {
//            return nl.item(0).getAttributes().getNamedItem("orga-id").getNodeValue();
//        } else {
//            return "";
//        }
//    }
//
//    private static String takeChannel(Document doc) {
//        XPathFactory xPathfactory = XPathFactory.newInstance();
//        XPath xpath = xPathfactory.newXPath();
//        XPathExpression expr = null;
//        try {
//            expr = xpath.compile("//feed[@channel]");
//        } catch (XPathExpressionException e) {
//            e.printStackTrace();
//        }
//        NodeList nl = null;
//        try {
//            nl = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if (nl != null && nl.getLength() != 0) {
//            return nl.item(0).getAttributes().getNamedItem("channel").getNodeValue();
//        }
//        return "";
//    }
//
//
//    private static class FeedInfo {
//        private String customer;
//
//        public String getCustomer() {
//            return customer;
//        }
//
//        public void setCustomer(String customer) {
//            this.customer = customer;
//        }
//
//        private String senderId;
//        private String orgaId;
//        private String channel;
//
//        private static FeedInfo mapToObject(String f) {
//            List<String> feedInf = Arrays.asList(f.split("\t"));
//            FeedInfo feedInfo = new FeedInfo();
//            feedInfo.setCustomer(feedInf.get(0));
//            feedInfo.setSenderId(feedInf.get(1));
//            feedInfo.setOrgaId(feedInf.get(2));
//            feedInfo.setChannel(feedInf.get(3));
//            return feedInfo;
//        }
//
//        public String getSenderId() {
//            return senderId;
//        }
//
//        public void setSenderId(String senderId) {
//            this.senderId = senderId;
//        }
//
//        public String getOrgaId() {
//            return orgaId;
//        }
//
//        public void setOrgaId(String orgaId) {
//            this.orgaId = orgaId;
//        }
//
//        public String getChannel() {
//            return channel;
//        }
//
//        public void setChannel(String channel) {
//            this.channel = channel;
//        }
//
//
//    }
//
//    private static String takeCustomer(Document doc) {
//        XPathFactory xPathfactory = XPathFactory.newInstance();
//        XPath xpath = xPathfactory.newXPath();
//        XPathExpression expr = null;
//        try {
//            expr = xpath.compile("//feed[@customer]");
//        } catch (XPathExpressionException e) {
//            e.printStackTrace();
//        }
//        NodeList nl = null;
//        try {
//            nl = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
//        } catch (XPathExpressionException e) {
//            e.printStackTrace();
//        }
//        if (nl.getLength() != 0) {
//            return nl.item(0).getAttributes().getNamedItem("customer").getNodeValue();
//        } else {
//            return "";
//        }
//    }
//
//    private static String takeSenderId(Document doc) {
//        XPathFactory xPathfactory = XPathFactory.newInstance();
//        XPath xpath = xPathfactory.newXPath();
//        XPathExpression expr = null;
//        try {
//            expr = xpath.compile("//feed[@sender-id]");
//        } catch (XPathExpressionException e) {
//            e.printStackTrace();
//        }
//        NodeList nl = null;
//        try {
//            nl = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
//        } catch (XPathExpressionException e) {
//            e.printStackTrace();
//        }
//        if (nl != null && nl.getLength() != 0) {
//            return nl.item(0).getAttributes().getNamedItem("sender-id").getNodeValue();
//        } else {
//            return "";
//        }
//    }
//
//    private static Document convertToXml(String stringXml) {
//
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//
//        //API to obtain DOM Document instance
//        DocumentBuilder builder = null;
//        try {
//            //Create DocumentBuilder with default configuration
//            builder = factory.newDocumentBuilder();
//
//            //Parse the content to Document object
//            Document doc = null;
//            try {
//                doc = builder.parse(new InputSource(new StringReader(stringXml)));
//            } catch (Exception e) {
//                System.out.println("Not valid xml" + stringXml);
//            }
//            return doc;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    private static void readFeedDataFromJWF(List<String> feedLine) {
//        try (BufferedReader br = new BufferedReader(new FileReader(JWFData))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                feedLine.add(line);
//            }
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//}
