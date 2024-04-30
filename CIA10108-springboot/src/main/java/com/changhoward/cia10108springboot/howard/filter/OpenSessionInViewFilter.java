package com.changhoward.cia10108springboot.howard.filter;

import com.changhoward.cia10108springboot.howard.util.HibernateUtil;
import org.hibernate.SessionFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = { "/*" })
public class OpenSessionInViewFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        try {
            System.out.println("filter open transaction");
            factory.getCurrentSession().beginTransaction();
            chain.doFilter(req, res);
            factory.getCurrentSession().getTransaction().commit();
        } catch (Exception e) {
            factory.getCurrentSession().getTransaction().rollback();
            e.printStackTrace();
            chain.doFilter(req, res);
        }
    }

}




