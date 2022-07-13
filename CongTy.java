import java.util.ArrayList;
import java.util.Scanner;

public class CongTy implements NhapXuat {
	// 0. final
	// 1.attbs
	private String tenCongTy;
	private String maSoThue;
	private float tongLuong;
	private DanhSachNhanSu objDsNhanSu;
	private DanhSachPhongBan objDsPhongBan;
	private DanhSachTask objDsTask;
	private ArrayList<TruongPhong> dsTruongPhong;
	// 2.get set

	public DanhSachNhanSu getObjDsNhanSu() {
		return objDsNhanSu;
	}

	public void setObjDsNhanSu(DanhSachNhanSu objDsNhanSu) {
		this.objDsNhanSu = objDsNhanSu;
	}

	public DanhSachPhongBan getObjDsPhongBan() {
		return objDsPhongBan;
	}

	public void setObjDsPhongBan(DanhSachPhongBan objDsPhongBan) {
		this.objDsPhongBan = objDsPhongBan;
	}

	public String getTenCongTy() {
		return tenCongTy;
	}

	public void setTenCongTy(String tenCongTy) {
		this.tenCongTy = tenCongTy;
	}

	public String getMaSoThue() {
		return maSoThue;
	}

	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}

	public float getTongLuong() {
		return tongLuong;
	}

	public DanhSachTask getObjDsTask() {
		return objDsTask;
	}

	public void setObjDsTask(DanhSachTask objDsTask) {
		this.objDsTask = objDsTask;
	}

	// 3.constructors
	public CongTy() {
		this.dsTruongPhong = new ArrayList<TruongPhong>();
	}

	// 4.in out
	@Override
	public void xuat() {

	}

	public void taoDuLieu() {
		this.objDsNhanSu = new DanhSachNhanSu();
		this.objDsNhanSu.taoDuLieu();

		this.objDsPhongBan = new DanhSachPhongBan();
		this.objDsPhongBan.taoDuLieu();

		this.objDsTask = new DanhSachTask();
		this.objDsTask.taoDuLieu();
		
		layDSTruongPhong();
	}

	public void xuatDSNhanSu() {
		this.objDsNhanSu.xuat();
	}

	public void xuatDSPhongBan() {
		this.objDsPhongBan.xuat();
	}

	public void xuatDSTask() {
		this.objDsTask.xuat();
	}

	// 5.method

	public void phanBoNhanVien() {
		Scanner sc = new Scanner(System.in);
		// 1. duyet ds nhan vien
		// 2. hoi muon phan bo hay khong, 1. Phan bo: -> liet ke ds phong ban-> nhap ma
		// phong ban - 2. Khong phan bo
		for (NhanSu ns : this.objDsNhanSu.getListNhanSu()) {
			if (ns instanceof NhanVienThuong) {
				boolean flag = true;
				do {
					System.out.println("Dang phan bo cho nhan vien: ");
					ns.xuatTenVaMa();
					System.out.println("1. Phan bo\t2. Di tiep");
					int chon = Integer.parseInt(sc.nextLine());
					switch (chon) {
					case 1:
						System.out.println("===== DANH SACH PHONG BAN =====");
						xuatDSPhongBan();
						System.out.println("Moi chon: ");
						String maPhong = sc.nextLine();

						// Lay phong ban tuong ung ma nguoi dung nhap
						PhongBan pb = layPhongBan(maPhong);

						// them ns nay vao phong ban
						if (pb != null) {
							// gan ma phong ban cho nhan su nay
							ns.setMaPhongBan(maPhong);
							// them nhan su nay vao phong ban
							pb.getDsNhanVien().add((NhanVienThuong) ns);
						}
						flag = false;
						break;
					case 2:
						flag = false;
						break;
					default:
						System.out.println("CHI NHAP 1 HOAC 2");
					}
				} while (flag);
			}
		}

	}

	public void chiDinhTruongPhong() {
		Scanner sc = new Scanner(System.in);
		// 1. duyet ds truong phong
		// 2. hoi muon phan bo hay khong, 1. Phan bo: -> liet ke ds phong ban-> nhap ma
		// phong ban - 2. Khong phan bo
		for (TruongPhong tp : this.dsTruongPhong) {
			boolean flag = true;
			do {
				System.out.println("Dang phan bo cho truong phong: ");
				tp.xuatTenVaMa();
				System.out.println("1. Phan bo\t2. Di tiep");
				int chon = Integer.parseInt(sc.nextLine());
				switch (chon) {
				case 1:
					System.out.println("===== DANH SACH PHONG BAN =====");
					xuatDSPhongBan();
					System.out.println("Moi chon: ");
					String maPhong = sc.nextLine();

					// Lay phong ban tuong ung ma nguoi dung nhap
					PhongBan pb = layPhongBan(maPhong);

					// them ns nay vao phong ban
					if (pb != null) {
						// gan ma phong ban cho nhan su nay
						tp.setMaPhongBan(maPhong);
						// chi dinh trg phong cho phong ban
						pb.setTruongPhong(tp);;
					}
					flag = false;
					break;
				case 2:
					flag = false;
					break;
				default:
					System.out.println("CHI NHAP 1 HOAC 2");
				}
			} while (flag);

		}

	}

	private PhongBan layPhongBan(String maPhong) {
		for (PhongBan pb : this.objDsPhongBan.getListPhongBan()) {
			if (pb.getMaPhongBan().equalsIgnoreCase(maPhong)) {
				return pb;
			}
		}
		return null;

	}

	public void layDSTruongPhong() {
		for (NhanSu ns : this.objDsNhanSu.getListNhanSu()) {
			if (ns instanceof TruongPhong) {
				this.dsTruongPhong.add((TruongPhong) ns);
			}
		}
	}
	
	//Duyet ds cac task
	//Nhap nhan su theo ma -> het
	//Phan task hoac bo qua hoac chon lai
	public void phanTask(Scanner sc) {
		for(Task task : this.objDsTask.getListTask()) {
			System.out.println("Task dang phan bo: ");
			task.xuat();
			NhanSu ns = timNhanSuTheoMa(sc);
			boolean flag = true;
			do {
				System.out.println("1. Phan task\t2. Chon lai nhan su khac\t3. Bo qua");
				int chon = Integer.parseInt(sc.nextLine());
				switch(chon) {
				case 1:
					//Gan nv vao task
					task.setMaNV(ns.getMaNV());
					//Gan task vao thong tin nhan vien
					ns.getObjTask().getListTask().add(task);
					System.out.println("Phan bo thanh cong.");
					flag = false;
					break;
				case 2:
					ns = timNhanSuTheoMa(sc);
					break;
				case 3:
					flag = false;
					break;
				default: System.out.println("CHON TU 1 DEN 3.");
				}
			}while(flag);
		}
	}

	private NhanSu timNhanSuTheoMa(Scanner sc) {
		NhanSu ns = null;
		do {
			System.out.println("Nhap vao nhan su chi dinh task: ");
			String ma = sc.nextLine();
			for(NhanSu nSu :this.objDsNhanSu.getListNhanSu()) {
				if(nSu.getMaNV().equalsIgnoreCase(ma)) {
					ns=nSu;
					System.out.println("Nhan su dang chon la: ");
					ns.xuatTenVaMa();
					break;
				}
			}
			
		}while(ns == null);
		return ns;
	}
}
