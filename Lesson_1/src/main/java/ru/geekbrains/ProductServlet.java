package ru.geekbrains;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

@WebServlet(name = "ProductServlet", urlPatterns = "/show_products")
public class ProductServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(ProductServlet.class);
    private transient ServletConfig servletConfig;

    @Override
    public void init(ServletConfig servletConfig) {
        this.servletConfig = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
        logger.info("show products");
        StringBuilder sb = new StringBuilder("<html><body>");
        Product[] products = new Product[10];
        products[0] = new Product(1, "apple", 10.9);
        products[1] = new Product(2, "orange", 13.9);
        products[2] = new Product(3, "peach", 16.5);
        products[3] = new Product(4, "cherry", 7.5);
        products[4] = new Product(5, "banana", 8.5);
        products[5] = new Product(6, "tomato", 25.9);
        products[6] = new Product(7, "potato", 11.9);
        products[7] = new Product(8, "cucumber", 4.9);
        products[8] = new Product(9, "carrot", 7.9);
        products[9] = new Product(10, "pepper", 30.9);

        for (int i = 0; i < 10; i++) {
            sb.append("<span>" + "id: ")
                    .append(products[i].getId())
                    .append("   ")
                    .append(" title: ")
                    .append(products[i].getTitle())
                    .append(" cost: ")
                    .append(products[i].getCost())
                    .append("</span><br>");
        }
        servletResponse.getWriter().printf(sb.toString());
    }

    @Override
    public String getServletInfo() {
        return "BasicServlet";
    }

    @Override
    public void destroy() {
        logger.info("Servlet {} destroyed", getServletInfo());
    }
}
