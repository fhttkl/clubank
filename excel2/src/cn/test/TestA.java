package cn.test;

import com.alibaba.fastjson.JSONObject;

import pdfParse.cn.pdf.parse.PDFReaderUtil;

/**
 * @author yuheng
 * 2018��5��4��
 */
public class TestA {

	public static void main(String[] args) {
		try {
			JSONObject aa = PDFReaderUtil.readReceiptPdf("D:\\360��ȫ���������\\�εε��ӷ�Ʊ.pdf");
			System.out.println(aa.toJSONString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
