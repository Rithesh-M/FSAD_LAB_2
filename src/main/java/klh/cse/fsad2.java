package klh.cse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import klh.cse.entity.Product;

public class fsad2 {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        // DELETE by ID
        Product product = session.get(Product.class, 3); // change ID as needed

        if (product != null) {
            session.remove(product);
            System.out.println("Product deleted successfully");
        } else {
            System.out.println("Product not found");
        }

        tx.commit();
        session.close();
        factory.close();
    }
}
