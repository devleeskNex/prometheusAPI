package com.nexclipper.prometheus.util;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Connection {
	
	private String SERVER = "";
	public Connection() {
		this.SERVER = new Server().info();
	}
	
	
	public String get (String endpoint) {
		URL url = null;
		HttpURLConnection con = null;
		try {
			url = new URL(this.SERVER + endpoint);
			con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.getInputStream();
			return getData(con.getInputStream());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return "{}";
		} catch (IOException e) {
			e.printStackTrace();
			return "{}";
		}
	}
	private static String getData(InputStream is) {
		String result = "";
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] buf = new byte[1024 * 8];
		int length = 0;
		try {
			while ( (length = is.read(buf)) != -1) {
				out.write(buf, 0, length);
			}
			result = new String(out.toByteArray(), "UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
