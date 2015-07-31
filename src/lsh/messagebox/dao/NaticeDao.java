package lsh.messagebox.dao;

import java.util.Map;

import lsh.messagebox.vo.Natice;

public interface NaticeDao {
	
	void saveNatice(Natice n);
	
	Map<String, Natice> showNatice();
	
}
