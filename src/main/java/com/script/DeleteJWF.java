package com.script;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DeleteJWF {
    private static List<String> feeds = Arrays.asList(
            "de-techdata",
            "de-mann_hummel_sf",
            "at-broadbean_ldad_test",
            "at-jobrocker",
            "de-test_push_ld",
            "de-opengrid_europe",
            "de-ede",
            "de-arag",
            "de-uniper_push",
            "de-kone",
            "de-westpress_int",
            "de-test_dvinci_easy",
            "de-arlanxeo",
            "de-impuls_dvinci",
            "de-jobad_push",
            "de-sap_rp_test",
            "de-jll",
            "de-wuerth_eisos",
            "de-bdo_push",
            "at-hays_bb",
            "de-test_mp2jf",
            "fr-broadbean_ldad_test",
            "de-test_smartrecruiters",
            "at-deloitte_intern",
            "de-igus",
            "at-deloitte_er",
            "de-otto_digital_jap",
            "fr-manpower",
            "de-broadbean_ldad_test",
            "pl-stepstone",
            "de-softgarden_ldad",
            "pl-otcf",
            "de-kleusenberg",
            "de-ensinger",
            "de-emagine_new",
            "de-douglas_eq",
            "de-timepartner_ld",
            "de-visable_dvinci",
            "za-pageuppeople",
            "za-broadbean_ldad_test",
            "de-arthrex_push",
            "de-bechtle_test",
            "ycg-ssp_dach",
            "de-willis_towers_watson",
            "de-leg",
            "ycg-zfv",
            "de-rexx_test_ldad",
            "de-kpmg_sf",
            "de-pluss_docwise",
            "de-piepenbrock",
            "de-hamburg_sued_ld",
            "test-ldad",
            "ycg-testfeed",
            "at-atosit",
            "pl-polomarket",
            "de-personalwerk_ldad",
            "de-cws_boco_workday",
            "de-wuerth_eisos_ld",
            "de-dspro_dvinci",
            "de-tennet_new",
            "de-unicredit_neu",
            "de-homag",
            "de-test_ats_sap",
            "at-atosit",
            "at-deloitte_er",
            "at-jobticket",
            "at-magna",
            "at-michaelpage_bb",
            "at-personalwerk_push",
            "at-pmc",
            "at-thyssenkrupp_bb",
            "at-transfer",
            "be-bosch_smartrecruiters",
            "de-3eck",
            "de-albrecht_jung",
            "de-aldi_nord_eq",
            "de-andritz",
            "de-arag",
            "de-astra_zeneca",
            "de-basf",
            "de-bayernlb_haufe",
            "de-broadbean_ldad_test",
            "de-canon",
            "de-cgm",
            "de-computacenter_push",
            "de-consultex",
            "de-continental_bb",
            "de-currenta_ld",
            "de-cws_boco_workday",
            "de-dkb",
            "de-douglas_eq",
            "de-dsmedia_ld",
            "de-ensinger",
            "de-euromaster",
            "de-fourteenone_bb",
            "de-gabler",
            "de-gea_equest",
            "de-gohiring",
            "de-hamburg_sued_ld",
            "de-hdw_juwi",
            "de-hdw_steuerring",
            "de-hertz",
            "de-hubside",
            "de-infineon",
            "de-inverto",
            "de-jll",
            "de-jobrocker_cb",
            "de-jobticket",
            "de-kpmg_sf",
            "de-lanxess",
            "de-loreal",
            "de-lti",
            "de-lufthansa_int_muz",
            "de-lvm",
            "de-magna",
            "de-mann_hummel_sf",
            "de-mbtech_bb",
            "de-novum",
            "de-noweda",
            "de-operational_services",
            "de-orizon_new",
            "de-personalwerk_push",
            "de-piening",
            "de-piepenbrock",
            "de-pluss_docwise",
            "de-robertwalters",
            "de-schenker_bb",
            "de-siemens_healthcare",
            "de-sig_combibloc",
            "de-srgroup",
            "de-swatch_equest",
            "de-swissport",
            "de-symrise",
            "de-test_push_ld",
            "de-thyssenkrupp_bb",
            "de-timepartner_ld",
            "de-ul",
            "de-vivento_xml",
            "de-westpress_preview",
            "de-willis_towers_watson",
            "de-yield_sf",
            "de-zalando_bb",
            "fr-engie_cofely_pull",
            "pl-cbre_spzoo",
            "pl-michaelpage",
            "pl-polcode",
            "test-ldad",
            "ycg-stepstone",
            "ycg-zfv",
            "za-careers24",
            "za-parvana",
            "za-peoplebank",
            "za-zoho_ld"
    );

    private static String delete_url = "http://next.jobfeed.stepstone.com/jobfeed-web/delete_feed.jz?feedName=";

    public static void main(String[] args) {

        ArrayList<String> str = new ArrayList<>();
        str.add("1");
        str.add("2");
        str.set(0, "2");
        Set<String> collect = feeds.stream()
                .collect(Collectors.toSet());
        int i=1 ;

        for(String f : collect) {
            System.out.println(f);
            i++;
        }

    }

    private static void deleteFeed(String feedName) throws IOException {
        URL obj = new URL(delete_url + feedName);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        int response = con.getResponseCode();
        System.out.println("Sending reguest to: " + delete_url + feedName + " Response code: " + response);
    }
}
