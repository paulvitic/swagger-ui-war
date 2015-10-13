package net.vitic.swagger.webapp;

import org.apache.jasper.servlet.JspServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.util.Log4jConfigListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by paul on 22/12/14.
 */
public class WebApp implements WebApplicationInitializer
{
    private static final String JSP_SERVLET_NAME = "jsp";
    private static final String DISPATCHER_SERVLET_NAME = "dispatcher";

    public void onStartup(ServletContext aServletContext) throws ServletException {
    	// set init parameters
    	aServletContext.setInitParameter("log4jConfigLocation","classpath:conf/log.properties");
    	
        registerListener(aServletContext);
        registerDispatcherServlet(aServletContext);
        registerJspServlet(aServletContext);
    }

    private void registerListener(ServletContext aContext) {
    	aContext.addListener(new Log4jConfigListener());
        AnnotationConfigWebApplicationContext root = createContext(RootNode.class);
        aContext.addListener(new ContextLoaderListener(root));
    }

    private void registerDispatcherServlet(ServletContext aContext) {
        AnnotationConfigWebApplicationContext ctx = createContext(ApplicationNode.class);
        ServletRegistration.Dynamic dispatcher =
                aContext.addServlet(DISPATCHER_SERVLET_NAME, new DispatcherServlet(ctx));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }

    private void registerJspServlet(ServletContext aContext) {
        ServletRegistration.Dynamic dispatcher =
                aContext.addServlet(JSP_SERVLET_NAME, new JspServlet());
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("*.jsp");
    }

    private AnnotationConfigWebApplicationContext createContext(final Class<?>... aModules) {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(aModules);
        return ctx;
    }
}
