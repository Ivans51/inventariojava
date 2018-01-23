package core.dao;

import core.vo.Factura;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class FacturaDao {

    private SqlSessionFactory sqlSessionFactory = null;

    public FacturaDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    /**
     * Returns the list of all Auditoria instances from the database.
     *
     * @return the list of all Auditoria instances from the database.
     */
    @SuppressWarnings("unchecked")
    public List<Factura> selectAll() {
        List<Factura> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            list = session.selectList("Factura.selectAll");
        } finally {
            session.close();
        }
        System.out.println("selectAll() --> " + list);
        return list;

    }

    /**
     * Select instance of Factura from the database.
     *
     * @param id the instance to be persisted.
     */
    public Factura selectById(int id) {
        Factura person = null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            person = session.selectOne("Factura.selectById", id);
        } finally {
            session.close();
        }
        System.out.println("selectById(" + id + ") --> " + person);
        return person;
    }

    /**
     * Insert an instance of Factura into the database.
     *
     * @param usuario the instance to be persisted.
     */
    public int insert(Factura usuario) {
        int id = -1;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            id = session.insert("Factura.insert", usuario);
        } finally {
            session.commit();
            session.close();
        }
        System.out.println("insert(" + usuario + ") --> " + usuario.getIdfactura());
        return id;
    }

    /**
     * Update an instance of Factura into the database.
     *
     * @param usuario the instance to be persisted.
     */
    public void update(Factura usuario) {
        int id = -1;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            id = session.update("Factura.update", usuario);

        } finally {
            session.commit();
            session.close();
        }
        System.out.println("update(" + usuario + ") --> updated");
    }

    /**
     * Delete an instance of Factura from the database.
     *
     * @param id value of the instance to be deleted.
     */
    public void delete(int id) {

        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.delete("Factura.delete", id);
        } finally {
            session.commit();
            session.close();
        }
        System.out.println("delete(" + id + ")");

    }
}