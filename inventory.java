package game;

public class inventory {
	String[] list;
	int num;

	public inventory(String[] list) {
		super();
		this.list = list;

	}

	public String[] getList() {
		return list;
	}

	public void setList(String[] list) {
		this.list = list;
	}
	public void add(String str){
		for (int i = 0; i<list.length;i++){
			if(list[i]== null){
				list[i] = str;
				return;
			}
		}
	}

}
