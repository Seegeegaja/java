package repository;

import dto.ProductDTO;
import dto.UserDTO;

import java.util.List;

public interface RepositoryInterface {
    int accessionData(UserDTO dto);
    int pInsert(ProductDTO pDTO);
    int pUpdate(ProductDTO pDTO);

    int pDelete(int delId);
    List<ProductDTO> pGetAllList();

    ProductDTO pFindById(int id);

    int uInsert(UserDTO uDto);
    int uUpdate(UserDTO uDto);

    int uDelete(int delId);
    List<UserDTO> uGetAllList();

    UserDTO uFindById(int id);

}
