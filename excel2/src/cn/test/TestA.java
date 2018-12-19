package cn.test;

import com.alibaba.fastjson.JSONObject;

import pdfParse.cn.pdf.parse.PDFReaderUtil;

/**
 * @author yuheng
 * 2018年5月4日
 */
public class TestA {

	public static void main(String[] args) {
		try {
			JSONObject aa = PDFReaderUtil.readReceiptPdf("D:\\360安全浏览器下载\\滴滴电子发票.pdf");
			System.out.println(aa.toJSONString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
