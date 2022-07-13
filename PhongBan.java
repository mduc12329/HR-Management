import java.util.ArrayList;

public class PhongBan implements NhapXuat {
	//0. final
	//1.atbs
	private String maPhongBan;
	private String tenPhongBan;
	private TruongPhong truongPhong;
	private ArrayList<NhanVienThuong> dsNhanVien;
	//2.get set
	public String getMaPhongBan() {
		return maPhongBan;
	}

	public void setMaPhongBan(String maPhongBan) {
		this.maPhongBan = maPhongBan;
	}

	public String getTenPhongBan() {
		return tenPhongBan;
	}

	public void setTenPhongBan(String tenPhongBan) {
		this.tenPhongBan = tenPhongBan;
	}

	public TruongPhong getTruongPhong() {
		return truongPhong;
	}

	public void setTruongPhong(TruongPhong truongPhong) {
		this.truongPhong = truongPhong;
	}

	public ArrayList<NhanVienThuong> getDsNhanVien() {
		return dsNhanVien;
	}

	public void setDsNhanVien(ArrayList<NhanVienThuong> dsNhanVien) {
		this.dsNhanVien = dsNhanVien;
	}

	//3.constructors
	public PhongBan() {
		this.truongPhong = null;
		this.dsNhanVien = new ArrayList<NhanVienThuong>();
	}
	
	public PhongBan(String maPhongBan, String tenPhongBan) {
		this.maPhongBan = maPhongBan;
		this.tenPhongBan = tenPhongBan;
		this.dsNhanVien = new ArrayList<NhanVienThuong>();
	}

	//4.in out
	@Override
	public void xuat() {
		System.out.println("======  TT PHONG BAN  ======");
		System.out.println("Ten: "+this.tenPhongBan+" Ma: "+this.maPhongBan);
		if(this.truongPhong != null) {
			System.out.println("Truong phong: ");
			this.truongPhong.xuat();
		}else {
			System.out.println("Chua co truong phong.");
		}
		for(NhanVienThuong nvt : this.dsNhanVien) {
			nvt.xuat();
		}
		System.out.println("~~~~~~  END PHONG BAN  ~~~~~");

	}
	//5.method

	
}
