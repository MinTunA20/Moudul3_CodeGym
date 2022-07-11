package DAO;

import connectDB.Connect_MySQL;
import model.nhanvien;
import model.phongban;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class nhanvienDAO implements CRUD<nhanvien> {
    private static final String INSERT_CATEGORY = "INSERT INTO department (namePhongban) VALUES (?);";
    private static final String SELECT_ALL = "select * from department;";
    private static final String SEARCH_CATEGORY = "select * from department where namePhongban like ? ;";
    private static final String SEARCH_NHANVIEN = "select * from department where nameNhanvien like ? ;";
    private static final String DELETE_NHANVIEN = "delete from department where idNhanvien = ?;";
    private static final String SELECT_NHANVIEN = "select * from department  where idNhanvien = ?;";

    private static final String UPDATE_PHONGBAN = "UPDATE department SET namePhongban?;";
    private static final String SELECT_BY_PHONGBAN="select * from department  where idPhongban=?;";
    phongbanDAO phongbanDao = new phongbanDAO();

    @Override
    public static List<nhanvien> getAll() {
        String sql = "select * from nhanvien";
        List<nhanvien> nhanviens = new ArrayList<>();
        try (Connection connection = Connect_MySQL.getConnect()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("idNhanvien");
                String name = resultSet.getString("nameNhanvien");
                Date doB = resultSet.getDate("doB");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phoneNumber");
                String email = resultSet.getString("email");
                int idPhongban = Integer.parseInt(resultSet.getString("phongban"));
                String phongban = String.valueOf(phongbanDAO.findById(resultSet.getInt("idPhongban")));

                nhanviens.add(new nhanvien(id, name, doB, address, phoneNumber, email, phongban));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return nhanviens;
    }



    @Override
    public boolean create(nhanvien nhanvien) {
        String sql = "insert into nhanvien value (?,?,?,?,?,?,?)";
        try (Connection connection = Connect_MySQL.getConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, nhanvien.getIdNhanvien());
            preparedStatement.setString(2, nhanvien.getNameNhanvien());
            preparedStatement.setString(3, String.valueOf(nhanvien.getDoB()));
            preparedStatement.setString(4, nhanvien.getAddress());
            preparedStatement.setString(5, nhanvien.getPhoneNumber());
            preparedStatement.setString(6, nhanvien.getEmail());
            preparedStatement.setInt(7, Integer.parseInt(nhanvien.getPhongban()));
            return preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean edit(int id, nhanvien nhanvien) {
        String sql = "UPDATE nhanvien SET nameNhanvien = ?,doB = ?, " +
                "address = ?,phoneNumber = ?,email = ?, idPhongban=? WHERE (id = ?)";
        try (Connection connection = Connect_MySQL.getConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, nhanvien.getIdNhanvien());
            preparedStatement.setString(2, nhanvien.getNameNhanvien());
            preparedStatement.setString(3, String.valueOf(nhanvien.getDoB()));
            preparedStatement.setString(4, nhanvien.getAddress());
            preparedStatement.setString(5, nhanvien.getPhoneNumber());
            preparedStatement.setString(6, nhanvien.getEmail());
            preparedStatement.setInt(7, Integer.parseInt(nhanvien.getPhongban()));
            return preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        String sql = "delete from nhanvien WHERE idNhanvien = ?";
        try (Connection connection = Connect_MySQL.getConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            return preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override
    public nhanvien findById(int id) {
        String sql = "select * from nhanvien where idNhanvien = " + id;
        try (Connection connection = Connect_MySQL.getConnect()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            resultSet.next();
            int idS = resultSet.getInt("id");
            String name = resultSet.getString("name");
            LocalDate doB = LocalDate.parse(resultSet.getString("dateOfBirth"));
            String email = resultSet.getString("email");
            String address = resultSet.getString("address");
            String phoneNumber = resultSet.getString("phoneNumber");
            phongban phongban = phongbanDAO.findById(resultSet.getInt("idPhongban"));


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
