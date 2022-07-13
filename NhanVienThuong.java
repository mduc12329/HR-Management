
public class NhanVienThuong extends NhanSu implements NhapXuat{
	//0.field
	final int LUONG_NGAY = 200;
	final int PHU_CAP_1 = 300;
	final int PHU_CAP_2 = 1000;
	//1.atbs
	//2.get set
	//3.constructors
	
	public NhanVienThuong() {
		super();
	}

	public NhanVienThuong(String maNV, String tenNV, String namSinh, String email, String soDienThoai,
			String maPhongBan, float soNgayLamViec) {
		super(maNV, tenNV, namSinh, email, soDienThoai, maPhongBan, soNgayLamViec);

	}

	//4.in out
	//5.method
	@Override
	public void tinhLuong() {
		// TODO Auto-generated method stub

	}

}
