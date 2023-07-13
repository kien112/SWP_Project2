/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.RoleDAO;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import model.User;

/**
 *
 * @author Acer
 */
public class UserAuthorizationFilter implements Filter {

//    @Override
//    public void destroy() {
//
//    }
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) sr;
//        HttpServletResponse respone = (HttpServletResponse) sr1;
//        HttpSession session = request.getSession();
//        RoleDAO r = new RoleDAO();
//        User u = (User) session.getAttribute("user");
//        String role = null;
//        if (u != null) {
//            role = r.getRoleNameByUserId(u.getUser_id());
//        }
//        if (role == null) {
//            role = "Guest";
//        }
////        System.out.println(role);
//        String requestedURL = request.getRequestURI();
//        if (u != null) {
//            if (requestedURL.contains("changepassword") || requestedURL.contains("changePassword.jsp")
//                    || requestedURL.contains("userProfile.jsp")) {
//                fc.doFilter(request, respone);
//            }
//        } else {
//            respone.sendRedirect("accessDenied.jsp");
//        }
////        System.out.println(role + ":" + requestedURL);
////        System.out.println(hasPermission(role, requestedURL));
////        if (hasPermission(role, requestedURL)) {
////            fc.doFilter(request, respone);
////        } else {
////            respone.sendRedirect("accessDenied.jsp");
////
////        }
//
//    }
//
//    private boolean hasPermission(String role, String requestedURL) {
//        if (requestedURL.contains("changePassword.jsp") || requestedURL.contains("changepassword")
//                || requestedURL.contains("userProfile.jsp"))  {
//            return !role.equals("Guest");
//        }
//
//        else if (requestedURL.contains("forgotPassword.jsp") || requestedURL.contains("forgotPassword")
//                || requestedURL.contains("EnterOtp.jsp") || requestedURL.contains("ValidateOtp")
//                || requestedURL.contains("newPassword.jsp") || requestedURL.contains("newPassword")
//                || requestedURL.contains("register.jsp") || requestedURL.contains("register")
//                || requestedURL.contains("blogList.jsp") || requestedURL.contains("blog")
//                || requestedURL.contains("blogDetails.jsp") || requestedURL.contains("blogdetail")
//                || requestedURL.contains("home.jsp") || requestedURL.contains("home")
//                || requestedURL.contains("courseDetails.jsp") || requestedURL.contains("details")
//                || requestedURL.contains("courseList.jsp") || requestedURL.contains("courses")
//                || requestedURL.contains("myCourse.jsp") || requestedURL.contains("home")
//                || requestedURL.contains("myRegistration.jsp") || requestedURL.contains("myRegistration")
//                || requestedURL.contains("home.jsp") || requestedURL.contains("home")) {
//            return role.equals("Guest");
//        }
//
//        else if (requestedURL.contains("myCourse.jsp") || requestedURL.contains("myCourse")
//                || requestedURL.contains("myRegistration.jsp") || requestedURL.contains("myRegistration")) {
//            return role.equals("Customer");
//        }
//
//        else if (requestedURL.contains("footer.jsp")) {
//            return false;
//        }
//
//        else if (requestedURL.contains("header.jsp")) {
//            return false;
//        }
//        return true;
//    }

    
    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;
    
//    public UserAuthorizationFilter {
//    }    
    
    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("AutthorizationFilter:DoBeforeProcessing");
        }

        // Write code here to process the request and/or response before
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log items on the request object,
        // such as the parameters.
        /*
	for (Enumeration en = request.getParameterNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    String values[] = request.getParameterValues(name);
	    int n = values.length;
	    StringBuffer buf = new StringBuffer();
	    buf.append(name);
	    buf.append("=");
	    for(int i=0; i < n; i++) {
	        buf.append(values[i]);
	        if (i < n-1)
	            buf.append(",");
	    }
	    log(buf.toString());
	}
         */
    }    
    
    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("AutthorizationFilter:DoAfterProcessing");
        }

        // Write code here to process the request and/or response after
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log the attributes on the
        // request object after the request has been processed. 
        /*
	for (Enumeration en = request.getAttributeNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    Object value = request.getAttribute(name);
	    log("attribute: " + name + "=" + value.toString());
	}
         */
        // For example, a filter might append something to the response.
        /*
	PrintWriter respOut = new PrintWriter(response.getWriter());
	respOut.println("<P><B>This has been appended by an intrusive filter.</B>");
         */
    }

    
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        RoleDAO r = new RoleDAO();
        User u = (User) session.getAttribute("user");
        String role = null;
        if (u != null) {
            role = r.getRoleNameByUserId(u.getUser_id());
        }
        if (role == null) {
            role = "Guest";
        }

        String requestedURL = req.getRequestURI();
        if (u == null) {
            if (requestedURL.contains("changepassword") || requestedURL.contains("changePassword.jsp")
                    || requestedURL.contains("userProfile.jsp") ) {
                req.getRequestDispatcher("accessDenied").include(request, response);
            }
        }
        
        if(!hasPermission(role, requestedURL)){
            req.getRequestDispatcher("accessDenied").include(request, response);
        }

        chain.doFilter(request, response);
    }

    
    private boolean hasPermission(String role, String url) {

        if(url.contains("userList") || url.contains("settingList") 
                || url.contains("userDetail") || url.contains("settingDetail")){
            return role.equals("Admin");
        }
        
        if(url.contains("slider") || url.contains("updateBlog")){
            return role.equals("Marketing");
        }
        
        if(url.contains("myCourse") || url.contains("myRegistration")){
            return role.equals("Customer");
        }
        
        if(url.contains("subject")){
            return role.equals("Expert");
        }
        return true;
    }
    
    
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {        
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {                
                log("AutthorizationFilter:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("AutthorizationFilter()");
        }
        StringBuffer sb = new StringBuffer("AutthorizationFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }
    
    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);        
        
        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);                
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");                
                pw.print(stackTrace);                
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }
    
    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }
    
    public void log(String msg) {
        filterConfig.getServletContext().log(msg);        
    }

}
