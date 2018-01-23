package core.dao;

import core.vo.Devolucion;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class DevolucionDao {

    private SqlSessionFactory sqlSessionFactory = null;

    public DevolucionDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    /**
     * Returns the list of all Auditoria instances from the database.
     *
     * @return the list of all Auditoria instances from the database.
     */
    @SuppressWarnings("unchecked")
    public List<Devolucion> selectAll() {
        List<Devolucion> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            list = session.selectList("Devolucion.selectAll");
        } finally {
            session.close();
        }
        System.out.println("selectAll() --> " + list);
        return list;

    }

    /**
     * Select instance of Devolucion from the database.
     *
     * @param id the instance to be persisted.
     */
    public Devolucion selectById(int id) {
        Devolucion person = null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            person = session.selectOne("Devolucion.selectById", id);
        } finally {
            session.close();
        }
        System.out.println("selectById(" + id + ") --> " + person);
        return person;
    }

    /**
     * Insert an instance of Devolucion into the database.
     *
     * @param usuario the instance to be persisted.
     */
    public int insert(Devolucion usuario) {
        int id = -1;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            id = session.insert("Devolucion.insert", usuario);
        } finally {
            session.commit();
            session.close();
        }
        System.out.println("insert(" + usuario + ") --> " + usuario.getCod_detallefactura());
        return id;
    }

    /**
     * Update an instance of Devolucion into the database.
     *
     * @param usuario the instance to be persisted.
     */
    public void update(Devolucion usuario) {
        int id = -1;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            id = session.update("Devolucion.update", usuario);

        } finally {
            session.commit();
            session.close();
        }
        System.out.println("update(" + usuario + ") --> updated");
    }

    /**
     * Delete an instance of Devolucion from the database.
     *
     * @param id value of the instance to be deleted.
     */
    public void delete(int id) {

        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.delete("Devolucion.delete", id);
        } finally {
            session.commit();
            session.close();
        }
        System.out.println("delete(" + id + ")");

    }
}