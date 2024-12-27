package service;

import dto.ProductDTO;
import dto.UserDTO;

import java.util.List;

public interface ServiceInterface {
    int accessionService(UserDTO dto);

    int pInsertService(ProductDTO pDTO);
    int pUpdateService(ProductDTO pDTO);

    int pDeleteService(int delId);
    List<ProductDTO> pGetAllListService();

    ProductDTO pFindByIdService(int id);

    int uInsertService(UserDTO uDto);
    int uUpdateService(UserDTO uDto);

    int uDeleteService(int delId);
    List<UserDTO> uGetAllListService();

    UserDTO uFindByIdService(int id);

}
