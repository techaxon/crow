//package com.name.crow.bck;
//
//import nz.net.ultraq.thymeleaf.LayoutDialect;
//import org.springframework.beans.BeansException;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.context.MessageSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.support.ReloadableResourceBundleMessageSource;
//import org.springframework.core.Ordered;
//import org.springframework.web.servlet.ViewResolver;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.thymeleaf.extras.springsecurity3.dialect.SpringSecurityDialect;
//import org.thymeleaf.extras.tiles2.dialect.TilesDialect;
//import org.thymeleaf.spring4.SpringTemplateEngine;
//import org.thymeleaf.spring4.view.ThymeleafViewResolver;
//import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
//import org.thymeleaf.templateresolver.TemplateResolver;
//
//
///**
// * Created by pchandramohan on 11/13/16.
// */
//
//
////@Configuration
////@EnableWebMvc
////@ComponentScan(basePackages = "com.name.crow")
//public class CrowConfiguration extends WebMvcConfigurerAdapter implements ApplicationContextAware {
//
//    private static final String MESSAGE_SOURCE = "/i18n/messages";
//    private static final String TEMPLATES = "templates";
//
//    private static final String RESOURCES_HANDLER = "/resources/";
//    private static final String RESOURCES_LOCATION = RESOURCES_HANDLER + "**";
//
//    private ApplicationContext applicationContext;
//
//    @Override
//    public void addViewControllers( ViewControllerRegistry registry ) {
//        registry.addViewController( "/" ).setViewName( "forward:/welcome" );
//        registry.setOrder( Ordered.HIGHEST_PRECEDENCE );
//        super.addViewControllers( registry );
//    }
//
//    @Bean(name = "messageSource")
//    public MessageSource messageSource() {
//        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//        messageSource.setBasename(MESSAGE_SOURCE);
//        messageSource.setCacheSeconds(5);
//        return messageSource;
//    }
//
//    @Bean
//    public TemplateResolver templateResolver() {
//        TemplateResolver templateResolver = new ServletContextTemplateResolver();
//        templateResolver.setPrefix(TEMPLATES);
//        templateResolver.setSuffix(".html");
//        templateResolver.setTemplateMode("HTML5");
//        templateResolver.setCacheable(false);
//        return templateResolver;
//    }
//
////    @Bean
////    public UrlTemplateResolver urlTemplateResolver() {
////        return new UrlTemplateResolver();
////    }
//
//    @Bean
//    public SpringTemplateEngine templateEngine() {
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.addTemplateResolver(templateResolver());
////        templateEngine.addTemplateResolver(urlTemplateResolver());
//        templateEngine.addDialect(new SpringSecurityDialect());
//        templateEngine.addDialect(new TilesDialect());
//        templateEngine.addDialect(new LayoutDialect());
//        return templateEngine;
//    }
//
//    /**
//     * Handles all views except for the ones that are handled by Tiles. This view resolver
//     * will be executed as first one by Spring.
//     */
//    @Bean
//    public ViewResolver thymeleafViewResolver() {
//        ThymeleafViewResolver vr = new ThymeleafViewResolver();
//        vr.setTemplateEngine(templateEngine());
//        vr.setCharacterEncoding("UTF-8");
//        vr.setOrder(Ordered.HIGHEST_PRECEDENCE);
//        // all message/* views will not be handled by this resolver as they are Tiles views
//        vr.setExcludedViewNames(new String[]{"message/*"});
//        return vr;
//    }
//
//    /**
//     * Handles Tiles views.
//     */
////    @Bean
////    public ViewResolver tilesViewResolver() {
////        ThymeleafViewResolver vr = new ThymeleafViewResolver();
////        vr.setTemplateEngine(templateEngine());
////        vr.setViewClass(ThymeleafTilesView.class);
////        vr.setCharacterEncoding("UTF-8");
////        vr.setOrder(Ordered.LOWEST_PRECEDENCE);
////        return vr;
////    }
//
////    @Bean
////    public ThymeleafTilesConfigurer tilesConfigurer() {
////        ThymeleafTilesConfigurer ttc = new ThymeleafTilesConfigurer();
////        ttc.setDefinitions(new String[]{"tiles-defs.xml"});
////        return ttc;
////    }
//
////    @Override
////    public Validator getValidator() {
////        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
////        validator.setValidationMessageSource(messageSource());
////        return validator;
////    }
//
////    @Override
////    public void addResourceHandlers(ResourceHandlerRegistry registry) {
////        registry.addResourceHandler(RESOURCES_HANDLER).addResourceLocations(RESOURCES_LOCATION);
////    }
//
////    @Override
////    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
////        configurer.enable();
////    }
//
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        this.applicationContext = applicationContext;
//    }
//}
