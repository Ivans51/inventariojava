package core.dao;

import core.vo.Proveedor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ProveedorDao {

    private SqlSessionFactory sqlSessionFactory = null;

    public ProveedorDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<Proveedor> selectAll() {
        List<Proveedor> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            list = session.selectList("Proveedor.selectAll");
        } finally {
            session.close();
        }
        System.out.println("selectAll() --> " + list);
        return list;

    }

    /**
     * Select instance of Proveedor from the database.
     *
     * @param id the instance to be persisted.
     */
    public Proveedor selectById(int id) {
        Proveedor person = null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            person = session.selectOne("Proveedor.selectById", id);
        } finally {
            session.close();
        }
        System.out.println("selectById(" + id + ") --> " + person);
        return person;
    }

    /**
     * Insert an instance of Proveedor into the database.
     *
     * @param usuario the instance to be persisted.
     */
    public int insert(Proveedor usuario) {
        int id = -1;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            id = session.insert("Proveedor.insert", usuario);
        } finally {
            session.commit();
            session.close();
        }
        System.out.println("insert(" + usuario + ") --> " + usuario.getIdproveedor());
        return id;
    }

    /**
     * Update an instance of Proveedor into the database.
     *
     * @param usuario the instance to be persisted.
     */
    public void update(Proveedor usuario) {
        int id = -1;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            id = session.update("Proveedor.update", usuario);

        } finally {
            session.commit();
            session.close();
        }
        System.out.println("update(" + usuario + ") --> updated");
    }

    /**
     * Delete an instance of Proveedor from the database.
     *
     * @param id value of the instance to be deleted.
     */
    public void delete(int id) {

        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.delete("Proveedor.delete", id);
        } finally {
            session.commit();
            session.close();
        }
        System.out.println("delete(" + id + ")");

    }
}