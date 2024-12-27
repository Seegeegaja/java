import dto.ProductDTO;
import view.JapnView;
import view.ProductView;
import view.TotalView;
import view.UserView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        JapnView view = new JapnView();
        Scanner sc = new Scanner(System.in);
        int num = 0;
        String st = "";
        while (true) {
            System.out.println("우리 자판기는 회원제로 운영되는 자판기입니다");
            System.out.println("회원가입 또는 로그인을 선택해주세요");
            System.out.println("회원 가입은 '1' 로그인은 '2'");
            num = sc.nextInt();
            switch (num) {
                case 1:
                    System.out.println("회원가입");
                    view.accessionView();
                    break;
                case 2:
                    System.out.println("로그인");
                    String logInUser = view.loginView();
                    if (logInUser != null) {
                        if (logInUser.equals("admin")) {
                            adminMain();
                        } else {
                            userMain();
                        }
                    }
                    break;
                default:
                    System.out.println("잘못입력하셨습니다");
            }


        }


    }
    private static void adminMain() {
        ProductView pView = new ProductView();
        TotalView tView = new TotalView();
        UserView uView = new UserView();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("관리자 화면입니다");
            System.out.println("1.자판기 관리 2.회원관리 3.판매관리 4.로그아웃 ");
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    System.out.println("자판기 관리 화면입니다");
                    System.out.println("1.메뉴 입력 2.메뉴수정 3.메뉴 삭제 4. 메뉴조회 5.나가기");
                     num = sc.nextInt();
                     switch (num) {
                         case 1:
                             pView.pInsertView();
                             break;
                         case 2:
                             pView.pUpdateView();
                             break;
                         case 3:
                             pView.pDeleteView();
                             break;
                         case 4:
                             pView.pGetAllView();
                             break;
                         case 5:
                             System.out.println("ㅅㄱ");
                             return;
                         default:
                             System.out.println("잘못입력하셨습니다");
                     }
                    break;
                case 2:
                    System.out.println("회원관리 화면입니다");
                    System.out.println("1.정보입력 2.수정 3.삭제 4.조회 5.나가기");
                    num = sc.nextInt();
                    switch (num) {
                        case 1:
                            uView.uInsertView();
                            break;
                        case 2:
                            uView.uUpdateView();
                            break;
                        case 3:
                            uView.uDeleteView();
                            break;
                        case 4:
                            uView.uGetAllView();
                            break;
                        case 5:
                            System.out.println("ㅅㄱ");
                            return;
                        default:
                            System.out.println("잘못입력하셨습니다");
                    }
                case 3:
                    System.out.println("판매 관리 화면입니다");
                    System.out.println("1.제품별 판매현황 2.회원별 판매 현황 3.나가기");
                    num = sc.nextInt();
                    switch (num) {
                        case 1:
                            tView.pAllList();
                            break;
                        case 2:
                            tView.uAllList();
                            break;
                        case 3:
                            System.out.println("ㅅㄱ");
                            return;

                        default:
                            System.out.println("잘못입력하셨습니다");

                    }
                case 4:
                    System.out.println("ㅅㄱ");
                    return;
                default:
                    System.out.println("마 잘좀 찍으라");
            }

        }

    }

    private static void userMain() {
        JapnView jview = new JapnView();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("회원 화면입니다");
            System.out.println("1.동전추입 2.메뉴 선택 3.로그아웃");
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    jview.insertCoin();
                    break;
                case 2:
                    jview.selectMenu();
                    break;
                case 3:
                    System.out.println("ㅅㄱ");
                    return;
                default:
                    System.out.println("잘못입력했습니다");
            }

        }



    }



}
