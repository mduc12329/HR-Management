import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DanhSachTask implements NhapXuat {
	//0. final
	//1.atbs
	private ArrayList<Task> listTask;
	//2.get set
	public ArrayList<Task> getListTask() {
		return listTask;
	}

	public void setListTask(ArrayList<Task> listTask) {
		this.listTask = listTask;
	}
	//3.constructors
	public DanhSachTask() {
		this.listTask = new ArrayList<Task>();
	}
	//4.in out
	
	//5.method
	@Override
	public void xuat() {
		for(Task task : this.listTask){
			task.xuat();
		}

	}
	
	public void taoDuLieu() {
		try {
			FileReader reader = new FileReader("src/Task.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);

			String line;

			while ((line = bufferedReader.readLine()) != null) {
				String[] listInfo = line.split(" # ");
				
				//Tao du lieu cho task
				Task task = new Task(listInfo[0],listInfo[1],Float.parseFloat(listInfo[2]));
				
				//Them task vao list
				this.listTask.add(task);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	

}
