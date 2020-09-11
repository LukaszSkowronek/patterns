//package com.stepstone.bors.usermgm.stepstoner.infrastructure.repository;
//import com.stepstone.bors.usermgm.stepstoner.application.authentication.StepStonerAuthenticationRepository;
//import com.stepstone.bors.usermgm.stepstoner.application.authentication.StepStonerDataRepository;
//import com.stepstone.datamodel.bors.UserBO;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import javax.annotation.PostConstruct;
//import javax.naming.Context;
//import javax.naming.NamingEnumeration;
//import javax.naming.NamingException;
//import javax.naming.directory.Attributes;
//import javax.naming.directory.DirContext;
//import javax.naming.directory.InitialDirContext;
//import javax.naming.directory.SearchControls;
//import javax.naming.directory.SearchResult;
//import java.util.Properties;
//@Service
//public class ActiveDirectoryStepStonerRepository
//        implements StepStonerAuthenticationRepository, StepStonerDataRepository {
//    private static final Logger LOGGER =
//            LoggerFactory.getLogger(ActiveDirectoryStepStonerRepository.class);
//    /**
//     * Fully qualified username for querying AD data, ie. <code>STEPSTONE-ASA\\username</code>
//     */
//    private final String adUserName;
//    /**
//     * Password for <code>adUserName</code>
//     */
//    private final String adUserPass;
//    /**
//     * Hostname of the Active Directory server
//     */
//    private final String adServerName;
//    /**
//     * Base domain where AD users are stored, ie. <code>STEPSTONE-ASA\</code>
//     */
//    private final String userDomain;
//    @Autowired
//    public ActiveDirectoryStepStonerRepository(
//            @Value("${ad.user_name}") String adUserName,
//            @Value("${ad.user_pass}") String adUserPass,
//            @Value("${ad.server_name}") String adServerName,
//            @Value("${ad.user_domain}") String userDomain
//    ) {
//        this.adUserName = adUserName;
//        this.adUserPass = adUserPass;
//        this.adServerName = adServerName;
//        this.userDomain = userDomain;
//    }
//    @PostConstruct
//    public void dododo() {
//        getStepStoner("kislym01");
//    }
//    @Override
//    public UserBO getStepStoner(String login) {
//        LOGGER.debug("Fetching StepStoner with login {}", login);
//        Properties properties = initializeProperties();
//        properties.put(Context.SECURITY_PRINCIPAL, adUserName);
//        properties.put(Context.SECURITY_CREDENTIALS, adUserPass);
//        UserBO stepStoner = new UserBO();
//        try {
//            DirContext context = new InitialDirContext(properties);
//            NamingEnumeration<SearchResult> answer = queryForUser(login, context);
//            if (answer.hasMoreElements()) {
//                mapAttributes(stepStoner, answer);
//            }
//            context.close();
//        } catch (NamingException e) {
//            LOGGER.warn("Error occurred while getting StepStoner information from AD:", e);
//            return null;
//        }
//        LOGGER.trace("Retrieved StepStoner: {} ", stepStoner);
//        return stepStoner;
//    }
//    private Properties initializeProperties() {
//        Properties properties = new Properties();
//        properties.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
//        properties.put(Context.PROVIDER_URL, "LDAP://" + adServerName);
//        properties.put(Context.SECURITY_AUTHENTICATION, "simple");
//        return properties;
//    }
//    private NamingEnumeration<SearchResult> queryForUser(String login, DirContext context)
//            throws NamingException {
//        SearchControls sc = new SearchControls();
//        sc.setSearchScope(SearchControls.SUBTREE_SCOPE);
//        String[] attr = {"cn"};
//        sc.setReturningAttributes(attr);
//        String[] attrName = {"memberOf"};
//        sc.setReturningAttributes(attrName);
//        String searchContext = "DC=stepstone,DC=asa";
//        String searchFilter = "(&(objectClass=user)(sAMAccountName=" + login + "))";
//        return context.search(searchContext, searchFilter, sc);
//    }
//    private void mapAttributes(UserBO stepStoner, NamingEnumeration<SearchResult> answer)
//            throws NamingException {
//        SearchResult searchResult = answer.next();
//        Attributes attributes = searchResult.getAttributes();
//        if (null != attributes.get("sAMAccountName")) {
//            stepStoner.setLogin(attributes.get("sAMAccountName").get().toString());
//        } else {
//            stepStoner.setLogin("");
//        }
//        if (null != attributes.get("mail")) {
//            stepStoner.setEmail(attributes.get("mail").get().toString());
//        } else {
//            stepStoner.setEmail("");
//        }
//        if (null != attributes.get("givenName")) {
//            stepStoner.setFirstName(attributes.get("givenName").get().toString());
//        } else {
//            stepStoner.setFirstName("");
//        }
//        if (null != attributes.get("sn")) {
//            stepStoner.setLastName(attributes.get("sn").get().toString());
//        } else {
//            stepStoner.setLastName("");
//        }
//        if (null != attributes.get("title")) {
//            stepStoner.setJobTitle(attributes.get("title").get().toString());
//        } else {
//            stepStoner.setJobTitle("");
//        }
//        if (null != attributes.get("l")) {
//            stepStoner.setLocation(attributes.get("l").get().toString());
//        } else {
//            stepStoner.setLocation("");
//        }
//        if (null != attributes.get("telephoneNumber")) {
//            stepStoner.setPhoneNo(attributes.get("telephoneNumber").get().toString());
//        } else {
//            stepStoner.setPhoneNo("");
//        }
//    }
//    @Override
//    public boolean authenticate(String userLogin, String userPassword) {
//        if (userLogin.isEmpty() || userPassword.isEmpty()) {
//            return false;
//        }
//        Properties properties = initializeProperties();
//        properties.put(Context.SECURITY_PRINCIPAL, userDomain + userLogin);
//        properties.put(Context.SECURITY_CREDENTIALS, userPassword);
//        try {
//            new InitialDirContext(properties);
//            LOGGER.debug("StepStoner '{}' authentication successful", userLogin);
//            return true;
//        } catch (NamingException e) {
//            LDAPResultCode resultCode = LDAPResultCodeReader.getResultCodeFromNamingException(e);
//            if (resultCode.getCode() == null) {
//                LOGGER.warn("StepStoner authentication error ", e);
//            } else {
//                LOGGER.debug(
//                        "StepStoner authentication error, code: {} - {}, description: {}",
//                        resultCode.getCode(),
//                        resultCode.getSubCode(),
//                        resultCode.getDescription()
//                );
//            }
//            return false;
//        }
//    }
//}