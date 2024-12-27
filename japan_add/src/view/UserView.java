package view;

import dto.UserDTO;
import service.JapanService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class UserView {
    Scanner sc = new Scanner(System.in);
    JapanService service = new JapanService();
    //uu_id , password , phone, money,created_at,updated_at
    public void uInsertView() {
        UserDTO uDTO = new UserDTO();
        System.out.println("유저관리 입력화면 입니다");
        System.out.println("유저 이름 : ");
        String uu_id = sc.next();
        uDTO.setUsId(uu_id);
        System.out.println("유저 password : ");
        String password = sc.next();
        uDTO.setPassword(password);
        System.out.println("전화 번호 : ");
        String phone = sc.next();
        uDTO.setPhone(phone);
        System.out.println("충전금액 : ");
        int money = sc.nextInt();
        uDTO.setMoney(money);
        uDTO.setCreated_at(LocalDateTime.now());
        int resul = service.uInsertService(uDTO);
        if (resul > 0) {
            System.out.println("자료가 저장되었습니다");
        } else {
            System.out.println("실패 ㅅㄱ");

        }
    }

    public void uUpdateView() {
        System.out.println("수정하실 유저의 ID를 입력해주세요");
        int uId = sc.nextInt();
        UserDTO orDTO = service.uFindByIdService(uId);
        UserDTO upDTo = new UserDTO();
        System.out.println("수정 : " + orDTO.getId());
        System.out.println("주정 전 이름 : " + orDTO.getuu_Id());
        upDTo.setId(orDTO.getId());
        System.out.println("수정할 이름 : ");
        String uu_id = sc.next();
        upDTo.setUsId(uu_id);
        System.out.println("수정전 password : " + orDTO.getPassword());
        String password = sc.next();
        upDTo.setPassword(password);
        System.out.println("수정 전 전화 번호 : " + orDTO.getPassword());
        String phone = sc.next();
        upDTo.setPhone(phone);
        System.out.println("수정 전 money : " + orDTO.getMoney());
        int money = sc.nextInt();
        upDTo.setMoney(money);
        upDTo.setCreated_at(orDTO.getCreated_at());
        upDTo.setUpdated_at(LocalDateTime.now());
        int result = service.accessionService(upDTo);
        if (result > 0) {
            System.out.println("수정 완료");
        } else {
            System.out.println("실패 ㅅㄱ");
        }
    }

    public void uDeleteView() {
        System.out.println("삭제할 ID를 입력해주세요");
        int delId = sc.nextInt();
        if (service.uDeleteService(delId) > 0) {
            System.out.println("ID : " + delId + "의 데이터가 삭제되었습니다");
        } else {
            System.out.println("실패");
        }
    }

    public void uGetAllView() {
        List<UserDTO> uDTO = service.uGetAllListService();
        pLine();
        pTitle();
        pLine();
        for (UserDTO dto : uDTO) {
            System.out.println(dto);

        }
        pLine();
    }
    public void pLine() {
        System.out.println("===============================================");
    }

    public void pTitle() {
        System.out.println("Id \t password \t phone \t money ");
    }
}
