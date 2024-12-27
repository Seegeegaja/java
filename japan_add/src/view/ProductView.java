package view;

import dto.ProductDTO;
import service.JapanService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class ProductView {
    Scanner sc = new Scanner(System.in);
    JapanService service = new JapanService();

    public void pInsertView() {
        ProductDTO pDTO = new ProductDTO();
        System.out.println("메뉴입력 화면입니다");//S int int bool
        System.out.println("메뉴 이름 : ");
        String product = sc.next();
        pDTO.setProduct(product);
        System.out.println("가격 : ");
        int price = sc.nextInt();
        pDTO.setPrice(price);
        System.out.println("재고 수량 : ");
        int stock = sc.nextInt();
        pDTO.setStock(stock);
        System.out.println("판매여부(1 = 판매, 0 = 판매하지 않음(잘못입력했을때 판매하지 않음))");
        int num = sc.nextInt();
        boolean status = (num == 1);
        pDTO.setStatus(status);
        pDTO.setCreated_at(LocalDateTime.now());
        int result = service.pInsertService(pDTO);
        if (result > 0) {
            System.out.println("입력이 되었습니다");
        } else {
            System.out.println("실패");
        }
    }

    public void pUpdateView() {
        System.out.println("수정하실 메뉴의 Id을 입력해주세요");
        int updateNum = sc.nextInt();

        ProductDTO orDto = service.pFindByIdService(updateNum);

        ProductDTO upDto = new ProductDTO();
        System.out.println("수정 ID : " + orDto.getP_id());
        System.out.println("수정 전 이름 : " + orDto.getProduct());
        upDto.setP_id(orDto.getP_id());
        System.out.println("수정할 이름 : ");
        String product = sc.next();
        upDto.setProduct(product);
        System.out.println("수정 전 가격 : " + orDto.getPrice());
        int price = sc.nextInt();
        upDto.setPrice(price);
        System.out.println("제품의 재고 : ");
        int stock = sc.nextInt();
        upDto.setStock(stock);
        System.out.println("판매여부(1 = 판매, 0 = 판매하지 않음(잘못입력했을때 판매하지 않음)) ");
        int num = sc.nextInt();
        boolean status = (num == 1);
        upDto.setStatus(status);
        upDto.setCreated_at(orDto.getCreated_at());
        upDto.setUpdated_at(LocalDateTime.now());
        int result = service.pUpdateService(upDto);
        if (result > 0) {
            System.out.println("수정 완료");
        } else {
            System.out.println("실패");
        }
    }

    public void pDeleteView() {
        System.out.println("삭제할 ID를 입력해주세요");
        int delId = sc.nextInt();
        if (service.pDeleteService(delId) > 0) {
            System.out.println("ID : " + delId + "의 데이터가 삭제 되었습니다");

        } else {
            System.out.println("삭제에 실패하였습니다");

        }
    }

    public void pGetAllView() {
        List<ProductDTO> pDto = service.pGetAllListService();
        pLine();
        pTitle();
        pLine();
        for (ProductDTO dto : pDto) {
            System.out.println(dto);
        }
        pLine();
    }

    public void pLine() {
        System.out.println("===============================================");
    }

    public void pTitle() {
        System.out.println("Id \t 이름 \t 가격 \t 수량 \t 판매여부 ");
    }
}
