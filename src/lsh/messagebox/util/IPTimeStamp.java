package lsh.messagebox.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class IPTimeStamp {
	private SimpleDateFormat sdf = null;
	private String ip = null;
	
	public IPTimeStamp(String ip) {
		this.ip = ip;
	}
	
	public String getIPTimeRand() {					//ip+时间戳+3位随机数
		StringBuffer bf = new StringBuffer();
		if (this.ip != null) {						//ip为空就不加ip
			String s[] = this.ip.split("\\.");			//拆分
			for (int i = 0;i < s.length; i++) {
				bf.append(this.addZero(s[i],3));		//不够3位数补0
			}
		}
		bf.append(this.getTimeStamp()); 		//取得时间戳
		Random r = new Random();
		for (int i = 0; i < 3; i++) {			//增加3位随机数
			bf.append(r.nextInt(10));
		}
		return bf.toString();
	}

	public String getTimeStamp() {
		this.sdf = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
		return this.sdf.format(new Date());
	}

	private String addZero(String str, int len) {
		StringBuffer s = new StringBuffer();
		s.append(str);
		while (s.length() < len) {
			s.insert(0, "0");
		}
		return s.toString();
	}
	
	public static void main(String args[]) {
		IPTimeStamp i = new IPTimeStamp("127.0.0.1");
		System.out.println(i.getIPTimeRand());
	}
}
