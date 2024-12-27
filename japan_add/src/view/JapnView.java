package view;

import dto.UserDTO;
import service.JapanService;

import java.time.LocalDateTime;
import java.util.Scanner;

public class JapnView implements ViewInterface {
    JapanService service = new JapanService();
    Scanner sc = new Scanner(System.in);



    @Override

    public void accessionView() {
        System.out.println("회원가입 화면입니다");
        UserDTO dto = new UserDTO();
        System.out.println("아뒤 : ");
        String uu_id = sc.next();
        dto.setUsId(uu_id);
        System.out.println("비밀번호 숫자 : ");
        String password = sc.next();
        dto.setPassword(password);
        System.out.println("전화번호 : ");
        String phone = sc.next();
        dto.setPhone(phone);
        System.out.println("충전하실 금액(1,000 단위로 충전해주세요) : ");
        int money = sc.nextInt();
        dto.setMoney(money);
        dto.setCreated_at(LocalDateTime.now());
        int result = service.accessionService(dto);
        if (result > 0) {
            System.out.println("회원가입이 완료되었습니다");
        } else {
            System.out.println("실패요");

        }
    }

    @Override
    public String loginView() {
        System.out.println("로그인 화면 입니다");
        System.out.println("아뒤 : ");
        String uu_id = sc.next();
        System.out.println("비번 : ");
        String password = sc.next();

        boolean login = service.loginService(uu_id, password);
        if (login) {
            System.out.println("로그인이 성공");
            return uu_id;
        } else {
            System.out.println("로그인 실패");
        }
        return null;
    }

    public void insertCoin() {
    }

    public void selectMenu() {

    }





}
