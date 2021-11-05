package backend.Controllers;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

public class ServerController {

    public void runServer(){
        Tomcat server = new Tomcat();
        server.setBaseDir(System.getProperty("java.io.tmpdir"));
        server.setPort(8080);
        server.getConnector();
        server.addContext("", null);
        server.addServlet("", "defaultServlet", new HttpServlet() {
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                String fileName = req.getPathInfo().replaceFirst("/", "");
                InputStream file = getClass().getClassLoader().getResourceAsStream(fileName);
                String mimeType = getServletContext().getMimeType(fileName);
                resp.setContentType(mimeType);
                IOUtils.copy(file, resp.getOutputStream());
            }
        }).addMapping("/*");

        server.addServlet("", "helloServlet", new HttpServlet() {
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

                String name = req.getParameter("name");
                if (name == null)
                    name ="Tomcat";
                resp.getWriter().println("<h1> Hello, " + name + "!</h1>");
            }
        }).addMapping("/index/html");
        try{
            server.start();
            server.getServer().await();
        }catch (LifecycleException e){
            e.printStackTrace();
        }
    }
}
