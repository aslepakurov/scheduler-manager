package ua.kpi.comsys.manager;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


/**
 * SchedulerManagerInitializer Class
 *
 * @author aslepakurov
 * @version 1/14/2016
 */
public class SchedulerManagerInitializer implements WebApplicationInitializer{

    public void onStartup(ServletContext container) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(AppConfig.class);
        ctx.setServletContext(container);
        ServletRegistration.Dynamic servlet = container.addServlet(
                "dispatcher", new DispatcherServlet(ctx));
        FilterRegistration fr = container.addFilter("CorsFilter", CORSFilter.class);
        fr.addMappingForUrlPatterns(null, true, "/*");
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }
}
