package repository;

import db.DBConn;
import dto.ProductDTO;
import dto.UserDTO;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JapanRepository implements RepositoryInterface {
    int result = 0;
    Connection dbconn = DBConn.getConnection();
    PreparedStatement psmt = null;
    String sql;


    @Override
    public int accessionData(UserDTO dto) {
        //db에 저장
        try {
            sql = " INSERT INTO user (uu_id, password, phone, money, created_at)" ;
            sql = sql + "VALUES (?, ?, ?, ?, ?)";
            psmt = dbconn.prepareStatement(sql);
            psmt.setString(1, dto.getuu_Id());
            psmt.setString(2, dto.getPassword());
            psmt.setString(3, dto.getPassword());
            psmt.setInt(4, dto.getMoney());
            psmt.setTimestamp(5, Timestamp.valueOf(dto.getCreated_at()));
            return psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return 0;
    }

    @Override
    public int pInsert(ProductDTO pDTO) {
        try {
            sql = "INSERT INTO product (product, price, stock, status , created_at)";
            sql = sql + "VALUES (?, ?, ?, ?, ?)";
            psmt = dbconn.prepareStatement(sql);
            psmt.setString(1, pDTO.getProduct());
            psmt.setInt(2, pDTO.getPrice());
            psmt.setInt(3, pDTO.getStock());
            psmt.setBoolean(4, pDTO.isStatus());
            psmt.setTimestamp(5, Timestamp.valueOf(pDTO.getCreated_at()));
            result = psmt.executeUpdate();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int pUpdate(ProductDTO pDTO) {
        sql = "UPDATE product set ";
        sql = sql + "product = ?, ";
        sql = sql + "price = ?, ";
        sql = sql + "stock = ?, ";
        sql = sql + "status = ?, ";
        sql = sql + "created_at = ?, ";
        sql = sql + "updated_at = ? ";
        sql = sql + "WHERE p_id = ? ";

        try {
            psmt = dbconn.prepareStatement(sql);
            psmt.setString(1, pDTO.getProduct());
            psmt.setInt(2, pDTO.getPrice());
            psmt.setInt(3, pDTO.getStock());
            psmt.setBoolean(4, pDTO.isStatus());
            psmt.setTimestamp(5, Timestamp.valueOf(pDTO.getCreated_at()));
            psmt.setTimestamp(6, Timestamp.valueOf(pDTO.getUpdated_at()));
            psmt.setInt(7, pDTO.getP_id());
            result = psmt.executeUpdate();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int pDelete(int delId) {
        sql = "DELETE FROM product WHERE p_id=? ";
        try {
            psmt = dbconn.prepareStatement(sql);
            psmt.setInt(1, delId);
            return psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public List<ProductDTO> pGetAllList() {
        List<ProductDTO> dtoList = new ArrayList<>();
        ResultSet rs = null;

        try {
            sql = "SELECT * FROM product ORDER BY p_id ASC";
            psmt = dbconn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                ProductDTO dto = new ProductDTO();
                dto.setP_id(rs.getInt("p_id"));
                dto.setProduct(rs.getString("product"));
                dto.setPrice(rs.getInt("price"));
                dto.setStock(rs.getInt("stock"));
                dto.setStatus(rs.getBoolean("status"));
                dto.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());
                if (rs.getTimestamp("updated_at") != null) {
                    dto.setUpdated_at(rs.getTimestamp("updated_at").toLocalDateTime());

                }
                dtoList.add(dto);
            }
            rs.close();
            psmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dtoList;
    }

    @Override
    public ProductDTO pFindById(int id) {
        ProductDTO dto = new ProductDTO();
        ResultSet rs = null;
        sql = "SELECT * FROM product WHERE p_id = ?";
        try {
            psmt = dbconn.prepareStatement(sql);
            psmt.setInt(1, id);
            rs = psmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    dto.setP_id(rs.getInt("p_id"));
                    dto.setProduct(rs.getNString("product"));
                    dto.setPrice(rs.getInt("price"));
                    dto.setStock(rs.getInt("stock"));
                    dto.setStatus(rs.getBoolean("status"));
                    dto.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());
                    if (rs.getTimestamp("updated_at") != null) {
                        dto.setUpdated_at(rs.getTimestamp("updated_at").toLocalDateTime());
                    }
                }

            }
            return dto;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //uu_id , password , phone, money,created_at,updated_at
    @Override
    public int uInsert(UserDTO uDto) {
        try {
            sql = "INSERT INTO user (uu_id, password, money, created_at)" ;
            sql = sql + "VALUES (?, ?, ?, ?)" ;
            psmt = dbconn.prepareStatement(sql);
            psmt.setString(1, uDto.getuu_Id());
            psmt.setString(2, uDto.getPassword());
            psmt.setInt(3, uDto.getMoney());
            psmt.setTimestamp(4, Timestamp.valueOf(uDto.getCreated_at()));
            result = psmt.executeUpdate();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int uUpdate(UserDTO uDto) {
        sql = "UPDATE user set ";
        sql = sql + "uu_id = ?, ";
        sql = sql + "password = ?, ";
        sql = sql + "phone = ?, ";
        sql = sql + "money = ?, ";
        sql = sql + "created_at = ?, ";
        sql = sql + "updated_at = ? ";
        sql = sql + "WHERE u_id = ? ";

        try {
            psmt = dbconn.prepareStatement(sql);
            psmt.setString(1, uDto.getuu_Id());
            psmt.setString(2, uDto.getPassword());
            psmt.setString(3, uDto.getPhone());
            psmt.setInt(4, uDto.getMoney());
            psmt.setTimestamp(5, Timestamp.valueOf(uDto.getCreated_at()));
            psmt.setTimestamp(6, Timestamp.valueOf(uDto.getUpdated_at()));
            psmt.setInt(7, uDto.getId());
            result = psmt.executeUpdate();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    @Override
    public int uDelete(int delId) {
        sql = "DELETE FROM user WHERE u_id=? ";
        try {
            psmt = dbconn.prepareStatement(sql);
            psmt.setInt(1, delId);
            return psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<UserDTO> uGetAllList() {
        List<UserDTO> dtoList = new ArrayList<>();
        ResultSet rs = null;
        try {
            sql = "SELECT * FROM user ORDER BY u_id ASC";
            psmt = dbconn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                UserDTO dto = new UserDTO();
                dto.setId(rs.getInt("u_id"));
                dto.setUsId(rs.getString("uu_id"));
                dto.setPassword(rs.getString("password"));
                dto.setPhone(rs.getString("phone"));
                dto.setMoney(rs.getInt("money"));
                dto.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());
                if (rs.getTimestamp("updated_at") != null) {
                    dto.setUpdated_at(rs.getTimestamp("updated_at").toLocalDateTime());

                }
                dtoList.add(dto);

            }
            rs.close();
            psmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dtoList;
    }

    @Override
    public UserDTO uFindById(int id) {
        UserDTO dto = new UserDTO();
        ResultSet rs = null;
        sql = "SELECT * FROM user WHERE u_id = ?";
        try {
            psmt = dbconn.prepareStatement(sql);
            psmt.setInt(1, id);
            rs = psmt.executeQuery();
            if (rs != null) {
                dto.setId(rs.getInt("u_id"));
                dto.setUsId(rs.getString("uu_id"));
                dto.setPassword(rs.getString("password"));
                dto.setPhone(rs.getString("phone"));
                dto.setMoney(rs.getInt("money"));
                dto.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());
                if (rs.getTimestamp("updated_at") != null) {
                    dto.setUpdated_at(rs.getTimestamp("updated_at").toLocalDateTime());
                }
            }
            return dto;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean loginService(String uu_Id, String password) {
        sql = "SELECT COUNT(*) FROM user WHERE uu_id = ? AND password = ? ";
        try {
            psmt = dbconn.prepareStatement(sql);
            psmt.setString(1, uu_Id);
            psmt.setString(2, password);
            ResultSet rs = psmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
