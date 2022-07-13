import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DanhSachNhanSu implements NhapXuat {
	// 1.attbs
	private ArrayList<NhanSu> listNhanSu;
	// 2. get set

	public ArrayList<NhanSu> getListNhanSu() {
		return listNhanSu;
	}

	public void setListNhanSu(ArrayList<NhanSu> listNhanSu) {
		this.listNhanSu = listNhanSu;
	}

	// cons
	public DanhSachNhanSu() {
		this.listNhanSu = new ArrayList<NhanSu>();
	}

	// in out
	@Override
	public void xuat() {
		for (NhanSu ns : this.listNhanSu) {
			ns.xuat();
		}
	}

	public void taoDuLieu() {
		try {
			FileReader reader = new FileReader("src/DSNV.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);

			String line;

			while ((line = bufferedReader.readLine()) != null) {
				String[] listInfo = line.split(" # ");
				//Kiem tra truong phong hay nhan vien thuong
				NhanSu ns;
				if (listInfo[listInfo.length - 1].equalsIgnoreCase("true")) {
					ns = new TruongPhong();
				} else {
					ns = new NhanVienThuong();
				}
				//Tao du lieu cho nhan su
				ns.setMaNV(listInfo[0]);
				ns.setTenNV(listInfo[1]);
				ns.setNamSinh(listInfo[2]);
				ns.setEmail(listInfo[3]);
				ns.setSoDienThoai(listInfo[4]);
				//Them nhan su vao list
				this.listNhanSu.add(ns);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}