package service;

import dto.ProductDTO;
import dto.UserDTO;
import repository.JapanRepository;

import java.util.List;

public class JapanService implements ServiceInterface {
    JapanRepository repository = new JapanRepository();


    @Override
    public int accessionService(UserDTO dto) {
        return repository.accessionData(dto);
    }
    public boolean loginService(String uu_Id, String password) {
        return repository.loginService(uu_Id, password);
    }

    @Override
    public int pInsertService(ProductDTO pDTO) {
        return repository.pInsert(pDTO);
    }

    @Override
    public int pUpdateService(ProductDTO pDTO) {
        return repository.pUpdate(pDTO);
    }

    @Override
    public int pDeleteService(int delId) {
        return repository.pDelete(delId);
    }

    @Override
    public List<ProductDTO> pGetAllListService() {
        return repository.pGetAllList();
    }


    @Override
    public ProductDTO pFindByIdService(int id) {
        return repository.pFindById(id);
    }

    @Override
    public int uInsertService(UserDTO uDto) {
        return repository.uInsert(uDto);
    }

    @Override
    public int uUpdateService(UserDTO uDto) {
        return repository.uUpdate(uDto);
    }

    @Override
    public int uDeleteService(int delId) {
        return 0;
    }

    @Override
    public List<UserDTO> uGetAllListService() {
        return repository.uGetAllList();
    }

    @Override
    public UserDTO uFindByIdService(int id) {
        return repository.uFindById(id);
    }


}
