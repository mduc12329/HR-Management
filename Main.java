import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		CongTy cty = new CongTy();
		cty.taoDuLieu();
		boolean flag = true;
		do {
			menu();
			int num = Integer.parseInt(sc.nextLine());
			switch(num) {
			case 1: 
				cty.xuatDSNhanSu();
				break;
			case 2:
				
				cty.xuatDSPhongBan();
				break;
			case 3: 
				cty.xuatDSTask();
				break;
			case 4:
				cty.phanBoNhanVien();
				break;
			case 5: 
				cty.chiDinhTruongPhong();
				break;
			case 6:
				cty.phanTask(sc);
				break;
			case 0:
				flag = false;
				break;
			default: 
				System.out.println("Vui long nhap tu 0 den 6!");
			}
		}while(flag);
	}	
	
	private static void menu() {
		System.out.println("=============================================================================================");
		System.out.println("1. Xuat DS Nhan su.");
		System.out.println("2. Xuat DS Phong ban.");
		System.out.println("3. Xuat DS Task.");
		System.out.println("4. Phan bo nhan vien.");
		System.out.println("5. Chi dinh truong phong.");
		System.out.println("6. Phan task.");
		System.out.println("0. Thoat.");
		System.out.println("Moi chon nghiep vu: ");
	}
}
