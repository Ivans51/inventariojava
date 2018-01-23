package core.dao;

import core.vo.Auditoria;
import core.vo.DetalleFactura;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class DetalleFacturaDao {

    private SqlSessionFactory sqlSessionFactory = null;

    public DetalleFacturaDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    /**
     * Returns the list of all Auditoria instances from the database.
     *
     * @return the list of all Auditoria instances from the database.
     */
    @SuppressWarnings("unchecked")
    public List<DetalleFactura> selectAll() {
        List<DetalleFactura> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            list = session.selectList("DetalleFactura.selectAll");
        } finally {
            session.close();
        }
        System.out.println("selectAll() --> " + list);
        return list;

    }

    /**
     * Select instance of DetalleFactura from the database.
     *
     * @param id the instance to be persisted.
     */
    public DetalleFactura selectById(int id) {
        DetalleFactura person = null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            person = session.selectOne("DetalleFactura.selectById", id);
        } finally {
            session.close();
        }
        System.out.println("selectById(" + id + ") --> " + person);
        return person;
    }

    /**
     * Insert an instance of DetalleFactura into the database.
     *
     * @param usuario the instance to be persisted.
     */
    public int insert(DetalleFactura usuario) {
        int id = -1;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            id = session.insert("DetalleFactura.insert", usuario);
        } finally {
            session.commit();
            session.close();
        }
        System.out.println("insert(" + usuario + ") --> " + usuario.getCod_factura());
        return id;
    }

    /**
     * Update an instance of DetalleFactura into the database.
     *
     * @param usuario the instance to be persisted.
     */
    public void update(DetalleFactura usuario) {
        int id = -1;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            id = session.update("DetalleFactura.update", usuario);

        } finally {
            session.commit();
            session.close();
        }
        System.out.println("update(" + usuario + ") --> updated");
    }

    /**
     * Delete an instance of DetalleFactura from the database.
     *
     * @param id value of the instance to be deleted.
     */
    public void delete(int id) {

        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.delete("DetalleFactura.delete", id);
        } finally {
            session.commit();
            session.close();
        }
        System.out.println("delete(" + id + ")");

    }
}