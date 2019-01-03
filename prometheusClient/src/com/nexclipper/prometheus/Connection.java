package com.nexclipper.prometheus;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Connection {
	public String get (String urlStr) {
		URL url = null;
		HttpURLConnection con = null;
		try {
			url = new URL(urlStr);
			con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.getInputStream();
			System.out.println("Response Code - " + con.getResponseCode());
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
		System.out.println("result = " + result);
		return result;
	}
}
