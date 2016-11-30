//package com.name.crow.bck;
//
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRegistration;
//
///**
// * Created by pchandramohan on 11/13/16.
// */
////@Order(2)
//public class CrowInitializer implements WebApplicationInitializer {
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
//        ctx.register(CrowConfiguration.class);
//        ctx.setServletContext(servletContext);
//        ServletRegistration.Dynamic dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
//        dynamic.addMapping("/");
//        dynamic.setLoadOnStartup(1);
//    }
//
//
////    @Override
////    protected String[] getServletMappings() {
////        return new String[]{"/"};
////    }
////
////    @Override
////    protected Class<?>[] getRootConfigClasses() {
////        return new Class<?>[] {CrowConfiguration.class, CrowSecurityConfig.class};
////    }
////
////    @Override
////    protected Class<?>[] getServletConfigClasses() {
////        return new Class<?>[] {CrowConfiguration.class};
////    }
////
////    @Override
////    protected Filter[] getServletFilters() {
////        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
////        characterEncodingFilter.setEncoding("UTF-8");
////        characterEncodingFilter.setForceEncoding(true);
////        return new Filter[] {characterEncodingFilter};
////    }
////
////    @Override
////    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
////        registration.setInitParameter("defaultHtmlEscape", "true");
////        registration.setInitParameter("spring.profiles.active", "default");
////    }
//}
