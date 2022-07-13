//0. final
//1.atbs
//2.get set
//3.constructors
//4.in out
//5.method
public abstract class NhanSu implements NhapXuat{
	//1.atbs
	protected String maNV;
	protected String tenNV;
	protected String namSinh;
	protected String email;
	protected String soDienThoai;
	protected String maPhongBan;
	protected float luong;
	protected float soNgayLamViec;
	protected DanhSachTask objDsTask;
	//2.get set
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public String getNamSinh() {
		return namSinh;
	}
	public void setNamSinh(String namSinh) {
		this.namSinh = namSinh;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getMaPhongBan() {
		return maPhongBan;
	}
	public void setMaPhongBan(String maPhongBan) {
		this.maPhongBan = maPhongBan;
	}
	public float getSoNgayLamViec() {
		return soNgayLamViec;
	}
	public void setSoNgayLamViec(float soNgayLamViec) {
		this.soNgayLamViec = soNgayLamViec;
	}
	public DanhSachTask getObjTask() {
		return objDsTask;
	}
	public void setOnjTask(DanhSachTask dsTask) {
		this.objDsTask = dsTask;
	}
	public float getLuong() {
		return luong;
	}
	//3.constructors
	
	//Set default 
	private void init() {
		this.maPhongBan = "-1";
		this.objDsTask = new DanhSachTask();
	}
	public NhanSu() {
		init();
	}
	public NhanSu(String maNV, String tenNV, String namSinh, String email, String soDienThoai) {
		init();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.namSinh = namSinh;
		this.email = email;
		this.soDienThoai = soDienThoai;
	}
	public NhanSu(String maNV, String tenNV, String namSinh, String email, String soDienThoai, String maPhongBan,
			float soNgayLamViec) {
		init();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.namSinh = namSinh;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.maPhongBan = maPhongBan;
		this.soNgayLamViec = soNgayLamViec;
	}
	
	//4.in out
	public void xuat() {
		String temp = this.maPhongBan;
		if(this.maPhongBan.contentEquals("-1")) {
			temp = "Chua phan bo";
		}
		System.out.println("Ma: "+this.maNV+"\tTen NV: "+this.tenNV+"\tNam sinh: "+this.namSinh+"\tEmail: "+this.email+"\tSDT: "
		+this.soDienThoai+"\tMa phong ban: "+temp+"\tNgay lam: "+this.soNgayLamViec+"\tLuong: "+this.luong);
		
		//De xuat ds task cua nhan su
		if(this.objDsTask.getListTask().size() > 0) {
			System.out.println("DS Task thuc hien: ");
			this.objDsTask.xuat();
			
		}
		
	}

	public void xuatTenVaMa() {
		System.out.println("Ma: "+this.maNV+"\tTen NV: "+this.tenNV);
	}
	
	
		
	//5.method
	public abstract void tinhLuong();
	
}
