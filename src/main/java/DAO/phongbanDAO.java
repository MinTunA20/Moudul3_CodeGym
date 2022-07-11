package DAO;

import connectDB.Connect_MySQL;
import model.phongban;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class phongbanDAO implements CRUD<phongban> {
    @Override
    public List<phongban> getAll() {
        String sql = "select * from classstudent";
        List<phongban> classStudents = new ArrayList<>();
        try (Connection connection = Connect_MySQL.getConnect()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int idPhongban = resultSet.getInt(1);
                String namePhongban = resultSet.getString(2);
                phongban.add(new phongban(idPhongban, namePhongban));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return classStudents;
    }

    @Override
    public boolean create(phongban phongban) {
        return false;
    }

    @Override
    public boolean edit(int id, phongban phongban) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public static phongban findById(int id) {
        String sql = "select * from department where id = ?";
        try (Connection connection = Connect_MySQL.getConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            int idPhongban = resultSet.getInt(1);
            String namePhongban = resultSet.getString(2);
            phongban phongban = new phongban(idPhongban, namePhongban);
            return phongban ;


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}