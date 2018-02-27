package core.dao;

import core.vo.Cliente;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ClienteDao {

    private SqlSessionFactory sqlSessionFactory = null;

    public ClienteDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<Cliente> selectAll() {
        List<Cliente> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            list = session.selectList("Cliente.selectAll");
        } finally {
            session.close();
        }
        System.out.println("selectAll() --> " + list);
        return list;

    }

    /**
     * Select instance of Cliente from the database.
     *
     * @param id the instance to be persisted.
     */
    public Cliente selectById(int id) {
        Cliente person = null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            person = session.selectOne("Cliente.selectById", id);
        } finally {
            session.close();
        }
        System.out.println("selectById(" + id + ") --> " + person);
        return person;
    }

    /**
     * Insert an instance of Cliente into the database.
     *
     * @param usuario the instance to be persisted.
     */
    public int insert(Cliente usuario) {
        int id = -1;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            id = session.insert("Cliente.insert", usuario);
        } finally {
            session.commit();
            session.close();
        }
        System.out.println("insert(" + usuario + ") --> " + usuario.getCedula());
        return id;
    }

    /**
     * Update an instance of Cliente into the database.
     *
     * @param usuario the instance to be persisted.
     */
    public int update(Cliente usuario) {
        int id = -1;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            id = session.update("Cliente.update", usuario);

        } finally {
            session.commit();
            session.close();
        }
        return id;
    }

    /**
     * Delete an instance of Cliente from the database.
     *
     * @param id value of the instance to be deleted.
     */
    public void delete(int id) {

        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.delete("Cliente.delete", id);
        } finally {
            session.commit();
            session.close();
        }
        System.out.println("delete(" + id + ")");

    }
}