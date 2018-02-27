package core.dao;

import core.vo.Articulo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ArticuloDao {

    private SqlSessionFactory sqlSessionFactory = null;

    public ArticuloDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<Articulo> selectAll() {
        List<Articulo> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            list = session.selectList("Articulo.selectAll");
        } finally {
            session.close();
        }
        System.out.println("selectAll() --> " + list);
        return list;

    }

    /**
     * Select instance of Articulo from the database.
     *
     * @param id the instance to be persisted.
     */
    public Articulo selectById(int id) {
        Articulo person = null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            person = session.selectOne("Articulo.selectById", id);
        } finally {
            session.close();
        }
        System.out.println("selectById(" + id + ") --> " + person);
        return person;
    }
    
    public Articulo selectByNombre(String nombre) {
        Articulo person = null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            person = session.selectOne("Articulo.selectByNombre", nombre);
        } finally {
            session.close();
        }
        return person;
    }

    /**
     * Insert an instance of Articulo into the database.
     *
     * @param usuario the instance to be persisted.
     */
    public int insert(Articulo usuario) {
        int id = -1;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            id = session.insert("Articulo.insert", usuario);
        } finally {
            session.commit();
            session.close();
        }
        System.out.println("insert(" + usuario + ") --> " + usuario.getIdarticulo());
        return id;
    }

    /**
     * Update an instance of Articulo into the database.
     *
     * @param usuario the instance to be persisted.
     */
    public void update(Articulo usuario) {
        int id = -1;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            id = session.update("Articulo.update", usuario);
        } finally {
            session.commit();
            session.close();
        }
        System.out.println("update(" + usuario + ") --> updated");
    }
    public void updateStock(Articulo usuario) {
        int id = -1;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            id = session.update("Articulo.updateStock", usuario);
        } finally {
            session.commit();
            session.close();
        }
    }

    /**
     * Delete an instance of Articulo from the database.
     *
     * @param id value of the instance to be deleted.
     */
    public void delete(int id) {

        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.delete("Articulo.delete", id);
        } finally {
            session.commit();
            session.close();
        }
        System.out.println("delete(" + id + ")");

    }
}